package open.cklan.com.topline.module.presenter;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.annotations.PerBindingActivity;
import open.cklan.com.topline.api.ImageService;
import open.cklan.com.topline.contract.NewsListContract;
import open.cklan.com.topline.presenter.ImageListPresenter;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:20
 */
@Module
public class ImageListPresenterModule {
    NewsListContract.View view;

    public ImageListPresenterModule(NewsListContract.View view){
        this.view=view;
    }

    @PerBindingActivity
    @Provides
    NewsListContract.View provideView(){
        return this.view;
    }

    @Provides
    @PerBindingActivity
    ImageListPresenter providePresenter(ImageService service){
        return new ImageListPresenter(this.view,service);
    }
}
