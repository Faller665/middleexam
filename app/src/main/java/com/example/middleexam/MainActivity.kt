package com.example.middleexam

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.middleexam.Tool.BaseActivity
import com.example.middleexam.data.Story
import com.example.middleexam.databinding.ActivityMainBinding


class MainActivity :BaseActivity() {
    private val mybinding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val myviewmodel by lazy{
        ViewModelProvider(this)[ViewModel::class.java]
    }
   private lateinit var fragmentadapter:FragmentAdapter
   private var temp=mutableListOf<Story>()
    private var m:Int=20220429
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mybinding.root)
        val window=window
        transparentStatusBar(window)
        setSupportActionBar(mybinding.toolbar)

        myviewmodel.apply {
            getDataInMain1()
            get_StoryLIfeData().observe(this@MainActivity) {
                var temp1=it.plus(temp)
                temp=it as  MutableList<Story>
                mybinding.rv.apply {
                    adapter = MainRvAdapter(temp1, this@MainActivity, true)
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    addOnScrollListener(object :RecyclerView.OnScrollListener(){
                        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                            var lastPosition = -1
                            if(newState == RecyclerView.SCROLL_STATE_IDLE){
                                lastPosition = (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                            }
                            if(lastPosition == (layoutManager as LinearLayoutManager).itemCount -1){
                                m-=1
                                Toast.makeText(this@MainActivity, "正在加载", Toast.LENGTH_SHORT).show()
                                myviewmodel.getDataInMain2(m)
                            }
                        }})
            }
        }}


        mybinding.swipe.setOnRefreshListener {
            myviewmodel.getDataInMain1()
            if (mybinding.swipe.isRefreshing){
                mybinding.swipe.isRefreshing=false
                Toast.makeText(this, "刷新成功", Toast.LENGTH_SHORT).show()
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

}}