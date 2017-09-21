package com.junwu.kotlindemo.abstractkot

/**
 * ===============================
 * 描    述：kotlin抽象类的实现类
 * 作    者：pjw
 * 创建日期：2017/9/20 15:43
 * ===============================
 */
class AbstractImp(countC: Int) : AbstractDef(countC) {

    var address = "当前详细地址"

    /**
     * 父类的抽象属性的实现
     */
    override var addr: String
        get() = address
        set(value) {}

    /**
     * 实现抽象父类中的抽象方法
     */
    override fun funAbstract() {
        println("抽象父类的抽象方法的实现")
    }

    /**
     * 抽象类中的实例方法
     */
    fun funExample1() {
        super.funExample()
        for (i in 0..count) {
            println("当前第${i}次循环")
        }
//        // 左闭右开区间，合法值包括11，但不包括66
//        for (i in 11 until 66) { ... }
//        // 每次默认递增1，这里改为每次递增4
//        for (i in 23..89 step 4) { ... }
//        // for循环默认递增，这里使用downTo表示递减
//        for (i in 50 downTo 7) { ... }
    }

    /**
     * continue测试
     */
    fun funContinue() {
        //左闭右开区间，合法值包括11，但不包括66
        for (i in 11 until 66 step 1) {
            println("当前continue测试,第${i}次循环")
            if (i == count) {
                println("continue跳出去了")
                continue
            }
        }
    }

    /**
     * break测试
     */
    fun funBreak() {
        //循环从23到91 每次递增4 包括23也包括91
        //单循环不到91，在i==87的时候break停止了循环
        for (i in 23..91 step 4) {
            println("当前break测试,第${i}次循环")
            if (i == 87) {
                println("停止循环了")
                break
            }
        }
    }

}