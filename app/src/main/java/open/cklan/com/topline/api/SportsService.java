package open.cklan.com.topline.api;

import open.cklan.com.library.model.NewsListEntity;
import open.cklan.com.library.model.news_list.SportsListItemEntity;
import retrofit.Response;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:29
 * 体育频道api请求
 */
public interface SportsService {
    String listUrl="/dlist/article/dynamic?fn=2&passport=&devId=%2FZFMLJiODEH2ZhofA%2FMvRr6zMupdTQUacn5iBuq96YWxyB7oNj%2BThcWw2mgKWOnbIIGNeE0nI41SFrBIaL1THA%3D%3D&lat=&lon=&version=23.0&net=wifi&ts=1494214970&sign=23GJVL2f7m5bu5FOdYwyXwgIQ3CR1lr6j7oK6viy4Ax48ErR02zJ6%2FKXOnxX046I&encryption=1&canal=jinli_store2014_news&mac=racUMC0A9havm%2BHe6jH3YAvVdjgSXYDtwEDZ03eH1l8%3D&open=&openpath=HTTP/1.1";

    @GET(listUrl)
    Observable<Response<NewsListEntity<SportsListItemEntity>>> newsList(@Query("from") String tid, @Query("offset") long offset, @Query("size") long size);
}

