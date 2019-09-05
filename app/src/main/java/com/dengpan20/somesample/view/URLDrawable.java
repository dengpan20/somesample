package com.dengpan20.somesample.view;

import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

/**
 * @author Paddy
 * @time 2019-09-01 21:27
 * @class describe
 */
public class URLDrawable extends BitmapDrawable {

    private Drawable drawable;
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(drawable != null){
            drawable.draw(canvas);
        }
    }


    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }
}
