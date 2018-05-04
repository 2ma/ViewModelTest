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
    private int number;

    private static final String TAG = "ModelFragment";
    private static final String EXTRA_NUMBER = "com.example.lol.viewmodeltest.extra.NUMBER";

    public ModelFragment() {
    }

    public static ModelFragment getInstance(int number) {
        ModelFragment modelFragment = new ModelFragment();
        Bundle args = new Bundle();
        args.putInt(EXTRA_NUMBER, number);
        modelFragment.setArguments(args);
        return modelFragment;
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
        model = ViewModelProviders.of(this, new FragmentViewModelFactory()).get(FragmentModel.class);
        number = getArguments().getInt(EXTRA_NUMBER);
        Log.d(TAG, "Fragment onCreate: " + number);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        model.getCount().observe(this, this::display);
    }

    private void display(Integer integer) {
        textView.setText(String.valueOf(integer));
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + number);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: " + number);
    }
}
