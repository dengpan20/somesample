package com.dengpan20.somesample.activity

import android.os.Bundle
import com.dengpan20.somesample.R.layout.activity_sencod_floor
import com.dengpan20.somesample.base.BaseActivity
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener
import kotlinx.android.synthetic.main.activity_sencod_floor.*

class SencodFloorActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_sencod_floor)
        refreshLayout.setOnRefreshListener {
            OnRefreshListener {
                //                if(percent<0.5f){
//                    smartRefresh.finishRefresh()
//                    ivLogo.background.alpha = 255
//                    tvLogoCenter.alpha = 1f
//                }
            }
        }
        refreshLayout.setOnMultiPurposeListener(object : SimpleMultiPurposeListener() {
            override fun onHeaderMoving(
                header: RefreshHeader?,
                isDragging: Boolean,
                percent: Float,
                offset: Int,
                headerHeight: Int,
                maxDragHeight: Int
            ) {
                toolbar.alpha = 1 - Math.min(percent, 1f)
            }

        })
//        refreshLayout.setDragRate(0.5f)
        refreshLayout.setHeaderTriggerRate(0.5f)

//        classics.setOnHeaderChangeListener { percent, offset, headerHeight, maxDragHeight ->
//            toolbar.alpha =
//                1 - Math.min(percent, 1f)
//            if (refreshLayout.isRefreshing) {
//                if (percent < 0.6) {
//                    refreshLayout.finishRefresh()
////                    ivLogo.background.alpha = 255
////                    tvLogoCenter.alpha = 1f
//                    info("invoke this finish")
////                    var marginLayoutParams :ViewGroup.MarginLayoutParams = smartRefresh.layoutParams as ViewGroup.MarginLayoutParams
////                    marginLayoutParams.topMargin = dip(48)
////                    smartRefresh.layoutParams = marginLayoutParams
//                }
//            }
//        }

    }
}
