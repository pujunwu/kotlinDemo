package com.junwu.mvplibrary.ui.activitys.home

import com.junwu.mvplibrary.mvp.model.IModel
import com.junwu.mvplibrary.mvp.view.IView

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/27 15:39
 * ===============================
 */
interface HomeContract {

    interface Model : IModel {
        fun getText(): String
    }

    interface View : IView {

    }

}