package com.example.middleexam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.middleexam.data.TopStory


class BannerRvAdapter(private val data:List<TopStory>,private val activity: MainActivity): RecyclerView.Adapter<BannerRvAdapter.InnerHolder>() {

    class InnerHolder(root: View) : RecyclerView.ViewHolder(root) {
           val author=root.findViewById<TextView>(R.id.tv_author)
           val back=root.findViewById<ImageView>(R.id.iv_back)
           val introduce=root.findViewById<TextView>(R.id.tv_introduce)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_rvbanner, parent, false)
        return InnerHolder(view)
    }

    override fun getItemCount(): Int {
     return data.size
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
           val itemData=data[position]
        holder.apply {
            author.text=itemData.hint
            introduce.text=itemData.title
            Glide.with(activity).load(itemData.image).into(back)
        }
    }
}