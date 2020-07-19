package com.example.merchandise;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class KeranjangActivity extends AppCompatActivity {

     private Button Checkout;
     private EditText isiNama, isiTlp, isiAlamat;
     private TextView isiPesanan, isiWarna, isiUkuran, isiJumlah;
    public String isiPesanan2, isiWarna2, isiUkuran2, isiJumlah2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);

        isiNama = findViewById(R.id.et_nama);
        isiTlp = findViewById(R.id.et_tlp);
        isiAlamat = findViewById(R.id.et_alamat);
        isiPesanan = findViewById(R.id.isi_pesanan);
        isiWarna = findViewById(R.id.isi_warna);
        isiUkuran = findViewById(R.id.isi_ukuran);
        isiJumlah = findViewById(R.id.isi_jml);
        Checkout = findViewById(R.id.btn_cekout);

        SharedPreferences saveEt = PreferenceManager.getDefaultSharedPreferences(this);

        String Nama = saveEt.getString("Nama", " ");
        isiNama.setText(Nama);
        String Tlp = saveEt.getString("Notlp", " ");
        isiTlp.setText(Tlp);
        String Alamat = saveEt.getString("Alamat", " ");
        isiAlamat.setText(Alamat);

        Checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pesan = isiPesanan.getText().toString();
                String warna = isiWarna.getText().toString();
                String ukuran = isiUkuran.getText().toString();
                String jumlah = isiJumlah.getText().toString();
                String nama = isiNama.getText().toString();
                String tlp = isiTlp.getText().toString();
                String alamat = isiAlamat.getText().toString();

                Intent i = new Intent(KeranjangActivity.this, CheckoutActivity.class);

                i.putExtra("extraPesan2", pesan);
                i.putExtra("extraWarna2", warna);
                i.putExtra("extraUkuran2", ukuran);
                i.putExtra("extraJumlah2", jumlah);
                i.putExtra("extraNama", nama);
                i.putExtra("extraTlp", tlp);
                i.putExtra("extraAlamat", alamat);
                startActivity(i);

                SharedPreferences saveEt = PreferenceManager.getDefaultSharedPreferences(KeranjangActivity.this);
                SharedPreferences.Editor editor = saveEt.edit();

                editor.putString("nama", nama);
                editor.putString("tlp", tlp);
                editor.putString("alamat", alamat);
                editor.apply();
            }
        });
        Intent intent = getIntent();
        String dataPesan = intent.getStringExtra("extraPesan");
        String dataWarna = intent.getStringExtra("extraWarna");
        String dataJumlah = intent.getStringExtra("extraJumlah");
        String datatotal = intent.getStringExtra("extraTotal");

        isiPesanan.setText(dataPesan);
        isiWarna.setText(dataWarna);
        isiJumlah.setText(dataJumlah);
        isiUkuran.setText(datatotal);

        if (savedInstanceState != null){

            isiPesanan2 = savedInstanceState.getString("pesan");
            isiWarna2 =savedInstanceState.getString("warna");
            isiJumlah2 =savedInstanceState.getString("jumlah");
            isiUkuran2 =savedInstanceState.getString("ukuran");

        }
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putString("pesan", isiPesanan2);
        outState.putString("warna", isiWarna2);
        outState.putString("jumlah", isiJumlah2);
        outState.putString("ukuran", isiUkuran2);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
}
