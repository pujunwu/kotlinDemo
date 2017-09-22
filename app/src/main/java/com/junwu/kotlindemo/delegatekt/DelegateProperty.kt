package com.junwu.kotlindemo.delegatekt

import kotlin.reflect.KProperty

/**
 * ===============================
 * 描    述：代理属性
 * 作    者：pjw
 * 创建日期：2017/9/22 9:24
 * ===============================
 */
class DelegateProperty {

    operator fun getValue(hisRef: Any?, property: KProperty<*>): String {
        if (property.name == null || property.name.isEmpty()) {
            return "$hisRef, 这是一个代理属性实现getValue： '${property.name}' to me!"
        } else {
            return property.name
        }
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef, 这是一个代理属性实现setValue： '${property.name}'")
    }

}