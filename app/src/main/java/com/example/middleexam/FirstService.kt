package com.example.middleexam

import com.example.middleexam.data.FirstData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET


interface FirstService {
    @GET("api/4/news/latest")
    fun getInternetData(): Call<FirstData>
}