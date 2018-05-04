package com.example.lol.viewmodeltest;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class TestViewModel extends ViewModel {
    MutableLiveData<String> testData = new MutableLiveData<>();

    private static final String TAG = TestViewModel.class.getSimpleName();

    public LiveData<String> getTestData() {
        return testData;
    }

    public void start() {
        Single.fromCallable(this::test).subscribeOn(Schedulers.io())
            .subscribe(s -> testData.postValue(s));
    }

    private String test() {
        try {
            Thread.sleep(2000);

            Log.i(TAG, "test:");

            Thread.sleep(2000);

            Log.i(TAG, "test2:");

            return "after_sleep";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "error";
    }
}
