package com.hebw.mrr.mvp;

/**
 * @date: On 2018/4/8
 * @author: Hebw
 * @description: M业务类
 */

public class MPresenter extends BaseMvpPresenter<MContract.View>
        implements MContract.Presenter<MContract.View> {

    @Override
    public void initMData() {
        //加载弹窗
        mView.showProgressDialog();

        //进行网络请求
        //netRequest........

        //网络请求成功，回调View的方法设置数据
        mView.changeText("All I Know Is You");

        //隐藏弹窗
        mView.dismissProgressDialog();
    }

}
