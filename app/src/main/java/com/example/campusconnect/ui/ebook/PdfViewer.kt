package com.example.campusconnect.ui.ebook

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.campusconnect.R
import com.github.barteksc.pdfviewer.PDFView
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class PdfViewer : AppCompatActivity() {
      private var url : String? = null
     lateinit var pdfView : PDFView
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_viewer)

        pdfView=findViewById(R.id.pdfView)
        progressBar=findViewById(R.id.progressBar)

        url = intent.getStringExtra("pdfUrl").toString()
        pdfDownload().execute(url)
    }


     inner class  pdfDownload : AsyncTask<String, Void, InputStream>() {
        @Deprecated("Deprecated in Java")
        override fun doInBackground(vararg strings: String?): InputStream?
        {
            var inputStream : InputStream? = null
            try{
                val url : URL = URL(strings[0])
               val urlConnection : HttpURLConnection = url.openConnection() as HttpURLConnection

                if(urlConnection.responseCode==200)
                {
                    inputStream = BufferedInputStream(urlConnection.inputStream)
                }
                else{

                }
            }
            catch(e : IOException){
                e.printStackTrace()
            }
            return inputStream
        }
        override fun onPostExecute(inputStream: InputStream?) {
            inputStream?.let {
               pdfView.fromStream(it).load()
                progressBar.visibility=View.GONE
            }
        }
    }

}