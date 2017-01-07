package com.httpdemo.zhulonglong.koitindemo.net

import com.httpdemo.zhulonglong.koitindemo.util.DelegatesExt
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.properties.Delegates

/**
 * net manager
 * Created by zhulonglong on 2017/1/7.
 */
class RetrifitService{

    companion object{
        val BASH_URL = "https://api.github.com/"
        var instance: RetrifitService by DelegatesExt.notNullSingleValue<RetrifitService>()
        fun instance() = instance
    }

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BASH_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }


}
