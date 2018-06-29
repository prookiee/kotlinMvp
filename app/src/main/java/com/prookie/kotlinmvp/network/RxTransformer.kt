package com.prookie.kotlinmvp.network

import com.prookie.kotlinmvp.base.mvp.IBaseView
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.schedulers.Schedulers

/**
 * Created by brin on 2018/6/13.
 */
object RxTransformer {

    /**
     * 线程调度以及绑定神明周期
     */
    fun <T> transfrom(view: IBaseView?): ObservableTransformer<T, T> =
            ObservableTransformer { upstream ->
                if (null == view) upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())//线程调度
                else upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).compose(view.bindLifecycle())//线程调度以及绑定生命周期
            }


}