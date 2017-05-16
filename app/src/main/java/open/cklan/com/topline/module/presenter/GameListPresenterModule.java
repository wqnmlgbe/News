package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.GameService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.GameListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class GameListPresenterModule {
    NewsListContract.View view;

    public GameListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    GameListPresenter providePresenter(GameService service){
        return new GameListPresenter(this.view,service);
    }
}
