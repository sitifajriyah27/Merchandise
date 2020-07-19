package com.example.merchandise.ui.kategori;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.merchandise.AryeshActivity;
import com.example.merchandise.DerryActivity;
import com.example.merchandise.R;
import com.example.merchandise.RicisActivity;
import com.example.merchandise.VazoActivity;
import com.example.merchandise.WildanActivity;

public class KategoriFragment extends Fragment {
   // private KategoriViewModel kategoriViewModel;

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*kategoriViewModel =
                ViewModelProviders.of(this).get(KategoriViewModel.class);*/

        View v = inflater.inflate(R.layout.fragment_kategori, container, false);
        b1 = v.findViewById(R.id.ricis);
        b2 = v.findViewById(R.id.wildan);
        b3 = v.findViewById(R.id.aryesh);
        b4 = v.findViewById(R.id.vazo);
        b5 = v.findViewById(R.id.derry);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent (getActivity(), RicisActivity.class);
                startActivity(a);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getActivity(), WildanActivity.class);
                startActivity(b);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(getActivity(), AryeshActivity.class);
                startActivity(c);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(getActivity(), VazoActivity.class);
                startActivity(d);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(getActivity(), DerryActivity.class);
                startActivity(e);
            }
        });

        /*final TextView textView = v.findViewById(R.id.text_kategori);
        kategoriViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return v;
    }
}