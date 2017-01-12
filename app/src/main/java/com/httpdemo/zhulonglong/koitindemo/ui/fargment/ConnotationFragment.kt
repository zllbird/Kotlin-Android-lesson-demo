package com.httpdemo.zhulonglong.koitindemo.ui.fargment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.httpdemo.zhulonglong.koitindemo.R
import com.httpdemo.zhulonglong.koitindemo.adapter.ConnotationTextProvider
import com.httpdemo.zhulonglong.koitindemo.adapter.ConotationImageProvider
import com.httpdemo.zhulonglong.koitindemo.domain.connotation.Conotation
import com.httpdemo.zhulonglong.koitindemo.domain.connotation.ConotationImage
import com.httpdemo.zhulonglong.koitindemo.domain.connotation.ConotationText
import kotlinx.android.synthetic.main.fragment_list.*
import me.drakeet.multitype.FlatTypeClassAdapter
import me.drakeet.multitype.MultiTypeAdapter
import java.util.*

/**
 * 内涵段子
 * Created by zhulonglong on 2017/1/12.
 */
class ConnotationFragment():Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list,container!!,false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.layoutManager = LinearLayoutManager(context)
        val items: List<Any> = ArrayList()
        val adapter: MultiTypeAdapter = MultiTypeAdapter(items)

        with(adapter){
            setFlatTypeAdapter(object:FlatTypeClassAdapter(){
                override fun onFlattenClass(item: Any): Class<*> {
                    return (item as Conotation).typeClass
                }
            })

            register(ConotationText::class.java,ConnotationTextProvider())
            register(ConotationImage::class.java,ConotationImageProvider())
        }

        list.adapter = adapter

    }



}