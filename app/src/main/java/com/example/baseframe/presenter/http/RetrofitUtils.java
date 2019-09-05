package com.example.baseframe.presenter.http;

import android.content.Context;
import android.util.Log;

import com.example.baseframe.base.Config;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2019/9/4 0004
 */
public class RetrofitUtils {
    private Context mContext;

    public RetrofitUtils(Context mContext) {
        this.mContext = mContext;
    }

    public Api getApiService(){
        return getRetrofit().create(Api.class);
    }


    public Retrofit getRetrofit(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(Config.DEFAULT_TIME, TimeUnit.SECONDS);
        builder.connectTimeout(Config.DEFAULT_TIME,TimeUnit.SECONDS);
        //设置拦截器
        builder.addInterceptor(getHttpLoginInterceptor());
        //设置缓存
        File cacheFile = new File(mContext.getExternalCacheDir(),"HttpCache");
        Cache cache  = new Cache(cacheFile,1024 * 1024 * 50);//大小为50Mb
        builder.cache(cache);
        builder.addInterceptor(getCacheInterceptor());
        //设置Header
      //  builder.addInterceptor(getHeadInterceptor());

        Retrofit retrofit = new Retrofit.Builder()
                //服务器地址
                .baseUrl(Config.BASE_URL)
                //设置Gson转化库
                .addConverterFactory(GsonConverterFactory.create())
                //配置回调库,采用Rxjava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //设置okhttpClient为网络客户端
                .client(builder.build())
                .build();

        return retrofit;
    }

    //设置日志拦截器
    public HttpLoggingInterceptor getHttpLoginInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("HomePresenter", "log: ------"+message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    //设置缓存
    public Interceptor getCacheInterceptor(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetUtils.isNetworkConnected(mContext)){
                    //无网络的情况下强制使用缓存，无论缓存是否过期
                    //有网络时则根据缓存时长来决定是否发出请求。
                    request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                }
                Response response = chain.proceed(request);
                if (!NetUtils.isNetworkConnected(mContext)){
                    //有网络的情况下，超过一分钟，则重新请求，否则直接使用缓存数据
                    int maxAge = 60;//缓存一分钟
                    String cacheControl = "public,max-age="+maxAge;
                    return response.newBuilder()
                            .header("Cache-Control",cacheControl)
                            .removeHeader("Pragma")
                            .build();
                }else {
                    int maxStale = 60 * 60 * 24 * 7 * 1; //1周
                    return  response.newBuilder()
                            .header("Cache-Control","public,only-if-cached,max-stale="+maxStale)
                            .removeHeader("Pragma").build();
                }
            }
        };
        return interceptor;
    }

    //设置header
    public Interceptor getHeadInterceptor(){
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder();
                //设置header内容
                // TODO: 2019/8/21  设置Header内容
                builder.header("time",System.currentTimeMillis()+"");
                Request.Builder requestBuilder = builder.method(originalRequest.method(),originalRequest.body());
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        };
        return interceptor;
    }

}
