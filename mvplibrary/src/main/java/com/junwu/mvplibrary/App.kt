package com.junwu.mvplibrary

import android.app.Application
import com.junwu.mvplibrary.di.component.DaggerAppComponent
import com.junwu.mvplibrary.di.module.AppModule

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/27 15:19
 * ===============================
 */
class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()

    }




}