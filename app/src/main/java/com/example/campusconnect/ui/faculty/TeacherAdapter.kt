package com.example.campusconnect.ui.faculty
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.campusconnect.R


class TeacherAdapter(private val list: List<TeacherData>, private val context: Context?) :
    RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewAdapter {
        val view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false)
        return TeacherViewAdapter(view)
    }

    override fun onBindViewHolder(holder: TeacherViewAdapter, position: Int) {
        val item = list[position]
        holder.name.text = item.name
        holder.email.text = item.email
        holder.post.text = item.post
        try {
            Glide.with(context!!).load(item.image).placeholder(R.drawable.user).into(holder.imageView)
        } catch (e: Exception) {
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class TeacherViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var email: TextView
        var post: TextView
        var imageView: ImageView

        init {
            name = itemView.findViewById(R.id.teacherName)
            email = itemView.findViewById(R.id.teacherEamil)
            post = itemView.findViewById(R.id.teacherPost)
            imageView = itemView.findViewById(R.id.teacherImage)
        }
    }
}