package open.cklan.com.topline.api;

import open.cklan.com.library.model.NewsContentEntity;
import open.cklan.com.library.model.NewsDetailEntity;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * AUTHOR：lanchuanke on 17/5/5 14:27
 */
public interface NewsDetailService {

    @GET("/nc/article/{id}/full.html")
    Observable<NewsDetailEntity> getContent(@Path("id")String id);
}
