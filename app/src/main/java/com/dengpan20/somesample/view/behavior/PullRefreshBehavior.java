package com.dengpan20.somesample.view.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

/**
 * Created by lehow on 2017/2/20.
 * 内容摘要：
 * 版权所有：极策科技
 */
public class PullRefreshBehavior extends CoordinatorLayout.Behavior {

    private static final String TAG = "PullRefreshBehavior";
    private static int HEADER_MIN_HEIGTH = 0;
    private float default_pull_trans_y = 0;

    public PullRefreshBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
        HEADER_MIN_HEIGTH = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 72 * 2, context.getResources().getDisplayMetrics());

    }


    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        Log.i(TAG, "onLayoutChild: ");
        int indexOfChild = parent.indexOfChild(child);
//        super.onLayoutChild(parent, child, layoutDirection);
        int childCount = parent.getChildCount();
        int topOffset = parent.getTop();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            if (childAt == child) {
                childAt.layout(0, 0, parent.getWidth(), 0 + Math.abs(childAt.getMeasuredHeight()));//需要这行，否则child不显示
            }

            childAt.setTranslationY(topOffset);
            if (i == childCount - 1) {//最后一个,调整他的高度,防止向上滚动到底，scrollview的内容显示不全
                int w = View.MeasureSpec.makeMeasureSpec(parent.getWidth(), View.MeasureSpec.EXACTLY);
                int h = View.MeasureSpec.makeMeasureSpec(parent.getHeight() - HEADER_MIN_HEIGTH, View.MeasureSpec.EXACTLY);
                childAt.measure(w, h);
                default_pull_trans_y = childAt.getTranslationY();
//                childAt.layout(0, 0, parent.getWidth(), parent.getHeight()-HEADER_MIN_HEIGTH);
            }
            if (i == indexOfChild) {//当前的pullview不显示，所以后面的偏移不应该累加他的高度
                continue;
            }
            topOffset += childAt.getMeasuredHeight();
        }
        return true;
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        Log.i(TAG, "==onStartNestedScroll: ");
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
        //coordinatorLayout 在此处判断 如果是垂直方向的滚，我就要先接收着看一看
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {

        Log.i(TAG, "==onStartNestedScroll: ");
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
//        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        Log.i(TAG, "onNestedPreScroll: dx=" + dx + " dy=" + dy);
        //target 为滚动控件
        //target.getTranslationY() > HEADER_MIN_HEIGTH; 滚动控件与
        int targetHeaderOffest = (int) (target.getTranslationY() - HEADER_MIN_HEIGTH);
        if (dy > 0 && targetHeaderOffest > 0) {//向上移动,并且与最小的Header距离大于0，先整体向上滚动
            int childCount = coordinatorLayout.getChildCount();
            int indexOfChild = coordinatorLayout.indexOfChild(child);
            int scollY = Math.min(targetHeaderOffest, dy);
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (i <= indexOfChild) {//固定在顶部
                } else {//移动pullview之后的控件
                    childAt.setTranslationY(childAt.getTranslationY() - scollY);
                }
            }
            consumed[1] = scollY;//更新coordinatorLayout消耗的距离
        }

    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        Log.i(TAG, "onNestedScroll: dxConsumed=" + dxConsumed + " dyConsumed=" + dyConsumed + " dxUnconsumed=" + dxUnconsumed + " dyUnconsumed=" + dyUnconsumed);

        if (dyConsumed <= 0 && dyUnconsumed < 0) {//向下滚动，有剩余的，整体向下滚动

            int childCount = coordinatorLayout.getChildCount();
            int indexOfChild = coordinatorLayout.indexOfChild(child);
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (i <= indexOfChild) {//固定在顶部
                } else {//pullview之下的控件之间移动就好
                    childAt.setTranslationY(childAt.getTranslationY() - dyUnconsumed);
                }
            }
        }


    }

    @Override
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target) {
        super.onStopNestedScroll(coordinatorLayout, child, target);
        float offsetToDefault = target.getTranslationY() - default_pull_trans_y;
        if (offsetToDefault > 0) {
            int childCount = coordinatorLayout.getChildCount();
            int indexOfChild = coordinatorLayout.indexOfChild(child);
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (i <= indexOfChild) {//固定在顶部
                } else {//回弹
                    childAt.setTranslationY(childAt.getTranslationY() - (offsetToDefault));
                }
            }
        }
    }

    @Override
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View child, Rect rectangle, boolean immediate) {
        return super.onRequestChildRectangleOnScreen(coordinatorLayout, child, rectangle, immediate);
    }


}