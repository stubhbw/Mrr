package com.hebw.mrr.retrofit.bean;


import com.hebw.mrr.BuildConfig;

/**
 * author: Hebw
 * description: 每次请求携带的数据类型
 */

public class BaseRequestBean<T> {

    private int versionId = BuildConfig.VERSION_CODE;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setVersionId(int versionId) {
        this.versionId = versionId;
    }
}
