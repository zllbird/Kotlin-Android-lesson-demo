package com.httpdemo.zhulonglong.koitindemo.ui.fargment

import android.accessibilityservice.GestureDescription
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.httpdemo.zhulonglong.koitindemo.R
import com.httpdemo.zhulonglong.koitindemo.adapter.StoreListAdapter
import com.httpdemo.zhulonglong.koitindemo.domain.store.Response
import com.httpdemo.zhulonglong.koitindemo.domain.store.Store
import com.httpdemo.zhulonglong.koitindemo.net.ResultSub
import com.httpdemo.zhulonglong.koitindemo.net.RetrifitService
import com.httpdemo.zhulonglong.koitindemo.net.StoreApi
import com.httpdemo.zhulonglong.koitindemo.ui.StoreDetailActivity
import kotlinx.android.synthetic.main.fragment_list.*
import org.jetbrains.anko.AlertDialogBuilder
import org.jetbrains.anko.async
import org.jetbrains.anko.support.v4.*
import retrofit2.Call
import retrofit2.Callback
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

import timber.log.Timber

/**
 * 干货列表
 * Created by zhulonglong on 2017/1/8.
 */
class StoreGateFragment():Fragment(){
    companion object{
        val TITLE:String = "StoreGateFragment:title"
    }

    var type:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = arguments.getString(TITLE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list,container!!,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        list.layoutManager = LinearLayoutManager(context)
        RetrifitService()
                .create(StoreApi::class.java)
                .requestStoreAndroid(type,20,1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                // 使用同一管理 ResultSub
                .subscribe(ResultSub<Store>{
                    list.adapter = StoreListAdapter(it){
                        toast("On click ${it.desc}")
                        startActivity<StoreDetailActivity>(StoreDetailActivity.URL to it.url)
                    }
                })

                // 直接使用匿名
//                .subscribe ({
//                    if (!it.error){
//                        Timber.i("size is ${it.results.size}")
//                        store_list.adapter = StoreListAdapter(it.results){toast("On click ${it.desc}")}
//                    }
//                },{it.printStackTrace()})
    }

    /**
     * 直接使用Retrofit
     */
    @Deprecated("过期") fun requestData(){
        val call = RetrifitService().create(StoreApi::class.java).requestStoreAndroidCall(10, 1)
        call.execute() // 同步
        // 异步
        call.enqueue(object :Callback<Response<Store>>{
            override fun onResponse(call: Call<Response<Store>>?, response: retrofit2.Response<Response<Store>>?) {
                toast("onResponse")
            }

            override fun onFailure(call: Call<Response<Store>>?, t: Throwable?) {
                toast("onFailure")
            }
        })
    }

    fun test(name:String) :String {

        return "";
    }


}
