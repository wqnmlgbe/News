package open.cklan.com.topline.api;

import java.util.List;

import open.cklan.com.library.model.NewsListEntity;
import open.cklan.com.library.model.news_list.ImageListItemEntity;
import retrofit.Response;
import retrofit.http.GET;
import rx.Observable;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:29
 * 图片频道api请求
 */
public interface ImageService {
    String listUrl="/photo/api/list/0096/54GI0096.json";

    @GET(listUrl)
    Observable<Response<List<ImageListItemEntity>>> newsList();
}
