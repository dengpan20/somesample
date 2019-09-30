package com.dengpan20.somesample.view.chart;

import android.graphics.Canvas;
import android.graphics.Color;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.renderer.XAxisRenderer;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

/**
 * Author: Paddy
 * Date: 2019/9/16 15:15
 * Description:
 */
public class CustomXAxisRenderer extends XAxisRenderer {

    public CustomXAxisRenderer(ViewPortHandler viewPortHandler, XAxis xAxis, Transformer trans) {
        super(viewPortHandler, xAxis, trans);
    }

    @Override
    protected void drawLabel(Canvas c, String formattedLabel, float x, float y, MPPointF anchor, float angleDegrees) {
//        super.drawLabel(c, formattedLabel, x, y, anchor, angleDegrees);//注释掉这个，否则坐标标签复写两次
        String[] lines = formattedLabel.split("\n");
        for (int i = 0; i < lines.length; i++) {
            float vOffset = i * mAxisLabelPaint.getTextSize();
            if(i ==1){
                mAxisLabelPaint.setColor(Color.BLUE);
            }else {
                mAxisLabelPaint.setColor(Color.BLACK);
            }
            Utils.drawXAxisValue(c, lines[i], x, y + vOffset, mAxisLabelPaint, anchor, angleDegrees);
        }

    }
}
