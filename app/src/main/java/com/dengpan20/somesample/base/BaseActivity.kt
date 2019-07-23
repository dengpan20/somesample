package com.dengpan20.somesample.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dengpan20.somesample.R
import com.dengpan20.somesample.activity.ToolBarActivity
import org.jetbrains.anko.AnkoLogger
import kotlin.reflect.KClass

abstract class BaseActivity : AppCompatActivity(), AnkoLogger {
    companion object{
        fun show(context: Context,clazz: Class<Any>){
            val intent = Intent(context,clazz)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tool_bar)
    }
//
//    override fun setContentView(layoutResID: Int) {
//
//    }

    fun toNextAct(clazz: Class<*>){
        val intent = Intent(this,clazz)
        this.startActivity(intent)
    }
}