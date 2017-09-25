package com.junwu.kotlindemo.thiskt

/**
 * ===============================
 * 描    述：This 表达式
 * 作    者：pjw
 * 创建日期：2017/9/22 15:38
 * ===============================
 */
class ThisKot {
    inner class B { // implicit label @B
        fun Int.foo() { // implicit label @foo
            val a = this@ThisKot // A's this
            val b = this@B // B's this

            val c = this // foo()'s receiver, an Int
            val c1 = this@foo // foo()'s receiver, an Int

//            val funLit = @lambda {
//                String.() ->
//                val d = this // funLit's receiver
//                val d1 = this@lambda // funLit's receiver
//            }
//            val funLit2 = { (s: String) ->
//                // foo()'s receiver, since enclosing function literal
//                // doesn't have any receiver
//                val d1 = this
//            }
        }
    }

//    更多说明：https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/Other/This-Expression.html


    /***********************************相等*****************************************/
    //    参照相等是通过 === 操作符判断的(不等是!== ) a===b 只有 a b 指向同一个对象是判别才成立。
//    另外，你可以使用内联函数 identityEquals() 判断参照相等
    private fun funEqual(a: Any, b: Any) {
        a.equals(b)
    }
//    结构相等是通过 == 判断的。像 a == b 将会翻译成：
//    a?.equals(b) ?: b === null
//    如果 a 不是 null 则调用 equals(Any?) 函数，否则检查 b 是否参照等于 null
//    注意完全没有必要为优化你的代码而将 a == null 写成 a === null 编译器会自动帮你做的。
//    更多说明：https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/Other/Equality.html

//    运算符重载，代码和编译器编译后
//    更多说明：https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/Other/Opetator-overloading.html

//    空安全
//    第三个选择是 NPE-lovers。我们可以用 b!! ，这会返回一个非空的 b 或者抛出一个 b 为空的 NPE
//    更多说明：https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/Other/Null-Safety.html

//    异常
//    更多说明：https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/Other/Exceptions.html

//    注解
//    更多说明：https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/Other/Annotations.html

//    反射
//    更多说明：https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/Other/Reflection.html

//    动态类型
//    更多说明：https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/Other/Dynamic-Type.html



}