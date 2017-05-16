package open.cklan.com.topline.presenter;

import java.util.List;

import javax.inject.Inject;

import open.cklan.com.library.model.NewsListEntity;
import open.cklan.com.library.model.news_list.ImageListItemEntity;
import open.cklan.com.topline.api.ImageService;
import open.cklan.com.topline.contract.NewsListContract;
import retrofit.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * AUTHOR：lanchuanke on 17/5/4 15:58
 */
public class ImageListPresenter extends BaseListPresenter{
    ImageService service;

    @Inject
    public ImageListPresenter(NewsListContract.View view, ImageService service) {
        this.view=view;
        this.service=service;
    }

    @Override
    public void refreshNewsList(String tid,long offset,long size) {
        service.newsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Response<List<ImageListItemEntity>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showRefreshError("1001",e.getMessage());
            }

            @Override
            public void onNext(Response<List<ImageListItemEntity>> newsListEntityResponse) {
                view.showList(newsListEntityResponse.body());
            }
        });
    }

    @Override
    public void loadMoreNewsList(String tid, long offset, long size) {
        service.newsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Response<List<ImageListItemEntity>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                view.showLoadMoreError("1002",e.getMessage());
            }

            @Override
            public void onNext(Response<List<ImageListItemEntity>> newsListEntityResponse) {
                view.addList(newsListEntityResponse.body());
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
