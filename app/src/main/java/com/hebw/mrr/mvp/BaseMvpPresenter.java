package com.hebw.mrr.mvp;

import android.content.Context;

/**
 * author: Hebw
 * description: Presenter基类
 */
public class BaseMvpPresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    protected T mView;
    protected Context mContext;

    @Override
    public void attachView(T view) {
        this.mView = view;
        this.mContext = (Context) mView;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }
}
