package com.dengpan20.somesample.activity

import android.os.Bundle
import com.dengpan20.somesample.R
import com.dengpan20.somesample.base.BaseActivity
import kotlinx.android.synthetic.main.activity_appar_layout.*

class ApparLayoutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appar_layout)
//        smartRefresh.setHeaderInsetStartPx(btnToolBar.measuredHeight)
//        smartRefresh.setHeaderInsetStart(48f)
    }
}
