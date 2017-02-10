package com.httpdemo.zhulonglong.koitindemo.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.httpdemo.zhulonglong.koitindemo.adapter.ForecastListAdapter
import com.httpdemo.zhulonglong.koitindemo.net.GitHubUserRequest
import com.httpdemo.zhulonglong.koitindemo.R
import com.httpdemo.zhulonglong.koitindemo.adapter.SearchListAdapter
import com.httpdemo.zhulonglong.koitindemo.adapter.StorePagerAdapter
import com.httpdemo.zhulonglong.koitindemo.domain.user.SearchRepoItem
import com.httpdemo.zhulonglong.koitindemo.net.GitHubAPI
import com.httpdemo.zhulonglong.koitindemo.net.RetrifitService
import com.httpdemo.zhulonglong.koitindemo.ui.fargment.StoreGateFragment
import kotlinx.android.synthetic.main.activity_github_test.*
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.startActivity
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.tag("kotlin")
        toast("hello")
        initViewPager()

    }

    private fun initViewPager() {

//        福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
        val types:List<String> = listOf(
                "all","Android","iOS","前端","拓展资源","福利","休息视频"
        )

        val list :ArrayList<StoreGateFragment> = ArrayList()
        for (index in 0..5){
            val item :StoreGateFragment = StoreGateFragment().apply {
                arguments = Bundle().apply { putString(StoreGateFragment.TITLE ,types[index]) }
            }
            list.add(item)
        }
        content_view_pager.adapter = StorePagerAdapter(list,supportFragmentManager)
        tab_layout.setupWithViewPager(content_view_pager)

//        var map = Bundle();
//        map.putByte()

        tv_player.setOnClickListener {
            startActivity<PlayerActivity>()
        }

    }

    public fun toPlayer(){

    }



}
