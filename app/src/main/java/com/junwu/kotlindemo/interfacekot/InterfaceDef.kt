package com.junwu.kotlindemo.interfacekot

/**
 * ===============================
 * 描    述：kotlin接口定义
 * 作    者：pjw
 * 创建日期：2017/9/20 12:01
 * 因为接口没有状态， 所以中只允许有无状态的属性
 * ===============================
 */
interface InterfaceDef {

    /**
     * 接口的抽象属性
     * 给当前属性直接赋值或者有构造方法赋值至少有其一
     */
    val property: Int

    /**
     * 属性供访问器的实现
     * 这样子类可直接使用该字段
     */
    val name: String
        get() = "foo"

    /**
     * 没有默认函数体方法
     */
    fun bar()

    /**
     * 有函数体的接口方法
     * 函数体是可选的
     */
    fun foo() {

    }
}
