package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    public static float a;
    public static float b;
    public static float result;

    public EditText editText_a, editText_b;
    public TextView resultView;
    public Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        editText_a = (EditText) findViewById(R.id.aValueTextView);
        editText_b = (EditText) findViewById(R.id.bValueTextView);
        addButton = (Button) findViewById(R.id.addFunctionButton);
        subtractButton = (Button) findViewById(R.id.subtractFunctionButton);
        multiplyButton = (Button) findViewById(R.id.multiplyFunctionButton);
        divideButton = (Button) findViewById(R.id.divisionFunctionButton);
        resultView = (TextView) findViewById(R.id.resultTextView);

        addButton.setOnClickListener(this);
        subtractButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        divideButton.setOnClickListener(this);
    }


//    @Override
//    public void onSaveInstanceState(Bundle state) {
//        super.onSaveInstanceState(state);
//        state.putFloat("a", a);
//        state.putFloat("b", b);
//        state.putFloat("result", result);
//        Log.d("printing", "Saving State" + a + " " + b + " " + result);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        a = savedInstanceState.getFloat("a");
//        b = savedInstanceState.getFloat("b");
//        result = savedInstanceState.getFloat("result");
//
//        display();
//    }
//
//    public void display() {
//        resultView.setText("Result: " + result);
//    }

    @Override
    public void onClick(View view) {

        a = 0;
        b = 0;
        result = 0;
        if (TextUtils.isEmpty(editText_a.getText().toString())
                || TextUtils.isEmpty(editText_b.getText().toString())) {
            return;
        }
        a = Float.parseFloat(editText_a.getText().toString());
        b = Float.parseFloat(editText_b.getText().toString());

        System.out.println(a + "----------------------->" + b);
        switch (view.getId()) {
            case R.id.addFunctionButton:
                result = a + b;
                break;
            case R.id.subtractFunctionButton:
                result = a - b;
                break;
            case R.id.multiplyFunctionButton:
                result = a * b;
                break;
            case R.id.divisionFunctionButton:
                result = a / b;
                break;
            default:
                break;
        }
        System.out.println("***************************************" + result);
        resultView.setText("Result: " + result);

        String displayValue = "Result : " + result;
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("OPERATION_RESULT", displayValue);
        startActivity(intent);
    }

}
