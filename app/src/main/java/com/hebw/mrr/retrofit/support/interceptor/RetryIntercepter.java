package com.hebw.mrr.retrofit.support.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 重试拦截器
 */
public class RetryIntercepter implements Interceptor {

    private static final String TAG = "RetryIntercepter";

    public int maxRetry;//最大重试次数
    private int retryNum = 0;//假如设置为3次重试的话，则最大可能请求4次（默认1次+3次重试）

    /**
     * 设置重连次数
     * @param maxRetry 重试次数,如设置为3次重试的话，则最大可能请求4次（默认1次+3次重试）
     */
    public RetryIntercepter(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        while (!response.isSuccessful() && retryNum < maxRetry) {
            retryNum++;
            response = chain.proceed(request);
        }
        return response;
    }
}
