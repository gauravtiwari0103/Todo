package com.gaurav.leraning


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("REM_CMS/Api/Employee/GetAppliedLeaveList")
    fun getAppliedLeaveList(@Body request: LeaveListRequest): Call<ArrayList<Response>>
}



object RetrofitInstance {

    private const val BASE_URL = "https://app.astralerp.com/"

    val api: ApiInterface by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiInterface::class.java)
    }
}
