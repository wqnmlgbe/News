package open.cklan.com.topline.presenter;

import java.util.List;

import open.cklan.com.topline.contract.BaseContract;
import open.cklan.com.topline.contract.NewsListContract;

/**
 * AUTHOR：lanchuanke on 17/5/3 17:38
 */
public abstract class BaseListPresenter extends BasePresenter<NewsListContract.View> implements NewsListContract.UserActionListener{

    @Override
    public void clickItem(List<String> pic) {
        view.goGalleryActivity(pic);
    }
}
