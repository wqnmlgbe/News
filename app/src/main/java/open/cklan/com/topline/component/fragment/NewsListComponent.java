package open.cklan.com.topline.component.fragment;

import dagger.Component;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.component.activity.ActivityComponent;
import open.cklan.com.topline.module.presenter.NewsListPresenterModule;
import open.cklan.com.topline.presenter.BeautyListPresenter;
import open.cklan.com.topline.presenter.CarListPresenter;
import open.cklan.com.topline.presenter.EntertainmentListPresenter;
import open.cklan.com.topline.presenter.GameListPresenter;
import open.cklan.com.topline.presenter.HistoryListPresenter;
import open.cklan.com.topline.presenter.HotListPresenter;
import open.cklan.com.topline.presenter.ImageListPresenter;
import open.cklan.com.topline.presenter.SportsListPresenter;
import open.cklan.com.topline.presenter.TechListPresenter;
import open.cklan.com.topline.presenter.TopLineListPresenter;
import open.cklan.com.topline.presenter.VideoListPresenter;
import open.cklan.com.topline.ui.fragment.news_list.NewsListFragment;

/**
 * AUTHOR：lanchuanke on 17/5/4 16:15
 */
@PerBindingActivity
@Component(dependencies = ActivityComponent.class
        ,modules = NewsListPresenterModule.class)
public interface NewsListComponent extends ActivityComponent {

    void inject(NewsListFragment fragment);

    VideoListPresenter videoPresenter();

    TopLineListPresenter topLinePresenter();

    TechListPresenter techPresenter();

    SportsListPresenter sportsPresenter();

    ImageListPresenter imagePresenter();

    HotListPresenter hotPresenter();

    HistoryListPresenter historyPresenter();

    GameListPresenter gamePresenter();

    EntertainmentListPresenter entertainmentPresenter();

    CarListPresenter carPresenter();

    BeautyListPresenter beautyPresenter();

}
