package com.prookie.kotlinmvp.base.mvp

import com.prookie.kotlinmvp.network.RxService
import java.util.HashMap

/**
 * Created by brin on 2018/6/13.
 */
open class BaseModel {

    /**
     * 返回服务接口对象实例
     *
     * @param clazz
     * @param <T>
     * @return
     */
    protected fun <T> createService(clazz: Class<T>): T = RxService.RETROFIT.createService(clazz)

    /**
     * 获取公共请求参数
     *
     * @return
     */
    protected fun createBaseParamMap(): MutableMap<String, String> {
        val map: MutableMap<String, String> = mutableMapOf()
        map.put("UserId", "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456")//用户id
        map.put("UserName", "18856422586")
        map.put("DeviceType", "2")//设备类型:android / ios
        return map
    }
    

}