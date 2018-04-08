package com.hebw.mrr.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;

/**
 * author: Hebw
 * description: Activity基类
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseContract.BaseView {

    private static final String TAG = "BaseActivity";

    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initPresenters();
        initData();
        initView();
    }

    /**
     * 为BaseMvpActivity初始化Presenter
     * {@link BaseMvpActivity#initPresenters()}
     * 初始化需放在使用之前否则会报NullPointerException
     */
    protected void initPresenters() {}

    /**
     * 加载布局文件
     * @return 布局文件id
     */
    protected abstract int getContentViewId();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化化view组件
     */
    protected abstract void initView();

    @Override
    public void showTip(String msg) {
        Log.d(TAG, "showTip ==== " + msg);
    }

    @Override
    public void showTip(int msg) {
        Log.d(TAG, "showTip" + getString(msg));
    }

    @Override
    public void showProgressDialog() {
        Log.d(TAG, "showProgressDialog");
    }

    @Override
    public void dismissProgressDialog() {
        Log.d(TAG, "dismissProgressDialog");
    }
}