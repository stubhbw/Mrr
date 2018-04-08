package com.hebw.mrr.mvp;

/**
 * @date: On 2018/4/8
 * @author: Hebw
 * @description: M的业务
 */

public class MContract {

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        /**
         * 进行数据请求
         */
        void initMData();
    }

    interface View extends BaseContract.BaseView {
        /**
         * 更改文字
         */
        void changeText(String msg);
    }
}
