package junwu.com.mvplibrary.delegate.impls

import android.content.Context
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import junwu.com.mvplibrary.delegate.FragmentDelegate
import junwu.com.mvplibrary.delegate.IFragment

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 17:24
 * ===============================
 */
class FragmentDelegateImpl(fragmentV: android.support.v4.app.Fragment? = null,
                           fragmentA: android.app.Fragment? = null) : FragmentDelegate {

    private var mFragment: android.support.v4.app.Fragment? = fragmentV
    private var mFragment1: android.app.Fragment? = fragmentA
    //fragment实现类
    private var iFragment: IFragment? = if (mFragment != null) mFragment as IFragment else mFragment1 as? IFragment

    constructor(parcel: Parcel) : this(
            TODO("fragmentV"),
            TODO("fragmentA")) {

    }

    override fun onAttach(context: Context?) {

    }

    override fun onCreate(savedInstanceState: Bundle) {
        if (iFragment!!.isLazyLoad()) {
            return
        }
        onCreate()
    }

    override fun onCreate() {
        if (!iFragment!!.useEventBus()) {
            return
        }
//        if (mFragment != null) {
//            EventBus.getDefault().register(mFragment)
//        } else if (mFragment1 != null) {
//            EventBus.getDefault().register(mFragment1)
//        }
    }

    override fun onCreateView(view: View, savedInstanceState: Bundle) {
        if (iFragment!!.isLazyLoad()) {
            return
        }
        onCreateView(view)
    }

    override fun onCreateView(view: View) {
        if (view == null) {
            return
        }
//        if (mFragment != null) {
//            mUnbinder = ButterKnife.bind(mFragment, view)
//        } else if (mFragment1 != null) {
//            mUnbinder = ButterKnife.bind(mFragment1, view)
//        }
        iFragment?.initData()//初始化操作
    }

    override fun onActivityCreate(savedInstanceState: Bundle?) {

    }

    override fun onStart() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {

    }

    override fun onSaveInstanceState(outState: Bundle?) {

    }

    override fun onDestroyView() {
//        if (mUnbinder != null && mUnbinder !== Unbinder.EMPTY) {
//            mUnbinder!!.unbind()
//        }
    }

    override fun onDestroy() {
        if (!iFragment!!.isLazyLoad() && iFragment!!.useEventBus()) {
//            if (mFragment != null)
//                EventBus.getDefault().unregister(mFragment)
//            else if (mFragment1 != null)
//                EventBus.getDefault().unregister(mFragment1)
        }
        mFragment = null
        mFragment1 = null
        iFragment = null
//        mUnbinder = null
    }

    override fun onDetach() {

    }

    override fun isCreate(): Boolean {
//        return if (mFragment == null && mFragment1 == null || iFragment == null || mUnbinder === Unbinder.EMPTY) {
//            false
//        } else true
        return if (mFragment == null && mFragment1 == null || iFragment == null) {
            false
        } else true
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
//        super.writeToParcel(dest, flags)
    }

    protected fun FragmentDelegateImpl(`in`: Parcel) {
//        this.mFragment = `in`.readParcelable<Parcelable>(android.support.v4.app.Fragment::class.java.classLoader)
//        this.mFragment1 = `in`.readParcelable<Parcelable>(android.app.Fragment::class.java.classLoader)
//        this.iFragment = `in`.readParcelable<IFragment>(IFragment::class.java!!.getClassLoader())
//        this.mUnbinder = `in`.readParcelable<Unbinder>(Unbinder::class.java!!.getClassLoader())
    }

    //    val CREATOR: Parcelable.Creator<FragmentDelegateImpl> = object : Parcelable.Creator<FragmentDelegateImpl> {
//        override fun createFromParcel(source: Parcel): FragmentDelegateImpl {
//            return FragmentDelegateImpl(source)
//        }
//
//        override fun newArray(size: Int): Array<FragmentDelegateImpl> {
//            return arrayOfNulls(size)
//        }
//    }
    companion object CREATOR : Parcelable.Creator<FragmentDelegateImpl> {
        override fun createFromParcel(parcel: Parcel): FragmentDelegateImpl {
            return FragmentDelegateImpl(parcel)
        }

        override fun newArray(size: Int): Array<FragmentDelegateImpl?> {
            return arrayOfNulls(size)
        }
    }

}