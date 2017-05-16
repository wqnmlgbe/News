package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.EntertainmentService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.EntertainmentListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class EntertainmentListPresenterModule {
    NewsListContract.View view;

    public EntertainmentListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    EntertainmentListPresenter providePresenter(EntertainmentService service){
        return new EntertainmentListPresenter(this.view,service);
    }
}
