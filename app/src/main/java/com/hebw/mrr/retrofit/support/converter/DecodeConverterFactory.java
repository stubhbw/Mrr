package com.hebw.mrr.retrofit.support.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hebw.mrr.retrofit.bean.BaseBean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class DecodeConverterFactory extends Converter.Factory {
    private static final String TAG = "DecodeConverterFactory";
    private static final MediaType MEDIA_TYPE = MediaType.parse("text/plain; charset=utf-8");
    private final Gson gson;

    private DecodeConverterFactory(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        this.gson = gson;
    }

    public static DecodeConverterFactory create() {
        return create(new Gson());
    }

    public static DecodeConverterFactory create(Gson gson) {
        return new DecodeConverterFactory(gson);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (BaseBean.class.equals(type)) {
            return new DecodeResponseBodyConverter(gson, gson.getAdapter(TypeToken.get(type)));
        }
        return null;
    }


    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type,
                                                          Annotation[] parameterAnnotations,
                                                          Annotation[] methodAnnotations,
                                                          Retrofit retrofit) {
        if (String.class.equals(type)) {
            return (Converter<String, RequestBody>) value -> RequestBody.create(MEDIA_TYPE, value);
        }
        return null;
    }
}