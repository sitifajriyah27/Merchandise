package com.example.merchandise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DerryActivity extends AppCompatActivity {

    ImageView ftDerry1, ftDerry2;
    Button btnDerry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derry);

        ftDerry1 = findViewById(R.id.ftderry1);
        ftDerry2 = findViewById(R.id.ftderry2);
        btnDerry = findViewById(R.id.btnderry);

        ftDerry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DerryActivity.this, DescEstodiaActivity.class));
            }
        });
        ftDerry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DerryActivity.this, DescKokaActivity.class));
            }
        });
        btnDerry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DerryActivity.this, PsnDerryActivity.class));
            }
        });
    }
}
