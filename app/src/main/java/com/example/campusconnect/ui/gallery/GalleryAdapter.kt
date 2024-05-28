package com.example.campusconnect.ui.gallery

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.campusconnect.FullImageView
import com.example.campusconnect.R

class GalleryAdapter(private val context: Context?, private val images: List<String>) :
    RecyclerView.Adapter<GalleryAdapter.GalleryViewAdapter>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewAdapter {
        val view = LayoutInflater.from(context).inflate(R.layout.gallery_image, parent, false)
        return GalleryViewAdapter(view)
    }

    override fun onBindViewHolder(holder: GalleryViewAdapter, position: Int) {
        Glide.with(context!!).load(images[position]).into(holder.imageView)

        holder.imageView.setOnClickListener {
            val intent = Intent(context, FullImageView::class.java)
            intent.putExtra("image", images[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class GalleryViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView

        init {
            imageView = itemView.findViewById(R.id.image)
        }
    }
}
