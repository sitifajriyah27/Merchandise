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

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Toast back;
    private EditText etEmail, etPsw;
    Button btnLogin, btnDaftar;
    long timepress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnlogin);
        btnDaftar = findViewById(R.id.btndaftar);
        etEmail = findViewById(R.id.email);
        etPsw = findViewById(R.id.psw);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(LoginActivity.this, RegistrasiActivity.class);
                startActivity(a);
                finish();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password = etPsw.getText().toString();

                if (email.equals("")) {
                    Toast.makeText(LoginActivity.this, "Silahkan isi email Anda", Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(LoginActivity.this, "Silahkan isi password Anda", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        FirebaseUser user = mAuth.getCurrentUser();
//                                        updateUI(user);
                                        Toast.makeText(LoginActivity.this, "Login Success.",
                                                Toast.LENGTH_SHORT).show();
                                        SaveLogin();

                                        Intent inhome = new Intent(LoginActivity.this, MainActivity.class);
                                        inhome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(inhome);
                                        finish();
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(LoginActivity.this, "Login Failed.",
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
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
        if ( Preferences.getInstance(this).login())
        {
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }

    }

    @Override
    public void onBackPressed() {

        if (timepress + 2000>System.currentTimeMillis())
        {
            back.cancel();
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);

        }
        else
        {
            back = Toast.makeText(getApplicationContext(),"Back press again to exit",Toast.LENGTH_LONG);
            back.show();
        }

        timepress = System.currentTimeMillis();
    }
    public void SaveLogin ()
    {
        String email = etEmail.getText().toString();
        String password =  etPsw.getText().toString();
        Preferences.getInstance(LoginActivity.this).SaveUser(email, password);
    }
}
