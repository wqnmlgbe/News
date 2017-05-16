package open.cklan.com.topline.presenter;

import javax.inject.Inject;

import open.cklan.com.library.model.NewsDetailEntity;
import open.cklan.com.topline.api.NewsDetailService;
import open.cklan.com.topline.contract.NewsDetailContract;
import open.cklan.com.library.model.NewsContentEntity;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * AUTHOR：lanchuanke on 17/5/5 14:31
 */
public class NewsDetailPresenter extends BasePresenter<NewsDetailContract.View> implements NewsDetailContract.UserActionListener {
    NewsDetailService service;

    @Inject
    public NewsDetailPresenter(NewsDetailContract.View view,NewsDetailService service) {
        this.view=view;
        this.service=service;
    }

    @Override
    public void loadNewsContent(String id) {
        service.getContent(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsDetailEntity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(NewsDetailEntity detailEntity) {
                        view.showContent(detailEntity.entity);
                    }
                });
    }

    @Override
    public void loadNewsComment(String groupId, String itemId) {

    }
}
