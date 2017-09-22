package com.junwu.kotlindemo.multiplekt

/**
 * ===============================
 * 描    述：多重声明
 * 作    者：pjw
 * 创建日期：2017/9/22 13:55
 * ===============================
 */
class Person(val name: String, val age: Int, val relName: String) {
    /**
     * 多重声明
     * 方法前必须要加上operator关键字
     */
    operator fun component1(): String {
        return name
    }

    operator fun component2(): Int {
        return age
    }

    operator fun component3(): String {
        return relName
    }

}