package junwu.com.mvplibrary.di.module

import dagger.Module
import dagger.Provides
import io.rx_cache2.internal.RxCache
import io.victoralbertos.jolyglot.GsonSpeaker
import junwu.com.mvplibrary.di.entitys.RxCacheBuilderEntity
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 15:27
 * ===============================
 */
@Module
class ClientHttpModule {

    //请求超时时间
    private val TIME_OUT = 30L

    /****************************************OKHttpClient */
    @Singleton
    @Provides
    internal fun providerOkHttpClient(builder: OkHttpClient.Builder, configuration: ConfigModule.OkHttpConfiguration): OkHttpClient {
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        configuration.configOkhttp(builder)
        return builder.build()
    }

    @Singleton
    @Provides
    internal fun providerOkHttpBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
    }

    /****************************************Retrofit */
    @Singleton
    @Provides
    internal fun providerRetrofit(builder: Retrofit.Builder, okHttpClient: OkHttpClient, httpUrl: HttpUrl, configuration: ConfigModule.RetrofitConfiguration): Retrofit {
        builder.baseUrl(httpUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用rxjava
                .addConverterFactory(GsonConverterFactory.create())//使用Gson
        configuration.configRetrofit(builder)
        return builder.build()
    }

    @Singleton
    @Provides
    internal fun providerRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
    }

    @Singleton
    @Provides
    internal fun providerRxCache(builder: RxCache.Builder, @Named("RxCacheDirectory") cacheDirectory: File, rxCacheBuilder: RxCacheBuilderEntity, cacheConfiguration: ConfigModule.RxCacheConfiguration): RxCache {
        builder.setMaxMBPersistenceCache(100)//最大缓存
        cacheConfiguration.configRxCache(builder)
        rxCacheBuilder.cacheFolder = cacheDirectory.absolutePath
        return builder.persistence(cacheDirectory, GsonSpeaker())//设置缓存目录
    }

    @Singleton
    @Provides
    internal fun providerRxcacheBuilder(): RxCache.Builder {
        return RxCache.Builder()
    }

    @Singleton
    @Provides
    internal fun providerRxCacheBuilderEntity(): RxCacheBuilderEntity {
        return RxCacheBuilderEntity()
    }

    /****************************************IRepositoryManager */

//    @Singleton
//    @Provides
//    internal fun providerRepositoryManager(manager: RepositoryManager): IRepositoryManager {
//        return manager
//    }

}