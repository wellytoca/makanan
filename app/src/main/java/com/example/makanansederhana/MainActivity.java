package com.example.makanansederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton btnSayuran,btnDaging;
    public static final String JENIS_GALERI_KEY ="JENIS GALERI";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inisialisasiView();

    }

    private void inisialisasiView() {
        btnSayuran = findViewById(R.id.btn_buka_nama_sayuran);
        btnDaging = findViewById(R.id.btn_buka_nama_daging);
        btnSayuran.setOnClickListener(view -> bukaGaleri("Sayuran"));
        btnDaging.setOnClickListener(view -> bukaGaleri("Daging"));
    }

    private void bukaGaleri(String sayuran) {
        Log.d("MAIN","Buka activity Pernapasn");
        Intent intent=new Intent(this,GaleriActivity.class);
        intent.putExtra(JENIS_GALERI_KEY,sayuran);
        startActivity(intent);
    }
}