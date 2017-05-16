package open.cklan.com.topline.contract;

import java.util.List;

import open.cklan.com.library.model.news_list.BaseListItemEntity;

/**
 * AUTHOR：lanchuanke on 17/5/4 15:58
 */
public interface NewsListContract {
    interface View extends BaseContract.View{

        void showList(List<? extends BaseListItemEntity> newsList);

        void addList(List<? extends BaseListItemEntity> newsList);

        void goDetailActivity(String id);

        void goGalleryActivity(List<String> pic);

        void showRefreshError(String errorCode,String errorMessage);

        void showLoadMoreError(String errorCode,String errorMessage);

    }
    interface UserActionListener extends BaseContract.UserActionListener{


        void refreshNewsList(String tid,long offset,long size);

        void loadMoreNewsList(String tid,long offset,long size);

        void ignoreNew(int position,String category);

        void clickItem(String url);

        void clickItem(List<String> pic);
    }
}
