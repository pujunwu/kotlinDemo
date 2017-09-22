package com.junwu.kotlindemo.delegatekt

/**
 * ===============================
 * 描    述：代理测试类
 * 作    者：pjw
 * 创建日期：2017/9/22 9:06
 * ===============================
 */
class DelegateTest {

    fun testDelegat() {
        //代理测试
        var delImp = DelegateInterfaceImp("打印的内容")
        DelegateKot(delImp).print()
        //代理属性
//        println(delImp.p)
//        delImp.p = "end"
//        println(delImp.p)
        //延迟属性
        println(delImp.lazyValue)
        println(delImp.lazyValue)
        //可观察属性
        delImp.name = "123"
        delImp.name = "456"
        //可回滚观察属性
        delImp.name2 = "123"
        println(delImp.name2)
        delImp.name2 = "456"
        println(delImp.name2)
        //Map 中存储属性
        delImp.user = mutableMapOf(
                "name" to "John",
                "age" to 25
        )
        val d = delImp.user
        if (d == null || d.isEmpty()) {
            return
        }
        println("name:${d["name"]},age:${d["age"]}")
        d.forEach {
            println("key: ${it.key} , value: ${it.value}")
        }
    }

}
