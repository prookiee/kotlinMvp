package com.prookie.kotlinmvp.base

/**
 *
 * BaseResponse
 * Created by brin on 2018/6/13.
 *
 * @property Code     返回码
 * @property Message  返回信息
 * @property Content  返回内容
 *
 */
class BaseResponse<T>(val Code: String, val Message: String, val Content: T?){

    override fun toString(): String {
        return "BaseResponse(Code='$Code', Message='$Message', Content=$Content)"
    }
}