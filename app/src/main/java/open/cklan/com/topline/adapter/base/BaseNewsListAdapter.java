package open.cklan.com.topline.adapter.base;

import android.content.Context;
import android.widget.AdapterView;

import java.util.List;

import open.cklan.com.library.model.news_list.BaseListItemEntity;
import open.cklan.com.library.widget.refresh.adapter.BaseAdapter;
import open.cklan.com.library.widget.refresh.viewholder.BaseViewHolder;

/**
 * AUTHOR：lanchuanke on 17/5/11 18:29
 */
public abstract class BaseNewsListAdapter extends BaseAdapter<BaseListItemEntity,BaseViewHolder> implements BaseAdapter.OnItemClickListener {
    public BaseNewsListAdapter(Context mContext, List<BaseListItemEntity> mDatas) {
        super(mContext, mDatas);
        setAnimationEnable(true);
    }
}
