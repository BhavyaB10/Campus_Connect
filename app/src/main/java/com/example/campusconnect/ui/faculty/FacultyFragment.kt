package com.example.campusconnect.ui.faculty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.example.campusconnect.R

class FacultyFragment : androidx.fragment.app.Fragment() {
    lateinit var csDep : RecyclerView
    lateinit var itDep : RecyclerView
    lateinit var etcDep : RecyclerView
    lateinit var machDep : RecyclerView
    lateinit var csNoData: LinearLayout
    lateinit var itNoData: LinearLayout
    lateinit var etcNoData: LinearLayout
    lateinit var machNoData: LinearLayout

    lateinit var adapter: TeacherAdapter

    lateinit var list1:List<TeacherData>
    lateinit var list2:List<TeacherData>
    lateinit var list3:List<TeacherData>
    lateinit var list4:List<TeacherData>

    lateinit var reference: DatabaseReference
    lateinit var dbRef: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_faculty, container, false)
        csDep=view.findViewById(R.id.csDepartment)
        itDep=view.findViewById(R.id.itDepartment)
        etcDep=view.findViewById(R.id.etcDepartment)
        machDep=view.findViewById(R.id.mechanicalDepartment)
        csNoData=view.findViewById(R.id.csNoData)
        itNoData=view.findViewById(R.id.itNoData)
        etcNoData=view.findViewById(R.id.etcNoData)
        machNoData=view.findViewById(R.id.mechanicalNoData)

        reference= FirebaseDatabase.getInstance().reference.child("teacher")

        csDepartment()
        itDepartment()
        etcDepartment()
        machDepartment()

        return view
    }

    private fun csDepartment() {

        dbRef=reference.child("Computer Science")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list1=ArrayList()

                if(!dataSnapshot.exists()){
                    csNoData.visibility=View.VISIBLE
                    csDep.visibility=View.GONE
                }else{
                    csNoData.visibility=View.GONE
                    csDep.visibility=View.VISIBLE
                    for(snapshot: DataSnapshot in dataSnapshot.children){
                        val data: TeacherData? = snapshot.getValue(TeacherData::class.java)
                        (list1 as ArrayList<TeacherData>).add(data!!)

                    }
                    csDep.setHasFixedSize(true)
                    csDep.layoutManager = LinearLayoutManager(context)
                    adapter= TeacherAdapter(list1, context!!)
                    csDep.adapter=adapter

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun itDepartment() {

        dbRef=reference.child("IT")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list2=ArrayList()

                if(!dataSnapshot.exists()){
                    itNoData.visibility=View.VISIBLE
                    itDep.visibility=View.GONE
                }else{
                    itNoData.visibility=View.GONE
                    itDep.visibility=View.VISIBLE
                    for(snapshot: DataSnapshot in dataSnapshot.children){
                        val data: TeacherData? = snapshot.getValue(TeacherData::class.java)
                        (list2 as ArrayList<TeacherData>).add(data!!)

                    }
                    itDep.setHasFixedSize(true)
                    itDep.layoutManager = LinearLayoutManager(context)
                    adapter= TeacherAdapter(list2,context!!)
                    itDep.adapter=adapter

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun etcDepartment() {

        dbRef=reference.child("ETC")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list3=ArrayList()

                if(!dataSnapshot.exists()){
                    etcNoData.visibility=View.VISIBLE
                    etcDep.visibility=View.GONE
                }else{
                    etcNoData.visibility=View.GONE
                    etcDep.visibility=View.VISIBLE
                    for(snapshot: DataSnapshot in dataSnapshot.children){
                        val data: TeacherData? = snapshot.getValue(TeacherData::class.java)
                        (list3 as ArrayList<TeacherData>).add(data!!)

                    }
                    etcDep.setHasFixedSize(true)
                    etcDep.layoutManager = LinearLayoutManager(context)
                    adapter= TeacherAdapter(list3,context!!)
                    etcDep.adapter=adapter

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show()
            }
        })


    }

    private fun machDepartment() {

        dbRef=reference.child("Mechanical")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list4=ArrayList()

                if(!dataSnapshot.exists()){
                    machNoData.visibility=View.VISIBLE
                    machDep.visibility=View.GONE
                }else{
                    machNoData.visibility=View.GONE
                    machDep.visibility=View.VISIBLE
                    for(snapshot: DataSnapshot in dataSnapshot.children){
                        val data: TeacherData? = snapshot.getValue(TeacherData::class.java)
                        (list4 as ArrayList<TeacherData>).add(data!!)

                    }
                    machDep.setHasFixedSize(true)
                    machDep.layoutManager = LinearLayoutManager(context)
                    adapter= TeacherAdapter(list4,context!!)
                    machDep.adapter=adapter

                }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,"Error", Toast.LENGTH_SHORT).show()
            }
        })


    }

}