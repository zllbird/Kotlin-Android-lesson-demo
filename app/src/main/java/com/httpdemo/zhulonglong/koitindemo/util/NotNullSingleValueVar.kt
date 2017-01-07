package com.httpdemo.zhulonglong.koitindemo.util

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 自定义 委托
 * Created by zhulonglong on 2017/1/6.
 */
class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {

    private var value : T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("not init")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if (this.value == null) value else throw IllegalStateException("it has ben init")
    }

}

