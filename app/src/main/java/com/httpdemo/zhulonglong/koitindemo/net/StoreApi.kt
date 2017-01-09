package com.httpdemo.zhulonglong.koitindemo.net

import com.httpdemo.zhulonglong.koitindemo.domain.store.Response
import com.httpdemo.zhulonglong.koitindemo.domain.store.Store
import retrofit2.Call
import retrofit2.http.*
import rx.Observable

/**
 * net api (store)
 * Created by zhulonglong on 2017/1/9.
 */
interface StoreApi{
    @GET("{type}/{count}/{page}")
    fun requestStoreAndroid(@Path("type") type:String, @Path("count") count:Int, @Path("page") page:Int):Observable<Response<Store>>

    @GET("Android/{count}/{page}")
    fun requestStoreAndroidCall(@Path("count") count:Int,@Path("page") page:Int):Call<Response<Store>>

}
