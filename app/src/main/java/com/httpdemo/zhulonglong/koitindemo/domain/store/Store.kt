package com.httpdemo.zhulonglong.koitindemo.domain.store

/**
 * 干货-条目
 * Created by zhulonglong on 2017/1/8.
 */
data class Store(val _id:String , val createdAt:String ,
                 val desc:String , val publishedAt:String ,
                 val source:String, val type:String,
                 val url:String , val used:Boolean,
                 val who:String)