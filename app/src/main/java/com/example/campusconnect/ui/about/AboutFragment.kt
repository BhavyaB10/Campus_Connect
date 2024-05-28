package com.example.campusconnect.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.campusconnect.R


class AboutFragment : Fragment() {
    private lateinit var viewPager : ViewPager
    private lateinit var crAdapter: CourseAdapter
    lateinit var list: List<Course>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_about, container, false)

        val list = ArrayList<Course>()
        list.add(Course(R.drawable.ic_cs,"Computer Science","Computer Science is branch gfchgjjlkjm"))
        list.add(Course(R.drawable.ic_mechanical,"Mechanical","Mechanical is toughest branch of engineering contain various subfields and also known as master branch of engineering"))

        crAdapter= CourseAdapter(context,list)

        viewPager=view.findViewById(R.id.viewPager)

        val imageView : ImageView=view.findViewById(R.id.college_image)

        Glide.with(context!!).load("https://firebasestorage.googleapis.com/v0/b/my-college-app-9a831.appspot.com/o/Iet.webp?alt=media&token=498e3601-1894-49c4-ad34-7e6a5fa3a4af")
            .into(imageView)

        return view
    }

}