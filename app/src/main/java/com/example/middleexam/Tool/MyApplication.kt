package com.example.middleexam.Tool

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Looper



class MyApplication:Application() {

    companion object{
        lateinit var mcontext: MyApplication
    }
    override fun onCreate() {
        super.onCreate()
        mcontext =this
        Handler(Looper.myLooper()!!).post {
            while (true){
                try {
                    Looper.loop()
                }catch (e:java.lang.Exception){

                }
            }
        }
    }
  fun getcontext():Context{
return mcontext
  }
}