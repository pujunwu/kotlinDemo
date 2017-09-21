package com.junwu.kotlindemo.abstractkot

/**
 * ===============================
 * 描    述：kotlin抽象类的定义
 * 作    者：pjw
 * 创建日期：2017/9/20 15:36
 * ===============================
 */
abstract class AbstractDef(countC: Int) {

    var count: Int = countC

    /**
     * 抽象类中的抽象属性
     * 抽象属相在抽象类中不能被初始化
     *  在子类没有主构造函数，要对抽象属性，手动初始化。
     *  如果子类中有主构造函数，抽象属性可以在主构造函数中声明
     */
    abstract var addr: String

    /**
     * 抽象类中的抽象方法
     */
    abstract fun funAbstract()

    /**
     * 抽象类中的实例方法
     */
    fun funExample() {
        println("$count 打击次数")
    }

}