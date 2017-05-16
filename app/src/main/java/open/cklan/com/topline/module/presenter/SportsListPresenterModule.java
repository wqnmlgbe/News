package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.SportsService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.SportsListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class SportsListPresenterModule {
    NewsListContract.View view;

    public SportsListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    SportsListPresenter providePresenter(SportsService service){
        return new SportsListPresenter(this.view,service);
    }
}
