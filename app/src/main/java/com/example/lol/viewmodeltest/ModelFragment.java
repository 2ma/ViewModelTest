package com.example.lol.viewmodeltest;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ModelFragment extends Fragment {

    private FragmentModel model;
    private TextView textView;

    private static final String TAG = "ModelFragment";

    public ModelFragment() {
        Log.d(TAG, "ModelFragment: ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        textView = view.findViewById(R.id.textView);

        view.findViewById(R.id.button).setOnClickListener(v -> count());

        return view;
    }

    private void count() {
        model.count();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(this).get(FragmentModel.class);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model.getCount().observe(this, this::display);
    }

    private void display(Integer integer) {
        textView.setText(String.valueOf(integer));
    }
}
