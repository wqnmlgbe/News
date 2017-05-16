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
import open.cklan.com.library.model.news_list.GameListItemEntity;
import open.cklan.com.library.widget.refresh.adapter.BaseAdapter;
import open.cklan.com.library.widget.refresh.viewholder.BaseViewHolder;
import open.cklan.com.topline.R;
import open.cklan.com.topline.adapter.base.BaseNewsListAdapter;
import open.cklan.com.topline.contract.NewsListContract;

/**
 * AUTHOR：lanchuanke on 17/5/4 16:44
 */
public class GameListAdapter extends BaseNewsListAdapter {
    private NewsListContract.UserActionListener listener;
    public GameListAdapter(List<BaseListItemEntity> data, Context context, NewsListContract.UserActionListener listener) {
        super(context,data);
        this.listener=listener;
        addDefaultItemViewType(R.layout.item_news_single_img);
    }


    @Override
    protected void bindData(BaseViewHolder holder, BaseListItemEntity item, int position) {
        if(item!=null && item instanceof GameListItemEntity) {
            GameListItemEntity itemEntity= (GameListItemEntity) item;
            holder.setImageUrl(R.id.imageView,itemEntity.imgsrc);
            holder.setText(R.id.tv_title,itemEntity.title);
            holder.setText(R.id.tv_source,itemEntity.source);
            holder.setText(R.id.tv_comment_num,itemEntity.replyCount+"条评论");
        }
    }

    @Override
    public void onItemClick(BaseAdapter adapter, View view, int position) {

    }
}
