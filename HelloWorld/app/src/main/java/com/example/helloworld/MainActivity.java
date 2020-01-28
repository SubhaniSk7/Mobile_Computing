package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iiitdWebsite(View view) {
        Log.d("iiitd", "Opening IIITD website");

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.iiitd.ac.in"));
        startActivity(intent);
    }

    public void gfgWebsite(View view) {
        Log.d("gfg", "Opening GeeksForGeeks website");

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.geeksforgeeks.org"));
        startActivity(intent);
    }

    public void codeChefWebsite(View view) {
        Log.d("codechef", "Opening CodeChef website");

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.codechef.com"));
        startActivity(intent);
    }

    public void leetCodeWebsite(View view) {
        Log.d("leetcode", "Opening LeetCode website");

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.leetcode.com"));
        startActivity(intent);
    }
}
