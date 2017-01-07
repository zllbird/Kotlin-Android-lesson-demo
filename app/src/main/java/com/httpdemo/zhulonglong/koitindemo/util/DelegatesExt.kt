package com.httpdemo.zhulonglong.koitindemo.util

import kotlin.properties.ReadWriteProperty

/**
 * Ext
 * Created by zhulonglong on 2017/1/7.
 */
object DelegatesExt{
    fun <T> notNullSingleValue() : ReadWriteProperty<Any?, T> = NotNullSingleValueVar<T>()
}
