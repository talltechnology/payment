package com.wb.tech.payment

import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by WXY on 2019/4/9.
 */
class RetorfitClientUtil {
    private val myRetorfit: RetorfitClientUtil? = null
    private var httpClient: OkHttpClient? = null
    private var retrofitBuild: Retrofit.Builder? = null
    private fun constructor(){
        initokhttp()
        initRetorfit()
    }

    companion object {
        val instance:RetorfitClientUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED){RetorfitClientUtil()}
    }



    private fun initokhttp() {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .writeTimeout(25, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .cache(Cache(File(App.getAppliction().cacheDir.absolutePath + ""), (1024 * 1024).toLong()))
                .build()
    }

    private fun initRetorfit() {

        retrofitBuild = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(httpClient!!)
                .baseUrl(Api.BaseUrl)

    }

    fun <T> getRetorfit(t: Class<T>): T {

        if (myRetorfit == null) {
            synchronized(RetorfitClientUtil::class.java) {
                if (myRetorfit == null) {
                    RetorfitClientUtil()
                }
            }
        }
        return retrofitBuild!!.build().create(t)
    }

}