package com.junwu.kotlindemo.interfacekot

/**
 * ===============================
 * 描    述：kotlin类定义
 * 作    者：pjw
 * 创建日期：2017/9/20 11:53
 * ===============================
 */
class ClassDef {

//    访问修饰符，可以修饰类、接口、方法、属性
//    public：默认修饰符，被其修饰的在任何位置都能访问
//    private：只能在当前源文件内使用
//    internal：在同一模块内使用
//    protected：无效修饰符，只用于类和接口内
//    接口方法只能用public修饰

    public fun publicFun() {
        //当前方法所有地方可见，即默认修饰符
    }

    private fun privateFun() {
        //当前类可见，其他任何外部类和模块都不可见
    }

    internal fun InternalFun() {
        //当前Module(模块)可见，其他任何模块都不可见
    }

    protected fun protectedFun() {
        //当前类和继承当前类可见，其他的都不可见
    }

}