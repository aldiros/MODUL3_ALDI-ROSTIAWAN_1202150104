package com.example.aldiros.modul3_aldirostiawan_1202150104;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity {
    Button login;
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        login = (Button) findViewById(R.id.btn_login);
        user = (EditText) findViewById(R.id.txt_user);
        pass = (EditText) findViewById(R.id.txt_pass);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

//    logika untuk login menggunakan username EAD dan password mobile
    public void login(){
        String username = user.getText().toString().trim();
        String password = pass.getText().toString().trim();
        if (username.equals("EAD") && password.equals("mobile")){
            Intent loginIntent = new Intent(homeActivity.this, MenuAir.class);
            startActivity(loginIntent);
            Toast.makeText(this, "Selamat Datang di Toko Air Mineral", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Username dan Password yang Anda masukan Salah, " +
                    "Mohon Periksa Kembali", Toast.LENGTH_LONG).show();
        }
    }
}
