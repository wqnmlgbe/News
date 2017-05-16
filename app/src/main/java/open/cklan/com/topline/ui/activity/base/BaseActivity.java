package open.cklan.com.topline.ui.activity.base;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import open.cklan.com.topline.application.BaseApplication;
import open.cklan.com.topline.component.activity.ActivityComponent;
import open.cklan.com.topline.component.activity.DaggerActivityComponent;
import open.cklan.com.topline.component.application.AppComponent;
import open.cklan.com.topline.contract.BaseContract;
import open.cklan.com.topline.module.activity.ActivityModule;

/**
 * AUTHOR：lanchuanke on 17/5/3 17:32
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseContract.View{
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    protected abstract void initInject();

    public ActivityComponent getActivityComponent(){
        if(activityComponent==null){
            activityComponent= DaggerActivityComponent.builder()
                    .appComponent(getAppComponent())
                    .activityModule(new ActivityModule(this)).build();
        }
        return activityComponent;
    }

    protected AppComponent getAppComponent(){
        Application application = getApplication();
        if(application!=null && application instanceof BaseApplication){
            BaseApplication baseApplication= (BaseApplication) application;
            return baseApplication.getAppComponent();
        }else{
            throw new RuntimeException("Base Application must be BaseApplication");
        }
    }
}
