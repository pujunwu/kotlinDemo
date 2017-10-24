<div class="span6 preview" style="max-height: 647px; min-height: 647px;"><h1 class="title mousetrap">kotlinDemo</h1><div class="content mousetrap"><p>纯粹是个人学习总结，如有不对的地方请吐槽。</p>
<h3>kotlin学习笔记</h3>
<h4>demo类</h4>
<code>package com.junwu.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.junwu.kotlindemo.abstractkot.AbstractImp
import com.junwu.kotlindemo.classkot.TestClassKot
import com.junwu.kotlindemo.delegatekt.DelegateTest
import com.junwu.kotlindemo.getsetkot.GetSetKot
import com.junwu.kotlindemo.interfacekot.InterfaceImp
import com.junwu.kotlindemo.multiplekt.MultipleKot
import com.junwu.kotlindemo.rangeskt.RangesKot
import com.junwu.kotlindemo.singletonkt.SingletonKot
import com.junwu.kotlindemo.singletonkt.SingletonParKot
import com.junwu.kotlindemo.typekt.TypeKot
import kotlinx.android.synthetic.main.activity_kotlin.*

/**
 * kotlin基本语法测试
 */
class KotlinActivity : AppCompatActivity(), View.OnClickListener {

    private val interfaceImp = InterfaceImp()
    private val abstractImp = AbstractImp(15)
    private val getSetKot = GetSetKot(5)
    private var singletonParKot: SingletonParKot = SingletonParKot.getInstance("初始化传入的参数")

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_kotlin)
    tvNested.setOnClickListener {
        showMessage("嵌套类测试，查看控制台")
        TestClassKot(llRootView).funNested()
        showMessage((it as TextView).text.toString())
    }
    tvDelegate.setOnClickListener {
        showMessage("${(it as TextView).text}，查看控制台")
        DelegateTest().testDelegat()
    }
    setViewOnClickListener(arrayOf(
        tvInterface, tvAbstract,
        tvBC, tvGetSet, tvSingleton,
        tvMultiple, tvRanges, tvType
    ))
    }

    fun onKotlinListener(view: View) {
    startActivity(Intent(this, MainActivity::class.java))
    }

    /**
     * 设置点击事件
     */
    private fun setViewOnClickListener(args: Array&lt;View&gt;) {
    for (tv in args) {
        tv.setOnClickListener(this)
    }
    }

    override fun onClick(v: View?) {
    if (v == null) {
        return
    }
    when (v.id) {
        R.id.tvInterface -&gt; {
            showMessage("当前打印的是：" + interfaceImp.getStr())
            showMessage("测试循环打印，看控制台")
            interfaceImp.funA(intArrayOf(1, 2, 3, 4, 5))
        }
        R.id.tvAbstract -&gt; {
            showMessage("当前打印的是：" + abstractImp.address)
            showMessage("测试循环打印，看控制台")
            abstractImp.funExample1()
        }
        R.id.tvBC -&gt; {
            showMessage("break 和 continue，看控制台")
            abstractImp.funContinue()
            abstractImp.funBreak()
            getSetKot.address = "3223423e"
            showMessage("备用字段" + getSetKot.address)
        }
        R.id.tvGetSet -&gt; {
            getSetKot.address = null
            showMessage("备用字段为空打印结果:" + getSetKot.address)
        }
        R.id.tvSingleton -&gt; {
            showMessage("单例改变前的值：" + SingletonKot.INSTANCE.b)
            SingletonKot.INSTANCE.b = "改变后的值"
            showMessage("单例改变后的值：" + SingletonKot.INSTANCE.b)
            showMessage("初始化传入的参数：" + singletonParKot.paramStr)
            singletonParKot.paramStr = "重新传入的参数"
            showMessage("参数2：" + singletonParKot.paramStr)
        }
        R.id.tvMultiple -&gt; {
            showMessage("多重声明，查看控制台：")
            MultipleKot().testMultiple()
        }
        R.id.tvRanges -&gt; {
            showMessage("Ranges表达式测试，查看控制台：")
            RangesKot().rangesTest()
        }
        R.id.tvType -&gt; {
            showMessage("类型检查和转换，查看控制台：")
            TypeKot().typeTest()
        }
        else -&gt; {

        }
    }
    }

    fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}
</code>
</div></div>
