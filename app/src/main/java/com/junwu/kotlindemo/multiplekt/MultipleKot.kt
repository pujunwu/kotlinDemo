package com.junwu.kotlindemo.multiplekt

/**
 * ===============================
 * 描    述：多重声明
 * 作    者：pjw
 * 创建日期：2017/9/22 13:51
 * ===============================
 */
class MultipleKot {

    /**
     * 多重声明测试类
     */
    fun testMultiple() {
        var personA: Person = Person("Door", 22, "ShanDong")
        var personB: Person = Person("Green", 30, "BeiJing")
        var personC: Person = Person("Dark", 23, "YunNan")
        var personD: Person = Person("Tool", 26, "GuanDong")
        var personE: Person = Person("Mark", 24, "TianJin")
        var pers = listOf(personA, personB, personC, personD, personE)
        for ((name, age, relName) in pers) {
            println("name: $name, age: $age,relName:$relName")
        }
        val person = Person("Jane", 20, "")
        val (name, age) = person
        println(name)   //  Jane
        println(age)    //  20
        val map = mutableMapOf(
                1 to personA,
                2 to personB,
                3 to personC,
                4 to personD,
                5 to personE
        )
        for ((key, value) in map) {
            val (name, age, relName) = value
            println("key: $key, value:$name,$age,$relName")
        }
    }

}