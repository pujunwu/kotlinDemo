package com.junwu.kotlindemo.classkot

import android.util.Log
import android.view.View
import kotlin.properties.Delegates

/**
 * ===============================
 * 描    述：kotlin嵌套类
 * 作    者：pjw
 * 创建日期：2017/9/21 14:06
 * ===============================
 */
class ClassKot(text: View) {

//    对于非空类型的属性是必须初始化的。如果我们希望延迟进行初始化，就可以使用lateinit关键字了
//    lateinit只能在不可null的对象上使用，比须为var
//    private lateinit var mAdapter: RecyclerAdapter<Transaction>
//    并且 lateinit 不支持基础数据类型，比如 Int。对于基础数据类型，我们可以这样
//    private var mNumber: Int by Delegates.notNull<Int>()

    private val bar: Int = 1
    private var textView = text

    /**
     * 嵌套类
     * 没有外部类的对象引用
     * 不可以直接访问外部类的成员变量
     */
    class Nested {
        fun foo() = 2
    }

    /**
     * inner关键字修饰的是内部类
     * 内部类拥有外部类的一个对象引用
     * 这样就可以访问外部类的成员
     */
    inner class Inner {
        fun foo() = bar
    }

    /**
     * 匿名内部类
     */
    fun setListener() {
        //完整写法
        textView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d("test:", p0.toString())
            }
        })
        //简便写法
        textView.setOnClickListener {
            Log.d("test:", it.toString())
        }
    }


}