package com.example.middleexam

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
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
        val adapter:FragmentAdapter= FragmentAdapter(this,fragments)
        mybinding.vp2.adapter=adapter
    }
}