package com.dengpan20.somesample.activity

import android.os.Bundle
import com.dengpan20.somesample.R.layout.activity_tool_bar_v1
import com.dengpan20.somesample.base.BaseActivity
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.android.synthetic.main.activity_sencod_floor.view.*
import kotlinx.android.synthetic.main.activity_tool_bar.*
import org.jetbrains.anko.error
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class ToolBarActivity : BaseActivity() {

    private var percent:Float = 0.0f
    private var isRefresh:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_tool_bar_v1)
        smartRefresh.setOnRefreshListener {
            OnRefreshListener {
//                if(percent<0.5f){
//                    smartRefresh.finishRefresh()
//                    ivLogo.background.alpha = 255
//                    tvLogoCenter.alpha = 1f
//                }
                isRefresh = true
            }
        }
        smartRefresh.setDragRate(0.6f)
        adHeader.setOnHeaderChangeListener{percent1, offset, headerHeight, maxDragHeight ->
            //刷新的状态是需要显示
            //拉开的状态需要隐藏
            val maxHeight = headerHeight/2
            var offseF = offset *1.0f
            if(offseF >= maxHeight){
                offseF = maxHeight * 1.0f
            }else if (offseF <= 0){
                offseF = 0f
            }
            var offsetP = 1 - offseF *1F/maxHeight
            var offsetAlpha = (offsetP *255).toInt()


            try {
//                ivLogo.background.alpha = ((1 - offset*1f/(headerHeight/2f)) * 255f ).toInt()
//                tvLogoCenter.background.alpha = ivLogo.background.alpha
                ivLogo.background.alpha = offsetAlpha
                ivLogo.alpha = offsetP
                tvLogoCenter.alpha = offsetP
            }catch (e:Exception){
                e.printStackTrace()
                error(e.message)
            }

//            if(offset >= ivLogo.measuredHeight){
//                ivLogo.visibility = View.GONE
//            }else{
//                ivLogo.visibility = View.VISIBLE
//            }
//            if(offsetAlpha == 0){
//                var marginLayoutParams :ViewGroup.MarginLayoutParams = smartRefresh.layoutParams as ViewGroup.MarginLayoutParams
//                marginLayoutParams.topMargin = 0
//                smartRefresh.layoutParams = marginLayoutParams
//            }
            info("alpha = "+ ivLogo.background.alpha
            + "offset = $offset offsetF = $offseF offsetP = $offsetP offsetA = $offsetAlpha")
            if(isRefresh){
                if (percent1 <0.6) {
                    smartRefresh.finishRefresh()
                    ivLogo.background.alpha = 255
                    tvLogoCenter.alpha = 1f
                    info("invoke this finish")
//                    var marginLayoutParams :ViewGroup.MarginLayoutParams = smartRefresh.layoutParams as ViewGroup.MarginLayoutParams
//                    marginLayoutParams.topMargin = dip(48)
//                    smartRefresh.layoutParams = marginLayoutParams
                }

            }
            info(offset)

        }
        adHeader.setOnClickListener { toast("点击了图片") }
        smartRefresh.setHeaderTriggerRate(0.5f)
    }
}
