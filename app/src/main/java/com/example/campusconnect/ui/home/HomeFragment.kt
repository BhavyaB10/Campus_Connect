package com.example.campusconnect.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.campusconnect.R

class HomeFragment : Fragment() {
    private lateinit var slider: ImageSlider
    private  lateinit var map:ImageView
    private  lateinit var CS : TextView
    private lateinit var IT : TextView
    private  lateinit var MECH : TextView
    private  lateinit var ETC : TextView
    private lateinit var Civil : TextView
    private  lateinit var EI : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view : View=inflater.inflate(R.layout.fragment_home, container, false)

        slider=view.findViewById(R.id.slider)

        CS=view.findViewById(R.id.CS)
        IT=view.findViewById(R.id.IT)
        MECH=view.findViewById(R.id.Mech)
        ETC=view.findViewById(R.id.ETC)
        EI=view.findViewById(R.id.EI)
        Civil=view.findViewById(R.id.Civil)

        CS.setOnClickListener { startActivity(Intent(context,Computer_Science::class.java)) }
        IT.setOnClickListener { startActivity(Intent(context,Information_Technology::class.java)) }
        ETC.setOnClickListener { startActivity(Intent(context,E_and_TC::class.java)) }
        MECH.setOnClickListener { startActivity(Intent(context,Mechanical::class.java)) }
        EI.setOnClickListener { startActivity(Intent(context,E_and_I::class.java)) }
        Civil.setOnClickListener { startActivity(Intent(context,CIVIL::class.java))}


        val imageList = listOf(
            SlideModel(R.drawable.iet, "IET DAVV"),
            SlideModel(R.drawable.college_two, "AUDITORIUM"),
            SlideModel(R.drawable.college_three, "PLACEMENTS"),
            SlideModel(R.drawable.iet_one, "LABS"),
            SlideModel(R.drawable.akshank, "AAKSHANK")

        )



        slider.setImageList(imageList, ScaleTypes.FIT)
        slider.startSliding(1000)
//        slider.setIndicatorAnimation(IndicatorAnimations.WORM)
//        slider.setIndicatorStyle(IndicatorStyle.WORM)
//        slider.setIndicatorVisibility(true)

        map=view.findViewById(R.id.map)

        map.setOnClickListener {

            openMap()
        }

         return view
    }

    private fun openMap() {
        val uri: Uri =Uri.parse("geo:0 , 0?q=Institute of Engineering and Technology,Khandwa Road ,Indore")
        val intent= Intent(Intent.ACTION_VIEW,uri)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

}