package open.cklan.com.topline.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import open.cklan.com.library.model.news_list.BaseListItemEntity;
import open.cklan.com.library.model.news_list.ImageListItemEntity;
import open.cklan.com.library.widget.refresh.adapter.BaseAdapter;
import open.cklan.com.library.widget.refresh.viewholder.BaseViewHolder;
import open.cklan.com.topline.R;
import open.cklan.com.topline.adapter.base.BaseNewsListAdapter;
import open.cklan.com.topline.contract.NewsListContract;

/**
 * AUTHOR：lanchuanke on 17/5/4 16:44
 */
public class ImageListAdapter extends BaseNewsListAdapter {
    private NewsListContract.UserActionListener listener;
    public ImageListAdapter(List<BaseListItemEntity> data, Context context, NewsListContract.UserActionListener listener) {
        super(context,data);
        this.listener=listener;
        addDefaultItemViewType(R.layout.item_news_pic);
    }

    @Override
    protected void bindData(BaseViewHolder holder, BaseListItemEntity item, int position) {
        if(item!=null && item instanceof ImageListItemEntity) {
            ImageListItemEntity itemEntity= (ImageListItemEntity) item;
            holder.setImageUrl(R.id.imageView,itemEntity.cover);
            holder.setText(R.id.tv_img_num,itemEntity.imgsum+"张");
            holder.setText(R.id.tv_title,itemEntity.setname);
            holder.setText(R.id.tv_comment_num,itemEntity.replynum+"条评论");
            holder.addOnClickListener(R.id.layout_item_news,this);
        }
    }


    @Override
    public void onItemClick(BaseAdapter adapter, View view, int position) {
        BaseListItemEntity item = getItem(position);
        if(item!=null && item instanceof ImageListItemEntity) {
            ImageListItemEntity itemEntity = (ImageListItemEntity) item;
            listener.clickItem(itemEntity.pics);
        }
    }
}
