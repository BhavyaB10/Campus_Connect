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
    private lateinit var viewPager: ViewPager
    private lateinit var crAdapter: CourseAdapter
    lateinit var list: List<Course>

     private val handler = Handler(Looper.getMainLooper())
    private var currentPage = 6
    private val delayMs: Long = 3000

        private val delayMs: Long = 3000

    private val runnable = object : Runnable {
        override fun run() {
            if (crAdapter.count > 0) {
                currentPage = (currentPage + 1) % crAdapter.count
                viewPager.setCurrentItem(currentPage, true)
                handler.postDelayed(this, delayMs)
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        val list = ArrayList<Course>()
        list.add(
            Course(
                "Computer Engineering",
                "Computer Engineering at IET DAVV focuses on developing expertise in computer systems, software development, and algorithms. Core courses include Programming and Data Structures, Algorithms, Computer Networks, Operating Systems, and Database Management Systems. Graduates are prepared for careers in software development, systems design, and IT consulting."
            )
        )
        list.add(
            Course(
                "Information Technology",
                "The Information Technology program covers key areas such as Web Technologies, Software Engineering, Information Security, Data Mining, and Cloud Computing. This branch equips students with skills to excel in IT infrastructure, cybersecurity, and data analytics roles, catering to the growing demand for IT professionals."
            )
        )
        list.add(
            Course(
                "Electronics and Telecommunication Engineering",
                "Combining electronics with measurement and control, this branch covers Control Systems, Instrumentation Devices, Sensors and Transducers, Process Control, and Industrial Automation. It prepares students for roles in automation, instrumentation, and control engineering sectors."
            )
        )
        list.add(
            Course(
                "Mechanical Engineering",
                "Mechanical Engineering includes Thermodynamics, Fluid Mechanics, Machine Design, Manufacturing Processes, and Heat Transfer. Students are trained for careers in design, manufacturing, and thermal engineering, addressing the mechanical needs of various industries."
            )
        )
        list.add(
            Course(
                "Civil Engineering",
                "Civil Engineering focuses on Structural Analysis, Geotechnical Engineering, Transportation Engineering, Environmental Engineering, and Construction Management. Graduates are equipped to work in construction, urban planning, and infrastructure development, contributing to building and maintaining essential public works."
            )
        )
        list.add(
            Course(
                "Electronics and Instrumentation Engineering",
                "Combining electronics with measurement and control, this branch covers Control Systems, Instrumentation Devices, Sensors and Transducers, Process Control, and Industrial Automation. It prepares students for roles in automation, instrumentation, and control engineering sectors."
            )
        )


        crAdapter = CourseAdapter(context, list)

        viewPager = view.findViewById(R.id.viewPager)

        viewPager.adapter = crAdapter

        val imageView: ImageView = view.findViewById(R.id.college_image)

        Glide.with(context!!)
            .load("https://firebasestorage.googleapis.com/v0/b/my-college-app-9a831.appspot.com/o/gallery%2FUntitled.jpg?alt=media&token=fe905be7-40ac-4a3b-914d-9b2fa7928470")
            .into(imageView)

        return view
    }
        override fun onPause() {
        super.onPause()
        // Stop the handler when the fragment is not visible
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        // Resume the handler when the fragment is visible again
        handler.postDelayed(runnable, delayMs)
    }

}
