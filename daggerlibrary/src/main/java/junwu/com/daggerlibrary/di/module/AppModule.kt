package junwu.com.daggerlibrary.di.module

import android.app.Activity
import android.app.Application
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
 * 创建日期：2017/9/28 16:03
 * ===============================
 */
@Module
class AppModule(application: Application) {

    val applicationa = application

    @Provides
    @ViewScope
    fun provideApplication(): Application = applicationa


    /****************************************OKHttpClient **********************************/
    //请求超时时间
    private val TIME_OUT = 30L

    @Singleton
    @Provides
    fun providerOkHttpBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    @Singleton
    @Provides
    fun providerOkHttpClient(builder: OkHttpClient.Builder/*, configuration: ConfigModule.OkHttpConfiguration*/): OkHttpClient {
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
//        configuration.configOkhttp(builder)
        return builder.build()
    }

}