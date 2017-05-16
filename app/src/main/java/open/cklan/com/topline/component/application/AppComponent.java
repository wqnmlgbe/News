package open.cklan.com.topline.component.application;

import android.content.SharedPreferences;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Component;
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
import open.cklan.com.topline.application.BaseApplication;
import open.cklan.com.topline.module.application.AppModule;
import retrofit.Retrofit;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:24
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    BaseApplication getApplication();

    NetEasyCategoryListService getNetEasyCategoryList();

    TopLineService getTopLineService();

    VideoService getVideoService();

    TechService getTechService();

    SportsService getSportsService();

    ImageService getImageService();

    HotService getHotService();

    HistoryService getHistoryService();

    GameService getGameService();

    EntertainmentService getEntertainmentService();

    CarService getCarService();

    BeautyService getBeautyService();

    NewsDetailService getNewsDetailService();

    SharedPreferences getSharedPreferences();

    Retrofit getRetrofit();

    OkHttpClient getOkHttpClient();
}
