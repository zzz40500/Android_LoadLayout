package com.mingle.loadview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mingle.entity.LoadingViewArg;

/**
 * Created by zzz40500 on 15/6/10.
 */
public abstract class BaseLoadingView {

    protected LoadingViewArg mLoadingViewArg;

    public BaseLoadingView() {

    }

    public void setLoadingViewArg(LoadingViewArg loadingViewArg) {
        this.mLoadingViewArg = loadingViewArg;
        initView(loadingViewArg);
    }

    protected abstract void initView(LoadingViewArg loadingViewArg);


    /**
     * 显示loadView
     */
    public abstract void showLoadView(View contentView, View errView);

    public abstract void showLoadView(View contentView, View errView, CharSequence loadingText);

    public abstract void dismissLoadView(View contentView, View errView);


    protected abstract void setError();
    public void onWindowFocused() {
    }


}
