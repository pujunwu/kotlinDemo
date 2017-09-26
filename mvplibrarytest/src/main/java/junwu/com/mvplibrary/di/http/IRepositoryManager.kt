package junwu.com.mvplibrary.di.http

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 18:03
 * ===============================
 */
interface IRepositoryManager {

    /**
     * 注入RetrofitService,在[com.junwu.mvplibrary.config.IRegisterApiModule.registerComponents]中进行注入
     */
    fun injectRetrofitService(vararg services: Class<*>)

    /**
     * 注入CacheService,在[com.junwu.mvplibrary.config.IRegisterApiModule.registerComponents]中进行注入
     */
    fun injectCacheService(vararg services: Class<*>)

    /**
     * 根据传入的Class获取对应的Retrofit service
     */
    fun <T> obtainRetrofitService(service: Class<T>): T

    /**
     * 根据传入的Class获取对应的RxCache service
     */
    fun <T> obtainCacheService(cache: Class<T>): T

    /**
     * 销毁方法
     */
    fun onTerminate()

}