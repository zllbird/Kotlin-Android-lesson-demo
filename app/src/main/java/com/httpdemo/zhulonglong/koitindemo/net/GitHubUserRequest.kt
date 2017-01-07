package com.httpdemo.zhulonglong.koitindemo.net

import android.util.Log
import com.google.gson.Gson
import java.net.URL
import org.jetbrains.anko.*
/**
 *
 * Created by zhulonglong on 2017/1/6.
 */
public class  GitHubUserRequest(){
    data class GitHubUserResult(val total_count:Int , val incomplete_results:Boolean ,val items:List<GitHubUser>)
    data class GitHubUser(val id:Int , val html_url:String , val score:Double,val avatar_url:String,
                          val login:String, val followers:Int
    )

    fun execute(): GitHubUserResult {
        val gitHubUserResult = URL("https://api.github.com/search/users?q=tom+repos:%3E42+followers:%3E1000").readText()
        return Gson().fromJson(gitHubUserResult, GitHubUserResult::class.java)
    }


    fun requestToUserDetail(name: String): GitHubUser {
        Log.e("haha","dafds   " +name)
        val gitHubUserDetailResult = URL("https://api.github.com/users/$name").readText()
        Log.e("haha",gitHubUserDetailResult)
        return Gson().fromJson(gitHubUserDetailResult, GitHubUser::class.java)
    }

}


