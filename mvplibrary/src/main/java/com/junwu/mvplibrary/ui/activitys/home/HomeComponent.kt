package com.junwu.mvplibrary.ui.activitys.home

import com.junwu.mvplibrary.di.component.AppComponent
import com.junwu.mvplibrary.di.module.ViewModule
import com.junwu.mvplibrary.di.scope.ViewScope
import dagger.Component

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/27 15:09
 * ===============================
 */
@ViewScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ViewModule::class, HomeModule::class))
interface HomeComponent {

    fun inject(homeActivity: HomeActivity)

}