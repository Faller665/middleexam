package com.example.middleexam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.middleexam.data.Comment


class AssessRvAdapter(val data:List<Comment>,val context:Context) : RecyclerView.Adapter<AssessRvAdapter.InnerHolder>(){
    class InnerHolder(root: View): RecyclerView.ViewHolder(root) {
       val head2=root.findViewById<ImageView>(R.id.iv_head2)
       val name=root.findViewById<TextView>(R.id.tv_name)
       val assess=root.findViewById<TextView>(R.id.tv_assess)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_assess, parent, false)
        return InnerHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: InnerHolder, position: Int) {
        val itemdata=data[position]
        holder.apply {
            name.text=itemdata.author
            assess.text=itemdata.content
            Glide.with(context).load(itemdata.avatar).into(head2)
        }
    }


}