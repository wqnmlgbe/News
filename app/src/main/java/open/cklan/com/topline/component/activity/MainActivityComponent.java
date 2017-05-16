package open.cklan.com.topline.component.activity;

import dagger.Component;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.module.presenter.MainPresenterModule;
import open.cklan.com.topline.presenter.MainActivityPresenter;
import open.cklan.com.topline.ui.activity.MainActivity;

/**
 * AUTHOR：lanchuanke on 17/5/4 10:10
 */
@PerBindingActivity
@Component(dependencies = ActivityComponent.class,modules = MainPresenterModule.class)
public interface MainActivityComponent extends ActivityComponent{

    void inject(MainActivity activity);

    MainActivityPresenter getPresenter();
}
