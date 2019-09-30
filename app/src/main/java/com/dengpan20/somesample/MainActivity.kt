package com.dengpan20.somesample

import android.content.Intent
import android.os.Bundle
import com.dengpan20.somesample.R.layout.activity_main
import com.dengpan20.somesample.activity.*
import com.dengpan20.somesample.base.BaseActivity
import com.lgw.ocrlibrary.ocr.camera.CameraActivity
import com.lgw.ocrlibrary.ocr.thrlib.OCRProxy
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.button
import org.jetbrains.anko.matchParent
import java.io.File

class MainActivity : BaseActivity() {
    private val REQUEST_CODE_GENERAL = 105
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        OCRProxy.initToken(this)
        initListener()
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
