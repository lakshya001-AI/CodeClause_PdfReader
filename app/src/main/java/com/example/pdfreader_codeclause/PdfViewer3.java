package com.example.pdfreader_codeclause;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewer3 extends AppCompatActivity {

    PDFView pdfview3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer3);

        pdfview3 = findViewById(R.id.pdfView3);
        pdfview3.fromAsset("pdf3.pdf")
                .enableSwipe(true)
                .load();

    }
}