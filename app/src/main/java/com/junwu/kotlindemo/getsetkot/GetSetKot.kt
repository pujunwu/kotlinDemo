package com.junwu.kotlindemo.getsetkot

/**
 * ===============================
 * 描    述：属性和字段
 * 作    者：pjw
 * 创建日期：2017/9/20 17:14
 * ===============================
 */
class GetSetKot(age: Int) {

    //初始化代码块
    init {
        println("传入的age:$age")
    }

    //备用字段，自定义访问器
    //初始化值会直接写入备用字段
    //field 关键词只能用于属性的访问器
    var address: String? = null
    set(value) {
        when (value != null) {
            true -> field = value
            false -> field = "11111111"
        }
    }
    get() {
        if (field == null) {
            return "11111111"
        }
        return field
    }

    //编译器会检查访问器的代码,如果使用了备用字段(或者访问器是默认的实现逻辑)，就会自动生成备用字段,否则就不会
    //只读属性，默认实现getter方法
    //编译器不会生成备用字段
    val nominalAge = age + 1

    //属性定义,可读可写，默认实现getter和setter方法
    //编译器会自动生成默认访问器，这时就会自动生成备用字段
    var name: String = ""

    //备用属性
    //如果你想要做一些事情但不适合这种 "隐含备用字段" 方案，你可以试着用备用属性的方式
    private var _table: Map<String, Int>? = null
    public val table: Map<String, Int>
    get() {
        if (_table == null)
            _table = HashMap() //参数类型是推导出来的
        return _table ?: throw AssertionError("Set to null by another thread")
    }

    //延迟初始化属性

}
