package com.example.middleexam

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.middleexam.data.FirstData
import com.example.middleexam.data.TopStory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainViewModel :ViewModel(){

    private val topStoryLifeData by lazy {
        MutableLiveData<List<TopStory>>()
    }

    fun gettopStoryLifeData(): MutableLiveData<List<TopStory>>{
        return topStoryLifeData
    }
    fun getData(){
        val retrofit=Retrofit.Builder()
            .baseUrl("https://news-at.zhihu.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val testService=retrofit.create(FirstService::class.java)
        testService.getInternetData().enqueue(object :Callback<FirstData>{
            override fun onResponse(call: Call<FirstData>, response: Response<FirstData>) {
                val data=response.body()
                if (data!=null){
                    topStoryLifeData.postValue(data.top_stories)
                }
            }

            override fun onFailure(call: Call<FirstData>, t: Throwable) {

            }

        }
        )
    }

}