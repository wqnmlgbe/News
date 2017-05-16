package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.CategoryListService;
import open.cklan.com.topline.api.NetEasyCategoryListService;
import open.cklan.com.topline.contract.MainContract;
import open.cklan.com.topline.presenter.MainActivityPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class MainPresenterModule {
    MainContract.View view;

    public MainPresenterModule(MainContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    MainContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    MainActivityPresenter providePresenter(){
        return new MainActivityPresenter(this.view);
    }
}
