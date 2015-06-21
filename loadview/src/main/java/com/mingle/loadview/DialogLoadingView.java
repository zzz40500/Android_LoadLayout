package com.mingle.loadview;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingle.entity.LoadingViewArg;
import com.nineoldandroids.view.ViewHelper;

/**
 * 对话框
 * Created by zzz40500 on 15/6/14.
 */
public class DialogLoadingView  extends  SimpleLoadingView{

    private Dialog mLoadingDialog;

    private TextView mLoadTV;

    public void initView(LoadingViewArg loadingViewArg) {

        mLoadingDialog=new Dialog(mLoadingViewArg.context,R.style.custom_dialog);
        View contentView= LayoutInflater.from(mLoadingViewArg.context).inflate(getLoadingViewLayoutId(),null);
        mLoadTV= (TextView) contentView.findViewById(R.id.loadingTV);

        ViewHelper.setAlpha(mLoadTV,0.6f);
        if(TextUtils.isEmpty(mLoadingViewArg.loadText)){
            mLoadTV.setVisibility(View.GONE);
        }else {
            mLoadTV.setText(mLoadingViewArg.loadText);
        }
        mLoadingDialog.setContentView(contentView);
    }


    @Override
    public void showLoadView(View contentView, View errView) {
        errView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        mLoadingDialog.show();
    }

    @Override
    public void showLoadView(View contentView, View errView, CharSequence loadingText) {
        if(TextUtils.isEmpty(mLoadingViewArg.loadText)){
            mLoadTV.setVisibility(View.GONE);
        }else {
            mLoadTV.setText(mLoadingViewArg.loadText);
        }
        showLoadView(contentView,errView);

    }

    @Override
    public void dismissLoadView(View contentView, View errView) {
        errView.setVisibility(View.GONE);
        contentView.setVisibility(View.VISIBLE);
        mLoadingDialog.dismiss();
    }

    @Override
    protected void setError() {
        mLoadingDialog.dismiss();
    }

    @Override
    protected int getLoadingViewLayoutId() {
        return R.layout.layout_loading_dialog;
    }
}
