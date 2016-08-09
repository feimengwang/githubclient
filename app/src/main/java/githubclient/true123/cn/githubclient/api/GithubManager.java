package githubclient.true123.cn.githubclient.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import githubclient.true123.cn.githubclient.GithubApplication;
import githubclient.true123.cn.githubclient.util.StateUtils;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * Created by junbo on 9/8/2016.
 */
public class GithubManager {

    public static OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(1000 * 60, TimeUnit.MILLISECONDS)
                .readTimeout(1000 * 60, TimeUnit.MILLISECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        CacheControl.Builder cacheBuilder = new CacheControl.Builder();
                        cacheBuilder.maxAge(0, TimeUnit.SECONDS);
                        cacheBuilder.maxStale(365, TimeUnit.DAYS);
                        CacheControl cacheControl = cacheBuilder.build();

                        Request request = chain.request();
                        if (!StateUtils.isNetworkAvailable(GithubApplication.getGithubApplicationContext())) {
                            request = request.newBuilder()
                                    .cacheControl(cacheControl)
                                    .build();
                        }
                        Response originalResponse = chain.proceed(request);
                        if (StateUtils.isNetworkAvailable(GithubApplication.getGithubApplicationContext())) {
                            int maxAge = 0; // read from cache
                            return originalResponse.newBuilder()
                                    .removeHeader("Pragma")
                                    .header("Cache-Control", "public ,max-age=" + maxAge)
                                    .build();
                        } else {
                            int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                            return originalResponse.newBuilder()
                                    .removeHeader("Pragma")
                                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                    .build();
                        }
                    }
                })
                .build();
    }

    public static Retrofit getRetrofit(OkHttpClient okHttpClient, String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static GithubService getGithubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }
}
