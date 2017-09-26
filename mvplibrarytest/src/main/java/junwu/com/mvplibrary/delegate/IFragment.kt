package junwu.com.mvplibrary.delegate

import android.view.View

/**
 * ===============================
 * 描    述：
 * 作    者：pjw
 * 创建日期：2017/9/25 16:23
 * ===============================
 */
interface IFragment {

    /**
     * 获取当前布局Id
     */
    fun getLayoutId(): Int

    /**
     * 获取当前显示的布局
     */
    fun getLayoutView(): View

    /**
     * 是否自动注册EventBus事件
     *
     * @return 是否注册EventBus事件
     */
    fun useEventBus(): Boolean

    /**
     * 执行注入方法
     */
    fun initInject()

    /**
     * 获取是否是懒加载
     *
     * @return 是否是懒加载
     */
    fun isLazyLoad(): Boolean

    /**
     * 初始化方法
     */
    fun initData()

}