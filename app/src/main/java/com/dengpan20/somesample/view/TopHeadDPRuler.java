package com.dengpan20.somesample.view;

import android.content.Context;
import android.graphics.Canvas;

import android.graphics.Color;
import android.util.Log;
import yanzhikai.ruler.Utils.RulerStringUtil;

/**
 * @author Paddy
 * @time 2020-05-31 23:55
 * @class describe
 */
public class TopHeadDPRuler extends HorizontalRuler {

    //todo  计算中间  位置
    private float centerStartX;
    public TopHeadDPRuler(Context context, DPRuler booheeRuler) {
        super(context, booheeRuler);
        initCenterStartX();
    }

    private void initCenterStartX() {
        centerStartX = (getMeasuredHeight() - mParent.getBigScaleLength())/2f;
        Log.i("TopHead",getMeasuredHeight() +" centerX "+centerStartX);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawScale(canvas);
        drawEdgeEffect(canvas);
    }

    //画刻度和字
    private void drawScale(Canvas canvas) {
        //计算开始和结束刻画时候的刻度
        float start = (getScrollX() - mDrawOffset) / mParent.getInterval() + mParent.getMinScale();
        float end = (getScrollX() + canvas.getWidth() + mDrawOffset) / mParent.getInterval() + mParent.getMinScale();
        for (float i = start; i <= end; i++) {
            //将要刻画的刻度转化为位置信息
            float locationX = (i - mParent.getMinScale()) * mParent.getInterval();

            if (i >= mParent.getMinScale() && i <= mParent.getMaxScale()) {
                if (i % mCount == 0) {
                    mBigScalePaint.setColor(Color.RED);

                    //可以做一个上中下 TODO  默认中间


                    canvas.drawLine(locationX, 0, locationX, mParent.getBigScaleLength(), mBigScalePaint);
//                    canvas.drawText(RulerStringUtil.resultValueOf(i,mParent.getFactor()), locationX, mParent.getTextMarginHead(), mTextPaint);
                } else {
                    mSmallScalePaint.setColor(Color.BLUE);
                    canvas.drawLine(locationX, 0, locationX, mParent.getSmallScaleLength(), mSmallScalePaint);
                }
            }
        }
//        mOutLinePaint.setColor(Color.RED);
        //画轮廓线
//        canvas.drawLine(getScrollX(), 0, getScrollX() + canvas.getWidth(), 0, mOutLinePaint);

    }



    //画边缘效果
    private void drawEdgeEffect(Canvas canvas) {
        if (mParent.canEdgeEffect()) {
            if (!mStartEdgeEffect.isFinished()) {
                int count = canvas.save();
                //旋转位移Canvas来使EdgeEffect绘画在正确的地方
                canvas.rotate(270);
                canvas.translate(-mParent.getCursorHeight(), 0);
                if (mStartEdgeEffect.draw(canvas)) {
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(count);
            } else {
                mStartEdgeEffect.finish();
            }
            if (!mEndEdgeEffect.isFinished()) {
                int count = canvas.save();
                canvas.rotate(90);
                canvas.translate(0, -mLength);
                if (mEndEdgeEffect.draw(canvas)) {
                    postInvalidateOnAnimation();
                }
                canvas.restoreToCount(count);
            } else {
                mEndEdgeEffect.finish();
            }
        }
    }
}
