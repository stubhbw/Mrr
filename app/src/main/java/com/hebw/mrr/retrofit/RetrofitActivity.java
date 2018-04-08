package com.hebw.mrr.retrofit;

import android.util.Log;

import com.hebw.mrr.R;
import com.hebw.mrr.mvp.BaseActivity;
import com.hebw.mrr.retrofit.bean.WeatherBean;
import com.hebw.mrr.retrofit.support.api.HttpApi;

import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author: Hebw
 * @description: Retrofit演示界面
 * 点击发起Retrofit请求
 */

public class RetrofitActivity extends BaseActivity {

    private static final String TAG = "RetrofitActivity";

    @Override
    protected int getContentViewId() {
        return R.layout.act_m;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @OnClick(R.id.btn_hello)
    public void onClick() {
        Call<WeatherBean> call = HttpApi.getInstance().getWeather();
        call.enqueue(new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                Log.d(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }
}
