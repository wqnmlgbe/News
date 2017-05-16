package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.HotService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.HotListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class HotListPresenterModule {
    NewsListContract.View view;

    public HotListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    HotListPresenter providePresenter(HotService service){
        return new HotListPresenter(this.view,service);
    }
}
