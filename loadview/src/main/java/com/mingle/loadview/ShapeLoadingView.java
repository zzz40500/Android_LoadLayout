package com.mingle.loadview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.mingle.entity.LoadingViewArg;
import com.mingle.widget.LoadingView;

/**
 * 58同城加载动画
 * Created by zzz40500 on 15/6/14.
 */
public class ShapeLoadingView extends SimpleLoadingView {


    private LoadingView mProgressView;

    public void initView(LoadingViewArg loadingViewArg) {
        super.initView(loadingViewArg);
        mProgressView = (LoadingView) mLoadView.findViewById(R.id.progressView);
        mProgressView.setLoadingText(mLoadingViewArg.loadText);

    }

    @Override
    public void showLoadView(View contentView, View errView, CharSequence loadingText) {


        mProgressView.setLoadingText(loadingText);
        showLoadView(contentView, errView);

    }


    @Override
    public int getLoadingViewLayoutId() {
        return R.layout.layout_shape_loading_view;
    }
}
