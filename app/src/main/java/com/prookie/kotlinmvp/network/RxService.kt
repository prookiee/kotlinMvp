package com.prookie.kotlinmvp.network

import com.prookie.kotlinmvp.constant.ApiConstant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by brin on 2018/6/13.
 */
enum class RxService {

    RETROFIT;

    private var mRetrofit: Retrofit? = null
    private val READ_TIMEOUT = 60L //读取超时时间,单位秒
    private val CONN_TIMEOUT = 50L //连接超时时间,单位秒


    private val httpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.addHeader("Content-Type", "application/json")
                chain.proceed(builder.build())
            }
            .connectTimeout(CONN_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()


    private fun createRetrofit(): Retrofit {
        if (mRetrofit == null)
            mRetrofit = Retrofit.Builder()
                    .client(httpClient)
                    .baseUrl(ApiConstant.BASE_PATH) //api base path
                    .addConverterFactory(GsonConverterFactory.create())//返回值为Gson的支持(以实体类返回)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//返回值为Oservable<T>的支持
                    .build()
        return mRetrofit!!

    }

    fun <T> createService(service: Class<T>): T {
        validateServiceInterface<T>(service)//校验接口合法性
        return RxService.RETROFIT.createRetrofit().create(service)
    }


    private fun <T> validateServiceInterface(service: Class<T>?) {
        if (service == null) {
            //Toast.ShowToast("服务接口不能为空！");
        }
        if (!service!!.isInterface) {
            throw IllegalArgumentException("API declarations must be interfaces.")
        }
        if (service.interfaces.isNotEmpty()) {
            throw IllegalArgumentException("API interfaces must not extend other interfaces.")
        }
    }


}