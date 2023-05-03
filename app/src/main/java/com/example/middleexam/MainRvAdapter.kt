package com.example.middleexam



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.middleexam.data.Story


class MainRvAdapter(val data:List<Story>, private val activity: MainActivity,private val hasMore:Boolean): RecyclerView.Adapter<MainRvAdapter.InnerHolder>() {

    private var clickInterface: ClickInterface? = null
   interface ClickInterface {
       fun  onTitleClick( view:View,  position:Int)
    }

   public fun setOnclick(clickInterface: ClickInterface) {
       this.clickInterface = clickInterface
    }

    class InnerHolder(root: View) : RecyclerView.ViewHolder(root) {
           val title=root.findViewById<TextView>(R.id.tv_title2)
           val hint=root.findViewById<TextView>(R.id.tv_hint)
           val iv1=root.findViewById<ImageView>(R.id.iv_1)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_main, parent, false)
        return InnerHolder(view)
    }
    override fun getItemCount(): Int {
        return data.size
    }
    override fun onBindViewHolder(holder:InnerHolder, position: Int) {
            val itemData=data[position]
            holder.apply {
                title.text=itemData.title
                hint.text=itemData.hint
                val temp=itemData.images.joinToString()
                Glide.with(activity).load(temp).into(iv1)
            }
        holder.title.setOnClickListener {
            clickInterface?.onTitleClick(it,position)
        }
        }
}