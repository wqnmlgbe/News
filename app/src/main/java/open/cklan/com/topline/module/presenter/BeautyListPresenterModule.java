package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.BeautyService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.BeautyListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class BeautyListPresenterModule {
    NewsListContract.View view;

    public BeautyListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    BeautyListPresenter providePresenter(BeautyService service){
        return new BeautyListPresenter(this.view,service);
    }
}
