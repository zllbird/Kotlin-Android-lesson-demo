package com.httpdemo.zhulonglong.koitindemo.domain.store

/**
 * Created by zhulonglong on 2017/1/9.
 */
data class Response<T>(val error:Boolean, val results:List<T>)
