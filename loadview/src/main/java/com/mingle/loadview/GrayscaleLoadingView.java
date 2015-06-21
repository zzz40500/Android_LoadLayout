package com.mingle.loadview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mingle.entity.LoadingViewArg;
import com.mingle.widget.LoadingView;

/**
 *
 * 灰阶加载动画
 * Created by zzz40500 on 15/6/14.
 */
public class GrayscaleLoadingView  extends SimpleLoadingView {


    private ImageView mImageView;

    private LoadingViewArg mLoadingViewArg;

    public void initView(LoadingViewArg loadingViewArg) {
        super.initView(loadingViewArg);
        this.mLoadingViewArg=loadingViewArg;
        mImageView= (ImageView) mLoadView.findViewById(R.id.image);
    }

    @Override
    public void showLoadView(View contentView, View errView) {
        super.showLoadView(contentView, errView);
        Bitmap bitmap= convertFromView(contentView);
        mImageView.setImageBitmap(getGrayscaleView(bitmap));
        mLoadingViewArg.startTime=System.currentTimeMillis();
    }

    @Override
    public void dismissLoadView(View contentView, View errView) {
        super.dismissLoadView(contentView, errView);
    }

    @Override
    public void onWindowFocused() {
        super.onWindowFocused();
        Bitmap bitmap= convertFromView(mLoadingViewArg.contentView);
        mImageView.setImageBitmap(getGrayscaleView(bitmap));
        mLoadingViewArg.startTime=System.currentTimeMillis();


    }

    @Override
    public void showLoadView(View contentView, View errView, CharSequence loadingText) {
        showLoadView(contentView, errView, loadingText);
    }


    @Override
    protected int getLoadingViewLayoutId() {
        return R.layout.layout_grayscale;
    }


    /**
     * 从View 中生成 BitMap
     *
     * @param view
     * @return
     */
    public  Bitmap convertFromView(View view) {
//        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
//                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();

        return bitmap;
    }

    public Bitmap getGrayscaleView(Bitmap bitmap){

        if(  bitmap  == null){
            return  bitmap;
        }
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);

        ColorMatrix cMatrix = new ColorMatrix();
        // 设置饱和度
        cMatrix.setSaturation(0.1f);

        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(cMatrix));

        Canvas canvas = new Canvas(bmp);
        // 在Canvas上绘制一个已经存在的Bitmap。这样，dstBitmap就和srcBitmap一摸一样了
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return  bmp;
    }
}
