package open.cklan.com.topline.api;

import open.cklan.com.library.model.NewsListEntity;
import open.cklan.com.library.model.news_list.CarListItemEntity;
import retrofit.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:29
 * 汽车频道api请求
 */
public interface CarService {
    String listUrl="/nc/auto/list/5YyX5Lqs/{offset}-{size}.html";

    @GET(listUrl)
    Observable<Response<NewsListEntity<CarListItemEntity>>> newsList(@Path("offset") long offset, @Path("size") long size);
}
