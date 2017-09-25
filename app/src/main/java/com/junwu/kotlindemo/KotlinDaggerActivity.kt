package com.junwu.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import javax.inject.Inject

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 14:08
 * ===============================
 */
class KotlinDaggerActivity : AppCompatActivity() {

    @Inject
    lateinit var app: AppKot

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var appKot = AppKot.appkot
        if (appKot != null)
            appKot.component.inject(this)

        showMessage(app.toString())
    }

    fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}