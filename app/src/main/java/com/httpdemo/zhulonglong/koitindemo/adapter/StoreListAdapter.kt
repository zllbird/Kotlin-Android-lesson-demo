package com.httpdemo.zhulonglong.koitindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.httpdemo.zhulonglong.koitindemo.R
import com.httpdemo.zhulonglong.koitindemo.domain.store.Store
import kotlinx.android.synthetic.main.item_store.view.*
import kotlinx.android.synthetic.main.item_store.*
import timber.log.Timber

/**
 * 干货-适配器
 * Created by zhulonglong on 2017/1/8.
 */
class StoreListAdapter(val stores:List<Store>,val onItemClick: (Store) -> Unit):RecyclerView.Adapter<StoreListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_store,parent,false),onItemClick)
    }
    override fun getItemCount():Int = stores.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewByStore(stores[position])
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int, payloads: MutableList<Any>?) {
        super.onBindViewHolder(holder, position, payloads)
    }

    class ViewHolder(val view: View,val onItemClick: (Store) -> Unit):RecyclerView.ViewHolder(view){
        fun bindViewByStore(store:Store) = with(store){
            view.store_id.text = _id
            view.store_desc.text = desc
            view.store_type.text = type
            view.setOnClickListener { onItemClick(store) }
        }
    }
}
