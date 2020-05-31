package com.dengpan20.somesample

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.dengpan20.somesample.R.layout.activity_main
import com.dengpan20.somesample.activity.*
import com.dengpan20.somesample.activity.adapter.FunListAdapter
import com.dengpan20.somesample.base.BaseActivity
import com.dengpan20.somesample.bean.FunBean
import com.lgw.ocrlibrary.ocr.camera.CameraActivity
import com.lgw.ocrlibrary.ocr.thrlib.OCRProxy
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.button
import org.jetbrains.anko.info
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.toast
import java.io.File

class MainActivity : BaseActivity() {
    private val REQUEST_CODE_GENERAL = 105

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        OCRProxy.initToken(this)
        initListener()
        initFunList()

    }

    private fun initFunList() {
        val funList = FunListAdapter()
        recycler.layoutManager = GridLayoutManager(this,3)
        recycler.adapter = funList
        funList.replaceData(getFunListData())
        funList.onItemClickListener = BaseQuickAdapter.OnItemClickListener{
            adapter, view, position ->
            toast("点击")
            when(position){
                0 -> toNextAct(RecyclerTabActivity::class.java) //Recycler Tablayout 联动
                1 -> toNextAct(CustomViewActivity::class.java)
            }
        }
    }

    private fun getFunListData(): MutableCollection<out FunBean> {
        var  list = ArrayList<FunBean>()
//        list.plus(FunBean(0,"RecyclerTab"))
        list.add(FunBean(0,"RecyclerTab"))
        list.add(FunBean(1,"RulerView"))
        info("ooo=="+list.size)
        return list
    }

    override fun onDestroy() {
        super.onDestroy()
        OCRProxy.orcRelease()
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
        chart.setOnClickListener { toNextAct(MPChartActivity::class.java) }
        mvvm.setOnClickListener {
            toNextAct(MVVMLoginActivity::class.java)
        }
        secondfloor.setOnClickListener{
            toNextAct(SencodFloorActivity::class.java)
        }
        room.setOnClickListener {
            toNextAct(RoomActivity::class.java)
        }
        xpopup.setOnClickListener { toNextAct(XPopupActivity::class.java) }
        constait.setOnClickListener { toNextAct(ConstraitLayoutActivity::class.java) }
        orc.setOnClickListener{
            gotoCameraAct()
        }
        textView.setOnClickListener { toNextAct(PageTurningActivity::class.java) }
        webVideo.setOnClickListener{
            toNextAct(VideoWebActivity::class.java)
        }
    }

    private fun gotoCameraAct() {
        val intent = Intent(this, CameraActivity::class.java)
        intent.putExtra(
            CameraActivity.KEY_OUTPUT_FILE_PATH,
//            FileUtil.getSaveFile(this).getAbsolutePath()

            File(this.filesDir,"pic.jpg").absolutePath
//            val file = File context.getFilesDir(), "pic.jpg")

        )
        intent.putExtra(
            CameraActivity.KEY_CONTENT_TYPE,
            CameraActivity.CONTENT_TYPE_GENERAL
        )
        intent.putExtra(CameraActivity.KEY_NEXT,ConstraitLayoutActivity::class.java.name)
        startActivityForResult(intent, REQUEST_CODE_GENERAL)
    }


}
