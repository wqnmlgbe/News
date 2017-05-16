package open.cklan.com.topline.adapter;

import android.content.Context;
import android.text.TextUtils;

import java.util.List;

import open.cklan.com.library.model.NewsContentEntity;
import open.cklan.com.library.model.NewsContentParserEntity;
import open.cklan.com.library.model.base.BaseMultiItem;
import open.cklan.com.library.widget.refresh.adapter.BaseAdapter;
import open.cklan.com.library.widget.refresh.viewholder.BaseViewHolder;
import open.cklan.com.topline.R;

/**
 * AUTHOR：lanchuanke on 17/5/15 14:06
 */
public class NewsDetailAdapter extends BaseAdapter<BaseMultiItem,BaseViewHolder> {
    private static final int TYPE_TEXT=1;
    private static final int TYPE_IMG=2;
    private static final int TYPE_VIDEO=3;
    private static final int TYPE_COMMENT=4;
    public NewsDetailAdapter(Context mContext, List<BaseMultiItem> mDatas) {
        super(mContext, mDatas);
        addItemViewType(TYPE_TEXT, R.layout.item_detail_text);
        addItemViewType(TYPE_IMG, R.layout.item_detail_image);
        addItemViewType(TYPE_VIDEO, R.layout.item_detail_video);
        addItemViewType(TYPE_COMMENT, R.layout.item_detail_comment);
    }

    @Override
    protected void bindData(BaseViewHolder holder, BaseMultiItem item, int position) {
        int viewType=getItemViewType(position);
        Object data = item.data;
        switch (viewType){
            case TYPE_TEXT:
                if(data!=null && data instanceof NewsContentParserEntity){
                    holder.setText(R.id.tv_content,((NewsContentParserEntity) data).body);
                }
                break;
            case TYPE_IMG:
                if(data!=null && data instanceof NewsContentEntity.ImgEntity){
                    NewsContentEntity.ImgEntity imgEntity= (NewsContentEntity.ImgEntity) data;
                    String pixel=imgEntity.pixel;
                    if(!TextUtils.isEmpty(pixel)){
                        String[] size=pixel.split("\\*");
                        int width=Integer.valueOf(size[0]);
                        int height=Integer.valueOf(size[1]);
                        holder.setSize(R.id.imageView,width,height);
                    }
                    holder.setImageUrl(R.id.imageView,imgEntity.src);
                }
                break;
            case TYPE_VIDEO:
                break;
            case TYPE_COMMENT:
                break;
        }
    }
}
