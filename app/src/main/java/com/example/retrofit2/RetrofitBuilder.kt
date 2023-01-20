package com.example.retrofit2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder private constructor() {

    var BASE_URL_GET = "https://simplifiedcoding.net/demos/"
    var BASE_URL_POST = "https://reqres.in"
    private var builder: Retrofit.Builder? = null
    private var apiInterface: ApiInterface? = null

    companion object {
        var instance: RetrofitBuilder? = null
            get() {
                if (field == null) {
                    field = RetrofitBuilder()
                }
                return field
            }
            private set
    }

    fun build(url: String?) {
        builder = Retrofit.Builder()
        builder!!.baseUrl(url.toString())
        builder!!.addConverterFactory(GsonConverterFactory.create())
        val retrofit = builder!!.build()
        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun callApi(): ApiCalls {
        return ApiCalls(apiInterface!!)
    }
}