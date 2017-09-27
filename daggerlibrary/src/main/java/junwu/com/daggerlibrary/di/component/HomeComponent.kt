package junwu.com.daggerlibrary.di.component

import com.junwu.mvplibrary.di.module.ViewModule
import com.junwu.mvplibrary.di.scope.ViewScope
import com.junwu.mvplibrary.ui.activitys.home.HomeModule
import dagger.Component
import junwu.com.daggerlibrary.ui.HomeActivity

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/27 16:35
 * ===============================
 */
@ViewScope
@Component(modules = arrayOf(ViewModule::class, HomeModule::class))
interface HomeComponent {

    fun inject(homeActivity: HomeActivity)

}