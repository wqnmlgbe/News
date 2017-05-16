package open.cklan.com.topline.presenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import open.cklan.com.library.annotations.CategoryTid;
import open.cklan.com.library.annotations.CategoryTitle;
import open.cklan.com.library.annotations.CategoryType;
import open.cklan.com.library.utils.LogUtil;
import open.cklan.com.topline.api.CategoryListService;
import open.cklan.com.topline.api.NetEasyCategoryListService;
import open.cklan.com.topline.constant.Constants;
import open.cklan.com.topline.contract.MainContract;
import open.cklan.com.library.model.CategoryEntity;
import open.cklan.com.library.model.NetEasyCategoryEntity;
import open.cklan.com.library.model.NetEasyCategoryListEntity;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:00
 */
public class MainActivityPresenter extends BasePresenter<MainContract.View> implements MainContract.UserActionListener {


    @Inject
    public MainActivityPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void loadCategories() {
       new CategoryListServiceImpl().categoryList()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Subscriber<List<CategoryEntity>>() {
                   @Override
                   public void onCompleted() {

                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onNext(List<CategoryEntity> categoryEntities) {
                        view.showCategories(categoryEntities);
                   }
               });
    }

    class CategoryListServiceImpl implements CategoryListService {

        @Override
        public Observable<List<CategoryEntity>> categoryList() {
            return Observable.create(new Observable.OnSubscribe<List<CategoryEntity>>() {
                @Override
                public void call(Subscriber<? super List<CategoryEntity>> subscriber) {
                    subscriber.onNext(initCategoryList());
                    subscriber.onCompleted();
                }
            });
        }

        private List<CategoryEntity> initCategoryList() {
            List<CategoryEntity> list = new ArrayList<>();
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_TOP, CategoryType.CATEGORY_TYPE_TOP, CategoryTid.CATEGORY_TID_TOP));
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_VIDEO, CategoryType.CATEGORY_TYPE_VIDEO,CategoryTid.CATEGORY_TID_VIDEO));
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_IMAGE, CategoryType.CATEGORY_TYPE_IMAGE,CategoryTid.CATEGORY_TID_IMAGE));
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_BEAUTY,CategoryType.CATEGORY_TYPE_BEAUTY,CategoryTid.CATEGORY_TID_BEAUTY));
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_SPORTS, CategoryType.CATEGORY_TYPE_SPORTS,CategoryTid.CATEGORY_TID_SPORTS));
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_CAR, CategoryType.CATEGORY_TYPE_CAR,CategoryTid.CATEGORY_TID_CAR));
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_ENTERTAINMENT, CategoryType.CATEGORY_TYPE_ENTERTAINMENT,CategoryTid.CATEGORY_TID_ENTERTAINMENT));
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_HOT, CategoryType.CATEGORY_TYPE_HOT,CategoryTid.CATEGORY_TID_HOT));
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_HISTORY, CategoryType.CATEGORY_TYPE_HISTORY,CategoryTid.CATEGORY_TID_HISTORY));
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_TECH, CategoryType.CATEGORY_TYPE_TECH,CategoryTid.CATEGORY_TID_TECH));
            list.add(new CategoryEntity(CategoryTitle.CATEGORY_TITLE_GAME,CategoryType.CATEGORY_TYPE_GAME,CategoryTid.CATEGORY_TID_GAME));
            return list;
        }
    }

}