package com.example.retrofit2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var retrofitBuilder: RetrofitBuilder? = RetrofitBuilder.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGetRequest.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            retrofitBuilder?.build(retrofitBuilder?.BASE_URL_GET)
            val call: Call<List<GetRequestModel?>?>? = retrofitBuilder?.callApi()?.heros
            call?.enqueue(object : Callback<List<GetRequestModel?>?> {
                override fun onResponse(
                    call: Call<List<GetRequestModel?>?>,
                    response: Response<List<GetRequestModel?>?>
                ) {
                    txtResultValue.text = response.body().toString()
                    progressBar.visibility = View.GONE
                }

                override fun onFailure(call: Call<List<GetRequestModel?>?>, t: Throwable) {
                    progressBar.visibility = View.GONE
                }
            })
        }

        btnPostRequest.setOnClickListener {
            progressBar.visibility = View.VISIBLE
            retrofitBuilder!!.build(retrofitBuilder!!.BASE_URL_POST)
            val postRequestModel = PostRequestModel("IT wala")
            val call = retrofitBuilder!!.callApi().postHeros(postRequestModel)
            call!!.enqueue(object : Callback<PostResponseModel?> {
                override fun onResponse(
                    call: Call<PostResponseModel?>,
                    response: Response<PostResponseModel?>
                ) {
                    txtResultValue.text = response.body().toString()
                    progressBar.visibility = View.GONE
                }

                override fun onFailure(call: Call<PostResponseModel?>, t: Throwable) {
                    progressBar.visibility = View.GONE
                }
            })
        }
    }
}