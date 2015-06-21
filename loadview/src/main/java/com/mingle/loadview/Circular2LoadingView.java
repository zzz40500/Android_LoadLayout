package com.mingle.loadview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

import com.mingle.Action;
import com.mingle.entity.LoadingViewArg;
import com.mingle.widget.CircularProgressBar;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

/**
 *
 *
 *
 * Created by zzz40500 on 15/6/10.
 */
public class Circular2LoadingView extends SimpleLoadingView {

    private CircularProgressBar mProgressView;
    private TextView mLoadingTV;

    public void initView(LoadingViewArg loadingViewArg) {
        super.initView(loadingViewArg);
        mProgressView= (CircularProgressBar) mLoadView.findViewById(R.id.progressView);
        mLoadingTV= (TextView) mLoadView.findViewById(R.id.loadingTV);
        mProgressView.setProgressColor(mLoadingViewArg.context.getResources().getColor(mLoadingViewArg.progressColor));
        mLoadingTV.setText(mLoadingViewArg.loadText);
    }




    @Override
    public void showLoadView(View contentView, View errView) {
        super.showLoadView(contentView,errView);
        mProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoadView(View contentView, View errView, CharSequence loadingText) {
        mLoadingTV.setText(loadingText);
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
        return R.layout.layout_cicular2_view;
    }

}
