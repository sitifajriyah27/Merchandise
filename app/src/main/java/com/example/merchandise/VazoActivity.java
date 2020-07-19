package com.example.merchandise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class VazoActivity extends AppCompatActivity {

    ImageView ftVazo1, ftVazo2, ftVazo3, ftVazo4;
    Button btnVazo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vazo);

        ftVazo1 = findViewById(R.id.ftvazo1);
        ftVazo2 = findViewById(R.id.ftvazo2);
        ftVazo3 = findViewById(R.id.ftvazo3);
        ftVazo4 = findViewById(R.id.ftvazo4);
        btnVazo = findViewById(R.id.btnvazo);

        ftVazo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VazoActivity.this, DescMasker1Activity.class));
            }
        });
        ftVazo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VazoActivity.this, DescMasker2Activity.class));
            }
        });
        ftVazo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VazoActivity.this, DescMasker3Activity.class));
            }
        });
        ftVazo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VazoActivity.this, DescMasker4Activity.class));
            }
        });
        btnVazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VazoActivity.this, PsnVazoActivity.class));
            }
        });
    }
}
