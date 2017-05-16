package open.cklan.com.topline.component.activity;

import dagger.Component;
import open.cklan.com.library.annotations.ActivityScope;
import open.cklan.com.topline.component.application.AppComponent;
import open.cklan.com.topline.ui.activity.base.BaseActivity;
import open.cklan.com.topline.module.activity.ActivityModule;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:24
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent extends AppComponent {
    BaseActivity getActivity();
}
