package com.example.merchandise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class RicisActivity extends AppCompatActivity {

    ImageView ftRicis1, ftRicis2, ftRicis3, ftRicis4;
    Button btnRicis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ricis);

        ftRicis1 = findViewById(R.id.ftricis1);
        ftRicis2 = findViewById(R.id.ftricis2);
        ftRicis3 = findViewById(R.id.ftricis3);
        ftRicis4 = findViewById(R.id.ftricis4);
        btnRicis = findViewById(R.id.btnricis);

        ftRicis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RicisActivity.this, DescJilbab1Activity.class));
            }
        });
        ftRicis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RicisActivity.this, DescJilbab2Activity.class));
            }
        });
        ftRicis3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RicisActivity.this, DescJilbab3Activity.class));
            }
        });
        ftRicis4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RicisActivity.this, DescJilbab4Activity.class));
            }
        });
        btnRicis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RicisActivity.this, PsnRicisActivity.class));
            }
        });
    }
}
