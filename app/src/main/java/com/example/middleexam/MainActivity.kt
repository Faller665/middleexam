package com.example.middleexam

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewConfiguration
import android.widget.Toast
import androidx.core.view.ViewConfigurationCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.middleexam.Tool.BaseActivity
import com.example.middleexam.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity :BaseActivity() {
    private val mybinding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val myviewmodel by lazy{
        ViewModelProvider(this)[ViewModel::class.java]
    }
   private lateinit var fragmentadapter:FragmentAdapter
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

        mybinding.swipe.setOnRefreshListener {
            myviewmodel.getDataInMain()
            if (mybinding.swipe.isRefreshing){
                mybinding.swipe.isRefreshing=false
                Toast.makeText(this, "数据刷新完成", Toast.LENGTH_SHORT).show()
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
         fragmentadapter= FragmentAdapter(this,fragments)
        mybinding.vp2.apply {
            adapter=fragmentadapter
//            setOnTouchListener(object :OnTouchListener{
//                var Flage1=0
//                var x:Float= 0F
//                var y:Float= 0F
//                val configuration: ViewConfiguration = ViewConfiguration.get(context);
//                val mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration);
//
//                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                    if (event != null) {
//                        when(event.action){
//                            MotionEvent.ACTION_DOWN->{
//                                Flage1=0
//                                x = event.x
//                                y = event.y
//                            }
//                            MotionEvent.ACTION_MOVE->{
//                                val xDiff = abs(event.x - x)
//                                val yDiff = abs(event.y - y)
//                                if (xDiff <mTouchSlop && xDiff >= yDiff){
//                                    Flage1=1
//                                }else{
//                                    Flage1=0
//                                }
//                            }
//                            MotionEvent.ACTION_UP->{
//                                if (Flage1==0){
//                                    Toast.makeText(this@MainActivity, "nsibcbsuvb", Toast.LENGTH_SHORT).show()
//                                }
//                            }
//                        }
//                    }
//                    return false
//                }
//
//            })
        }
    }
}