package com.mingle;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.mingle.entity.LoadingViewArg;
import com.mingle.loadview.LoadingViewHelp;
import com.mingle.loadview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzz40500 on 15/6/10.
 */
public class LoadFrameLayout extends FrameLayout {

    private  boolean mLoadFinish;
    private boolean mError=false;
    private LoadingViewHelp mLoadingViewHelp;

    private boolean autoDismiss=false;
    private int mProgressType;
    private int mProgressColor;
    private String mLoadText;
    private int mEmptyView;
    private List<Action>  mDelayed=new ArrayList<>();
    private LoadingViewArg mLoadingViewArg=new LoadingViewArg();;


    public LoadFrameLayout(Context context) {
        super(context);
    }

    public LoadFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public LoadFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray typedArray = getContext()
                .obtainStyledAttributes(attrs, R.styleable.LoadFrameLayout);
        autoDismiss=   typedArray.getBoolean(R.styleable.LoadFrameLayout_autoDismiss, LoadingViewConfig.getInstance().isAutoDismiss());
        mProgressType= typedArray.getInt(R.styleable.LoadFrameLayout_loadViewType, LoadingViewConfig.getInstance().getDefProgressType());
        mProgressColor=typedArray.getResourceId(R.styleable.LoadFrameLayout_progressColor,R.color.def_progress_color);
        mLoadText=typedArray.getString(R.styleable.LoadFrameLayout_loadText);
        mEmptyView=typedArray.getResourceId(R.styleable.LoadFrameLayout_emptyView,LoadingViewConfig.getInstance().getEmptyViewLayoutId());

        typedArray.recycle();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoadFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onFinishInflate() {
        if(this.getChildCount() != 1) {
            throw  new RuntimeException("the child count must is 1");
        }else{

            mLoadingViewArg.context=getContext();
            mLoadingViewArg.parentVG=this;
            mLoadingViewArg.contentView=getChildAt(0);
            mLoadingViewArg.progressColor=mProgressColor;
            mLoadingViewArg.type=mProgressType;
            mLoadingViewArg.loadText=mLoadText;
            mLoadingViewArg.startTime=System.currentTimeMillis();
            mLoadingViewArg.emptyViewLayoutId=mEmptyView;
            mLoadingViewHelp = new LoadingViewHelp(mLoadingViewArg);
            mLoadingViewHelp.showLoadView();
        }
        super.onFinishInflate();
    }


    public void  setError(CharSequence charSequence){
        mError=true;
        mLoadingViewHelp.setError(charSequence);
    }

    public  void setmError(CharSequence sequence,View.OnClickListener onClickListener){
        mError=true;
        mLoadingViewHelp.setError(sequence, onClickListener);
    }


    public void setErrorClickListener(View.OnClickListener onClickListener){
        mLoadingViewHelp.setErrorClickListener(onClickListener);
    }

    /**
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {

        Log.e("'","onLayout");

        if( mLoadFinish&&! mError && autoDismiss){
            if(System.currentTimeMillis()-mLoadingViewArg.startTime >100) {
                mLoadingViewHelp.dismissLoadView();

                for(Action action: mDelayed){
                    action.action();
                }
                mDelayed.clear();
            }
        }
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("'","onMeasure");
    }

    public void showLoadView(){
        mError=false;
        mLoadingViewArg.startTime=System.currentTimeMillis();

        mLoadingViewHelp.showLoadView();
    }

    public void dismissLoadView(){
        mLoadingViewHelp.dismissLoadView();
    }

    public void setEorrText(CharSequence sequence){
        mLoadingViewHelp.setError(sequence);
    }


    /**
     * 因为在4.0 上面的话,调用了onWindowFocusChanged之后会调用 onLayout的方法,
     * 在5.0上面的话,调用了onWindowFocusChanged 不在调用onLayout 的方法
     * 为了避免这个事情,所以加了这个加以判断.
     */

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        mLoadFinish=hasWindowFocus;

        if(hasWindowFocus){
            mLoadingViewArg.startTime=System.currentTimeMillis();
            mLoadingViewHelp.onWindowFocused();
        }

        Log.e("'onWindowFocusChanged","onWindowFocusChanged     "+hasWindowFocus);
    }



    public void addDelayedAction(Action action){

        mDelayed.add(action);

    }



}
