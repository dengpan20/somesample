package com.dengpan20.somesample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dengpan20.somesample.base.User

class LoginViewModel:ViewModel() {
//    private val liveData:LiveData<User> = MutableLiveData<User>()
    private var userMutableLiveData = MutableLiveData<User>()

    fun getLiveDatal():LiveData<User>{
        fetchData()
        return userMutableLiveData
    }

    private fun fetchData() {
        var user = User("","")
        userMutableLiveData.value = user
    }


    fun setValue(name:String,password:String){
        getLiveDatal().value!!.accout = name
        getLiveDatal().value!!.password = password
    }

    fun setUser(user: User){
        userMutableLiveData.value!!.accout = user.accout
        userMutableLiveData.value!!.password = user.password
    }

}