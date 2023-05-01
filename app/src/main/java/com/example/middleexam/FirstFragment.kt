package com.example.middleexam
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide

class FirstFragment(): Fragment(){
    @SuppressLint("MissingInflatedId")
    public override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val mView: View =inflater.inflate(R.layout.item_rvbanner, container, false)
        val back=mView.findViewById<ImageView>(R.id.iv_back)
        val author=mView.findViewById<TextView>(R.id.tv_author)
        val introduce=mView.findViewById<TextView>(R.id.tv_introduce)
        val myviewmodel by lazy{
            ViewModelProvider(this)[MainViewModel::class.java]
        }
        val bundle = arguments
          val email = bundle!!.getInt("data")
        myviewmodel.apply {
            getData()
            gettopStoryLifeData().observe(viewLifecycleOwner){
                Glide.with(requireContext()).load(it[email].image).into(back)
                author.text=it[email].hint
                introduce.text=it[email].title
            }
        }

        return mView
    }

    public override fun onViewCreated(
        view: android.view.View,
        savedInstanceState: android.os.Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
    }
}