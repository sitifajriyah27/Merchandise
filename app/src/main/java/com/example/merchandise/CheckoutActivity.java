package com.example.merchandise;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class CheckoutActivity extends AppCompatActivity {

    private static final String ACTION_UPDATE_NOTIFICATION =
            "com.android.example.notifyme.ACTION_UPDATE_NOTIFICATION";
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";
    private static final int NOTIFICATION_ID = 0;
    private NotificationManager mNotifyManager;
    //    private NotificationReceiver mReceiver = new NotificationReceiver();
    TextView isiNama, isiTelepon, isiAlamat, isiPesanan, isiWarna, isiUkuran, isiJumlah;
//    private NotificationReceiver mReceiver = new NotificationReceiver();
    private Button btnChoose, btnUpload, btnSubmit;
    private ImageView buktiTf;
    private Uri filepath;
    private final int PICK_IMAGE_REQUEST = 71;
    private static final String CHANNEL_ID = "Fajriyah notif";
    private static final String CHANNEL_NAME = "Fajriyah notif";
    private static final String CHANNEL_DESC = "Fajriyah";

    // firebase
    FirebaseStorage storage;
    StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        btnChoose = findViewById(R.id.btn_choose);
        btnUpload = findViewById(R.id.btn_upload);
        buktiTf = findViewById(R.id.bukti);
        btnSubmit = findViewById(R.id.btn_submit);
        isiNama = findViewById(R.id.isi_nama);
        isiTelepon = findViewById(R.id.isi_tlp);
        isiAlamat = findViewById(R.id.isi_alamat);
        isiPesanan = findViewById(R.id.isi_pesanan2);
        isiWarna = findViewById(R.id.isi_warna2);
        isiJumlah = findViewById(R.id.isi_jml2);
        isiUkuran = findViewById(R.id.isi_ukuran2);
        buktiTf = findViewById(R.id.bukti);


        Intent valuebkt = getIntent();
        String velnama = valuebkt.getStringExtra("extraNama");
        String veltlp = valuebkt.getStringExtra("extraTlp");
        String velalamat = valuebkt.getStringExtra("extraAlamat");
        String velpesan = valuebkt.getStringExtra("extraPesan2");
        String velwarna = valuebkt.getStringExtra("extraWarna2");
        String veljml = valuebkt.getStringExtra("extraJumlah2");
        String velukuran = valuebkt.getStringExtra("extraUkuran2");


        isiNama.setText(velnama);
        isiTelepon.setText(veltlp);
        isiAlamat.setText(velalamat);
        isiPesanan.setText(velpesan);
        isiWarna.setText(velwarna);
        isiJumlah.setText(veljml);
        isiUkuran.setText(velukuran);

        //Firebase Init
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel ch = new NotificationChannel(
                    CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager mn = getSystemService(NotificationManager.class);
            mn.createNotificationChannel(ch);
        }
//        createNotificationChannel();
//        registerReceiver(mReceiver,
//                new IntentFilter(ACTION_UPDATE_NOTIFICATION));
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                notifikasi();
            }
        });

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();

            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadImage();
            }
        });
    }

    private void UploadImage() {
        if (filepath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref = storageReference.child("images/" + UUID.randomUUID().toString());
            ref.putFile(filepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(CheckoutActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(CheckoutActivity.this, "Failed" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            progressDialog.setMessage("Uploaded" + (int) progress + "%");
                        }
                    });

        }
    }

    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            filepath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                buktiTf.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    private class NotificationReceiver extends BroadcastReceiver {
//        public NotificationReceiver() {
//        }
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//        }
//    }

//    @Override
//    protected void onDestroy() {
//        unregisterReceiver(mReceiver);
//        super.onDestroy();
//    }
//
//    private void createNotificationChannel() {
//        mNotifyManager =
//                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        if (android.os.Build.VERSION.SDK_INT >=
//                android.os.Build.VERSION_CODES.O) {
//        }
//    }
//
//    private void sendNotification() {
////        Intent updateIntent = new Intent(ACTION_UPDATE_NOTIFICATION);
////        PendingIntent updatePendingIntent = PendingIntent.getBroadcast(this,
////                NOTIFICATION_ID, updateIntent, PendingIntent.FLAG_ONE_SHOT);
//        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
//        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
//
//    }
//
//    private NotificationCompat.Builder getNotificationBuilder() {
//        Intent notificationIntent = new Intent(this, MainActivity.class);
//        PendingIntent notificationPendingIntent = PendingIntent.getActivity
//                (this, NOTIFICATION_ID, notificationIntent,
//                        PendingIntent.FLAG_UPDATE_CURRENT);
//        NotificationCompat.Builder notifyBuilder = new NotificationCompat
//                .Builder(this, PRIMARY_CHANNEL_ID)
//                .setContentTitle("Tim Ricis")
//                .setContentText("Transaksi sudah berhasil, Terimakasih sudah berbelanja")
//                .setSmallIcon(R.drawable.timriciss)
//                .setAutoCancel(true).setContentIntent(notificationPendingIntent)
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
//                .setDefaults(NotificationCompat.DEFAULT_ALL);
//        return notifyBuilder;
//    }

    private void notifikasi(){
        NotificationCompat.Builder mb =
                new NotificationCompat.Builder(this,CHANNEL_ID)
                        .setSmallIcon(R.drawable.timriciss)
                        .setContentTitle("Tim Ricis")
                        .setContentText("Terimakasih Sudah Berbelanja")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat nm = NotificationManagerCompat.from(this);
        nm.notify(1,mb.build());


    }
}

