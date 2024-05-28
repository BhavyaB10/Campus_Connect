package com.example.campusconnect.ui.notice

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.campusconnect.FullImageView
import com.example.campusconnect.R

class NoticeAdapter(private val context: Context?, private val list: ArrayList<NoticeData>) :
    RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewAdapter {
        val view =
            LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false)
        return NoticeViewAdapter(view)
    }

    override fun onBindViewHolder(holder: NoticeViewAdapter, position: Int) {
        val currentItem = list[position]
        holder.noticeTitle.text = currentItem.title
        holder.date.text = currentItem.date
        holder.time.text = currentItem.time
        try {
            if (currentItem.image != null)
                Glide.with(context!!).load(currentItem.image)
                .into(holder.noticeImage)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

        holder.noticeImage.setOnClickListener {
            val intent = Intent(context,FullImageView::class.java)
            intent.putExtra("image",currentItem.image)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

     class NoticeViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val noticeTitle: TextView
        val date : TextView
        val time : TextView
         val noticeImage: ImageView

        init {
            noticeTitle = itemView.findViewById(R.id.noticeTitle)
            noticeImage = itemView.findViewById(R.id.noticeImage)
            date = itemView.findViewById(R.id.date)
            time = itemView.findViewById(androidx.core.R.id.time)
        }
    }
}