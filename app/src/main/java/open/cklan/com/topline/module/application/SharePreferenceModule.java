package open.cklan.com.topline.module.application;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.topline.application.BaseApplication;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:22
 */
@Module
public class SharePreferenceModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(BaseApplication context){
        return context.getSharedPreferences("cache",Context.MODE_PRIVATE);
    }
}
