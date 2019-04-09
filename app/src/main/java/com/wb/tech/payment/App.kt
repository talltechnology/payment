package com.wb.tech.payment

import android.app.Application

/**
 * Created by WXY on 2019/4/9.
 */
class App(): Application() {
    companion object {
        private var MyAppliction:Application?=null

          fun getAppliction()=MyAppliction!!
    }

    override fun onCreate() {
        super.onCreate()
        MyAppliction=this
    }
}