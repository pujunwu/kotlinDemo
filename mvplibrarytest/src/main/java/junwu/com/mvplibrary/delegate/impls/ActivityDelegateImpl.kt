package junwu.com.mvplibrary.delegate.impls

import android.app.Activity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import junwu.com.mvplibrary.delegate.ActivityDelegate
import junwu.com.mvplibrary.delegate.IActivity

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 16:31
 * ===============================
 */
class ActivityDelegateImpl(activity: Activity?) : ActivityDelegate {

    private var mActivity: Activity? = activity
    private var iActivity: IActivity? = activity as IActivity
//    private var mUnbinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle) {
        val layoutId = iActivity!!.getLayoutId()
        if (layoutId != 0) {
            mActivity!!.setContentView(layoutId)
//            mUnbinder = ButterKnife.bind(mActivity)
        } else {
            val view = iActivity!!.getLayoutView()
            if (view != null) {
                mActivity!!.setContentView(view)
//                mUnbinder = ButterKnife.bind(view)
            }
        }
        if (iActivity!!.eventBus()) {
//            EventBus.getDefault().register(mActivity)
        }
    }

    override fun onStart() {}

    override fun onResume() {}

    override fun onPause() {}

    override fun onStop() {}

    override fun onSaveInstanceState(outState: Bundle) {}

    override fun onDestroy() {
//        if (mUnbinder != null && mUnbinder !== Unbinder.EMPTY) {
//            mUnbinder!!.unbind()
//        }
//        if (iActivity!!.eventBus()) {
//            EventBus.getDefault().unregister(mActivity)
//        }
        mActivity = null
        iActivity = null
//        mUnbinder = null
    }

//
//    override fun writeToParcel(dest: Parcel, flags: Int) {
//        super.writeToParcel(dest, flags)
//    }

//    protected fun ActivityDelegateImpl(`in`: Parcel): ??? {
//        this.mActivity = `in`.readParcelable<Parcelable>(Activity::class.java.classLoader)
//        this.iActivity = `in`.readParcelable<IActivity>(IActivity::class.java!!.getClassLoader())
//        this.mUnbinder = `in`.readParcelable<Unbinder>(Unbinder::class.java!!.getClassLoader())
//    }
//
//    val CREATOR: Parcelable.Creator<ActivityDelegateImpl> = object : Parcelable.Creator<ActivityDelegateImpl> {
//        override fun createFromParcel(source: Parcel): ActivityDelegateImpl {
//            return ActivityDelegateImpl(source)
//        }
//
//        override fun newArray(size: Int): Array<ActivityDelegateImpl> {
//            return arrayOfNulls(size)
//        }
//    }

//    constructor(parcel: Parcel) : this(TODO("activity")) {
////        this.mActivity = `in`.readParcelable<Parcelable>(Activity::class.java.classLoader)
////        this.iActivity = `in`.readParcelable<IActivity>(IActivity::class.java!!.getClassLoader())
////        this.mUnbinder = `in`.readParcelable<Unbinder>(Unbinder::class.java!!.getClassLoader())
//    }

    //    companion object CREATOR : Parcelable.Creator<ActivityDelegateImpl> {
//        override fun createFromParcel(parcel: Parcel): ActivityDelegateImpl {
//            return ActivityDelegateImpl(parcel)
//        }
//
//        override fun newArray(size: Int): Array<ActivityDelegateImpl?> {
//            return arrayOfNulls(size)
//        }
//    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        super.writeToParcel(parcel, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ActivityDelegateImpl> {
        override fun createFromParcel(parcel: Parcel): ActivityDelegateImpl {
            return ActivityDelegateImpl(null)
        }

        override fun newArray(size: Int): Array<ActivityDelegateImpl?> {
            return arrayOfNulls(size)
        }
    }

}