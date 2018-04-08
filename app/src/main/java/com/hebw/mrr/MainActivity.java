package com.hebw.mrr;

import com.hebw.mrr.mvp.BaseContract;
import com.hebw.mrr.mvp.BaseMvpActivity;

public class MainActivity extends BaseMvpActivity {

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }


    @Override
    protected BaseContract.BasePresenter createPresenter() {
        return null;
    }
}
