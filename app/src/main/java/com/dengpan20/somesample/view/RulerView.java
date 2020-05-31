package com.dengpan20.somesample.view;

import android.content.Context;
import android.graphics.*;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.dengpan20.somesample.R;
import com.dengpan20.somesample.view.listener.OnValueChangeListener;

import java.math.BigDecimal;

/**
 * @author Paddy
 * @time 2020-05-31 20:35
 * @class describe
 */
public class RulerView extends View {

    private final int SCALE_WIDTH_BIG = 4;//大刻度线宽度
    private final int SCALE_WIDTH_SMALL = 2;//小刻度线宽度
    private final int LINE_WIDTH = 6;//指针线宽度


    private int rectPadding = 20;//圆角矩形间距
    private int rectHeight;//圆角矩形高
    private Paint paint;
    private int start;
    private int end;
    private int originValue; //初始刻度中间的值
    private int currentValue;

    private String unit;//单位刻度

    private int width;
    private int height;
    private int rulerWidth;//刻度尺的宽度
    private int maxRulerLength;//大刻度尺的长度
    private int midRulerLenght;//中刻度尺的长度
    private int minRulerLength;//小刻度尺的长度

    private int rulerSpace;//刻度尺间距
    private int rulerSoaceUnit;//大刻度尺的间距


    private float midY;//当前中心刻度y坐标
    private float originMidY;//初始中心刻度y坐标
    private float lastY;
    private float minY;//最小刻度y坐标,从最小刻度开始画刻度


    private int borderUp, borderDown;//上下边界值坐标

    private VelocityTracker velocityTracker;//速度监测
    private float velocity;//当前滑动速度
    private float a = 1000000;//加速度
    private boolean continueScroll;//是否继续滑动
    private boolean isMeasure = false;//是否测量过

