package com.junwu.kotlindemo

import android.app.Application
import com.junwu.kotlindemo.daggerkt.AppComponent
import com.junwu.kotlindemo.daggerkt.AppModule
import com.junwu.kotlindemo.daggerkt.DaggerAppComponent

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 14:01
 * ===============================
 */
class AppKot : Application() {

    companion object {
        var appkot: AppKot? = null
    }

    val component: AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    override fun onCreate() {
        super.onCreate()
        appkot = this@AppKot
        component.inject(this)
    }

}