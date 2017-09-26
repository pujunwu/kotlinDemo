package junwu.com.mvplibrary.delegate

import android.app.Application
import junwu.com.mvplibrary.config.IConfigModule
import junwu.com.mvplibrary.config.IRegisterApiModule
import junwu.com.mvplibrary.delegate.impls.ActivityLifecycle
import junwu.com.mvplibrary.di.component.AppComponent
import junwu.com.mvplibrary.di.module.AppModule
import junwu.com.mvplibrary.di.module.ClientHttpModule
import junwu.com.mvplibrary.di.module.ConfigModule

/**
 * ===============================
 * 描    述：app代理类
 * 作    者：pjw
 * 创建日期：2017/9/25 16:09
 * ===============================
 */
class AppDelegate(application: Application) {

    val sAppDelegate: AppDelegate by lazy { this }

    private var mApplication: Application = application
    //Activity生命周期监听类
    private var mActivityLifecycle: ActivityLifecycle? = null
    private var mAppComponent: AppComponent? = null

    /**
     * 在application的onCreate方法中调用
     */
    fun onCreate() {
        mActivityLifecycle = ActivityLifecycle()
        mApplication!!.registerActivityLifecycleCallbacks(mActivityLifecycle)
    }

    /**
     * 初始化网络模块，包括了网络数据，本地缓存数据，以及其他数据
     * 建议在application的onCreate方法中调用
     *
     * @param configModules 配置ApiService和cacheApi接口
     */
    fun injectRegApiService(configModules: IConfigModule, vararg registerApiModules: IRegisterApiModule) {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(mApplication))//提供application
                .clientHttpModule(ClientHttpModule())//用于提供okhttp和retrofit的单例
                .configModule(getConfigModule(configModules))
                .build()

        mAppComponent?.inject(this)
        //调用注册apiService
        if (registerApiModules != null) {
            val manager = mAppComponent!!.getIRepositoryManager()
            for (module in registerApiModules) {
                module.registerComponents(manager)
            }
        }
    }

    /**
     * 销毁调用方法
     */
    fun onTerminate() {
        if (mActivityLifecycle != null) {
            mApplication!!.unregisterActivityLifecycleCallbacks(mActivityLifecycle)
        }
//        mAppComponent?.getIRepositoryManager().onTerminate()
        this.mActivityLifecycle = null
        this.mAppComponent = null
    }

    /**
     * 获取ConfigModule，并调用配置applyOptions方法
     */
    private fun getConfigModule(configModule: IConfigModule): ConfigModule {
        val builder = ConfigModule.builder()
        //调用之后OKHttp、retrofit、rxCache的基本配置信息就已经知道
        configModule.applyOptions(builder)
        return builder.build()
    }

    fun getAppComponent(): AppComponent? {
        return mAppComponent
    }
}