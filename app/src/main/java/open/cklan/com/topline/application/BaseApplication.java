package open.cklan.com.topline.application;

import android.app.Application;
import android.content.SharedPreferences;

import javax.inject.Inject;

import open.cklan.com.topline.component.application.AppComponent;
import open.cklan.com.topline.component.application.DaggerAppComponent;
import open.cklan.com.topline.module.application.AppModule;

/**
 * AUTHOR：lanchuanke on 17/5/3 21:51
 */
public class BaseApplication extends Application {

    private AppComponent appComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent= DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent(){
        return this.appComponent;
    }
}
