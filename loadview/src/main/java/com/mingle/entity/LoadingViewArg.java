package com.mingle.entity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author zwm
 * @version 2.0
 * @ClassName LoadingViewArg
 * @Description
 * @date 2015/6/17.
 */
public class LoadingViewArg {

    public Context context;
    public int type;
    public int progressColor;
    public ViewGroup parentVG;
    public View contentView;
    public String loadText;
    public int emptyViewLayoutId;
    public long startTime;

}
