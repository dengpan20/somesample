package com.dengpan20.somesample.activity

import android.os.Bundle
import com.dengpan20.somesample.R
import com.dengpan20.somesample.base.BaseActivity
import com.dengpan20.somesample.db.GmatDataBase
import com.dengpan20.somesample.extends.subscribeDbResult
import kotlinx.android.synthetic.main.activity_appar_layout.*
import org.jetbrains.anko.info

class ApparLayoutActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appar_layout)
//        smartRefresh.setHeaderInsetStartPx(btnToolBar.measuredHeight)
//        smartRefresh.setHeaderInsetStart(48f)

        val db = GmatDataBase.getInstance(this)
        db.noteDao()
            .getNote(3)
            .subscribeDbResult(
                {
                    it.toString()
                    info(it.id)
                }, {
                    info("ooo=="+it.message)
                }
            )
    }
}
