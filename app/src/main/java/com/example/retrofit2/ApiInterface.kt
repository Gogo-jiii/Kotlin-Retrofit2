package com.example.retrofit2

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @get:GET("marvel")
    val heros: Call<List<GetRequestModel?>?>?

    @POST("/api/users")
    fun postHeros(@Body postRequestModel: PostRequestModel?): Call<PostResponseModel?>?
}