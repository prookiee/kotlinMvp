package com.prookie.kotlinmvp.utils

import android.app.Activity
import com.tbruyelle.rxpermissions2.RxPermissions

/**
 * Created by brin on 2018/6/13.
 */
class RxPermissionHelper(private val listener: PermissionCallbacks) {


    fun requestPermission(activity: Activity, vararg permissions: String) {
        RxPermissions(activity).request(*permissions)
                .subscribe { t: Boolean ->
                    if (t) listener.onPermissionsGranted()
                    else listener.onPermissionsDenied()
                }
    }


    /**
     * 申请权限接口回调
     */
    interface PermissionCallbacks {

        //同意授权
        fun onPermissionsGranted()

        //拒绝授权
        fun onPermissionsDenied()

    }
}