package com.example.campusconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.github.chrisbanes.photoview.PhotoView

class FullImageView : AppCompatActivity() {
    private lateinit var imageView: PhotoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image_view)
        imageView=findViewById(R.id.imageView)

        val image : String? = intent.getStringExtra("image")

        Glide.with(this).load(image).into(imageView)
    }
}