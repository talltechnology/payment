package com.wb.tech.payment

import okhttp3.RequestBody
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url
import rx.Observable

/**
 * Created by WXY on 2019/4/9.
 */
interface ApiService{

    @FormUrlEncoded
    @POST
    fun doPost(@Url url:String,@FieldMap parems:HashMap<String,String>):Observable<RequestBody>

}