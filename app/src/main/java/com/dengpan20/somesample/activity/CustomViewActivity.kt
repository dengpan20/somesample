package com.dengpan20.somesample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dengpan20.somesample.R
import com.dengpan20.somesample.base.BaseActivity
import com.dengpan20.somesample.view.listener.OnValueChangeListener
import kotlinx.android.synthetic.main.activity_custom_view.*

class CustomViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)




//        rulerView.setOnValueChangeListener(object :OnValueChangeListener{
//            override fun onValueChanged(value: Float) {
//                tvValue1.text = "result $value"
//            }
//
//        })

//        rulerView2.setOnValueChangeListener(object :OnValueChangeListener{
//            override fun onValueChanged(value: Float) {
//                tvValue2.text = "result $value"
//            }
//
//        })

//        knl_bottom_head.bindRuler(br_top_head);
    }
}
