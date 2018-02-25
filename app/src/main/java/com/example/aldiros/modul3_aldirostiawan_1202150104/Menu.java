package com.example.aldiros.modul3_aldirostiawan_1202150104;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by aldiros on 25/02/2018.
 */

public class Menu {
    private int gambar ;
    private String nama, info, komposisi;
    public Menu(int gambar, String nama, String komposisi, String info ) {
        this.gambar = gambar;
        this.nama = nama;
        this.info = info;
        this.komposisi = komposisi;
    }

    public String getDetails() {
        return info;
    }

    public String getNama() {
        return nama;
    }

    public int getGambar() {
        return gambar;
    }
    public String getKomposisi() {
        return komposisi;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public void setHarga(String harga) {
        this.info = harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


}
