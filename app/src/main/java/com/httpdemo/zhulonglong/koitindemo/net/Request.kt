package com.httpdemo.zhulonglong.koitindemo.net

import android.util.Log
import java.net.URL

/**
 *  Request
 * Created by zhulonglong on 2017/1/6.
 */
public class Request(val url:String){

    public fun run(){
        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName,forecastJsonStr)
    }

}