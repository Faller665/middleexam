package com.example.middleexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.middleexam.Tool.BaseActivity
import com.example.middleexam.databinding.ActivityMainBinding
import com.example.middleexam.databinding.ActivityWebBinding

class Web : BaseActivity() {
    private val mybinding:ActivityWebBinding by lazy { ActivityWebBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mybinding.root)
        val window=window
        transparentStatusBar(window)
        val temp:String?=intent.getStringExtra("url")
        val id:Int=intent.getIntExtra("id",0)
//        webview的使用
        mybinding.web.loadUrl(temp as String)
        mybinding.web.setWebViewClient(object :WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                view?.loadUrl(temp)
                return true
            }
        })

        mybinding.btNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.assess -> {
                   val intent= Intent(this,Assess::class.java)
                    intent.putExtra("id",id)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                else -> {return@setOnItemSelectedListener true}
            }
        }

    }
}