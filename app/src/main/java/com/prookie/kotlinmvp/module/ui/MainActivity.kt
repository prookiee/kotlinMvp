package com.prookie.kotlinmvp.module.ui


import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.view.MotionEvent
import com.prookie.kotlinmvp.R
import com.prookie.kotlinmvp.adapter.FragmentAdapter
import com.prookie.kotlinmvp.base.BaseActivity
import com.prookie.kotlinmvp.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    private val fragmentList: List<BaseFragment> = listOf(HomeFragment(), ClassficationFragment())


    override fun getContentLayoutId(): Int = R.layout.activity_main

    override fun initView() {

        viewpager.adapter = FragmentAdapter(supportFragmentManager, fragmentList)

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)



    }

    /**
     * mOnNavigationItemSelectedListener
     */
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                viewpager.setCurrentItem(0, false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                viewpager.setCurrentItem(1, false)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    override fun initData() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
