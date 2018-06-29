package com.prookie.kotlinmvp.base

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * BaseEntity
 * 已经实现序列化
 * Created by brin on 2018/6/13.
 */
@Parcelize
open class BaseEntity : Parcelable {

    open protected lateinit var Id: String


}