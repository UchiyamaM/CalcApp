package com.example.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SecondActivity.class);

        EditText editText1 = findViewById(R.id.editText1);
        double value1 = Double.parseDouble(editText1.getText().toString());

        EditText editText2 = findViewById(R.id.editText2);
        double value2 = Double.parseDouble(editText2.getText().toString());

        double result = 0;

        switch (v.getId()) {
            case R.id.button1:
                result = value1 + value2;
                break;
            case R.id.button2:
                result = value1 - value2;
                break;
            case R.id.button3:
                result = value1 * value2;
                break;
            case R.id.button4:
                result = value1 / value2;
                break;
            default:
                break;
        }

        intent.putExtra("VALUE1", result);
        startActivity(intent);
    }
}
