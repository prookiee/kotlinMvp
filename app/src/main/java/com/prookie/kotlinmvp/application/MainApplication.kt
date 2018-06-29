package com.prookie.kotlinmvp.application

import android.app.Application
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by brin on 2018/6/13.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private var instance: MainApplication by NotNullSingleValueVar()
        fun instance(): MainApplication = instance

    }


    private class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {
        private var value: T? = null
        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return value ?: throw IllegalStateException("application is not init")
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            this.value = value ?: throw IllegalStateException("application is already init")
        }

    }

}