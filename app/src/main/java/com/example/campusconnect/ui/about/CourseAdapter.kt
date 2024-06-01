package com.example.campusconnect.ui.about

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.campusconnect.R

class CourseAdapter(private val context: Context?, private val list: List<Course>) : PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view =
            LayoutInflater.from(context).inflate(R.layout.branch_item_layout, container, false)
        val brTitle: TextView
        val brDesc: TextView
        brTitle = view.findViewById(R.id.branch_title)
        brDesc = view.findViewById(R.id.branch_description)

        brTitle.text = list[position].title
        brDesc.text = list[position].description
        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}