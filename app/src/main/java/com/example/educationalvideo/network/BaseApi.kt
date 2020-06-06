package com.example.educationalvideo.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * @author cui
 * @data 2020/4/14
 * Description:
 */
class BaseApi {
    /**
     * mRetrofit
     */
    private var mRetrofit: Retrofit? = null
    /**
     * mClient
     */
    private var mClient: OkHttpClient? = null

    /**
     * 默认连接超时时间
     */
    init {
        mRetrofit = null
        mClient = null
    }

    companion object {
        /**
         * 实例
         **/
        private var instance: BaseApi? = null
        /**
         * 网络配置项
         */
        private lateinit var mConfig: NetConfig
        /**
         * 默认连接超时时间
         */
        private const val DEFAULT_CONNECT_TIMEOUT_MILLS = 40 * 1000L
        /**
         * 默认读取超时时间
         */
        private const val DEFAULT_READ_TIMEOUT_MILLS = 40 * 1000L

        fun getInstance(): BaseApi? {
            if (instance == null) {
                instance = BaseApi()
            }
            return instance
        }

        @JvmStatic
        fun createRetrofit(): Retrofit? {
            return getInstance()?.getRetrofit()
        }

        @JvmStatic
        fun registerConfig(config: NetConfig) {
            mConfig = config
            //赋值为空
            instance = null
        }

        @JvmStatic
        fun <C> get(service: Class<C>): C? {
            return getInstance()?.getRetrofit()?.create(service)
        }

    }

    fun getRetrofit(): Retrofit? {
        if (mRetrofit == null) {
            mRetrofit = Retrofit.Builder()
                .baseUrl(mConfig.configBaseUrl())
                .client(getHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return mRetrofit
    }
    private fun getHttpClient(): OkHttpClient? {
        if (mClient == null) {
            val builder = OkHttpClient.Builder()
            //连接超时时间
            val timeoutMills =
                if (mConfig.configConnectTimeoutMills() != 0L) mConfig.configConnectTimeoutMills() else DEFAULT_CONNECT_TIMEOUT_MILLS
            builder.connectTimeout(timeoutMills, TimeUnit.MILLISECONDS)
            //读取超时时间
            val readTimeout =
                if (mConfig.configReadTimeoutMills() != 0L) mConfig.configReadTimeoutMills() else DEFAULT_READ_TIMEOUT_MILLS
            builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS)
            //拦截器
            val interceptors = mConfig.configInterceptors()
            for (interceptor in interceptors) {
                builder.addInterceptor(interceptor)
            }
            //设置打印
            if (mConfig.configLogEnable()) {
                val logInterceptor = HttpLoggingInterceptor()
                logInterceptor.level = HttpLoggingInterceptor.Level.BODY
                builder.addInterceptor(logInterceptor)
            }
        }
        return mClient
    }
}