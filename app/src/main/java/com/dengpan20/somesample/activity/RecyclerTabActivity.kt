package com.dengpan20.somesample.activity

import android.os.Bundle
import android.view.MotionEvent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dengpan20.somesample.R
import com.dengpan20.somesample.activity.adapter.MultAdapter
import com.dengpan20.somesample.base.BaseActivity
import com.dengpan20.somesample.bean.FunBean
import com.dengpan20.somesample.bean.MultBean
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_recycler_tab.*


class RecyclerTabActivity : BaseActivity() {

    private val multAdapter = MultAdapter(null)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_tab)

        initView()
        initData()

    }

    private fun initData() {
        val data = ArrayList<MultBean>()
        for (i in 0..6){
            tabLayout.addTab(tabLayout.newTab().setText("tab${i}").setTag(i*2))
            data.add(MultBean(MultBean.TYPE_TITLE,"title${i}",null))
            var datam =  ArrayList<FunBean>()
            for (j in 0..11){
                datam.add(FunBean(j,"content${j}"))
            }
            data.add(MultBean(MultBean.TYPE_CONTENT,"title${i}",datam))

        }

        multAdapter.replaceData(data)
    }

    private fun initView() {
//        for (i in 0..11){
//            tabLayout.addTab(tabLayout.newTab().setText("tab${i}").setTag(i))
//        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = multAdapter
        recyclerView.setHasFixedSize(true)
        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                val layoutManager = recyclerView.layoutManager
//                layoutManager?.scrollToPosition(tab.position)
                isRecyclerScroll = false
                moveToPos(layoutManager as LinearLayoutManager,recyclerView,tab.tag as Int)
            }

        })
        recyclerView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(isRecyclerScroll){
                    val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                    val findFirstVisibleItemPosition =
                        linearLayoutManager.findFirstVisibleItemPosition()
                    if(lastPos != findFirstVisibleItemPosition){
                        tabLayout.setScrollPosition(findFirstVisibleItemPosition,0f,true)
                    }
                    lastPos = findFirstVisibleItemPosition
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if(canScroll){
                    canScroll = false
                    moveToPos(recyclerView.layoutManager as LinearLayoutManager,recyclerView,scrollPosition)
                }
            }
        })
        recyclerView.setOnTouchListener { v, event ->
            //当滑动由recyclerView触发时，isRecyclerScroll 置true
            if (event.action == MotionEvent.ACTION_DOWN) {
                isRecyclerScroll = true
            }
            false
        }
    }


    private var scrollPosition = 0
    private var canScroll = false
    private var isRecyclerScroll = false
    private var lastPos = 0
    private fun moveToPos(manager: LinearLayoutManager,recyclerView: RecyclerView,pos:Int){
        val findFirstVisibleItemPosition = manager.findFirstVisibleItemPosition()
        val findLastVisibleItemPosition = manager.findLastVisibleItemPosition()

        if(pos<= findFirstVisibleItemPosition){ // 如果跳转位置firstItem 之前(滑出屏幕的情况)，就smoothScrollToPosition可以直接跳转，
            recyclerView.smoothScrollToPosition(pos)
        }else if(pos<=findLastVisibleItemPosition){// 跳转位置在firstItem 之后，lastItem 之间（显示在当前屏幕），smoothScrollBy来滑动到指定位置
            val top = recyclerView.getChildAt(pos-findFirstVisibleItemPosition).top
            recyclerView.smoothScrollBy(0,top)
        }else{
            // 如果要跳转的位置在lastItem 之后，则先调用smoothScrollToPosition将要跳转的位置滚动到可见位置
            // 再通过onScrollStateChanged控制再次调用当前moveToPosition方法，执行上一个判断中的方法
            recyclerView.smoothScrollToPosition(pos)
            scrollPosition = pos
            canScroll = true
        }
    }

}
