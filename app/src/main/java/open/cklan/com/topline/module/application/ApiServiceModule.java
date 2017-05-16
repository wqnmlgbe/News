package open.cklan.com.topline.module.application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.topline.api.BeautyService;
import open.cklan.com.topline.api.CarService;
import open.cklan.com.topline.api.EntertainmentService;
import open.cklan.com.topline.api.GameService;
import open.cklan.com.topline.api.HistoryService;
import open.cklan.com.topline.api.HotService;
import open.cklan.com.topline.api.ImageService;
import open.cklan.com.topline.api.NetEasyCategoryListService;
import open.cklan.com.topline.api.NewsDetailService;
import open.cklan.com.topline.api.SportsService;
import open.cklan.com.topline.api.TechService;
import open.cklan.com.topline.api.TopLineService;
import open.cklan.com.topline.api.VideoService;
import retrofit.Retrofit;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:35
 */
@Module
public class ApiServiceModule {

    @Provides
    @Singleton
    NewsDetailService provideNewsDetailService(Retrofit retrofit){
        return retrofit.create(NewsDetailService.class);
    }

    @Singleton
    @Provides
    NetEasyCategoryListService provideNetEasyCategoryListService(Retrofit retrofit){
        return retrofit.create(NetEasyCategoryListService.class);
    }

    @Provides
    @Singleton
    TopLineService provideTopLineService(Retrofit retrofit){
        return retrofit.create(TopLineService.class);
    }
    @Provides
    @Singleton
    VideoService provideVideoService(Retrofit retrofit){
        return retrofit.create(VideoService.class);
    }
    @Provides
    @Singleton
    TechService provideTechService(Retrofit retrofit){
        return retrofit.create(TechService.class);
    }
    @Provides
    @Singleton
    SportsService provideSportsService(Retrofit retrofit){
        return retrofit.create(SportsService.class);
    }
    @Provides
    @Singleton
    ImageService provideImageService(Retrofit retrofit){
        return retrofit.create(ImageService.class);
    }
    @Provides
    @Singleton
    HotService provideHotService(Retrofit retrofit){
        return retrofit.create(HotService.class);
    }
    @Provides
    @Singleton
    HistoryService provideHistoryService(Retrofit retrofit){
        return retrofit.create(HistoryService.class);
    }
    @Provides
    @Singleton
    GameService provideGameService(Retrofit retrofit){
        return retrofit.create(GameService.class);
    }
    @Provides
    @Singleton
    EntertainmentService provideEntertainmentService(Retrofit retrofit){
        return retrofit.create(EntertainmentService.class);
    }
    @Provides
    @Singleton
    CarService provideCarService(Retrofit retrofit){
        return retrofit.create(CarService.class);
    }
    @Provides
    @Singleton
    BeautyService provideBeautyService(Retrofit retrofit){
        return retrofit.create(BeautyService.class);
    }
}
