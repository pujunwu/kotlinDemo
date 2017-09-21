package com.junwu.kotlindemo.interfacekot

/**
 * ===============================
 * 描    述：kotlin接口定义1
 * 作    者：pjw
 * 创建日期：2017/9/20 14:33
 * ===============================
 */
interface InterfaceDef1 {

    /**
     * 没有默认函数体方法
     */
    fun funA(intArray: IntArray)

    /**
     * 有函数体的接口方法
     * 函数体是可选的
     */
    fun foo() {

    }

}