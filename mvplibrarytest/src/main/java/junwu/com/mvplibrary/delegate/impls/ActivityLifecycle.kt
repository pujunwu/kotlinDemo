package junwu.com.mvplibrary.delegate.impls

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import junwu.com.mvplibrary.delegate.ActivityDelegate
import junwu.com.mvplibrary.delegate.IActivity

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 16:24
 * ===============================
 */
class ActivityLifecycle : Application.ActivityLifecycleCallbacks {

    private var mFragmentLifecycle: FragmentLifecycle? = null

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle) {
        val iActivity = (if (activity is IActivity) activity else null) ?: return
        var delegate: ActivityDelegate? = getActivityDelegate(activity)
        if (delegate == null && activity.intent != null) {
            delegate = ActivityDelegateImpl(activity)
            activity.intent.putExtra(ActivityDelegate.ACTIVITY_DELEGATE, delegate)
        }
        if (delegate != null) {
            delegate.onCreate(savedInstanceState)
        }
        //添加fragment监听
        if (activity is FragmentActivity && iActivity.fragment()) {
            if (mFragmentLifecycle == null) {
                mFragmentLifecycle = FragmentLifecycle()
            }
            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(mFragmentLifecycle, true)
        }
    }

    override fun onActivityStarted(activity: Activity) {
        getActivityDelegate(activity)?.onStart()
    }

    override fun onActivityResumed(activity: Activity) {
        getActivityDelegate(activity)?.onResume()
    }

    override fun onActivityPaused(activity: Activity) {
        getActivityDelegate(activity)?.onStop()
    }

    override fun onActivityStopped(activity: Activity) {
        getActivityDelegate(activity)?.onStop()
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        getActivityDelegate(activity)?.onSaveInstanceState(outState)
    }

    override fun onActivityDestroyed(activity: Activity) {
        val delegate = getActivityDelegate(activity)
        if (delegate != null) {
            delegate.onDestroy()
            activity.intent.removeExtra(ActivityDelegate.ACTIVITY_DELEGATE)
        }
    }

    private fun getActivityDelegate(activity: Activity): ActivityDelegate? {
        return if (activity is IActivity && activity.intent != null) {
            activity.intent.getParcelableExtra(ActivityDelegate.ACTIVITY_DELEGATE)
        } else null
    }

}