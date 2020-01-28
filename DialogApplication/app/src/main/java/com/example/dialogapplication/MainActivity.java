package com.example.dialogapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.displayMsg);
        b1 = (Button) findViewById(R.id.firstActivityButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivityForResult(intent, 2);// Activity is started with requestCode 2
            }
        });
    }

    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2

        Log.d("requestCode:====", "" + requestCode);
        if (requestCode == 2) {
            String message;
            if (data != null) {
                message = data.getStringExtra("DISPLAY");
            } else{
                message = "Subhaniasdlkfaslfkj";
            }
            Log.d("DISPLAY:::::::::::::", message);
            tv1.setText(message);


        }
    }
}
