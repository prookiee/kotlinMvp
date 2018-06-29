package com.prookie.kotlinmvp.base

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prookie.kotlinmvp.utils.RxPermissionHelper

/**
 * Created by brin on 2018/6/16.
 */
abstract class BaseFragment : Fragment(), RxPermissionHelper.PermissionCallbacks {


    protected abstract fun getContentLayoutId(): Int

    protected abstract fun initView(view : View)

    protected abstract fun initData()


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(activity, getContentLayoutId(), null)
        initView(view)
        return view
    }

    override fun onPermissionsGranted() {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPermissionsDenied() {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}