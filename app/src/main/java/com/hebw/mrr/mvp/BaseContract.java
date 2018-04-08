package com.hebw.mrr.mvp;

/**
 * author: Hebw
 * description: 基本合约类,规定了基类view和基类Presenter要做的事情
 */
public interface BaseContract {

    interface BasePresenter<T> {

        /**
         * 粘贴视图
         *
         * @param view
         */
        void attachView(T view);

        /**
         * 释放视图
         */
        void detachView();
    }

    interface BaseView {
        /**
         * 弹窗/吐司提示
         *
         * @param msg
         */
        void showTip(String msg);

        /**
         * 弹窗/吐司提示
         *
         * @param msg
         */
        void showTip(int msg);

        /**
         * 展示加载窗
         */
        void showProgressDialog();

        /**
         * 隐藏加载窗
         */
        void dismissProgressDialog();
    }
}
