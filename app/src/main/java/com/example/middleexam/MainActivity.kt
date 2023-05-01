package com.example.middleexam

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.middleexam.Tool.BaseActivity
import com.example.middleexam.databinding.ActivityMainBinding

class MainActivity :BaseActivity() {
    private val mybinding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val myviewmodel by lazy{
        ViewModelProvider(this)[ViewModel::class.java]
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mybinding.root)
        val window=window
        transparentStatusBar(window)
        setSupportActionBar(mybinding.toolbar)

        myviewmodel.apply {
            getDataInMain()
            get_StoryLIfeData().observe(this@MainActivity){
                mybinding.rv.apply {
                    adapter=MainRvAdapter(it,this@MainActivity)
                    layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }
        }

        var fragments= ArrayList<BackFragment>()
        for (i in 0..4){
           val itemfragment:FirstFragment= FirstFragment()
           val bundle: Bundle=  Bundle()
            bundle.putInt("data",i)
            itemfragment.arguments = bundle
            fragments.add(object : BackFragment {
                override fun back(): Fragment {
                    return itemfragment
                }
            })
        }
        val fragmentadapter:FragmentAdapter= FragmentAdapter(this,fragments)
        mybinding.vp2.adapter=fragmentadapter

    }
}