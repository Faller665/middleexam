package com.example.middleexam

import com.example.middleexam.data.FirstData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface FirstService {
    @GET("api/4/news/latest")
    fun getInternetData1(): Call<FirstData>
    @GET("api/4/news/before/{date}")
    fun getInternetData2(@Path("date")date:Int?):Call<FirstData>
}