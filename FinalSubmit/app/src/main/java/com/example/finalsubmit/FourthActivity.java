package com.example.finalsubmit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FourthActivity extends AppCompatActivity {

    public static String username = "";
    public static String userRollNo = "";
    public static String userEmail = "";
    public static String userFeedback = "";

    public TextView editText_name, editText_rollNo, editText_email, editText_feedback;
    public Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        editText_name = (TextView) findViewById(R.id.nameIdTextView);
        editText_rollNo = (TextView) findViewById(R.id.rollNoIdTextView);
        editText_email = (TextView) findViewById(R.id.emailIdTextView);
        editText_feedback = (TextView) findViewById(R.id.feedbackIdTextView);

        okButton = (Button) findViewById(R.id.submitFunctionButton);


        Intent intent = getIntent();
        username = intent.getStringExtra("DISPLAY_NAME");
        userRollNo = intent.getStringExtra("DISPLAY_ROLLNO");
        userEmail = intent.getStringExtra("DISPLAY_EMAIL");
        userFeedback = intent.getStringExtra("DISPLAY_FEEDBACK");


        editText_name.setText(username);
        editText_rollNo.setText(userRollNo);
        editText_email.setText(userEmail);
        editText_feedback.setText(userFeedback);
    }
}
