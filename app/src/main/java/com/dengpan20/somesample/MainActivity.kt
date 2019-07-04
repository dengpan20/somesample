package com.dengpan20.somesample

import android.os.Bundle
import com.dengpan20.somesample.R.layout.activity_main
import com.dengpan20.somesample.activity.ToolBarActivity
import com.dengpan20.somesample.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        initListener()
    }

    private fun initListener() {
        btnToolBar.setOnClickListener {
            toNextAct(ToolBarActivity::class.java)
        }
    }

}
