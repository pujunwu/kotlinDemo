package junwu.com.mvplibrary.delegate

import android.view.View

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 16:22
 * ===============================
 */
interface IActivity {

    /**
     * 获取当前布局Id
     *
     * @return
     */
    fun getLayoutId(): Int

    /**
     * 执行注入方法
     */
    fun initInject()

    /**
     * 获取当前显示的布局
     *
     * @return
     */
    fun getLayoutView(): View

    /**
     * 子类做初始化操作
     */
    fun initData()

    /**
     * 是否有事件绑定
     *
     * @return
     */
    fun eventBus(): Boolean

    /**
     * 是否使用fragment
     *
     * @return
     */
    fun fragment(): Boolean

}