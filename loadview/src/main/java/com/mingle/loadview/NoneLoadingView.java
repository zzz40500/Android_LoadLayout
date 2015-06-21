package com.mingle.loadview;

import android.view.View;

import com.mingle.entity.LoadingViewArg;

/**
 * Created by zzz40500 on 15/6/18.
 */
public class NoneLoadingView  extends  BaseLoadingView {
    @Override
    protected void initView(LoadingViewArg loadingViewArg) {

    }

    @Override
    public void showLoadView(View contentView, View errView) {
        contentView.setVisibility(View.VISIBLE);
        errView.setVisibility(View.GONE);
    }

    @Override
    public void showLoadView(View contentView, View errView, CharSequence loadingText) {
        contentView.setVisibility(View.VISIBLE);
        errView.setVisibility(View.GONE);
    }

    @Override
    public void dismissLoadView(View contentView, View errView) {
        contentView.setVisibility(View.VISIBLE);
        errView.setVisibility(View.GONE);
    }

    @Override
    protected void setError() {

    }
}
