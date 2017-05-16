package open.cklan.com.topline.adapter;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.Bind;
import open.cklan.com.library.model.news_list.BaseListItemEntity;
import open.cklan.com.library.model.news_list.VideoListItemEntity;
import open.cklan.com.library.widget.refresh.adapter.BaseAdapter;
import open.cklan.com.library.widget.refresh.viewholder.BaseViewHolder;
import open.cklan.com.topline.R;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.videoplayer.JCVideoPlayer;
import open.cklan.com.videoplayer.JCVideoPlayerStandard;

/**
 * AUTHOR：lanchuanke on 17/5/4 16:44
 */
public class VideoListAdapter extends BaseAdapter<BaseListItemEntity,VideoListAdapter.ViewHolder> {
    private NewsListContract.UserActionListener listener;
    public VideoListAdapter(List<BaseListItemEntity> data, Context context, NewsListContract.UserActionListener listener) {
        super(context,data);
        this.listener=listener;
        addDefaultItemViewType(R.layout.item_video);
    }

    @Override
    protected void bindData(ViewHolder holder, BaseListItemEntity item, int position) {
        VideoListItemEntity itemEntity= (VideoListItemEntity) item;
        holder.videoPlayer.setUp(itemEntity.mp4_url, JCVideoPlayer.SCREEN_LAYOUT_LIST,itemEntity.title);
        Glide.with(mContext).load(itemEntity.cover).into(holder.videoPlayer.thumbImageView);
    }

    public class ViewHolder extends BaseViewHolder {
        @Bind(R.id.videoplayer)
        JCVideoPlayerStandard videoPlayer;
        @Bind(R.id.layout_item_news)
        RelativeLayout layoutItemNews;

        public ViewHolder(View itemView) {
            super(itemView);

        }

    }
}
