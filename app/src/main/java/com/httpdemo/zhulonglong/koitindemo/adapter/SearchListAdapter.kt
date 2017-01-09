package com.httpdemo.zhulonglong.koitindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.httpdemo.zhulonglong.koitindemo.R
import com.httpdemo.zhulonglong.koitindemo.domain.user.SearchRepoItem
import kotlinx.android.synthetic.main.item_search_repo.*
import kotlinx.android.synthetic.main.item_search_repo.view.*

import org.jetbrains.anko.*

/**
 * search result
 * Created by zhulonglong on 2017/1/8.
 */
class SearchListAdapter(val items:List<SearchRepoItem>,val onItemClick:(SearchRepoItem) -> Unit): RecyclerView.Adapter<SearchListAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_search_repo,parent,false)
        return ViewHolder(view,onItemClick)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindViewBySearchRepoItem(items[position],onItemClick)
    }

    class ViewHolder(val view: View,val onItemClick: (SearchRepoItem) -> Unit):RecyclerView.ViewHolder(view){
        fun bindViewBySearchRepoItem(searchRepoItem: SearchRepoItem, onItemClick: (SearchRepoItem) -> Unit) = with(searchRepoItem){
            view.repo_name.text = name
            view.repo_desc.text = description
            view.repo_stars.text = stargazers_count.toString()
            view.setOnClickListener { onItemClick(searchRepoItem) }
        }
    }
}
