package com.example.aldiros.modul3_aldirostiawan_1202150104;

/**
 * Created by aldiros on 25/02/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    ImageView botol;
    TextView volume;
    int level = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        int gambar = intent.getExtras().getInt("gambar");
        String nama = intent.getStringExtra("nama");
        String komposisis = intent.getStringExtra("komposisi");
        ImageView gambarDetail = (ImageView) findViewById(R.id.detailGambar);
        TextView namaMenu = (TextView) findViewById(R.id.detailNama);
        TextView detail_deskripsi = (TextView) findViewById(R.id.detailDeskripsi);


        gambarDetail.setImageResource(gambar);
        namaMenu.setText(nama);
        detail_deskripsi.setText(komposisis);



        botol = (ImageView) findViewById(R.id.isiBotol); //menginisaisi konten yang ada pada layout
        volume = (TextView) findViewById(R.id.liter);
        volume();
    }


//    pada saat botol diklik, maka text Liter akan bertambah dan berkurang sesuai method
    public void volume(){
        switch (level){
            case 0:volume.setText("1L");break;
            case 1:volume.setText("2L");break;
            case 2:volume.setText("3L");break;
            case 3:volume.setText("4L");break;
            case 4:volume.setText("5L");break;
            case 5:volume.setText("Full");break;

        }

    }

//    method untuk menambah volume air
    public void tambah(View view) {
        if (level < 5) {
            level++;
            botol.setImageLevel(level);
        } else {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Sudah mencapai batas maksimal", Toast.LENGTH_SHORT);
            toast.show();
        }
        volume();
    }

//    method untuk mengurangi volume air
    public void kurang(View view) {
        if (level > 0) {
            level--;
            botol.setImageLevel(level);
        } else  {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Air terlalu sedikit", Toast.LENGTH_SHORT);
            toast.show();
        }
        volume();
    }
}