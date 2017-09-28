package com.junwu.mvplibrary.di.module

import android.app.Activity
import com.junwu.mvplibrary.di.scope.ViewScope
import com.junwu.mvplibrary.mvp.view.IView
import dagger.Module
import dagger.Provides

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/27 14:50
 * ===============================
 */
@Module
class ViewModule(activity: Activity? = null, iView: IView) {

    val ac = activity
    val view = iView

    @Provides
    @ViewScope
    fun provideActivity(): Activity? = ac

    @Provides
    @ViewScope
    fun provideIView(): IView = view

}
