package com.httpdemo.zhulonglong.koitindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.httpdemo.zhulonglong.koitindemo.net.GitHubUserRequest
import com.httpdemo.zhulonglong.koitindemo.R
import com.squareup.picasso.Picasso

import org.jetbrains.anko.*
import kotlinx.android.synthetic.main.item_forecast.view.*

/**
 *
 * Created by zhulonglong on 2017/1/5.
 */
class ForecastListAdapter(val items: List<GitHubUserRequest.GitHubUser>,
                          val onItemClickListener: (GitHubUserRequest.GitHubUser) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast,parent,false)
        return ViewHolder(view,onItemClickListener)
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindGitHubUser(items[position])
    }

    class ViewHolder(view: View, val onItemClickListener: (GitHubUserRequest.GitHubUser) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindGitHubUser(gitHubUser: GitHubUserRequest.GitHubUser){
            with(gitHubUser){
                Picasso.with(itemView.context).load(avatar_url).into(itemView.icon)
                itemView.description.text = html_url
                itemView.maxTemperature.text = "$score"
                itemView.setOnClickListener { onItemClickListener(gitHubUser) }
            }
        }
    }
}
