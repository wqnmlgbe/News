package open.cklan.com.topline.api;

import open.cklan.com.library.model.NewsListEntity;
import open.cklan.com.library.model.news_list.BeautyListItemEntity;
import retrofit.Response;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:29
 * 视频频道api请求
 */
public interface BeautyService {
    String listUrl ="/recommend/getChanListNews?fn=1&passport=&devId=%2FZFMLJiODEH2ZhofA%2FMvRr6zMupdTQUacn5iBuq96YWxyB7oNj%2BThcWw2mgKWOnbIIGNeE0nI41SFrBIaL1THA%3D%3D&lat=&lon=&version=23.0&net=wifi&ts=1494215420&sign=q4ECrdrAvfZPiDtoROr9%2B%2F1ffld87Rf%2FLIfr7P4NyZ148ErR02zJ6%2FKXOnxX046I&encryption=1&canal=jinli_store2014_news&mac=racUMC0A9havm%2BHe6jH3YAvVdjgSXYDtwEDZ03eH1l8%3D&open=&openpath=HTTP/1.1";

    @GET(listUrl)
    Observable<Response<NewsListEntity<BeautyListItemEntity>>> newsList(@Query("channel") String tid, @Query("offset") long offset, @Query("size") long size);
}
