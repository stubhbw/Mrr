package com.hebw.mrr.retrofit.support.converter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.hebw.mrr.retrofit.bean.BaseBean;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;


public class DecodeResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final String TAG = "DecodeResponseBodyConve";
    private final TypeAdapter<T> adapter;
    private Gson gson;

    DecodeResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.adapter = adapter;
        this.gson = gson;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        //解密字符串
//        String decrypt = RSAUtils.decrypt(response);
        BaseBean bean = gson.fromJson(response, BaseBean.class);
        if (!bean.getCode().equals(0000)) {
//            ServerException exception = new ServerException();
//            exception.code = bean.getCode();
//            exception.message = bean.getMsg();
//            throw exception;
        }
        T t = adapter.fromJson(response);
        Log.d(TAG, response);
        return t;
    }
}