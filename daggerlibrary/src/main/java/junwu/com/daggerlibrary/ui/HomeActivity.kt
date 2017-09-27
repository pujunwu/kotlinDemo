package junwu.com.daggerlibrary.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.junwu.mvplibrary.ui.activitys.home.HomeModel
import com.junwu.mvplibrary.ui.activitys.home.HomeModule
import junwu.com.daggerlibrary.R
import junwu.com.daggerlibrary.di.component.DaggerHomeComponent
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/27 16:37
 * ===============================
 */
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var homeModel: HomeModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        DaggerHomeComponent.builder().homeModule(HomeModule()).build().inject(this)
        tvTest.setOnClickListener {
            val c = it as? TextView
            if (c != null) {
                c.setText("sfdsfds")
            }
            println(homeModel.toString())
        }
    }

}
