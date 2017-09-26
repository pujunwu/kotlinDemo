package junwu.com.mvplibrary.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 15:26
 * ===============================
 */
@Module
class AppModule(application: Application) {

    private val mApplication: Application = application

    @Singleton
    @Provides
    fun providerApplication(): Application {
        return mApplication
    }

}