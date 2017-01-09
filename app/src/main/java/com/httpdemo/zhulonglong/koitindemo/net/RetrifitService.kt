package com.httpdemo.zhulonglong.koitindemo.net

import com.httpdemo.zhulonglong.koitindemo.util.DelegatesExt
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates

/**
 * net manager
 * Created by zhulonglong on 2017/1/7.
 */
class RetrifitService{

    companion object{
//        val BASH_URL = "https://api.github.com/"
        val BASH_URL = "http://gank.io/api/data/"
        var instance: RetrifitService by DelegatesExt.notNullSingleValue<RetrifitService>()
        fun instance() = instance

        val TIME_OUT:Long = 30
    }

    //  1、请求超时
//     2、提供日志
//     3、

    val retrofit: Retrofit by lazy {
//        val inter :HttpLoggingInterceptor = HttpLoggingInterceptor()
//        inter.level = HttpLoggingInterceptor.Level.BODY
        Retrofit.Builder()
                .baseUrl(BASH_URL)
                .client(OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        })
                        .connectTimeout(TIME_OUT,TimeUnit.SECONDS)
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    fun <T> create(service:Class<T>) : T = retrofit.create(service)


}
