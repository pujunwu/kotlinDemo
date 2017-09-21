package com.junwu.kotlindemo.singleton

/**
 * ===============================
 * 描    述：有参数的单例
 * 作    者：pjw
 * 创建日期：2017/9/21 17:02
 * ===============================
 */
class SingletonParKot private constructor(ingName: String) {

    var paramStr: String = ingName

    init {
        println("这是一个有参数的单例：($this),参数：($ingName)")
    }

    companion object {
        @Volatile
        private var INSTANCE: SingletonParKot? = null
        fun getInstance(c: String): SingletonParKot {
            if (INSTANCE == null) {
                synchronized(SingletonParKot::class) {
                    if (INSTANCE == null) {
                        INSTANCE = SingletonParKot(c)
                    }
                }
            }
            return INSTANCE!!
        }
    }

}