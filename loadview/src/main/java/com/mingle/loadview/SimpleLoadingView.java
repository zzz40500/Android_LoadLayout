package com.mingle.loadview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.mingle.entity.LoadingViewArg;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

/**
 * @author zwm
 * @version 2.0
 * @ClassName SimpleLoadingView
 * @Description TODO(这里用一句话描述这个类的作用)
 * @date 2015/6/17.
 */
public  abstract  class SimpleLoadingView extends BaseLoadingView {


    protected View mLoadView;

    public static final int ANIMATION_DURATION=500;

    public void initView(LoadingViewArg loadingViewArg) {

        if (loadingViewArg.parentVG.getBackground() != null) {
            //为了向下兼容
            getLoadView().setBackgroundDrawable(loadingViewArg.parentVG.getBackground());
        }
        loadingViewArg.parentVG.addView(getLoadView());
    }


    public View getLoadView() {
        if (mLoadView == null) {
            mLoadView = LayoutInflater.from(mLoadingViewArg.context).inflate(getLoadingViewLayoutId(), null);
        }
        return mLoadView;
    }



    @Override
    public void showLoadView(View contentView, View errView) {
        contentView.setVisibility(View.VISIBLE);
        errView.setVisibility(View.GONE);
        mLoadView.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoadView(View contentView, View errView) {
        if(mLoadView.getVisibility() == View.GONE){
            return;
        }
        contentView.setVisibility(View.VISIBLE);
        errView.setVisibility(View.GONE);
        AlphaAnimation alphaOutAnimation = new AlphaAnimation(1, 0);
        AlphaAnimation alphaInAnimation = new AlphaAnimation(0, 1);
        alphaOutAnimation.setDuration(ANIMATION_DURATION);
        alphaInAnimation.setDuration(ANIMATION_DURATION);
        mLoadView.setVisibility(View.GONE);
        mLoadView.startAnimation(alphaOutAnimation);
        contentView.startAnimation(alphaInAnimation);
    }

    public void dismissAnim(View contentView, View errView){
        contentView.setVisibility(View.VISIBLE);
        errView.setVisibility(View.GONE);
        AlphaAnimation alphaOutAnimation = new AlphaAnimation(1, 0);
        AlphaAnimation alphaInAnimation = new AlphaAnimation(0.5f, 1);
        Animator animator= ObjectAnimator.ofFloat(contentView, "translationY", 60, 0);
//        Animator rotateX= ObjectAnimator.ofFloat(contentView, "rotationX",-6, 0);
//        ViewHelper.setPivotY(contentView,contentView.getMeasuredHeight());


//        Animator animator= ObjectAnimator.ofFloat(contentView, "scaleX", 0.9f, 1);
//        Animator rotateX= ObjectAnimator.ofFloat(contentView, "scaleY", 0.9f, 1);
        animator.setDuration(ANIMATION_DURATION);
//        rotateX.setDuration(ANIMATION_DURATION);
//        rotateX.setInterpolator(new DecelerateInterpolator());
        animator.setInterpolator(new DecelerateInterpolator());
        alphaOutAnimation.setInterpolator(new DecelerateInterpolator());
        alphaInAnimation.setInterpolator(new DecelerateInterpolator());
        animator.start();
//        rotateX.start();
        alphaOutAnimation.setDuration(ANIMATION_DURATION);
        alphaInAnimation.setDuration(ANIMATION_DURATION);
        mLoadView.setVisibility(View.GONE);
        mLoadView.startAnimation(alphaOutAnimation);
        contentView.startAnimation(alphaInAnimation);

    }

    @Override
    protected void setError() {
        mLoadView.setVisibility(View.GONE);
    }

    protected abstract  int getLoadingViewLayoutId() ;
}
