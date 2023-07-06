package com.example.pdfreader_codeclause;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfViewer2 extends AppCompatActivity {

    PDFView pdfview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer2);

        pdfview2 = findViewById(R.id.pdfView2);
        pdfview2.fromAsset("pdf2.pdf").load();
    }
}