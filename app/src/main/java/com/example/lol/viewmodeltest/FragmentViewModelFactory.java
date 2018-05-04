package com.example.lol.viewmodeltest;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class FragmentViewModelFactory implements ViewModelProvider.Factory {
    @NonNull
    @Override
    public FragmentModel create(@NonNull Class modelClass) {
        return new FragmentModel();
    }
}
