package com.prookie.kotlinmvp.base.mvp

import com.trello.rxlifecycle2.LifecycleTransformer

/**
 * Created by brin on 2018/6/13.
 */
interface IBaseView {

    fun <M> bindLifecycle(): LifecycleTransformer<M>

    fun showLoading()

    fun hideLoading()

}