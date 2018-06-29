package com.prookie.kotlinmvp.base.mvp

/**
 * Created by brin on 2018/6/13.
 */
abstract class BasePresenter<T : IBaseView> : IBasePresenter<T> {

    private lateinit var mMvpView: T

    override fun attachView(view: T) {
        mMvpView = view
    }

    override fun detachView() {
//        mMvpView = null
    }

    protected fun getMvpView(): T = mMvpView


}