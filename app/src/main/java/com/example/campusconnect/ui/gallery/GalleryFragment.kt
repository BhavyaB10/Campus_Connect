package com.example.campusconnect.ui.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.campusconnect.R
import com.google.firebase.database.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class GalleryFragment : Fragment() {
    lateinit var convoRecyclerView: RecyclerView
    lateinit var independenceRV: RecyclerView
    lateinit var otherRecyclerView: RecyclerView
    lateinit var adapter: GalleryAdapter
    private lateinit var reference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_gallery, container, false)
        convoRecyclerView=view.findViewById(R.id.convocationRecyclerView)
        otherRecyclerView=view.findViewById(R.id.image2RecyclerView)
        independenceRV=view.findViewById(R.id.independenceRecyclerView)

        reference=FirebaseDatabase.getInstance().reference.child("gallery")

        getConvoImage()

        getOtherImage()

        getIndependenceDayImage()

        return view
    }

    private fun getOtherImage() {
        reference.child("Other Events").addValueEventListener(object : ValueEventListener {

            val imageList : List<String> = ArrayList()
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(snapshot : DataSnapshot in dataSnapshot.children){
                   val data : String = snapshot.value.toString()
                    (imageList as ArrayList<String> ).add(data)

                }
                adapter=GalleryAdapter(context,imageList)
                otherRecyclerView.layoutManager=GridLayoutManager(context,3)
                otherRecyclerView.setHasFixedSize(true)
                otherRecyclerView.adapter=adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"Something went wrong",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getConvoImage() {
        reference.child("Convocation").addValueEventListener(object : ValueEventListener {

            val imageList : List<String> = ArrayList()

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(snapshot : DataSnapshot in dataSnapshot.children){
                    val data : String = snapshot.value.toString()
                    (imageList as ArrayList<String> ).add(data)

                }
                adapter=  GalleryAdapter(context,imageList)
                convoRecyclerView.layoutManager=GridLayoutManager(context,3)
                convoRecyclerView.setHasFixedSize(true)
                convoRecyclerView.adapter=adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"Something went wrong",Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun getIndependenceDayImage() {
        reference.child("Independence Day").addValueEventListener(object : ValueEventListener {

            val imageList : List<String> = ArrayList()

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for(snapshot : DataSnapshot in dataSnapshot.children){
                    val data : String = snapshot.value.toString()
                    (imageList as ArrayList<String> ).add(data)

                }
                adapter= GalleryAdapter(context,imageList)
                independenceRV.layoutManager=GridLayoutManager(context,3)
                independenceRV.setHasFixedSize(true)
                independenceRV.adapter=adapter
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"Something went wrong",Toast.LENGTH_SHORT).show()
            }
        })
    }
}