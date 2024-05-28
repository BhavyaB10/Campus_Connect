package com.example.campusconnect.ui.ebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.example.campusconnect.R

class EBook : AppCompatActivity() {
    lateinit var ebookRecycler:RecyclerView
    private lateinit var reference: DatabaseReference
    lateinit var list: List<EbookData>
    lateinit var adapter: EbookAdapter
    lateinit var progressbar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ebook)

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Ebooks"

        ebookRecycler=findViewById(R.id.ebookRecycler)
        progressbar=findViewById(R.id.progressBar)
        reference=FirebaseDatabase.getInstance().reference.child("pdf")

        getData()

    }

    private fun getData() {
        reference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list=ArrayList()
                progressbar.visibility= View.GONE
               for(snapshot:DataSnapshot in dataSnapshot.children){
                   val data : EbookData? = snapshot.getValue(EbookData::class.java)
                   (list as ArrayList<EbookData>).add(data!!)
               }

                adapter= EbookAdapter(this@EBook,list)
                ebookRecycler.layoutManager = LinearLayoutManager(this@EBook)
                ebookRecycler.adapter=adapter
            }

            override fun onCancelled(error: DatabaseError) {
                progressbar.visibility= View.GONE

                Toast.makeText(applicationContext,error.message,Toast.LENGTH_SHORT).show()
            }

        })
    }
}