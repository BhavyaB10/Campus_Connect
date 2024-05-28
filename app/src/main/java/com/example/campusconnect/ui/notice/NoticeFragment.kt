package com.example.campusconnect.ui.notice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.example.campusconnect.R

class NoticeFragment : Fragment() {

    lateinit var deleteNoticeRecyclerView: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var list: ArrayList<NoticeData>
    lateinit var adapter: NoticeAdapter
    lateinit var reference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View= inflater.inflate(R.layout.fragment_notice, container, false)
        deleteNoticeRecyclerView=view.findViewById(R.id.noticeRecyclerView)
        progressBar=view.findViewById(R.id.ProgressBar)

        reference= FirebaseDatabase.getInstance().reference.child("Notice")

        deleteNoticeRecyclerView.layoutManager= LinearLayoutManager(context)
        deleteNoticeRecyclerView.setHasFixedSize(true)


        getNotice()

        return view
    }

    private fun getNotice() {
        reference.addValueEventListener(object : ValueEventListener {
            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list=ArrayList()
                for(snapshot: DataSnapshot in dataSnapshot.children){
                    val data : NoticeData?=snapshot.getValue(NoticeData::class.java)
                    list.add(data!!)
                }

                adapter= NoticeAdapter(context, list )
                adapter.notifyDataSetChanged()
                progressBar.visibility=View.GONE

                deleteNoticeRecyclerView.adapter=adapter
            }

            override fun onCancelled(error: DatabaseError) {
                progressBar.visibility=View.GONE
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}