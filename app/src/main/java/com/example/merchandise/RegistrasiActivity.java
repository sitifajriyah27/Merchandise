package com.example.merchandise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrasiActivity extends AppCompatActivity {

    private Button btn_daftar, btn_login;
    private EditText etNama, etEmail, etPsw;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        mAuth = FirebaseAuth.getInstance();
        btn_daftar = findViewById(R.id.btndaftar);
        btn_login = findViewById(R.id.btnlogin);
        etNama = findViewById(R.id.nama);
        etEmail = findViewById(R.id.email);
        etPsw = findViewById(R.id.psw);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrasiActivity.this, LoginActivity.class));
            }
        });

        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNama.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPsw.getText().toString();

                if (nama.equals("")) {
                    Toast.makeText(RegistrasiActivity.this, "Silahkan isi nama Anda", Toast.LENGTH_SHORT).show();
                } else if (email.equals("")) {
                    Toast.makeText(RegistrasiActivity.this, "Silahkan isi email Anda", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(RegistrasiActivity.this, "Silahkan isi password Anda", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegistrasiActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(RegistrasiActivity.this, "Registrasi Success.",
                                                Toast.LENGTH_SHORT).show();
//
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(RegistrasiActivity.this, "Registrasi Failed.",
                                                Toast.LENGTH_SHORT).show();
                                    }


                                    // ...
                                }
                            });
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent c = new Intent(RegistrasiActivity.this, LoginActivity.class);
        startActivity(c);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if ( Preferences.getInstance(this).login())
        {
            Intent i = new Intent(RegistrasiActivity.this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//    }
}
