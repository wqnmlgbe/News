package open.cklan.com.library.utils;

import android.text.TextUtils;
import android.util.Xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import open.cklan.com.library.model.NewsContentEntity;
import open.cklan.com.library.model.NewsContentParserEntity;
import open.cklan.com.library.model.base.BaseMultiItem;

/**
 * AUTHOR：lanchuanke on 17/5/15 11:02
 */
public class HtmlParserUtil {

    public static final List<BaseMultiItem> parseHtml(NewsContentEntity contentEntity) throws Exception {
        List<BaseMultiItem> list=new ArrayList<>();
        String body=contentEntity.body;
        List<NewsContentEntity.ImgEntity> img=contentEntity.img;
        Document document= Jsoup.parse(body);
        Elements bodyElements = document.getElementsByTag("body");
        if(bodyElements!=null && bodyElements.size()==1){
            Element bodyElement=bodyElements.get(0);
            List<Node> nodes = bodyElement.childNodes();
            if(nodes!=null && nodes.size()>0){
                BaseMultiItem entity=null;
                for(Node node:nodes){
                    entity=new BaseMultiItem<>();
                    if(node instanceof Element){
                        entity.viewType=NewsContentParserEntity.TYPE_TEXT;
                        entity.data=new NewsContentParserEntity(((Element) node).text());
                    }else if(node instanceof Comment){
                        entity.viewType=NewsContentParserEntity.TYPE_IMG;
                        String ref=((Comment)node).toString();
                        entity.data=getImgByRef(ref,img);
                    }
                    list.add(entity);
                }
            }
        }
        return list;
    }

    public static final NewsContentEntity.ImgEntity getImgByRef(String ref, List<NewsContentEntity.ImgEntity> list){
        if(TextUtils.isEmpty(ref))return null;
        ref=ref.replaceAll("\\n","");
        if(list!=null && list.size()>0){
            for(NewsContentEntity.ImgEntity img:list){
                if(ref.equals(img.ref)){
                    return img;
                }
            }
        }
        return null;
    }
}
