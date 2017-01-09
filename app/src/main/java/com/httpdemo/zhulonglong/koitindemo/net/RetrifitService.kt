package com.httpdemo.zhulonglong.koitindemo.net

import com.httpdemo.zhulonglong.koitindemo.util.DelegatesExt
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
//        val BASH_URL = "https://api.github.com/"
        val BASH_URL = "http://gank.io/api/data/"
        var instance: RetrifitService by DelegatesExt.notNullSingleValue<RetrifitService>()
        fun instance() = instance
    }

    val retrofit: Retrofit by lazy {
//        val inter :HttpLoggingInterceptor = HttpLoggingInterceptor()
//        inter.level = HttpLoggingInterceptor.Level.BODY
        Retrofit.Builder()
                .baseUrl(BASH_URL)
                .client(OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        })
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }


}
