package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.TechService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.TechListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class TechListPresenterModule {
    NewsListContract.View view;

    public TechListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    TechListPresenter providePresenter(TechService service){
        return new TechListPresenter(this.view,service);
    }
}
