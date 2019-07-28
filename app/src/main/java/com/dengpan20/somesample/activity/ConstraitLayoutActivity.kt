package com.dengpan20.somesample.activity

import android.os.Bundle
import com.dengpan20.somesample.R
import com.dengpan20.somesample.activity.adapter.ViewPagerAdapter
import com.dengpan20.somesample.base.BaseActivity
import com.dengpan20.somesample.bean.Tab
import com.dengpan20.somesample.fragment.AnimationConstraitFragment
import com.dengpan20.somesample.fragment.CircularFragment
import kotlinx.android.synthetic.main.activity_constrait_layout.*

class ConstraitLayoutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constrait_layout)

        val tab = listOf<Tab>(Tab(CircularFragment(),"圆形定位"),
            Tab(AnimationConstraitFragment(),"约束布局动画"))

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,tab)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

}
