package com.example.merchandise.ui.kategori;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KategoriViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KategoriViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}