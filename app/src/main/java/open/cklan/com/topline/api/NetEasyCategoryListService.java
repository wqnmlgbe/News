package open.cklan.com.topline.api;

import open.cklan.com.library.model.CategoryEntity;
import open.cklan.com.library.model.NetEasyCategoryListEntity;
import retrofit.http.GET;
import rx.Observable;

/**
 * AUTHOR：lanchuanke on 17/5/4 11:01
 */
public interface NetEasyCategoryListService {

    @GET("/nc/topicset/android/subscribe/manage/listspecial.html")
    Observable<NetEasyCategoryListEntity> categoryList();
}
