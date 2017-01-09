package com.httpdemo.zhulonglong.koitindemo.net

import rx.Subscriber

/**
 * 处理带progress的网络请求的progress sub
 * Created by zhulonglong on 2017/1/9.
 */
class ProgressSub<T>(val onNext: (T) ->Unit):Subscriber<T>(){

    override fun onCompleted() {
        // 处理网络请求结束
    }

    override fun onError(e: Throwable?) {
        // 统一处理网络请求异常
    }

    override fun onNext(t: T) {
        onNext(t)
    }

}
