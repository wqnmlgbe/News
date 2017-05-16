package open.cklan.com.library.model.news_list;

import java.io.Serializable;
import java.util.List;

import open.cklan.com.library.model.common.ImgExtra;

/**
 * AUTHOR：lanchuanke on 17/5/9 11:23
 */
public class CarListItemEntity extends BaseListItemEntity{
    public String postid;
    public boolean hasCover;
    public int hasHead;
    public int replyCount;
    public String ltitle;
    public int hasImg;
    public String digest;
    public boolean hasIcon;
    public String docid;
    public String title;
    public int order;
    public List<WapPluginfo> wap_pluginfo;
    public int priority;
    public String lmodify;
    public List<AutoWap> auto_wap;
    public String boardid;
    public List<Ads> ads;
    public String topic_background;
    public String url_3w;
    public String template;
    public int votecount;
    public String alias;
    public String cid;
    public String url;
    public int hasAD;
    public String source;
    public String ename;
    public String subtitle;
    public String imgsrc;
    public String tname;
    public String ptime;
    public List<ImgExtra> imgextra;

    public static class WapPluginfo {

        public String title;
        public String imgsrc;
        public String subtitle;
        public String url;
    }

    public static class AutoWap {

        public String title;
        public String imgsrc;
        public String subtitle;
        public String url;
    }

    public static class Ads {

        public String docid;
        public String title;
        public String skipID;
        public String tag;
        public String imgsrc;
        public String subtitle;
        public String skipType;
        public String url;
    }
}
