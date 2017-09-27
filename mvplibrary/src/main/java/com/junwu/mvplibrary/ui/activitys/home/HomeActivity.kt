package com.junwu.mvplibrary.ui.activitys.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.junwu.mvplibrary.App
import com.junwu.mvplibrary.R
import com.junwu.mvplibrary.di.module.ViewModule
import com.junwu.mvplibrary.mvp.view.IView
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/27 15:01
 * ===============================
 */
class HomeActivity : AppCompatActivity(), IView {

    @Inject
    lateinit var homeModel: HomeModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        var homeComponent = DaggerHomeComponent.builder()
//                .appComponent(App().appComponent)
//                .viewModule(ViewModule(this, this))
//                .homeModule(HomeModule())
//                .build().inject(this)

        setContentView(R.layout.activity_home)
        tvTest.setOnClickListener {
            val c = it as? TextView
            if (c != null) {
                c.setText("sfdsfds")
            }
            println(homeModel.toString())
        }
    }

}