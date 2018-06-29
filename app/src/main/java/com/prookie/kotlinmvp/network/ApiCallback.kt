package com.prookie.kotlinmvp.network

import com.prookie.kotlinmvp.base.BaseResponse
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import retrofit2.HttpException

/**
 * Created by brin on 2018/6/13.
 */
abstract class ApiCallback<M> : Observer<M> {

    abstract fun onStart(d: Disposable)

    abstract fun onSuccess(modelBean: M)

    abstract fun onFailure(errorMsg: String)

    abstract fun onFinish()


    override fun onSubscribe(d: Disposable) = onStart(d)

    override fun onComplete() = onFinish()

    override fun onNext(modelBean: M) {
        val response = modelBean as BaseResponse<M>
        if ("200" == response.Code) {
            onSuccess(modelBean)
        } else {
            onFailure(response.Message)
        }
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
        if (e is HttpException) {
            val exceptionCode = e.code()
            var msg = e.message()
            when (e.code()) {
                401 -> msg = "用户名密码错误，请重新登录！"
                402, 404, 407, 408 -> msg = "网络链接超时，请稍后再试！"
                501, 502, 504 -> msg = "服务器无响应，请稍后再试！"
            }
            onFailure(msg)
        } else run { onFailure(e.message.toString()) }
        onFinish()
    }


}