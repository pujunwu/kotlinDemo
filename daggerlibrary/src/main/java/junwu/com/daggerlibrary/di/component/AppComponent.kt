package junwu.com.daggerlibrary.di.component

import dagger.Component
import junwu.com.daggerlibrary.di.module.AppModule

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/28 16:00
 * ===============================
 */
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

//    //需要将SubComponent 追加到 被依赖的Component中
//    fun plus(viewModule: ViewModule): HomeComponent

}