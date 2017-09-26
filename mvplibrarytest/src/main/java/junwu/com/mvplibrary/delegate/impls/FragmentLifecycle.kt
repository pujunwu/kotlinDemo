package junwu.com.mvplibrary.delegate.impls

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import junwu.com.mvplibrary.delegate.FragmentDelegate
import junwu.com.mvplibrary.delegate.IFragment

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 17:07
 * ===============================
 */
class FragmentLifecycle : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentAttached(fm: FragmentManager?, f: Fragment?, context: Context?) {
        super.onFragmentAttached(fm, f, context)
        val savedInstanceState = getFragementBundle(f, null)
        //如果是IFragment的实现类 并且savedInstanceState不为空 并且不是懒加载就进入
        if (f is IFragment && savedInstanceState != null && !(f as IFragment).isLazyLoad()) {
            var fragmentDelegate = getFragmentDelegate(f)
            if (fragmentDelegate == null) {
                //创建代理类
                fragmentDelegate = FragmentDelegateImpl(f)
                savedInstanceState.putParcelable(FragmentDelegate.FRAGMENT_DELEGATE, fragmentDelegate)
            }
            fragmentDelegate?.onAttach(context)
        }
    }

    override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?, savedInstanceState: Bundle?) {
        super.onFragmentCreated(fm, f, savedInstanceState)
        var b: Bundle? = getFragementBundle(f, savedInstanceState)
        if (b != null) {
            getFragmentDelegate(f)?.onCreate(b)
        }
    }

    override fun onFragmentViewCreated(fm: FragmentManager?, f: Fragment?, v: View?, savedInstanceState: Bundle?) {
        super.onFragmentViewCreated(fm, f, v, savedInstanceState)
        var b: Bundle? = getFragementBundle(f, savedInstanceState)
        if (b != null && v != null) {
            getFragmentDelegate(f)?.onCreateView(v, b)
        }
    }

    override fun onFragmentActivityCreated(fm: FragmentManager?, f: Fragment?, savedInstanceState: Bundle?) {
        super.onFragmentActivityCreated(fm, f, savedInstanceState)
        val fragmentDelegate = getFragmentDelegate(f)
        fragmentDelegate?.onActivityCreate(getFragementBundle(f, savedInstanceState))
    }

    override fun onFragmentSaveInstanceState(fm: FragmentManager?, f: Fragment?, outState: Bundle?) {
        super.onFragmentSaveInstanceState(fm, f, outState)
        getFragmentDelegate(f)?.onSaveInstanceState(outState)
    }

    override fun onFragmentStarted(fm: FragmentManager?, f: Fragment?) {
        super.onFragmentStarted(fm, f)
        val fragmentDelegate = getFragmentDelegate(f)
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onStart()
        }
    }

    override fun onFragmentResumed(fm: FragmentManager?, f: Fragment?) {
        super.onFragmentResumed(fm, f)
        val fragmentDelegate = getFragmentDelegate(f)
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onResume()
        }
    }

    override fun onFragmentPaused(fm: FragmentManager?, f: Fragment?) {
        super.onFragmentPaused(fm, f)
        val fragmentDelegate = getFragmentDelegate(f)
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onPause()
        }
    }

    override fun onFragmentStopped(fm: FragmentManager?, f: Fragment?) {
        super.onFragmentStopped(fm, f)
        val fragmentDelegate = getFragmentDelegate(f)
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onStop()
        }
    }

    override fun onFragmentViewDestroyed(fm: FragmentManager?, f: Fragment?) {
        super.onFragmentViewDestroyed(fm, f)
        val fragmentDelegate = getFragmentDelegate(f)
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onDestroyView()
        }
    }

    override fun onFragmentDestroyed(fm: FragmentManager?, f: Fragment?) {
        super.onFragmentDestroyed(fm, f)
        val fragmentDelegate = getFragmentDelegate(f)
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onDestroy()
        }
    }

    override fun onFragmentDetached(fm: FragmentManager?, f: Fragment?) {
        super.onFragmentDetached(fm, f)
        val fragmentDelegate = getFragmentDelegate(f)
        if (fragmentDelegate != null) {
            fragmentDelegate!!.onDetach()
            f!!.arguments.clear()
        }
    }

    /**
     * 获取FragmentDelegate
     *
     * @param fragment Fragment
     * @return FragmentDelegate
     */
    private fun getFragmentDelegate(fragment: Fragment?): FragmentDelegate? {
        if (fragment != null && fragment is IFragment && fragment.arguments != null) {
            var fragmentDelegate: FragmentDelegate? = null
            try {
                fragmentDelegate = fragment.arguments.getParcelable(FragmentDelegate.FRAGMENT_DELEGATE)
            } catch (e: Exception) {
            }
            return if (fragmentDelegate == null || !fragmentDelegate!!.isCreate()) {
                null
            } else fragmentDelegate
        }
        return null
    }

    /**
     * 获取Fragment的Bundle
     *
     * @param f                  Fragment
     * @param savedInstanceState Bundle
     */
    private fun getFragementBundle(f: Fragment?, savedInstanceState: Bundle?): Bundle? {
        return savedInstanceState ?: f?.arguments
    }

}