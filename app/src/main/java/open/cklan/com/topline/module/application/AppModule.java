package open.cklan.com.topline.module.application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.topline.application.BaseApplication;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:20
 */

@Module(includes = {
        OkHttpModule.class,
        RetrofitModule.class,
        SharePreferenceModule.class,
        ApiServiceModule.class
})
public class AppModule {

    BaseApplication context;

    public AppModule( BaseApplication context){
        this.context=context;
    }

    @Provides
    @Singleton
    public BaseApplication provideApplication(){
        return this.context;
    }
}
