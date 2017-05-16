package open.cklan.com.topline.contract;

import open.cklan.com.library.model.NewsContentEntity;

/**
 * AUTHOR：lanchuanke on 17/5/5 14:06
 */
public interface NewsDetailContract {
    interface View extends BaseContract.View{
        void showContent(NewsContentEntity entity);

        void showCommentList();
    }
    interface UserActionListener extends BaseContract.UserActionListener{

        void loadNewsContent(String id);

        void loadNewsComment(String groupId,String itemId);

    }
}
