package com.example.merchandise.ui.tentangtoko;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TentangtokoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TentangtokoViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
}