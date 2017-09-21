package com.junwu.kotlindemo.classkot

import android.widget.TextView

/**
 * ===============================
 * 描    述：测试嵌套类
 * 作    者：pjw
 * 创建日期：2017/9/21 14:07
 * ===============================
 */
class TestClassKot(text: TextView) {

    private var textView = text

    fun funNested() {
        //嵌套类
        println(ClassKot.Nested().foo())//打印：2
        //嵌套内部类
        println(ClassKot(textView).Inner().foo())//打印：1
        //匿名内部类
        ClassKot(textView).setListener()
    }

}