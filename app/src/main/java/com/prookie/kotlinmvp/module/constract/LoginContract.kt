package com.prookie.kotlinmvp.module.constract

import io.reactivex.Observable
import com.prookie.kotlinmvp.base.BaseResponse
import com.prookie.kotlinmvp.base.mvp.IBaseView
import com.prookie.kotlinmvp.module.UserInfo

/**
 * Created by brin on 2018/6/13.
 */

interface ILoginView : IBaseView {
    fun loginSuccess()
    fun loginFailure()
}

interface ILoingPresenter {
    fun Login()
}

interface ILoginModel {
    fun login(): Observable<BaseResponse<*>>
    fun userInfo(): Observable<BaseResponse<UserInfo>>
}