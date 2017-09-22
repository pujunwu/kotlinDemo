package com.junwu.kotlindemo.singletonkt

/**
 * ===============================
 * 描    述：伴随对象
 * 作    者：pjw
 * 创建日期：2017/9/21 17:29
 * ===============================
 */
class MyClass {

    init {
        println("对象被创建了")
    }

    /**
     * 普通写法
     */
    companion object Factory {
        fun create(): MyClass = MyClass()
    }

//    /**
//     * 在使用了 companion 关键字时，伴随对象的名字可以省略
//     */
//    companion object {
//        fun create(): MyClass = MyClass()
//    }


}