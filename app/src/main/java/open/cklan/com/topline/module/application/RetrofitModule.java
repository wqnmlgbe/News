package open.cklan.com.topline.module.application;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.library.http.convertor.FastJsonConvertFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:20
 */
@Module
public class RetrofitModule {
    public static final String BASE_URL="http://c.m.163.com/";
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(new FastJsonConvertFactory())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

}
