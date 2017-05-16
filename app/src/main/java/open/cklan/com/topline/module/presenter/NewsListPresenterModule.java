package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.BeautyService;
import open.cklan.com.topline.api.CarService;
import open.cklan.com.topline.api.EntertainmentService;
import open.cklan.com.topline.api.GameService;
import open.cklan.com.topline.api.HistoryService;
import open.cklan.com.topline.api.HotService;
import open.cklan.com.topline.api.ImageService;
import open.cklan.com.topline.api.SportsService;
import open.cklan.com.topline.api.TechService;
import open.cklan.com.topline.api.TopLineService;
import open.cklan.com.topline.api.VideoService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.BeautyListPresenter;
import open.cklan.com.topline.presenter.CarListPresenter;
import open.cklan.com.topline.presenter.EntertainmentListPresenter;
import open.cklan.com.topline.presenter.GameListPresenter;
import open.cklan.com.topline.presenter.HistoryListPresenter;
import open.cklan.com.topline.presenter.HotListPresenter;
import open.cklan.com.topline.presenter.ImageListPresenter;
import open.cklan.com.topline.presenter.SportsListPresenter;
import open.cklan.com.topline.presenter.TechListPresenter;
import open.cklan.com.topline.presenter.TopLineListPresenter;
import open.cklan.com.topline.presenter.VideoListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class NewsListPresenterModule {
    NewsListContract.View view;
    public NewsListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    VideoListPresenter provideVideoPresenter(VideoService service){
        return new VideoListPresenter(this.view,service);
    }

    @Provides
    @PerBindingActivity
    BeautyListPresenter provideBeautyPresenter(BeautyService service){
        return new BeautyListPresenter(this.view,service);
    }

    @Provides
    @PerBindingActivity
    CarListPresenter provideCarPresenter(CarService service){
        return new CarListPresenter(this.view,service);
    }

    @Provides
    @PerBindingActivity
    EntertainmentListPresenter provideEntertainmentPresenter(EntertainmentService service){
        return new EntertainmentListPresenter(this.view,service);
    }

    @Provides
    @PerBindingActivity
    GameListPresenter provideGamePresenter(GameService service){
        return new GameListPresenter(this.view,service);
    }

    @Provides
    @PerBindingActivity
    HistoryListPresenter provideHistoryPresenter(HistoryService service){
        return new HistoryListPresenter(this.view,service);
    }

    @Provides
    @PerBindingActivity
    HotListPresenter provideHotPresenter(HotService service){
        return new HotListPresenter(this.view,service);
    }

    @Provides
    @PerBindingActivity
    ImageListPresenter provideImagePresenter(ImageService service){
        return new ImageListPresenter(this.view,service);
    }

    @Provides
    @PerBindingActivity
    SportsListPresenter provideSportsPresenter(SportsService service){
        return new SportsListPresenter(this.view,service);
    }

    @Provides
    @PerBindingActivity
    TechListPresenter provideTechPresenter(TechService service){
        return new TechListPresenter(this.view,service);
    }

    @Provides
    @PerBindingActivity
    TopLineListPresenter provideTopLinePresenter(TopLineService service){
        return new TopLineListPresenter(this.view,service);
    }



}
