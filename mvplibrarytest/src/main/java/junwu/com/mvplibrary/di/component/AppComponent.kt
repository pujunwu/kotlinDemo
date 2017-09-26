package junwu.com.mvplibrary.di.component

import android.app.Application
import dagger.Component
import io.rx_cache2.internal.RxCache
import junwu.com.mvplibrary.delegate.AppDelegate
import junwu.com.mvplibrary.di.entitys.RxCacheBuilderEntity
import junwu.com.mvplibrary.di.http.IRepositoryManager
import junwu.com.mvplibrary.di.module.AppModule
import junwu.com.mvplibrary.di.module.ClientHttpModule
import junwu.com.mvplibrary.di.module.ConfigModule
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 15:23
 * ===============================
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ClientHttpModule::class, ConfigModule::class))
interface AppComponent {

    /**
     * 注入
     *
     * @param delegate AppDelegate
     */
    fun inject(delegate: AppDelegate)

    /**
     * 获取当前application对象
     *
     * @return Application
     */
    fun getApplication(): Application

    /**
     * 获取OkHttpClient
     */
    fun getOkHttp(): OkHttpClient

    /**
     * 获取Retrofit
     */
    fun getRetrofit(): Retrofit

    /**
     * 获取RxCache
     */
    fun getRxCache(): RxCache

    /**
     * 获取RxCacheBuild对应的实体
     */
    fun getRxCacheBuilderEntity(): RxCacheBuilderEntity

    /**
     * 获取IRepositoryManager
     */
    fun getIRepositoryManager(): IRepositoryManager


}