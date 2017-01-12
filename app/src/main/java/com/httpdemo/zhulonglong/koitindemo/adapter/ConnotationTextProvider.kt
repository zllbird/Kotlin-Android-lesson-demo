package com.httpdemo.zhulonglong.koitindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.httpdemo.zhulonglong.koitindemo.R
import com.httpdemo.zhulonglong.koitindemo.domain.connotation.Conotation
import me.drakeet.multitype.ItemViewProvider

/**
 *
 * Created by zhulonglong on 2017/1/12.
 */
class ConnotationTextProvider():ItemViewProvider<Conotation,ConnotationTextProvider.ViewHolder>(){

    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_forecast,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, t: Conotation) {
        holder.bindViewByConnotation(t)
    }

    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        fun bindViewByConnotation(conotation: Conotation) = with(conotation){
            //
        }
    }
}
