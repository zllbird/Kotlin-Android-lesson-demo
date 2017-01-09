package com.httpdemo.zhulonglong.koitindemo.ui.fargment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.httpdemo.zhulonglong.koitindemo.R
import com.httpdemo.zhulonglong.koitindemo.adapter.StoreListAdapter
import com.httpdemo.zhulonglong.koitindemo.net.RetrifitService
import com.httpdemo.zhulonglong.koitindemo.net.StoreApi
import kotlinx.android.synthetic.main.fragment_store_gate.*
import org.jetbrains.anko.support.v4.*
import retrofit2.Retrofit
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

import org.jetbrains.anko.toast
import timber.log.Timber

/**
 * 干货列表
 * Created by zhulonglong on 2017/1/8.
 */
class StoreGateFragment():Fragment(){
    companion object{
        val TITLE:String = "StoreGateFragment:title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_store_gate,container!!,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        store_list.layoutManager = LinearLayoutManager(context)
//        store_list.adapter =
//        store_list.adapter =
        RetrifitService()
                .retrofit
                .create(StoreApi::class.java)
                .requestStoreAndroid(10,1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    if (!it.error){
                        Timber.i("size is ${it.results.size}")
                        store_list.adapter = StoreListAdapter(it.results){toast("On click ${it.desc}")}
                    }
                },{it.printStackTrace()})
    }

}
