package com.prookie.kotlinmvp.module.presenter

import com.prookie.kotlinmvp.base.BaseResponse
import com.prookie.kotlinmvp.base.mvp.BasePresenter
import com.prookie.kotlinmvp.module.UserInfo
import com.prookie.kotlinmvp.module.constract.ILoginView
import com.prookie.kotlinmvp.module.constract.ILoingPresenter
import com.prookie.kotlinmvp.module.model.LoginModel
import com.prookie.kotlinmvp.network.ApiCallback

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by brin on 2018/6/13.
 */
class LoginPresenter() : BasePresenter<ILoginView>(), ILoingPresenter {

    private val TAG: String = "LoginPresenter"


    private val mModel = LoginModel()

    override fun Login() = mModel.userInfo()
//            .compose(RxTransformer.transfrom<BaseResponse<UserInfo>>(getMvpView()))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiCallback<BaseResponse<UserInfo>>() {
                override fun onStart(d: Disposable) {
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onSuccess(modelBean: BaseResponse<UserInfo>) {
                    getMvpView().loginSuccess()
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onFailure(errorMsg: String) {
                    getMvpView().loginFailure()
                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onFinish() {
                    // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }


            })


}

