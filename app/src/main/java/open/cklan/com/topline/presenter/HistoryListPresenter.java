package open.cklan.com.topline.presenter;

import javax.inject.Inject;

import open.cklan.com.library.model.NewsListEntity;
import open.cklan.com.library.model.news_list.HistoryListItemEntity;
import open.cklan.com.topline.api.HistoryService;
import open.cklan.com.topline.contract.NewsListContract;
import retrofit.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * AUTHOR：lanchuanke on 17/5/4 15:58
 */
public class HistoryListPresenter extends BaseListPresenter{
    HistoryService service;

    @Inject
    public HistoryListPresenter(NewsListContract.View view, HistoryService service) {
        this.view=view;
        this.service=service;
    }

    @Override
    public void refreshNewsList(String tid,long offset,long size) {
        service.newsList(tid,offset,size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Response<NewsListEntity<HistoryListItemEntity>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response<NewsListEntity<HistoryListItemEntity>> newsListEntityResponse) {
                view.showList(newsListEntityResponse.body().entities);
            }
        });
    }

    @Override
    public void loadMoreNewsList(String tid, long offset, long size) {
        service.newsList(tid,offset,size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Response<NewsListEntity<HistoryListItemEntity>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response<NewsListEntity<HistoryListItemEntity>> newsListEntityResponse) {
                view.addList(newsListEntityResponse.body().entities);
            }
        });
    }

    @Override
    public void ignoreNew(int position,String category) {

    }

    @Override
    public void clickItem(String url) {
        view.goDetailActivity(url);
    }
}
