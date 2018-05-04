package com.example.lol.viewmodeltest;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

public class FragmentModel extends ViewModel {

    private MutableLiveData<Integer> count = new MutableLiveData<>();
    private static final String TAG = "FragmentModel";

    public FragmentModel() {
        count.setValue(1);
        Log.d(TAG, "FragmentModel: onCreate");
    }

    public LiveData<Integer> getCount() {
        return count;
    }

    public void count() {
        int c = count.getValue();
        count.setValue(++c);
    }
}
