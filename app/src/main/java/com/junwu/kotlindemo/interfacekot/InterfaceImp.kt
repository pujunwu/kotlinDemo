package com.junwu.kotlindemo.interfacekot

/**
 * ===============================
 * 描    述：kotlin接口实现
 * 作    者：pjw
 * 创建日期：2017/9/20 14:35
 * ===============================
 */
class InterfaceImp : InterfaceDef, InterfaceDef1 {

    override val property: Int
        get() = 1

    /**
     * 解决重写冲突：重新实现该方法
     * 可以只调用其中一个，也可以两个都调用，也可以一个都不调用
     */
    override fun foo() {
//        super<InterfaceDef>.foo()
//        super<InterfaceDef1>.foo()
    }

    /**
     * 正常的实现接口方法
     */
    override fun bar() {

    }

    /**
     * 正常的实现接口方法
     */
    override fun funA(intArray: IntArray) {
        println("常见循环：")
        for (i in intArray) {
            println("打印item:$i")
        }
        println("indices循环：")
        for (i in intArray.indices) {
            println("打印item index:$i value:${intArray[i]}")
        }
        println("withIndex循环：")
        for ((i, value) in intArray.withIndex()) {
            println("打印item index:$i value:$value")
        }
    }

    fun getStr(): String {
        return name
    }

}