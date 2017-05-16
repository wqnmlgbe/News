package open.cklan.com.topline.module.activity;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.ActivityScope;
import open.cklan.com.topline.ui.activity.base.BaseActivity;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:20
 */
@Module
public class ActivityModule {
    BaseActivity activity;

    public ActivityModule(BaseActivity activity){
        this.activity=activity;
    }

    @Provides
    @ActivityScope
    BaseActivity provideActivity(){
        return this.activity;
    }

}
