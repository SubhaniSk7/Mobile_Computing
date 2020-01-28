package com.example.finalsubmit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {
    public static String username = "";
    public static String userRollNo = "";
    public static String userEmail = "";
    public static String userFeedback = "";


    public EditText editText_name, editText_rollNo, editText_email, editText_feedback;
    public Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        editText_name = (EditText) findViewById(R.id.nameIdEditText);
        editText_rollNo = (EditText) findViewById(R.id.rollNoIdEditText);
        editText_email = (EditText) findViewById(R.id.emailIdEditText);
        editText_feedback = (EditText) findViewById(R.id.feedbackIdEditText);

        submitButton = (Button) findViewById(R.id.submitFunctionButton);

        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        {

            if (TextUtils.isEmpty(editText_name.getText().toString())
                    || TextUtils.isEmpty(editText_rollNo.getText().toString())
                    || TextUtils.isEmpty(editText_email.getText().toString())
                    || TextUtils.isEmpty(editText_feedback.getText().toString())) {
                return;
            }
            username = editText_name.getText().toString();
            userRollNo = editText_rollNo.getText().toString();
            userEmail = editText_email.getText().toString();
            userFeedback = editText_feedback.getText().toString();

            System.out.println(username + "-->" + userRollNo + "-->" + userEmail + "-->" + userFeedback);


            Intent intent = new Intent(this, FourthActivity.class);
            intent.putExtra("DISPLAY_NAME", username);
            intent.putExtra("DISPLAY_ROLLNO", userRollNo);
            intent.putExtra("DISPLAY_EMAIL", userEmail);
            intent.putExtra("DISPLAY_FEEDBACK", userFeedback);
            startActivity(intent);
        }

    }
}
