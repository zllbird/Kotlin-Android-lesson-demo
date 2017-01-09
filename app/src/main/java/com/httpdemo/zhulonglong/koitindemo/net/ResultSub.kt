package com.httpdemo.zhulonglong.koitindemo.net

import com.httpdemo.zhulonglong.koitindemo.domain.store.Response
import com.httpdemo.zhulonglong.koitindemo.exception.CusNetWorkException
import rx.Subscriber
import timber.log.Timber

/**
 * 处理带progress的网络请求的progress sub
 * Created by zhulonglong on 2017/1/9.
 */
open class ResultSub<T>(val onNext: (List<T>) ->Unit):Subscriber<Response<T>>(){

    override fun onCompleted() {
        // 处理网络请求结束
    }

    override fun onError(e: Throwable) {
        // 统一处理网络请求异常
        when(e){
            is RuntimeException -> Timber.e(e)
            is CusNetWorkException -> Timber.e(e)
        }
    }

    override fun onNext(t: Response<T>?) {
        if (t == null) throw RuntimeException("net response is null")
        if (t.error) throw CusNetWorkException("server error")
        onNext(t.results)
    }

}
