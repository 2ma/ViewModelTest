package com.example.lol.viewmodeltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ModelFragment f1 = ModelFragment.getInstance(0);
            ModelFragment f2 = ModelFragment.getInstance(1);
            getSupportFragmentManager().beginTransaction().add(R.id.cont1, f1).add(R.id.cont2, f2).commit();
        }

        findViewById(R.id.pagerBtn).setOnClickListener(v -> startActivity(new Intent(this, PagerActivity.class)));

    }

}
