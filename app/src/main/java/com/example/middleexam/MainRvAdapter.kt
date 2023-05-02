package com.example.middleexam



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.middleexam.data.Story



class MainRvAdapter(private val data:List<Story>, private val activity: MainActivity,private val hasMore:Boolean): RecyclerView.Adapter<MainRvAdapter.InnerHolder>() {


    private val normalType = 0 // 第一种ViewType，正常的item

    private val footType = 1 // 第二种ViewType，底部的提示View

    private val fadeTips = false // 变量，是否隐藏了底部的提示
    private lateinit var view:View
    class InnerHolder(root: View) : RecyclerView.ViewHolder(root) {
           val title=root.findViewById<TextView>(R.id.tv_title2)
           val hint=root.findViewById<TextView>(R.id.tv_hint)
           val iv1=root.findViewById<ImageView>(R.id.iv_1)
    }

    internal class FootHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       val tips=itemView.findViewById<TextView>(R.id.tv_footview)
    }


    // 获取条目数量，之所以要加1是因为增加了一条footView
    override fun getItemCount(): Int {
        return data.size
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_main, parent, false)
        return InnerHolder(view)
    }

    override fun onBindViewHolder(holder:InnerHolder, position: Int) {

            val itemData=data[position]
            holder.apply {
                title.text=itemData.title
                hint.text=itemData.hint
                val temp=itemData.images.joinToString()
                Glide.with(activity).load(temp).into(iv1)
            }
        }
}