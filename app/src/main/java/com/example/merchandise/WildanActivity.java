package com.example.merchandise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WildanActivity extends AppCompatActivity {

    ImageView ftWildan1, ftWildan2, ftWildan3, ftWildan4;
    Button btnWildan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildan);

        ftWildan1 = findViewById(R.id.ftwildan1);
        ftWildan2 = findViewById(R.id.ftwildan2);
        ftWildan3 = findViewById(R.id.ftwildan3);
        ftWildan4 = findViewById(R.id.ftwildan4);
        btnWildan = findViewById(R.id.btnwildan);

        ftWildan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WildanActivity.this, DescKaos1Activity.class));
            }
        });
        ftWildan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WildanActivity.this, DescKaos2Activity.class));
            }
        });
        ftWildan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WildanActivity.this, DescHoodie1Activity.class));
            }
        });
        ftWildan4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WildanActivity.this, DescHoodie2Activity.class));
            }
        });
        btnWildan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WildanActivity.this, PsnWildanActivity.class));
            }
        });
    }

}
