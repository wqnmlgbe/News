package open.cklan.com.topline.presenter;

import javax.inject.Inject;

import open.cklan.com.library.model.NewsListEntity;
import open.cklan.com.library.model.news_list.CarListItemEntity;
import open.cklan.com.topline.api.CarService;
import open.cklan.com.topline.contract.NewsListContract;
import retrofit.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * AUTHOR：lanchuanke on 17/5/4 15:58
 */
public class CarListPresenter extends BaseListPresenter{
    CarService service;

    @Inject
    public CarListPresenter(NewsListContract.View view, CarService service) {
        this.view=view;
        this.service=service;
    }

    @Override
    public void refreshNewsList(String tid,long offset,long size) {
        service.newsList(offset,size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Response<NewsListEntity<CarListItemEntity>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response<NewsListEntity<CarListItemEntity>> newsListEntityResponse) {
                if(newsListEntityResponse!=null && newsListEntityResponse.body()!=null){
                    view.showList(newsListEntityResponse.body().entities);
                }
            }
        });
    }

    @Override
    public void loadMoreNewsList(String tid, long offset, long size) {
        service.newsList(offset,size)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<Response<NewsListEntity<CarListItemEntity>>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Response<NewsListEntity<CarListItemEntity>> newsListEntityResponse) {
                if(newsListEntityResponse!=null && newsListEntityResponse.body()!=null){
                    view.addList(newsListEntityResponse.body().entities);
                }
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
