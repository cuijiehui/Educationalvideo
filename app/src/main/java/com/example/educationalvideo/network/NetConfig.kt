package com.example.educationalvideo.network

import okhttp3.Interceptor

/**
 * @author cui
 * @data 2020/4/14
 * Description:
 */
interface NetConfig {
    fun configBaseUrl():String
    fun configInterceptors():MutableList<Interceptor>
    fun configConnectTimeoutMills() : Long
    fun configReadTimeoutMills():Long
    fun configLogEnable():Boolean
}