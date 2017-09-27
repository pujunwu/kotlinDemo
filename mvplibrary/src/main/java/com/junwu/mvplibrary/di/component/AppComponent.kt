package com.junwu.mvplibrary.di.component

import android.app.Application
import com.junwu.mvplibrary.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/27 14:36
 * ===============================
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun getApplication(): Application

    /**
     * 注入
     *
     * @param application AppDelegate
     */
    fun inject(application: Application)

}