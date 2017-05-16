package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.CarService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.CarListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class CarListPresenterModule {
    NewsListContract.View view;

    public CarListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    CarListPresenter providePresenter(CarService service){
        return new CarListPresenter(this.view,service);
    }
}
