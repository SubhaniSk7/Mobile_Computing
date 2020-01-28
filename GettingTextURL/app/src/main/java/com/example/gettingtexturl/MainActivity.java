package com.example.gettingtexturl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText urlEditText;
    public Button sendButton;

    public static String a;
    public static String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = (EditText) findViewById(R.id.urlIdEditText);
        sendButton = (Button) findViewById(R.id.submitFunctionButton);

        sendButton.setOnClickListener(this);
    }

    public void onClick(View view) {

        a = "";
        result = "";
        if (TextUtils.isEmpty(urlEditText.getText().toString())) {
            return;
        }
        a = (String) (urlEditText.getText().toString());

        System.out.println(a + "----------------------->");
        switch (view.getId()) {
            case R.id.submitFunctionButton:
                result = a;
                break;
            default:
                break;
        }
        System.out.println("***************************************" + result);

        String displayValue = "Result : " + result;
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("OPERATION_RESULT", displayValue);
        startActivity(intent);
    }
}
