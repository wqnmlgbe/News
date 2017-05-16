package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.VideoService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.VideoListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class VideoListPresenterModule {
    NewsListContract.View view;

    public VideoListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    VideoListPresenter providePresenter(VideoService service){
        return new VideoListPresenter(this.view,service);
    }
}
