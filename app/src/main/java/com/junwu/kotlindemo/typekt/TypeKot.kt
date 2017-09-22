package com.junwu.kotlindemo.typekt

/**
 * ===============================
 * 描    述：类型检查和转换
 * 作    者：pjw
 * 创建日期：2017/9/22 15:00
 * ===============================
 */
class TypeKot {

    fun typeTest() {
        isTpye("123")
        isTpye(123)

        demo("123")
        demo(123)

        demo1("123")
        demo1(123)
        demo1(true)

        demo2("123")
        demo2(123)
        //“不安全”的转换符和
        var y: Any? = "2323"
        //注意 null 不能被转换为 String 因为它不是 nullable，也就是说如果 y 是空的，则上面的代码会抛出空异常
        println(y as String)
        //"安全"转换符
        //为了避免抛出异常，可以用 as? 这个安全转换符，这样失败就会返回 null
        //不管 as? 右边的是不是一个非空 String 结果都会转换为可空的。
        println(y as? String)

    }

    private fun isTpye(obj: Any?) {
        if (obj is String) {
            println("$obj,是字符串")
        }
        if (obj !is String) { // same as !(obj is String)
            println("$obj,不是字符串")
        }
    }

    /**
     * 智能转换
     * 判断如果是字符串类型，将自动转换为字符串类型
     * 编译器足够智能如何转换是安全的，如果不安全将会返回
     */
    private fun demo(x: Any) {
        if (x !is String) return
        println(x.length) //
    }

    private fun demo1(x: Any) {
        // X是自动转换到字符串的右边` | | `
        if (x !is String || x.length == 0) {
            println(x)
        }
        // x是自动投到字符串右边的'＆'。
        if (x is String && x.length > 0)
            println(x.length) // x被自动转换为字符串。
    }

    private fun demo2(x: Any) {
        when (x) {
            is Int -> println(x + 1)
            is String -> println(x.length + 1)
//            is Array<Int> -> print(x.sum())
        }
    }


}