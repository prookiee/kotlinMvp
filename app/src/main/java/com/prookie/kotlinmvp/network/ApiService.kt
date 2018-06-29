package com.prookie.kotlinmvp.network

import com.prookie.kotlinmvp.base.BaseResponse
import com.prookie.kotlinmvp.module.UserInfo
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import io.reactivex.Observable

/**
 * Created by brin on 2018/6/13.
 */
interface ApiService {

    @POST("{login}")
    fun login(@Path("login") url:String,@Body params : MutableMap<String,String>): Observable<BaseResponse<*>>

    @POST("{getUserinfo}")
    fun userInfo(@Path("getUserinfo") url:String,@Body params : MutableMap<String,String>): Observable<BaseResponse<UserInfo>>

}