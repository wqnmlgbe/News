package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.HistoryService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.HistoryListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class HistoryListPresenterModule {
    NewsListContract.View view;

    public HistoryListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    HistoryListPresenter providePresenter(HistoryService service){
        return new HistoryListPresenter(this.view,service);
    }
}
