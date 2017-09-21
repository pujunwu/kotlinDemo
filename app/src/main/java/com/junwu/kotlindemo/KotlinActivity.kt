package com.junwu.kotlindemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.junwu.kotlindemo.abstractkot.AbstractImp
import com.junwu.kotlindemo.getsetkot.GetSetKot
import com.junwu.kotlindemo.interfacekot.InterfaceImp

import kotlinx.android.synthetic.main.activity_kotlin.*

/**
 * kotlin基本语法测试
 */
class KotlinActivity : AppCompatActivity(), View.OnClickListener {

    private val interfaceImp = InterfaceImp()
    private val abstractImp = AbstractImp(15)
    private val getSetKot = GetSetKot(5)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        tvInterface.setOnClickListener(this)
        tvAbstract.setOnClickListener(this)
        tvBC.setOnClickListener(this)
        tvGetSet.setOnClickListener(this)
    }

    fun onKotlinListener(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View?) {
        if (v == null) {
            return
        }
        when (v.id) {
            R.id.tvInterface -> {
                Toast.makeText(this, "当前打印的是：" + interfaceImp.getStr(), Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "测试循环打印，看控制台", Toast.LENGTH_SHORT).show()
                interfaceImp.funA(intArrayOf(1, 2, 3, 4, 5))
            }
            R.id.tvAbstract -> {
                Toast.makeText(this, "当前打印的是：" + abstractImp.address, Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "测试循环打印，看控制台", Toast.LENGTH_SHORT).show()
                abstractImp.funExample1()
            }
            R.id.tvBC -> {
                Toast.makeText(this, "break 和 continue，看控制台", Toast.LENGTH_SHORT).show()
                abstractImp.funContinue()
                abstractImp.funBreak()
                getSetKot.address = "3223423e"
                Toast.makeText(this, "备用字段" + getSetKot.address, Toast.LENGTH_SHORT).show()
            }
            R.id.tvGetSet -> {
                getSetKot.address = null
                Toast.makeText(this, "备用字段为空打印结果:" + getSetKot.address, Toast.LENGTH_SHORT).show()
            }
            else -> {

            }
        }

    }

}
