package com.example.middleexam

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.middleexam.data.FirstData
import com.example.middleexam.data.Story
import com.example.middleexam.data.TopStory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ViewModel :ViewModel(){

    private val topStoryLifeData by lazy {
        MutableLiveData<List<TopStory>>()
    }
    private val storyLIfeData by lazy {
        MutableLiveData<List<Story>>()
    }
    fun get_topStoryLifeData(): MutableLiveData<List<TopStory>>{
        return topStoryLifeData
    }

    fun get_StoryLIfeData():MutableLiveData<List<Story>>{
        return storyLIfeData
    }
    fun getDataInFragment(){
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
    fun getDataInMain(){
        val retrofit=Retrofit.Builder()
            .baseUrl("https://news-at.zhihu.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val testService=retrofit.create(FirstService::class.java)
        testService.getInternetData().enqueue(object :Callback<FirstData>{
            override fun onResponse(call: Call<FirstData>, response: Response<FirstData>) {
                val data=response.body()
                if (data!=null){
                    storyLIfeData.postValue(data.stories)
                }
            }
            override fun onFailure(call: Call<FirstData>, t: Throwable) {

            }

        }
        )
    }

}