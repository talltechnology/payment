package com.wb.tech.payment

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

/**
 * Created by WXY on 2019/4/9.
 */
class ShareadPrefceUtils {
    private var shared:SharedPreferences?=null;
    private var edit: SharedPreferences.Editor? =null
    companion object {
        val instance: ShareadPrefceUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ShareadPrefceUtils() }
    }

    private fun constructor(){
        var context :Context=App.getAppliction();
        shared=context.getSharedPreferences("User",Context.MODE_PRIVATE)
        edit= shared!!.edit()
    }

    fun <T> add(key:String, valus:T):ShareadPrefceUtils{
        if (valus is String) {
            edit!!.putString(key, valus).commit()
        }else if(valus is Boolean){
            edit!!.putBoolean(key, valus).commit()
        }else if(valus is Int){
            edit!!.putInt(key, valus).commit()
        }else if(valus is Float){
            edit!!.putFloat(key, valus).commit()
        }
        return this
    }

    fun  getString(key:String, valus:String):String {
        return shared!!.getString(key,valus)
    }

}





