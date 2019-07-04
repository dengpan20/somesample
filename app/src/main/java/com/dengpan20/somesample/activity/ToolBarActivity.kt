package com.dengpan20.somesample.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dengpan20.somesample.R
import com.dengpan20.somesample.R.layout.activity_tool_bar
import com.dengpan20.somesample.base.BaseActivity
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshListener
import kotlinx.android.synthetic.main.activity_tool_bar.*

class ToolBarActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_tool_bar)
        smartRefresh.setOnRefreshListener {
            OnRefreshListener {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }
}
