package com.dengpan20.somesample.activity

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Base64
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.dengpan20.somesample.R
import com.dengpan20.somesample.base.BaseActivity
import com.dengpan20.somesample.util.FileUtil
import com.dengpan20.somesample.view.URLDrawable
import kotlinx.android.synthetic.main.activity_page_turning.*

class PageTurningActivity : BaseActivity() {

    private lateinit var context:Context
    var BASEURL = "https://gmat.viplgw.cn/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_turning)
        context = this
        val file = FileUtil.getFile(this, "2.txt")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tvContent.text = Html.fromHtml(file,Html.FROM_HTML_MODE_LEGACY,MyImageGetter(),null)
        }
    }


    fun getContext():Context{
        return context
    }

    inner class MyImageGetter :Html.ImageGetter{
        override fun getDrawable(source: String?): Drawable {
            var drawable = URLDrawable()

            Glide.with(getContext())
                .asBitmap()
                .load(BASEURL+source)
                .into(BitmapTarget(drawable))
            return drawable

        }

    }

    inner class BitmapTarget constructor(var draw: com.dengpan20.somesample.view.URLDrawable) :SimpleTarget<Bitmap>(){


        override fun onResourceReady(bitmap: Bitmap, transition: Transition<in Bitmap>?) {
            val bitmapDrawable = BitmapDrawable(resources, bitmap)
            //获取原图大小
            val intrinsicHeight = bitmapDrawable.intrinsicHeight
            val intrinsicWidth = bitmapDrawable.intrinsicWidth
            //设置大小
            bitmapDrawable.setBounds(intrinsicWidth,0,intrinsicWidth* 4,intrinsicHeight*4)
            draw.drawable = bitmapDrawable

            tvContent.text = tvContent.text
        }

    }


}
