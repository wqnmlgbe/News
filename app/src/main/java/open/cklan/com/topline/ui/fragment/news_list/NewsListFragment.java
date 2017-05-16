package open.cklan.com.topline.ui.fragment.news_list;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import open.cklan.com.library.annotations.CategoryTid;
import open.cklan.com.library.model.news_list.BaseListItemEntity;
import open.cklan.com.library.utils.SnackBarUtil;
import open.cklan.com.library.widget.refresh.ProgressStyle;
import open.cklan.com.library.widget.refresh.XRecyclerView;
import open.cklan.com.library.widget.refresh.adapter.BaseAdapter;
import open.cklan.com.topline.R;
import open.cklan.com.topline.adapter.BeautyListAdapter;
import open.cklan.com.topline.adapter.CarListAdapter;
import open.cklan.com.topline.adapter.EntertainmentListAdapter;
import open.cklan.com.topline.adapter.GameListAdapter;
import open.cklan.com.topline.adapter.HistoryListAdapter;
import open.cklan.com.topline.adapter.HotListAdapter;
import open.cklan.com.topline.adapter.ImageListAdapter;
import open.cklan.com.topline.adapter.SportsListAdapter;
import open.cklan.com.topline.adapter.TechListAdapter;
import open.cklan.com.topline.adapter.TopLineListAdapter;
import open.cklan.com.topline.adapter.VideoListAdapter;
import open.cklan.com.topline.component.fragment.DaggerNewsListComponent;
import open.cklan.com.topline.component.fragment.NewsListComponent;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.module.presenter.NewsListPresenterModule;
import open.cklan.com.topline.presenter.BaseListPresenter;
import open.cklan.com.topline.ui.activity.GalleryActivity;
import open.cklan.com.topline.ui.activity.NewsDetailActivity;
import open.cklan.com.topline.ui.fragment.base.BaseNewsListFragment;

/**
 * AUTHOR：lanchuanke on 17/5/4 15:24
 */
public class NewsListFragment extends BaseNewsListFragment implements NewsListContract.View{

    @Bind(R.id.recyclerView)
    XRecyclerView recyclerView;
    BaseListPresenter presenter;
    NewsListComponent component;

    List<BaseListItemEntity> newsList=new ArrayList<>();
    BaseAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_news_list,null);
        ButterKnife.bind(this,view);
        initPage();
        return view;
    }

    private void initPage() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        recyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.refreshNewsList(categoryEntity.tid,0,20);
            }

            @Override
            public void onLoadMore() {
                presenter.loadMoreNewsList(categoryEntity.tid,newsList.size(),20);
            }
        });
        recyclerView.refresh();
    }


    @Override
    protected void initInject() {
        DaggerNewsListComponent.Builder builder = DaggerNewsListComponent.builder();
        builder.activityComponent(getActivityComponent());
        builder.newsListPresenterModule(new NewsListPresenterModule(this));
        component=builder.build();
        component.inject(this);
        initPresenterAndAdapterByTid();
    }

    private void initPresenterAndAdapterByTid() {
        switch (categoryEntity.tid){
            case CategoryTid.CATEGORY_TID_BEAUTY:
                presenter=component.beautyPresenter();
                adapter=new BeautyListAdapter(this.newsList,getContext(),presenter);
                break;
            case CategoryTid.CATEGORY_TID_CAR:
                presenter=component.carPresenter();
                adapter=new CarListAdapter(this.newsList,getContext(),presenter);
                break;
            case CategoryTid.CATEGORY_TID_ENTERTAINMENT:
                presenter=component.entertainmentPresenter();
                adapter=new EntertainmentListAdapter(this.newsList,getContext(),presenter);
                break;
            case CategoryTid.CATEGORY_TID_GAME:
                presenter=component.gamePresenter();
                adapter=new GameListAdapter(this.newsList,getContext(),presenter);
                break;
            case CategoryTid.CATEGORY_TID_HISTORY:
                presenter=component.historyPresenter();
                adapter=new HistoryListAdapter(this.newsList,getContext(),presenter);
                break;
            case CategoryTid.CATEGORY_TID_HOT:
                presenter=component.hotPresenter();
                adapter=new HotListAdapter(this.newsList,getContext(),presenter);
                break;
            case CategoryTid.CATEGORY_TID_IMAGE:
                presenter=component.imagePresenter();
                adapter=new ImageListAdapter(this.newsList,getContext(),presenter);
                break;
            case CategoryTid.CATEGORY_TID_SPORTS:
                presenter=component.sportsPresenter();
                adapter=new SportsListAdapter(this.newsList,getContext(),presenter);
                break;
            case CategoryTid.CATEGORY_TID_TECH:
                presenter=component.techPresenter();
                adapter=new TechListAdapter(this.newsList,getContext(),presenter);
                break;
            case CategoryTid.CATEGORY_TID_TOP:
                presenter=component.topLinePresenter();
                adapter=new TopLineListAdapter(this.newsList,getContext(),presenter);
                break;
            case CategoryTid.CATEGORY_TID_VIDEO:
                presenter=component.videoPresenter();
                adapter=new VideoListAdapter(this.newsList,getContext(),presenter);
                break;
        }
    }

    @Override
    public void showList(List<? extends BaseListItemEntity> newsList) {
        recyclerView.refreshComplete();
        this.newsList.addAll(0,newsList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void addList(List<? extends BaseListItemEntity> newsList) {
        recyclerView.loadMoreComplete();
        this.newsList.addAll(newsList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void goDetailActivity(String id) {
        Intent intent=new Intent();
        intent.setClass(getContext(), NewsDetailActivity.class);
        intent.putExtra(NewsDetailActivity.ARG_DOC_ID,id);
        startActivity(intent);
    }

    @Override
    public void goGalleryActivity(List<String> pic) {
        if(pic==null || pic.size()==0)return;
        Intent intent=new Intent();
        intent.setClass(getContext(), GalleryActivity.class);
        intent.putExtra(GalleryActivity.ARG_PIC, (Serializable) pic);
        startActivity(intent);
    }

    @Override
    public void showRefreshError(String errorCode, String errorMessage) {
        recyclerView.refreshComplete();
        SnackBarUtil.showMessage(recyclerView,errorMessage);
    }

    @Override
    public void showLoadMoreError(String errorCode, String errorMessage) {
        recyclerView.loadMoreComplete();
        SnackBarUtil.showMessage(recyclerView,errorMessage);
    }
}
