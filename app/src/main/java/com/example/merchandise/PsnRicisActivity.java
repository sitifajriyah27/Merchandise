package com.example.merchandise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PsnRicisActivity extends AppCompatActivity {

    TextView Hrg;
    private Button Btn1;
    private Button Btn2;
    RadioGroup rg_0, rg_1, rg_2;
    RadioButton Rb1, Rb2, Rb3, Rb4, rbwarna1,rbwarna2;
    private TextView Jml1;
    Integer valuejml = 0;
    EditText etTotal;
    int harga[] = {89000, 39000, 55000, 66000};
    private Button Pilih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psn_ricis);

        Hrg = findViewById(R.id.hrg);
        Btn1 = findViewById(R.id.btn1);
        Btn2 = findViewById(R.id.btn2);
        Jml1 = findViewById(R.id.jumlah1);
        etTotal = findViewById(R.id.et_total);
        Pilih = findViewById(R.id.pilih);
        rg_0 = findViewById(R.id.rg0);
        rg_1 = findViewById(R.id.rg1);
        rg_2 = findViewById(R.id.rg2);
        Rb1 = findViewById(R.id.rb_1);
        Rb2 = findViewById(R.id.rb_2);
        Rb3 = findViewById(R.id.rb_3);
        Rb4 = findViewById(R.id.rb_4);
        rbwarna1 = findViewById(R.id.rbwarna1);
        rbwarna2 = findViewById(R.id.rbwarna2);


        if (savedInstanceState != null){
            String nilaiSaved = savedInstanceState.getString("nilai");
            Jml1.setText(nilaiSaved);
        }

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valuejml += 1;
                Jml1.setText(valuejml.toString());
                int tot = Integer.parseInt(Jml1.getText().toString());
                int sat = Integer.parseInt(Hrg.getText().toString());
                int total = tot*sat;
                etTotal.setText(String.valueOf(total));
            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valuejml > 1){
                    valuejml -= 1;
                    Jml1.setText(valuejml.toString());
                    int tot = Integer.parseInt(Jml1.getText().toString());
                    int sat = Integer.parseInt(Hrg.getText().toString());
                    int total = tot*sat;
                    etTotal.setText(String.valueOf(total));
                }
            }
        });


        Pilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pilpkt = " ";
                if (Rb1.isChecked()){
                    pilpkt+= "Seleb Square ";
                }
                if (Rb2.isChecked()){
                    pilpkt+= "Evelyn Square";
                }
                if (Rb3.isChecked()){
                    pilpkt+= "Evessel Square";
                }
                if (Rb4.isChecked()){
                    pilpkt+= "Basic Voal";
                }

                String pilpkt2 = " ";
                if (rbwarna1.isChecked()){
                    pilpkt2+= "Navy ";
                }
                if (rbwarna2.isChecked()){
                    pilpkt2+= "Blue ";
                }

                String vJumlah = Jml1.getText().toString();
                String vTotal = etTotal.getText().toString();

                Intent box = new Intent(PsnRicisActivity.this, KeranjangActivity.class);
                box.putExtra("extraPesan", pilpkt);
                box.putExtra("extraWarna", pilpkt2);
                box.putExtra("extraJumlah", vJumlah);
                box.putExtra("extraTotal", vTotal);
                startActivity(box);
            }
        });
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.rb_1:
                if (checked)
                    // Same day service
                    etTotal.setText(String.valueOf(harga[0]));
                Hrg.setText(String.valueOf(harga[0]));
                break;

            case R.id.rb_2:
                if (checked)
                    // Next day delivery
                    etTotal.setText(String.valueOf(harga[2]));
                Hrg.setText(String.valueOf(harga[2]));
                break;

            case R.id.rb_3:
                if (checked)
                    // Next day delivery
                    etTotal.setText(String.valueOf(harga[1]));
                Hrg.setText(String.valueOf(harga[1]));
                break;

            case R.id.rb_4:
                if (checked)
                    // Next day delivery
                    etTotal.setText(String.valueOf(harga[3]));
                Hrg.setText(String.valueOf(harga[3]));
                break;
            default:
                // Do nothing.
                break;
        }
    }
}
