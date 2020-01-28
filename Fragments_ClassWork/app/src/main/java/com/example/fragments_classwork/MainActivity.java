package com.example.fragments_classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate is running..");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy invoked");
    }
}
