package junwu.com.mvplibrary.delegate

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.View

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 16:21
 * ===============================
 */
interface FragmentDelegate : Parcelable {

    companion object {
        val FRAGMENT_DELEGATE by lazy { "fragment_delegate" }
    }

    fun onAttach(context: Context?)

    fun onCreate(savedInstanceState: Bundle)

    /**
     * 执行操作的
     */
    fun onCreate()

    fun onCreateView(view: View, savedInstanceState: Bundle)

    /**
     * 执行操作的
     */
    fun onCreateView(view: View)

    fun onActivityCreate(savedInstanceState: Bundle?)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onSaveInstanceState(outState: Bundle?)

    fun onDestroyView()

    fun onDestroy()

    fun onDetach()

    /**
     * 是否创建
     *
     * @return boolean
     */
    fun isCreate(): Boolean

}