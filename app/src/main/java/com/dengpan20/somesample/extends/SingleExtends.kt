package com.dengpan20.somesample.extends

import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**

 * Author: Paddy
 * Date: 2019/7/23 14:05
 * Description:
 *
 */

/**
 * 数据库一次性查询结果扩展方法，目的是处理数据库查询返回的Single结果
 * 有结果调用onSuccess，空结果或查询出错一律调用onFailed
 */
 fun <T> Single<T>.subscribeDbResult(onSuccess: (data: T) -> Unit, onFailed: (e: Throwable) -> Unit) {
    subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(object : SingleObserver<T> {
            override fun onSuccess(t: T) {
                onSuccess(t)
            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onError(e: Throwable) {
                onFailed(e)
            }
        })
}