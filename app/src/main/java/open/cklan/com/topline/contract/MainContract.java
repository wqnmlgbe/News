package open.cklan.com.topline.contract;

import java.util.List;

import open.cklan.com.library.model.CategoryEntity;
import open.cklan.com.library.model.NetEasyCategoryEntity;

/**
 * AUTHOR：lanchuanke on 17/5/4 10:55
 */
public interface MainContract {
    interface View extends BaseContract.View{
        void showCategories(List<CategoryEntity> categoryList);
    }
    interface UserActionListener extends BaseContract.UserActionListener{
        void loadCategories();
    }
}
