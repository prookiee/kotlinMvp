package com.prookie.kotlinmvp.module.ui

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import android.view.View
import com.prookie.kotlinmvp.R
import com.prookie.kotlinmvp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * Created by brin on 2018/6/16.
 */
class HomeFragment : BaseFragment() {


    override fun getContentLayoutId(): Int = R.layout.fragment_home


    override fun initView(view: View) {
        //init toolar
//        val toolbar = view.findViewById(R.id.toolbar_title) as Toolbar
//        toolbar.run {
//            title = "dfdffdfd"
//            (activity as AppCompatActivity).setSupportActionBar(this)
//        }
    }

    override fun initData() {
        //   TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}