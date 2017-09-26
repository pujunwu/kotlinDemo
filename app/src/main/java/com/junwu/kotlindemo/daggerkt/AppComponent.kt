package com.junwu.kotlindemo.daggerkt

import com.junwu.kotlindemo.AppKot
import com.junwu.kotlindemo.KotlinDaggerActivity
import com.junwu.kotlindemo.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 14:02
 * ===============================
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: AppKot)

    fun inject(activity: KotlinDaggerActivity)

    fun inject(activity: MainActivity)

}
