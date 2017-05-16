package open.cklan.com.topline.component.activity;

import dagger.Component;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.module.presenter.MainPresenterModule;
import open.cklan.com.topline.module.presenter.NewsDetailPresenterModule;
import open.cklan.com.topline.presenter.MainActivityPresenter;
import open.cklan.com.topline.presenter.NewsDetailPresenter;
import open.cklan.com.topline.ui.activity.MainActivity;
import open.cklan.com.topline.ui.activity.NewsDetailActivity;

/**
 * AUTHOR：lanchuanke on 17/5/4 10:10
 */
@PerBindingActivity
@Component(dependencies = ActivityComponent.class,modules = NewsDetailPresenterModule.class)
public interface NewsDetailActivityComponent extends ActivityComponent{

    void inject(NewsDetailActivity activity);

    NewsDetailPresenter getPresenter();
}
