
package com.example.makanansederhana;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.makanansederhana.model.Menu;

import java.util.List;

public class GaleriActivity  extends AppCompatActivity {

    List<Menu> menus;
    int indeksTampil =0;
    String jenisMenu;
    Button btnPertama,btnTerakhir,btnSebelumnya,btnBerikutnya;
    TextView txJudul,txNama,txDeskripsi;
    ImageView ivFotoMenu;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.propil_nama);
        Intent intent = getIntent();
        jenisMenu = intent.getStringExtra(MainActivity.JENIS_GALERI_KEY);
        menus = DataProvider.getMenusByTipe(this,jenisMenu);
        inisialisasiView();
        tampilkanPropil();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void inisialisasiView(){

        btnPertama =findViewById(R.id.btnPertama);
        btnSebelumnya =findViewById(R.id.btnSebelumnya);
        btnBerikutnya =findViewById(R.id.btnBerikutnya);
        btnTerakhir =findViewById(R.id.btnTerakhir);

        btnPertama.setOnClickListener(view -> menuPertama());
        btnTerakhir.setOnClickListener(view -> menuTerakhir());
        btnSebelumnya.setOnClickListener(view -> menuSebelumnya());
        btnBerikutnya.setOnClickListener(view -> menuBerikutnya());

        txNama =findViewById(R.id.txNama);
        txDeskripsi=findViewById(R.id.txDeskripsi);
        ivFotoMenu = findViewById(R.id.gambarSayuran);

        txJudul =findViewById(R.id.txJudul);
        txJudul.setText("Berbagai Macam Nama" +jenisMenu);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void tampilkanPropil() {

        Menu p=menus.get(indeksTampil);
       Log.d("Pencernaan","Menampilkan Pencernaan"+p.getJenis());
       txNama.setText(p.getNama());
       txDeskripsi.setText(p.getDeskripsi());

       ivFotoMenu.setImageDrawable(this.getDrawable(p.getGambar()));
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void menuPertama() {
        int posAwal = 0;
        if (indeksTampil == posAwal) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAwal;
            tampilkanPropil();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void menuTerakhir() {
        int posAkhir = menus.size() - 1;
        if (indeksTampil == posAkhir) {
            Toast.makeText(this,"Sudah di posisi_terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil = posAkhir;
            tampilkanPropil();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void menuBerikutnya() {
        if (indeksTampil == menus.size() - 1) {
            Toast.makeText(this,"Sudah di posisi terakhir",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil++;
            tampilkanPropil();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void menuSebelumnya() {
        if (indeksTampil == 0) {
            Toast.makeText(this,"Sudah di posisi pertama",Toast.LENGTH_SHORT).show();
            return;
        } else {
            indeksTampil--;
            tampilkanPropil();
        }
    }


}
