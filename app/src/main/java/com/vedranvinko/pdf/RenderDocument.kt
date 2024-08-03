package com.vedranvinko.pdf

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView

class RenderDocument : AppCompatActivity() {

    private lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        pdfView = findViewById(R.id.pdfView)

        val pdfUriString = intent.getStringExtra("pdfUri")
        val pdfUri = Uri.parse(pdfUriString)
        pdfView.fromUri(pdfUri).load()
    }
}