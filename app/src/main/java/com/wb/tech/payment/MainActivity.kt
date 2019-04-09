package com.wb.tech.payment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.RequestBody
import rx.Observable
import rx.Observer
import java.lang.Comparable

class MainActivity : AppCompatActivity() {
    val phone="15835091314"
    val pwd="123456"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login()
    }

    private fun login() {
        Log.e("--", "" + Api.BaseUrl)
        val parem=HashMap<String,String>()
        parem.put("phone",phone)
        parem.put("pwd",EncryptUtil.encrypt(pwd))
        RetorfitClientUtil.instance.getRetorfit(ApiService::class.java)
                .doPost(Api.LoginUrl, parem)
                .subscribe(object :Observer<RequestBody>{
                    override fun onError(e: Throwable?) {

                    }

                    override fun onNext(t: RequestBody?) {
                        Log.d("----",""+t)
//                        ShareadPrefceUtils.instance
//                                .add("")
//                                .add()
                    }

                    override fun onCompleted() {

                    }

                })
    }


}
