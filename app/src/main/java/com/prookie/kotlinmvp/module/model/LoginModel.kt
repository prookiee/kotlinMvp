package com.prookie.kotlinmvp.module.model

import com.prookie.kotlinmvp.base.BaseResponse
import com.prookie.kotlinmvp.base.mvp.BaseModel
import com.prookie.kotlinmvp.constant.ApiConstant
import com.prookie.kotlinmvp.module.UserInfo
import com.prookie.kotlinmvp.module.constract.ILoginModel
import com.prookie.kotlinmvp.network.ApiService
import io.reactivex.Observable

/**
 * Created by brin on 2018/6/13.
 */
class LoginModel : BaseModel(), ILoginModel {


    private val service: ApiService = createService(ApiService::class.java)

    override fun login(): Observable<BaseResponse<*>> {
        val map = createBaseParamMap()
        map.put("Mobile", "18856422586")
        map.put("Password", "123456")
        return service.login(ApiConstant.LOGIN, map)
    }

    /**
     * 获取用户信息
     */
    override fun userInfo(): Observable<BaseResponse<UserInfo>> {
        val map = createBaseParamMap()
        map.put("Mobile", "18856422586")
        return service.userInfo(ApiConstant.GET_USER_INFO, map)
    }
}