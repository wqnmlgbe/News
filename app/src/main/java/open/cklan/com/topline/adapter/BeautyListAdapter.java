package open.cklan.com.topline.adapter;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

import open.cklan.com.library.model.news_list.BaseListItemEntity;
import open.cklan.com.library.model.news_list.BeautyListItemEntity;
import open.cklan.com.library.widget.refresh.adapter.BaseAdapter;
import open.cklan.com.library.widget.refresh.viewholder.BaseViewHolder;
import open.cklan.com.topline.R;
import open.cklan.com.topline.adapter.base.BaseNewsListAdapter;
import open.cklan.com.topline.contract.NewsListContract;

/**
 * AUTHOR：lanchuanke on 17/5/4 16:44
 */
public class BeautyListAdapter extends BaseNewsListAdapter {
    private NewsListContract.UserActionListener listener;
    public BeautyListAdapter(List<BaseListItemEntity> data, Context context, NewsListContract.UserActionListener listener) {
        super(context,data);
        this.listener=listener;
        addDefaultItemViewType(R.layout.item_news_pic);
    }


    @Override
    protected void bindData(BaseViewHolder holder, BaseListItemEntity item, int position) {
        if(item!=null && item instanceof BeautyListItemEntity) {
            BeautyListItemEntity itemEntity= (BeautyListItemEntity) item;
            holder.setImageUrl(R.id.imageView,itemEntity.imgsrc);
            holder.setText(R.id.tv_title,itemEntity.title);
            holder.setText(R.id.tv_img_num,itemEntity.picCount+"张");
            holder.setText(R.id.tv_comment_num,itemEntity.replyCount+"条评论");
        }
    }


    @Override
    public void onItemClick(BaseAdapter adapter, View view, int position) {

    }
}
