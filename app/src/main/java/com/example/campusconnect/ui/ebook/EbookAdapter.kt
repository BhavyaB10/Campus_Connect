package com.example.campusconnect.ui.ebook

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.campusconnect.R

class EbookAdapter(private val context: Context, private val list: List<EbookData>) :
    RecyclerView.Adapter<EbookAdapter.EbookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EbookViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ebook_item_layout, parent, false)
        return EbookViewHolder(view)
    }


    override fun onBindViewHolder(holder: EbookViewHolder, position: Int) {

        holder.ebookName.text = list[position].pdfTitle
        println("Title--------------"+list[position].pdfTitle)
        holder.itemView.setOnClickListener {

            val intent = Intent(context, PdfViewer::class.java)
            intent.putExtra("pdfUrl", list.get(position).pdfUrl)
            context.startActivity(intent)
        }

        holder.ebookDownload.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(list[position].pdfUrl)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class EbookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ebookName: TextView
        val ebookDownload: ImageView

        init {
            ebookName = itemView.findViewById(R.id.ebookName)
            ebookDownload = itemView.findViewById(R.id.ebookDownload)
        }
    }
}