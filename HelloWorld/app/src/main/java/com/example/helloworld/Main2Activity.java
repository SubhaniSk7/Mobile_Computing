package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void sendMessage(View view){
        Log.d("Main2Acitivity file","Created and working");
        Intent sendIntent =new Intent(this, Main2Activity.class);
        startActivity(sendIntent);
    }
}
