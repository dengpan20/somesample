package com.dengpan20.somesample.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.dengpan20.somesample.R;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

public class ADHeader extends LinearLayout implements RefreshHeader {
    public ADHeader(Context context) {
        super(context);
        init(context);
    }



    public ADHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ADHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.header_in_home,null);
        removeAllViews();
        addView(view);
    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @NonNull
    @Override
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(@NonNull RefreshKernel kernel, int height, int extendHeight) {

    }
    /**
     * 手指拖动下拉（会连续多次调用，用于实时控制动画关键帧）
     * @param percent 下拉的百分比 值 = offset/headerHeight (0 - percent - (headerHeight+maxDragHeight) / headerHeight )
     * @param offset 下拉的像素偏移量  0 - offset - (headerHeight+maxDragHeight)
     * @param headerHeight Header的高度
     * @param maxDragHeight 最大拖动高度
     */
    @Override
    public void onPulling(float percent, int offset, int headerHeight, int maxDragHeight) {
//        Log.e("ADHeader","percent = "+ percent +" offset = "+ offset+" headerHeight ="+headerHeight +" maxDragHeight "+maxDragHeight);
        if(onHeaderChangeListener != null) onHeaderChangeListener.onPulling(percent,offset,headerHeight,maxDragHeight);
    }

    /**
     * 手指释放之后的持续动画（会连续多次调用）
     * @param percent 下拉的百分比 值 = offset/footerHeight (0 - percent - (footerHeight+extendHeight) / footerHeight )
     * @param offset 下拉的像素偏移量  0 - offset - (footerHeight+extendHeight)
     * @param height 高度 HeaderHeight or FooterHeight
     * @param extendHeight 扩展高度  extendHeaderHeight or extendFooterHeight
     */

    @Override
    public void onReleasing(float percent, int offset, int height, int extendHeight) {
//        onPulling(percent, offset, height, extendHeight);
        if(onHeaderChangeListener != null) onHeaderChangeListener.onPulling(percent,offset,height,extendHeight);
    }

    @Override
    public void onReleased(RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int extendHeight) {

    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
//        mProgressDrawable.stop();//停止动画
//        if (success){
//            mHeaderText.setText("刷新完成");
//        } else {
//            mHeaderText.setText("刷新失败");
//        }
//        return 500;//延迟500毫秒之后再弹回
        return 0;
    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
        switch (newState) {
            case None:
            case PullDownToRefresh:
                //开始刷新
                break;
            case Refreshing:
                //刷新中
                break;
            case ReleaseToRefresh:
                //完成
                break;
        }
    }

    public interface OnHeaderChangeListener{
        void onPulling(float percent, int offset, int headerHeight, int maxDragHeight);
    }

    OnHeaderChangeListener onHeaderChangeListener;

    public void setOnHeaderChangeListener(OnHeaderChangeListener onHeaderChangeListener) {
        this.onHeaderChangeListener = onHeaderChangeListener;
    }
}
