package com.example.middleexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.middleexam.Tool.BaseActivity
import com.example.middleexam.databinding.ActivityAssessBinding
import com.example.middleexam.databinding.ActivityMainBinding

class Assess : BaseActivity() {
    private val mybinding: ActivityAssessBinding by lazy { ActivityAssessBinding.inflate(layoutInflater) }
    val myviewmodel by lazy{
        ViewModelProvider(this)[ViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mybinding.root)
        val window=window
        transparentStatusBar(window)
        val id:Int=intent.getIntExtra("id",0)
        myviewmodel.apply {
            getDataInAssess(id)
            get_assessLIfeData().observe(this@Assess){
                mybinding.rvAssess.apply {
                    Log.d("TAG", "onCreate: d ,mfpo")
                    adapter=AssessRvAdapter(it,this@Assess)
                    layoutManager= LinearLayoutManager(this@Assess)
                }
            }
        }

    }
}