package com.httpdemo.zhulonglong.koitindemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.httpdemo.zhulonglong.koitindemo.adapter.ForecastListAdapter
import com.httpdemo.zhulonglong.koitindemo.net.GitHubUserRequest
import com.httpdemo.zhulonglong.koitindemo.R
import com.httpdemo.zhulonglong.koitindemo.adapter.SearchListAdapter
import com.httpdemo.zhulonglong.koitindemo.domain.user.SearchRepoItem
import com.httpdemo.zhulonglong.koitindemo.net.GitHubAPI
import com.httpdemo.zhulonglong.koitindemo.net.RetrifitService
import kotlinx.android.synthetic.main.activity_github_test.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.jetbrains.anko.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber
import java.util.*


class GithubApiTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_test)
        forecast_list.layoutManager = LinearLayoutManager(this)
        Timber.tag(javaClass.simpleName)
        quest()
    }

    fun quest(){
        RetrifitService().retrofit
                .create(GitHubAPI::class.java)
                .searchAndroidRepo("android")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d(it.toString())
                    forecast_list.adapter = SearchListAdapter(it.items){
                        toast("点击了${it.name}项目")
                    }
                },{Timber.e(it)},{})
    }

}
