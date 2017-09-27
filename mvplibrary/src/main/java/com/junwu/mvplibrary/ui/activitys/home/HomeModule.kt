package com.junwu.mvplibrary.ui.activitys.home

import com.junwu.mvplibrary.di.scope.ViewScope
import dagger.Module
import dagger.Provides

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/27 15:11
 * ===============================
 */
@Module
class HomeModule {

    @ViewScope
    @Provides
    fun provideHomeModel(): HomeModule = HomeModule()

}