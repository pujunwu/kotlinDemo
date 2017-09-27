package com.junwu.mvplibrary.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/27 14:41
 * ===============================
 */
@Module
class AppModule(application: Application) {

    private val app = application

    @Provides
    @Singleton
    fun provideApplication(): Application = app

}