    private OnValueChangeListener onValueChangeListener;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (null != onValueChangeListener) {
                float v = (float) (Math.round(currentValue * 10)) / 10;//保留一位小数
                onValueChangeListener.onValueChanged(v);
            }
        }
    };

    //设置value变化监听
    public void setOnValueChangeListener(OnValueChangeListener onValueChangeListener) {
        this.onValueChangeListener = onValueChangeListener;
    }
    public RulerView(Context context) {
//        super(context);
        this(context, null);
    }

    public RulerView(Context context, AttributeSet attrs) {
//        super(context, attrs);
        this(context, attrs, -1);
    }

    public RulerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        this(context,attrs,defStyleAttr,-1);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
    }

    public void setRang(int start, int end) {
        this.start = start;
        this.end = end;
        originValue = (start + end) / 2;
        currentValue = originValue;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (!isMeasure) {
            width = getMeasuredWidth();
            height = getMeasuredHeight();
            rulerWidth = width * 2 / 3;
            maxRulerLength = width / 5;
            midRulerLenght = width / 6;
            minRulerLength = maxRulerLength / 2;

            rulerSpace = height / 80 > 8 ? height / 80 : 8; //间隔
            rulerSoaceUnit = rulerSpace * 10 + SCALE_WIDTH_BIG + SCALE_WIDTH_SMALL * 9; //大间隔
            rectHeight = rulerSoaceUnit/2;

            borderUp = height /2 - ((start+end)/2 -start) * rulerSoaceUnit;
            borderDown = height/2 + ((start+end)/2 -start) * rulerSoaceUnit;

            midY  = ( borderUp+ borderDown)/2f;
            originMidY = midY;
            minY = borderDown;

            isMeasure = true;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画刻度线
        for (int i = start;i <= end;i++){
            canvas.rotate(90);

            Rect rect = new Rect();
            paint.setColor(Color.BLACK);
            paint.setTextSize(40f);
            paint.getTextBounds(""+i,0,(""+i).length(),rect);
            int width = rect.width();
            int height = rect.height();
            canvas.drawText(""+i, minY - (i - start) * rulerSoaceUnit - width / 2 -
                    SCALE_WIDTH_BIG / 2, -(rulerWidth - maxRulerLength - height - minRulerLength / 2), paint);
            canvas.rotate(-90);

            //画最大刻度线
            paint.setStrokeWidth(SCALE_WIDTH_BIG);

            canvas.drawLine(rulerWidth, minY - (i - start) * rulerSoaceUnit,
                    rulerWidth - maxRulerLength, minY - (i - start) * rulerSoaceUnit, paint);


            if(i == start){
                continue;
            }
            paint.setStrokeWidth(SCALE_WIDTH_SMALL);
            canvas.drawLine(rulerWidth, minY - (i - start) * rulerSoaceUnit + rulerSoaceUnit / 2,
                    rulerWidth - minRulerLength,
                    minY - (i - start) * rulerSoaceUnit + rulerSoaceUnit / 2, paint);

            //画小刻度线
            for (int j = 1; j < 10; j++) {
                if (j == 5) {
                    continue;
                }
                canvas.drawLine(rulerWidth, minY - (i - start) * rulerSoaceUnit + (SCALE_WIDTH_SMALL + rulerSpace) * j,
                        rulerWidth - minRulerLength, minY - (i - start) * rulerSoaceUnit + (SCALE_WIDTH_SMALL + rulerSpace) * j, paint);
            }
            //画竖线
            paint.setStrokeWidth(LINE_WIDTH);
            paint.setColor(Color.RED);
            canvas.drawLine(rulerWidth + LINE_WIDTH / 2, minY + SCALE_WIDTH_BIG / 2, rulerWidth + LINE_WIDTH / 2,
                    minY - (end - start) * rulerSoaceUnit - SCALE_WIDTH_BIG / 2, paint);
            //画指针线
            paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
            canvas.drawLine(0, height / 2, rulerWidth, height / 2, paint);

            //画圆角矩形
            paint.setStyle(Paint.Style.FILL);
            RectF r = new RectF();
            r.left = rulerWidth + rectPadding;
            r.top = height / 2 - rectHeight / 2;
            r.right = width;
            r.bottom = height / 2 + rectHeight / 2;
            canvas.drawRoundRect(r, 10, 10, paint);

            //画小三角形指针
            Path path = new Path();
            path.moveTo(rulerWidth + rectPadding, height / 2 - rulerSpace);
            path.lineTo(rulerWidth + rectPadding - 8, height / 2);
            path.lineTo(rulerWidth + rectPadding, height / 2 + rulerSpace);
            path.close();
            canvas.drawPath(path, paint);
//绘制文字
            paint.setColor(Color.BLACK);
            Rect rect1 = new Rect();
            String descri ="单位";
            paint.getTextBounds(descri, 0, descri.length(), rect1);
            int w1 = rect1.width();
            canvas.drawText(descri, width - (width - rulerWidth - 20) / 2 - w1 / 2, height / 2 - rectHeight / 2 - 10, paint);
            //绘制当前刻度值数字
            paint.setColor(getResources().getColor(R.color.font_white));
            float v = (float) (Math.round(currentValue * 10)) / 10;//保留一位小数
            String value = String.valueOf(v) + unit;
            Rect rect2 = new Rect();
            paint.getTextBounds(value, 0, value.length(), rect2);
            int w2 = rect2.width();
            int h2 = rect2.height();
            canvas.drawText(value, width - (width - rulerWidth - 20) / 2 - w2 / 2, height / 2 + h2 / 2, paint);
        }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastY = y;
                continueScroll = false;
                if(velocityTracker == null){
                    velocityTracker = VelocityTracker.obtain();
                }else {
                    velocityTracker.clear();
                }

                break;
            case MotionEvent.ACTION_MOVE:
                velocityTracker.addMovement(event);
                float offsetY = lastY -y;
                minY = minY - offsetY;
                midY = midY - offsetY;
                calculateCurrentScale();
                invalidate();
//                lastY = y;
                break;
            case MotionEvent.ACTION_UP:
                confirmBorder();
                //当前滑动速度
                velocityTracker.computeCurrentVelocity(1000);
                velocity = velocityTracker.getYVelocity();
                float minVelocity = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
                if(Math.abs(velocity) > minVelocity){//加速度大于多少
                    continueScroll = true;
                    continueScroll();
                }else {
                    velocityTracker.recycle();
                    velocityTracker = null;
                }
                break;
            case MotionEvent.ACTION_CANCEL:
                velocityTracker.recycle();
                velocityTracker = null;
                break;
        }

        return super.onTouchEvent(event);
    }

    private void continueScroll() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                float velocityAbs = 0;//速度绝对值
                if (velocity > 0 && continueScroll) {
                    velocity -= 50;
                    minY += velocity * velocity / a;
                    midY += velocity * velocity / a;
                    velocityAbs = velocity;
                } else if (velocity < 0 && continueScroll) {
                    velocity += 50;
                    minY -= velocity * velocity / a;
                    midY -= velocity * velocity / a;
                    velocityAbs = -velocity;
                }
                calculateCurrentScale();
                confirmBorder();
                postInvalidate();
                if (continueScroll && velocityAbs > 0) {
                    post(this);
                } else {
                    continueScroll = false;
                }
            }
        }).start();

    }

    //指针线超出范围时 重置回边界处

    private void confirmBorder() {

        if (midY < borderUp) {
            midY = borderUp;
            minY = borderDown + (borderUp - borderDown) / 2;
            postInvalidate();
        } else if (midY > borderDown) {
            midY = borderDown;
            minY = borderDown - (borderUp - borderDown) / 2;
            postInvalidate();
        }

    }

    /**
     * 计算当前刻度
     */

    private void calculateCurrentScale() {
        float offsetTotal = originMidY - midY;
        int offsetBig = (int) (offsetTotal / rulerSoaceUnit);//移动的大刻度数
        float offsetS = offsetTotal % rulerSoaceUnit;
        int offsetSmall = (new BigDecimal(offsetS / (rulerSpace + SCALE_WIDTH_SMALL)).setScale(0, BigDecimal.ROUND_HALF_UP)).intValue();//移动的小刻度数 四舍五入取整
        float offset = offsetBig + offsetSmall * 0.1f;
        if (originValue - offset > end) {
            currentValue = end;
        } else if (originValue - offset < start) {
            currentValue = start;
        } else {
            currentValue = (int) (originValue - offset);
        }
        mHandler.sendEmptyMessage(0);
    }
}
