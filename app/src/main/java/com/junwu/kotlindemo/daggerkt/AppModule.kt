package com.junwu.kotlindemo.daggerkt

import com.junwu.kotlindemo.AppKot
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 14:03
 * ===============================
 */
@Module
class AppModule(val app: AppKot) {

    @Provides
    @Singleton
    fun provideApp() = app

}