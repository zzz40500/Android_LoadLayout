package com.mingle.loadview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import com.mingle.Action;
import com.mingle.entity.LoadingViewArg;
import com.mingle.widget.CircularProgressBar;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

/**
 *
 *
 *
 * Created by zzz40500 on 15/6/10.
 */
public class CircularLoadingView extends SimpleLoadingView {

    private CircularProgressBar mProgressView;
    private TextView mLoadTV;


    public void initView(LoadingViewArg loadingViewArg) {
        super.initView(loadingViewArg);
        mProgressView= (CircularProgressBar) mLoadView.findViewById(R.id.progressView);
        mLoadTV= (TextView) mLoadView.findViewById(R.id.loadingTV);
        mLoadTV.setText(mLoadingViewArg.loadText);
        mProgressView.setProgressColor(mLoadingViewArg.context.getResources().getColor(mLoadingViewArg.progressColor));

    }

    @Override
    public void showLoadView(View contentView, View errView) {
        super.showLoadView(contentView, errView);
        mProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoadView(View contentView, View errView, CharSequence loadingText) {
        mLoadTV.setText(loadingText);
        showLoadView(contentView,errView);
    }


    @Override
    public void dismissLoadView(final View contentView, final View errView) {

        mProgressView.dismiss(new Action() {
            @Override
            public void action() {
                dismissAnim(contentView,errView);
            }
        });

    }

    @Override
    protected int getLoadingViewLayoutId() {
        return R.layout.layout_cicular_view;
    }


}
