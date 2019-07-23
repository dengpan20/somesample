package com.dengpan20.somesample

import android.os.Bundle
import com.dengpan20.somesample.R.layout.activity_main
import com.dengpan20.somesample.activity.*
import com.dengpan20.somesample.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.button
import org.jetbrains.anko.matchParent

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

        llFirContainer.button("appbar"){
            width = 0
            height = matchParent
            setOnClickListener{
                toNextAct(ApparLayoutActivity::class.java)
            }
        }
        mvvm.setOnClickListener {
            toNextAct(MVVMLoginActivity::class.java)
        }
        secondfloor.setOnClickListener{
            toNextAct(SencodFloorActivity::class.java)
        }
        room.setOnClickListener {
            toNextAct(RoomActivity::class.java)
        }
    }


}
