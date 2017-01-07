package com.httpdemo.zhulonglong.koitindemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.httpdemo.zhulonglong.koitindemo.net.GitHubUserRequest
import com.httpdemo.zhulonglong.koitindemo.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.user_detail.*
import org.jetbrains.anko.async
import org.jetbrains.anko.ctx
import org.jetbrains.anko.uiThread

/**
 * Created by zhulonglong on 2017/1/6.
 */
class UserDetailActivity: AppCompatActivity(){
    companion object{
        val ID = "UserDetailActivity:id"
        val LOGIN = "UserDetailActivity:login"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_detail)
        title = intent.getStringExtra(LOGIN)
        Log.i(javaClass.simpleName,"onCreate")
        async() {
            val result = GitHubUserRequest().requestToUserDetail(intent.getStringExtra(LOGIN))
            uiThread {
                bindResult(result)
            }
        }
    }

    private fun bindResult(result: GitHubUserRequest.GitHubUser) = with(result){
        Picasso.with(ctx).load(avatar_url).into(icon)
        supportActionBar!!.subtitle = login
        weatherDescription.text = "$login descri"
    }

}