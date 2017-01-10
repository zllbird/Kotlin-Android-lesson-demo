package com.httpdemo.zhulonglong.koitindemo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.httpdemo.zhulonglong.koitindemo.R
import kotlinx.android.synthetic.main.activity_store_detail.*

/**
 * 具体干货详情
 * Created by zhulonglong on 2017/1/10.
 */
class StoreDetailActivity():AppCompatActivity(){
    companion object{
        var URL = "StoreDetailActivity:url"
    }
    var url:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_detail)
        url = intent.getStringExtra(URL)
        web_view.loadUrl(url)
    }
}
