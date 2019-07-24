package com.dengpan20.somesample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.dengpan20.somesample.R
import com.dengpan20.somesample.bean.CateBean
import com.dengpan20.somesample.data.DataUtil
import com.dengpan20.somesample.pop.CustomPartShadowPopupView
import com.dengpan20.somesample.pop.MyListCustomPopupView
import com.dengpan20.somesample.pop.OnClikCallback
import com.lxj.xpopup.XPopup
import com.lxj.xpopup.interfaces.OnSelectListener
import com.lxj.xpopup.interfaces.SimpleCallback
import kotlinx.android.synthetic.main.activity_xpopup.*
import org.jetbrains.anko.toast

class XPopupActivity : AppCompatActivity() {
    private var popupView: MyListCustomPopupView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xpopup)
        showPop?.setOnClickListener {
            showPartShadow(it)
        }
    }

    private fun showCommom() {
        val pop = XPopup.Builder(this)
            .atView(showPop)
            .asAttachList(arrayOf("分享", "编辑"),
                intArrayOf(R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round),
                object : OnSelectListener {
                    override fun onSelect(position: Int, text: String?) {
                    }

                }).show()
    }


    private fun showPartShadow(v: View) {
        //        if(popupView!=null && popupView.isShow())return;
        if (popupView == null) {
            val myListCustomPopupView = MyListCustomPopupView(this);
            popupView = XPopup.Builder(this)
                .atView(v)
                //                    .isCenterHorizontal(true)
                .autoOpenSoftInput(true)
                //                    .offsetX(200)
                //                .dismissOnTouchOutside(false)
                .setPopupCallback(object : OnClikCallback() {
                    override fun onDataClick(bean: CateBean?) {
                    }
                })
                .asCustom(myListCustomPopupView) as MyListCustomPopupView
            myListCustomPopupView.setData(DataUtil.getData(20))
        }

        popupView!!.setOnDataSelected {
            toast("选择了")
            popupView!!.dismiss() }
        popupView!!.show()
    }
}
