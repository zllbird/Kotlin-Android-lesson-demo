package com.httpdemo.zhulonglong.koitindemo

import android.app.Application
import android.database.sqlite.SQLiteOpenHelper
import com.httpdemo.zhulonglong.koitindemo.util.DelegatesExt
import timber.log.Timber
import kotlin.properties.Delegates

/**
 * 蛋例
 * Created by zhulonglong on 2017/1/6.
 */
class App : Application() {
    companion object{
//        private var instance:App by Delegates.notNull<App>()
        private var instance :App by DelegatesExt.notNullSingleValue<App>()
        fun instance() = instance
    }

//    val database: SQLiteOpenHelper by lazy {
//        //code
//    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        Timber.plant(Timber.DebugTree())
    }

}
