package com.example.middleexam

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.middleexam.Tool.BaseActivity
import com.example.middleexam.databinding.ActivityMainBinding

class MainActivity :BaseActivity() {
    private val mybinding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val myviewmodel by lazy{
        ViewModelProvider(this)[MainViewModel::class.java]
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mybinding.root)
        val window=window
        transparentStatusBar(window)
        setSupportActionBar(mybinding.toolbar)
        myviewmodel.apply {
            getData()
//            getDateLifeData().observe(this@MainActivity){
//                mybinding.tvDate.text=it
//            }
            gettopStoryLifeData().observe(this@MainActivity){
             with(mybinding.rvBanner){
                 adapter=BannerRvAdapter(it,this@MainActivity)
                 layoutManager= LinearLayoutManager(this@MainActivity, RecyclerView.HORIZONTAL, false)
             }
            }
        }
    }
}