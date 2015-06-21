package com.mingle;

import com.mingle.entity.LoadingViewArg;
import com.mingle.loadview.BaseLoadingView;
import com.mingle.loadview.Circular2LoadingView;
import com.mingle.loadview.CircularLoadingView;
import com.mingle.loadview.DialogLoadingView;
import com.mingle.loadview.GrayscaleLoadingView;
import com.mingle.loadview.NoneLoadingView;
import com.mingle.loadview.ProgressTypeEnum;
import com.mingle.loadview.R;
import com.mingle.loadview.ShapeLoadingView;

/**
 * @author zwm
 * @version 2.0
 * @ClassName Config
 * @Description TODO(这里用一句话描述这个类的作用)
 * @date 2015/6/17.
 */
public class LoadingViewConfig {


    private static LoadingViewConfig ourInstance = new LoadingViewConfig();

    public static LoadingViewConfig getInstance() {
        return ourInstance;
    }

    private LoadingViewConfig() {

    }

    /**
     * 默认的加载样式
     */
    private int defProgressType= ProgressTypeEnum.CIRCULAR.getProgressType();

    /**
     * 默认的是否自动消失
     */
    private boolean autoDismiss=true;


    private int emptyViewLayoutId= R.layout.layout_empty_view;
    private  String  loadText;


    public int getDefProgressType() {
        return defProgressType;
    }

    public void setDefProgressType(ProgressTypeEnum defProgressType) {
        this.defProgressType = defProgressType.getProgressType();
    }

    public boolean isAutoDismiss() {
        return autoDismiss;
    }

    public void setAutoDismiss(boolean autoDismiss) {
        this.autoDismiss = autoDismiss;
    }

    public int getEmptyViewLayoutId() {
        return emptyViewLayoutId;
    }

    public void setEmptyViewLayoutId(int emptyViewLayoutId) {
        this.emptyViewLayoutId = emptyViewLayoutId;
    }

    public String getLoadText() {
        return loadText;
    }

    public void setLoadText(String loadText) {
        this.loadText = loadText;
    }

    public BaseLoadingView getLoadingView( LoadingViewArg loadingViewArg){
        BaseLoadingView baseLoadingView=null;
        switch (loadingViewArg.type){
            case 0:
                break;
            case 1:
                baseLoadingView=new CircularLoadingView();
                break;
            case 2:
                baseLoadingView=new Circular2LoadingView();
                break;
            case 3:
                baseLoadingView=new DialogLoadingView();
                break;
            case 4:
                baseLoadingView=new GrayscaleLoadingView();
                break;
            case 5:
                baseLoadingView=new ShapeLoadingView();
                break;
            case 6:
                baseLoadingView=customLoadingView1;
                break;
            case 7:
                baseLoadingView=customLoadingView2;
                break;

        }
        if(baseLoadingView == null){
            baseLoadingView=new
                    NoneLoadingView();
        }
        baseLoadingView.setLoadingViewArg(loadingViewArg);
        return  baseLoadingView;
    }


    private BaseLoadingView customLoadingView1;
    private BaseLoadingView customLoadingView2;

    public BaseLoadingView getCustom1LoadingView() {
        return customLoadingView1;
    }

    public void setCustom1LoadingView(BaseLoadingView customBese1) {
        this.customLoadingView1 = customBese1;
    }

    public BaseLoadingView getCustom2LoadingView() {
        return customLoadingView2;
    }

    public void setCustom2LoadingView(BaseLoadingView customBese2) {
        this.customLoadingView2 = customBese2;
    }
}
