package com.example.merchandise.ui.tentangtoko;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.merchandise.R;

public class TentangtokoFragment extends Fragment {

    private TentangtokoViewModel tentangtokoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tentangtokoViewModel =
                ViewModelProviders.of(this).get(TentangtokoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tentangtoko, container, false);
        final TextView textView = root.findViewById(R.id.text_tentangtoko);
        tentangtokoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}