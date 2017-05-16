package open.cklan.com.topline.ui.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import open.cklan.com.library.model.CategoryEntity;
import open.cklan.com.topline.component.activity.ActivityComponent;
import open.cklan.com.topline.ui.activity.base.BaseActivity;

/**
 * AUTHOR：lanchuanke on 17/5/3 17:38
 */
public abstract class BaseNewsListFragment extends BaseFragment {
    public static final String ARG_TITLE="title";
    public static final String ARG_TYPE="type";

    protected CategoryEntity categoryEntity;
    ActivityComponent activityComponent;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInject();
    }

    protected abstract void initInject();

    protected ActivityComponent getActivityComponent(){
        if(activityComponent==null){
            BaseActivity baseActivity= (BaseActivity) getActivity();
            activityComponent=baseActivity.getActivityComponent();
        }
        return activityComponent;
    }

    public void setTitleAndType(CategoryEntity categoryEntity){
       this.categoryEntity=categoryEntity;
    }

    public String getTitle(){
        return categoryEntity.title;
    }
}
