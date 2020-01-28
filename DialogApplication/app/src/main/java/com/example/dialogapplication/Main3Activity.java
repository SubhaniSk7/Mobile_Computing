package com.example.dialogapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity {
    Button submitButton, layoutButton;
    AlertDialog.Builder builder;
    EditText et3;
    final Context context = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        submitButton = (Button) findViewById(R.id.thirdActivityButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View mview = getLayoutInflater().inflate(R.layout.layout, null);

                builder = new AlertDialog.Builder(context);
                builder.setView(mview);
                builder.setPositiveButton("send", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        et3 = (EditText) findViewById(R.id.userText);

                        String message = (String) et3.getText().toString();
                        Log.d("Debug-----", message);
                        Intent intent = new Intent();
                        intent.putExtra("DISPLAY", message);
                        setResult(2, intent);
                        dialog.dismiss();
                        finish();//finishing activity
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
