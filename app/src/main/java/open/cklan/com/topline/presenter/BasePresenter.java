package open.cklan.com.topline.presenter;

import javax.inject.Inject;

import open.cklan.com.topline.contract.BaseContract;

/**
 * AUTHOR：lanchuanke on 17/5/3 17:38
 */
public abstract class BasePresenter<V extends BaseContract.View> {
    protected V view;
}
