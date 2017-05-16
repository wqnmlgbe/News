package open.cklan.com.topline.module.application;

import android.text.TextUtils;

import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import open.cklan.com.topline.BuildConfig;

/**
 * AUTHOR：lanchuanke on 17/5/3 18:20
 */
@Module
public class OkHttpModule {
    private static final long CONNECT_TIMEOUT = 30_000;
    private static final long WRITE_TIMEOUT = 30_000;
    private static final long READ_TIMEOUT = 30_000;
    private static final int REQUEST_CACHE_SIZE = 10 * 1024 * 1024;
    private static final int POOLING_MAX_CONNECTIONS = 5;
    private static final int REQUEST_KEEP_ALIVE_DEFAULT = 30000;

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setConnectionPool(new ConnectionPool(POOLING_MAX_CONNECTIONS, REQUEST_KEEP_ALIVE_DEFAULT));
        okHttpClient.setConnectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.setReadTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.setWriteTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.interceptors().add(headerInterceptor);
        //https
        try {
            //证书校验
            SSLContext sc = null;
            sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }}, new SecureRandom());
            okHttpClient.setSslSocketFactory(sc.getSocketFactory());
            okHttpClient.setHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        return okHttpClient;
    }

    Interceptor headerInterceptor=new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request=chain.request();
            request.newBuilder()
                    .addHeader("data4-Sent-Millis",System.currentTimeMillis()+"")
                    .addHeader("Add-To_Queue-Millis",System.currentTimeMillis()+"")
                    .addHeader("User-D","/ZFMLJiODEH2ZhofA/MvRr6zMupdTQUacn5iBuq96YWxyB7oNj+ThcWw2mgKWOnbIIGNeE0nI41SFrBIaL1THA==")
                    .addHeader("User_Agent","NewsApp/23.0 Android/6.0 (GIONEE/GN9012)")
                    .addHeader("User-N","J7j1Vq5rEW2YFBkjmfW6Bxb3VOTQjtndD5Qg328+Wm1OiOmXxQJ2MFkIjnBMtM41")
                    .addHeader("httpDNSIP","223.252.199.12")
                    .addHeader("User-C","5aS05p2h")
                    .addHeader("X-NR-Trace_Id",System.currentTimeMillis()+"_150006538_CQk3ZjVmYzk0OTYzZTEwZDgyCU5GQkVWU0lGSE1MTk5SUks%3D")
                    .addHeader("Host","c.m.163.com")
                    .addHeader("Connection","Keep-Alive")
                    .addHeader("Accept-Encoding","gzip")
                    .build();
            return chain.proceed(request);
        }
    };

    Interceptor AppKeyInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest = chain.request();
            HttpUrl.Builder httpUrlBuilder = newRequest.httpUrl().newBuilder();
            httpUrlBuilder.addQueryParameter("key", BuildConfig.JUHE_APPKEY);
            Request.Builder builder = newRequest.newBuilder();
            builder.url(httpUrlBuilder.build());
            if (newRequest.body() != null && TextUtils.isEmpty(newRequest.headers().get("Content-Type"))) {
                builder.header("Content-Type", "gzip").method(newRequest.method(), newRequest.body()).build();
            }
            return chain.proceed(builder.build());
        }
    };
}
