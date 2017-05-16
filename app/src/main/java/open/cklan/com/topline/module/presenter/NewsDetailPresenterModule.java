package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.NewsDetailService;
import open.cklan.com.topline.contract.NewsDetailContract;
import open.cklan.com.topline.presenter.NewsDetailPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class NewsDetailPresenterModule {
    NewsDetailContract.View view;

    public NewsDetailPresenterModule(NewsDetailContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsDetailPresenter providePresenter(NewsDetailService service){
        return new NewsDetailPresenter(this.view,service);
    }

    @PerBindingActivity
    @Provides
    NewsDetailContract.View provideView(){
        return this.view;
    }
}
