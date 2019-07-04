package com.dengpan20.somesample.test

import android.content.Context
import android.content.Intent

object Test {


    fun test(context: Context, clazz: Class<*>) {
        val intent = Intent(context, clazz)
        context.startActivity(intent)
    }
}
