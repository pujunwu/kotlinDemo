package junwu.com.mvplibrary.delegate

import android.os.Bundle
import android.os.Parcelable

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 16:06
 * ===============================
 */
interface ActivityDelegate : Parcelable {

    companion object {
        val LAYOUT_LINEARLAYOUT by lazy { "LinearLayout" }
        val LAYOUT_FRAMELAYOUT by lazy { "FrameLayout" }
        val LAYOUT_RELATIVELAYOUT by lazy { "RelativeLayout" }
        val ACTIVITY_DELEGATE by lazy { "activity_delegate" }
    }

    fun onCreate(savedInstanceState: Bundle)

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onSaveInstanceState(outState: Bundle)

    fun onDestroy()
}