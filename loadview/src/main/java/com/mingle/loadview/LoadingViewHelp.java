package com.mingle.loadview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mingle.LoadingViewConfig;
import com.mingle.entity.LoadingViewArg;
import com.mingle.loadview.BaseLoadingView;
import com.mingle.loadview.R;

/**
 * @author zwm
 * @version 2.0
 * @ClassName LoadViewHelpe
 * @Description TODO(这里用一句话描述这个类的作用)
 * @date 2015/6/16.
 */
public class LoadingViewHelp {

    private BaseLoadingView baseLoadingView;

    private Context mContext;
    private View mErrorView;
    private View mContentView;
    private TextView errTV;

    private LoadingViewArg mLoadingViewArg;

    public LoadingViewHelp(LoadingViewArg loadingViewArg) {
        this.mLoadingViewArg=loadingViewArg;
        this.mContext = mLoadingViewArg.context;
        mErrorView=getErrorView();
        baseLoadingView= LoadingViewConfig.getInstance().getLoadingView(loadingViewArg);
        mContentView=mLoadingViewArg.contentView;
        mLoadingViewArg.parentVG.addView(mErrorView);
    }


    private View getErrorView(){

        if(mErrorView ==null) {
            mErrorView = LayoutInflater.from(mContext).inflate(mLoadingViewArg.emptyViewLayoutId, null);
            errTV= (TextView) mErrorView.findViewById(R.id.errTV);
        }
        return  mErrorView;
    }



    public void showLoadView() {
        if(baseLoadingView != null)
        baseLoadingView.showLoadView(mContentView,mErrorView);
    }

    public void dismissLoadView( ) {
        if(baseLoadingView != null)
        baseLoadingView.dismissLoadView(mContentView,mErrorView);
    }


    public void  setError(CharSequence sequence){
        mContentView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
        if(baseLoadingView != null)
        baseLoadingView.setError();
        if(errTV != null)
        errTV.setText(sequence);
    }
    public  void setError(CharSequence sequence,View.OnClickListener onClickListener){
        setError(sequence);
        setErrorClickListener(onClickListener);
    }


    public void setErrorClickListener(View.OnClickListener onClickListener){
        mErrorView.setOnClickListener(onClickListener);
    }

    public void onWindowFocused() {
        baseLoadingView.onWindowFocused();
    }
}
