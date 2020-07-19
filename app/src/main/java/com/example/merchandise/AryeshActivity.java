package com.example.merchandise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class AryeshActivity extends AppCompatActivity {

    ImageView ftAryesh1, ftAryesh2, ftAryesh3, ftAryesh4;
    Button btnAryesh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aryesh);

        ftAryesh1 = findViewById(R.id.ftaryesh1);
        ftAryesh2 = findViewById(R.id.ftaryesh2);
        ftAryesh3 = findViewById(R.id.ftaryesh3);
        ftAryesh4 = findViewById(R.id.ftaryesh4);
        btnAryesh = findViewById(R.id.btnaryesh);

        ftAryesh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(AryeshActivity.this, DescSepatu1Activity.class);
                startActivity(a);
            }
        });
        ftAryesh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(AryeshActivity.this, DescFlatshoesActivity.class);
                startActivity(b);
            }
        });
        ftAryesh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(AryeshActivity.this, DescSepatu2Activity.class);
                startActivity(c);
            }
        });
        ftAryesh4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(AryeshActivity.this, DescTotebagActivity.class);
                startActivity(d);
            }
        });
        btnAryesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AryeshActivity.this, PsnAryeshActivity.class));
            }
        });

    }
}
