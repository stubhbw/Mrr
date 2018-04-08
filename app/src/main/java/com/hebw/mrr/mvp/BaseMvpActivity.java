package com.hebw.mrr.mvp;

/**
 * author: Hebw
 * description: 基类初始化Presenter并进行绑定和销毁的统一处理
 */
public abstract class BaseMvpActivity<P extends BaseContract.BasePresenter> extends BaseActivity {

    protected P mPresenter;

    @Override
    protected void initPresenters() {
        //创建Presenter
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        if (mPresenter == null) {
            throw new NullPointerException("presenter 不能为空!");
        }
        //绑定view
        mPresenter.attachView(this);
    }

    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
