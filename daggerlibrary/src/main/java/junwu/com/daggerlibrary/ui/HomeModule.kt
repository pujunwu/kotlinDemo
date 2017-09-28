package com.junwu.mvplibrary.ui.activitys.home

import com.junwu.mvplibrary.di.scope.ViewScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

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
    fun provideHomeModel(): HomeModel = HomeModel()

//    @ViewScope
//    @Provides
//    fun provideHomeModel(homeModel: HomeModel): HomeModel {
//        return homeModel
//    }

}