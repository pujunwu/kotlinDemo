package com.junwu.kotlindemo.rangeskt

/**
 * ===============================
 * 描    述：range表达式
 * 作    者：pjw
 * 创建日期：2017/9/22 14:32
 * ===============================
 */
class RangesKot {

    fun rangesTest() {
        funRanges(10)
        funRanges(13)
        funRanges(1)
        for (i in 1..4) println(i)
        for (i in 4 downTo 1) println(i)
        for (i in 4 downTo 1 step 2) println(i)
//        //左闭右开区间，合法值包括11，但不包括66
//        for (i in 11 until 66) { ... }
//        // 每次默认递增1，这里改为每次递增4
//        for (i in 23..89 step 4) { ... }
//        // for循环默认递增，这里使用downTo表示递减
//        for (i in 50 downTo 7) { ... }

        funRangesStr("island")
        funRangesStr("isle")
        funRangesStr("is le")

        //更多说明：https://huanglizhuo.gitbooks.io/kotlin-in-chinese/content/Other/Ranges.html
    }

    private fun funRanges(i: Int = 0) {
        if (i in 1..10) {
            println("i:$i 在1-10之间")
        } else {
            println("i:$i 不在1-10之间")
        }
    }

    private fun funRangesStr(i: String = "") {
        if (i in "island".."isle") {
            println("i:$i 在island到isle之间")
        } else {
            println("i:$i 不在island到isle之间")
        }
    }

}