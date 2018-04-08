package com.hebw.mrr.retrofit.support.api;

import android.support.annotation.NonNull;

import com.hebw.mrr.BuildConfig;
import com.hebw.mrr.retrofit.bean.WeatherBean;
import com.hebw.mrr.retrofit.support.interceptor.HttpLoggingInterceptor;
import com.hebw.mrr.retrofit.support.interceptor.RetryIntercepter;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.hebw.mrr.retrofit.support.api.UrlConstant.URL_WEATHER;

/**
 * 网络请求类
 *
 * @author Hebw
 */
public class HttpApi {

    private static final String TAG = "HttpApi";
    private HttpService service;

    private static class HttpClientHolder {
        private static final HttpApi INSTANCE = new HttpApi();
    }

    private HttpApi() {
        OkHttpClient.Builder builder = createOkHttpClientBuilder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.weather.com.cn/data/sk/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        service = retrofit.create(HttpService.class);
    }

    @NonNull
    private OkHttpClient.Builder createOkHttpClientBuilder() {
        //重试拦截器
        RetryIntercepter retryInterceptor = new RetryIntercepter(0);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                //重试拦截器
                .addInterceptor(retryInterceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS);

        //设置https
        if ("baseUrl".startsWith("https:")) {
            //...
        }

        //日志拦截器
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        return builder;
    }

    public static HttpApi getInstance() {
        return HttpClientHolder.INSTANCE;
    }

    public Call<WeatherBean> getWeather(){
        return service.getWeather(URL_WEATHER);
    }
}
