package com.junwu.kotlindemo.delegatekt

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/22 9:01
 * ===============================
 */
class DelegateInterfaceImp(val srt: String) : DelegateInterfaceKot {

    override fun print() {
        printz(srt)
    }

    fun printz(strx: String) {
        println("打印的结果：$strx")
    }

    //代理属性
    var p: String by DelegateProperty()


    /************************************延迟属性*********************************/
    var j = 3 + 5
    //lazy() 是一个接受 lamdba 并返回一个实现延迟属性的代理：第一次调用 get() 执行 lamdba 并传递 lazy() 并存储结果，以后每次调用 get() 时只是简单返回之前存储的值
    //只有第一次初始化时才执行lazy{}后面的代码块，以后的get操作都只是返回lazyValue的值，并不会执行lazy{}后面的代码块
    val lazyValue: String by lazy {
        j += +5
        "Hello!$j"
    }

    //默认情况下延迟属性的计算是同步的：该值的计算只在一个线程里，其他所有线程都将读取同样的值。
    // 如果代理不需要同步初始化，而且允许出现多线程同时执行该操作，可以传 LazyThreadSafetyMode.PUBLICATION 参数给 lazy() 。
    // 如果你确信初始化只会在单线程中出现，那么可以使用 LazyThreadSafetyMode.NONE 该模式不会提供任何线程安全相关的保障。
    val lazyValue2: String by lazy(LazyThreadSafetyMode.PUBLICATION) {
        j += +5
        "Hello!$j"
    }

    /************************************可观察属性*********************************/
    //Delegates.observable() 需要两个参数：一个初始值和一个用于修改的 handler 。
    // 每次我们给属性赋值时都会调用handler (在初始赋值操作后)。它有三个参数：一个将被赋值的属性，旧值，新值
    var name: String by Delegates.observable("初始值") { prop, old, new ->
        println("$old -> $new")
    }

    //如果你想能够打断赋值并取消它，用 vetoable()代替 observable() 。传递给vetoable 的 handler 会在赋新值之前调用
    var name2: String by Delegates.vetoable("初始值") { prop, old, new ->
        if (new.equals("123")) true else false
    }

    /************************************Map 中存储属性*********************************/

    //属性可以用 MutableMap 代替只读的 Map
    var user: MutableMap<String, Any?>? = null


    /************************************属性代理总结*********************************/
    /*只读属性 (val)，代理必须提供一个名字叫 getValue 的函数并接受如下参数：
    thisRef接收者--必须是属性拥有者是同一种类型，或者是其父类
    property 必须是 KProperty<*> 或这它的父类
    这个函数必须返回同样的类型或子类作为属性。
    可变属性 (var)，代理必须添加一个叫 setValue 的函数并接受如下参数：
    thisRef与 getValue() 一样
    property 与 getValue() 一样 新值--必须和属性类型一致或是它的父类
    getValue() 和 setValue() 函数必须作为代理类的成员函数或者扩展函数。扩展函数对与想要对对象代理原本没有的函数是十分有用。两种 函数必须标记 operator 关键字。
    代理类可能实现 ReadOnlyProperty 和 ReadWriteProperty 中的一个并要求带有 operator 方法。这些接口在 Kotlin 标准库中有声明：
    interface ReadOnlyProperty<in R, out T> {
        operator fun getValue(thisRef: R, property: KProperty<*>): T
    }
    interface ReadWriteProperty<in R, T> {
        operator fun getValue(thisRef: R, property: KProperty<*>): T
        operator fun setValue(thisRef: R, property: KProperty<*>, value: T)
    }
     */

}
