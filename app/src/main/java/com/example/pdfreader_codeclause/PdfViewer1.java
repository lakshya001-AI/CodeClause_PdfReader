package com.example.pdfreader_codeclause;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

import java.io.IOException;

public class PdfViewer1 extends AppCompatActivity {

    PDFView pdfview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer1);

        pdfview1 = findViewById(R.id.pdfView1);

       pdfview1.fromAsset("pdf1.pdf").load();




    }
}