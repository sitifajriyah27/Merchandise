package com.example.merchandise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PsnWildanActivity extends AppCompatActivity {

    private Button Pilih, Btn1, Btn2;
    private TextView Jml1;
    Integer valuejml = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psn_wildan);

        Btn1 = findViewById(R.id.btn1);
        Btn2 = findViewById(R.id.btn2);
        Jml1 = findViewById(R.id.jumlah1);
        Pilih = findViewById(R.id.pilih);

        if (savedInstanceState != null){
            String nilaiSaved = savedInstanceState.getString("nlai");
            Jml1.setText(nilaiSaved);
        }

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejml += 1;
                Jml1.setText(valuejml.toString());
            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valuejml > 1){
                    valuejml -= 1;
                    Jml1.setText(valuejml.toString());
                }
            }
        });

        Pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PsnWildanActivity.this, KeranjangActivity.class));
            }
        });
    }
}
