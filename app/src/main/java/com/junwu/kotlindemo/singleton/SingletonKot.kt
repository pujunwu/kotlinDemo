package com.junwu.kotlindemo.singleton

/**
 * ===============================
 * 描    述：Kotlin单例，无参数单例
 * 作    者：pjw
 * 创建日期：2017/9/21 16:56
 * ===============================
 */
class SingletonKot private constructor() {

    init {
        println("这是一个无参单例：($this)")
    }

    companion object {
        val INSTANCE: SingletonKot = SingletonKot()
    }

    var b: String? = null

}