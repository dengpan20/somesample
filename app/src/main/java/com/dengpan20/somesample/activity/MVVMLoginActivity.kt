package com.dengpan20.somesample.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dengpan20.somesample.R
import com.dengpan20.somesample.base.BaseActivity
import com.dengpan20.somesample.base.User
import com.dengpan20.somesample.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_mvvmlogin.*

class MVVMLoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvmlogin)
        val login = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        val observer = Observer<User>{
            user->
            //setUI
            accout.setText(user.accout)
            password.setText(user.password)
        }

        login.getLiveDatal().observe(this,observer)

        login.setValue(accout.text.toString(),password.text.toString())
        login.getLiveDatal()

    }
}
