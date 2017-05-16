package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.TopLineService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.TopLineListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class TopLineListPresenterModule {
    NewsListContract.View view;

    public TopLineListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    TopLineListPresenter providePresenter(TopLineService service){
        return new TopLineListPresenter(this.view,service);
    }
}
