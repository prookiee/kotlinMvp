package com.prookie.kotlinmvp.base.mvp

/**
 * Created by brin on 2018/6/13.
 */
interface IBasePresenter<T : IBaseView> {

    fun attachView(view: T)

    fun detachView()

}