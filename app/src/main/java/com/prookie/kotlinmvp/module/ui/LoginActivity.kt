package com.prookie.kotlinmvp.module.ui


import android.graphics.Color
import com.prookie.kotlinmvp.R
import com.prookie.kotlinmvp.base.BaseActivity
import com.prookie.kotlinmvp.module.presenter.LoginPresenter
import com.prookie.kotlinmvp.module.constract.ILoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

class LoginActivity : BaseActivity(), ILoginView {


    override fun getContentLayoutId(): Int = R.layout.activity_login

    override fun initView() = initData()

    override fun initData() {

        setSupportActionBar(toolbar)
        collapsing_toolbar_layout
//        toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);
        collapsing_toolbar_layout.setTitle("DesignLibrarySample");
        collapsing_toolbar_layout.setCollapsedTitleTextColor(Color.WHITE);
        collapsing_toolbar_layout.setExpandedTitleColor(Color.WHITE);



        val presenter = LoginPresenter()
        presenter.attachView(this)
        presenter.Login()

    }

    /**
     * 登录成功
     */
    override fun loginSuccess() {
        toast("登录成功")
    }

    /**
     * 登录失败
     */
    override fun loginFailure() {
        toast("登录失败")
    }


}
