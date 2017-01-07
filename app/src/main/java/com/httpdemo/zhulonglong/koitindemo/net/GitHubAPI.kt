package com.httpdemo.zhulonglong.koitindemo.net

import com.httpdemo.zhulonglong.koitindemo.domain.user.SearchRepo
import com.httpdemo.zhulonglong.koitindemo.domain.user.SearchRepoItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

/**
 * net api (git open api)
 * Created by zhulonglong on 2017/1/7.
 */
interface GitHubAPI{

    @GET("/search/repositories")
    fun searchAndroidRepo(
            @Query("q") q:String,@Query("sort") sort:String = "stars",@Query("order") order:String = "desc"):Observable<SearchRepo>

    @GET("user/{user}")
    fun detailUsers(@Path("user") name:String):Observable<String>

}
