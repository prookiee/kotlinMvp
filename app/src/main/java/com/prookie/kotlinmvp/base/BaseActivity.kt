package com.prookie.kotlinmvp.base

import android.Manifest
import android.os.Bundle
import com.prookie.kotlinmvp.base.mvp.IBaseView
import com.prookie.kotlinmvp.utils.RxPermissionHelper
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.components.support.RxFragmentActivity
import org.jetbrains.anko.longToast


abstract class BaseActivity : RxAppCompatActivity(), IBaseView, RxPermissionHelper.PermissionCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentLayoutId())
        initView()
        RxPermissionHelper(this).requestPermission(this,
                Manifest.permission.SEND_SMS, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    /**
     * 获取布局layoutId
     */
    abstract fun getContentLayoutId(): Int

    abstract fun initView()

    abstract fun initData()

    override fun onPermissionsGranted() {
        longToast("授权")
    }

    override fun onPermissionsDenied() {
        longToast("deny")
    }

    /**
     * rxjava绑定生命周期
     */
    override fun <M> bindLifecycle(): LifecycleTransformer<M> = super.bindUntilEvent(ActivityEvent.PAUSE)

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

}
