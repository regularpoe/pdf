package com.vedranvinko.pdf

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val openBtn = findViewById<Button>(R.id.openBtn)
        openBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "application/pdf"

            startActivityForResult(intent, REQUEST_PDF_PICKER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_PDF_PICKER && resultCode == RESULT_OK && data?.data != null) {
            val pdfUri = data.data
            val intent = Intent(this, RenderDocument::class.java)
            intent.putExtra("pdfUri", pdfUri.toString())
            startActivity(intent)
        }
    }

    companion object {
        private const val REQUEST_PDF_PICKER = 1001
    }

}


