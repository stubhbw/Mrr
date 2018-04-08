package com.hebw.mrr.mvp;

import android.widget.Button;

import com.hebw.mrr.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @date: On 2018/4/8
 * @author: Hebw
 * @description: M界面
 * 1.点击按钮P层模拟发起网络请求，加载弹窗
 * 2.请求成功调用V层方法传递数据，隐藏弹窗
 */

public class MActivity extends BaseMvpActivity<MPresenter> implements MContract.View {

    @Bind(R.id.btn_hello)
    Button mBtnHello;

    @Override
    protected MPresenter createPresenter() {
        return new MPresenter();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.act_m;
    }

    @Override
    protected void initData() {
        //初始化数据
    }

    @Override
    protected void initView() {
        //初始界面
    }

    @OnClick(R.id.btn_hello)
    public void onClick() {
        mPresenter.initMData();
        showTip("don't touch me!");
    }

    @Override
    public void changeText(String msg) {
        mBtnHello.setText(msg);
    }

}
