package com.example.pdfreader_codeclause;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class PdfPage extends AppCompatActivity {

    CardView CardView1,  CardView2, CardView3;
    TextView textView1, textView2, textView3;

    ImageView imageView1, imageView2, imageView3;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_page);

        CardView1 = findViewById(R.id.cardview1);
        CardView2 = findViewById(R.id.cardview2);
        CardView3 = findViewById(R.id.cardview3);

        textView1 = findViewById(R.id.textview1);
        textView2 = findViewById(R.id.textview2);
        textView3 = findViewById(R.id.textview3);

        imageView1 = findViewById(R.id.imageview1);
        imageView2 = findViewById(R.id.imageview2);
        imageView3 = findViewById(R.id.imageview3);

        textView1.setSelected(true);
        textView2.setSelected(true);
        textView3.setSelected(true);

        requestPermission();

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PdfViewer1.class);
                startActivity(intent);


            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PdfViewer2.class);
                startActivity(intent);

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PdfViewer3.class);
                startActivity(intent);

            }
        });


    }

    private void requestPermission(){
        Dexter.withContext(PdfPage.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Toast.makeText(getApplicationContext(), "Permission Granted ! Pdf File Loaded", Toast.LENGTH_SHORT).show();
                CardView1.setVisibility(View.VISIBLE);
                CardView2.setVisibility(View.VISIBLE);
                CardView3.setVisibility(View.VISIBLE);


            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                Toast.makeText(getApplicationContext(), "Permission Denied ! Pdf File not Loaded", Toast.LENGTH_SHORT).show();
                CardView1.setVisibility(View.INVISIBLE);
                CardView2.setVisibility(View.INVISIBLE);
                CardView3.setVisibility(View.INVISIBLE);
                finish();

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();

            }
        }).check();
    }
}