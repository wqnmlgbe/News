package open.cklan.com.topline.api;

import open.cklan.com.library.model.NewsListEntity;
import open.cklan.com.library.model.news_list.HistoryListItemEntity;
import retrofit.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:29
 * 历史频道api请求
 */
public interface HistoryService {
    String listUrl ="/nc/article/list/{tid}/{offset}-{size}.html\n";

    @GET(listUrl)
    Observable<Response<NewsListEntity<HistoryListItemEntity>>> newsList(@Path("tid") String tid, @Path("offset") long offset, @Path("size") long size);
}
