package com.example.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        double value1;
        double value2;

        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText("");

        EditText editText1 = findViewById(R.id.editText1);
        if (editText1.getText().toString().length() != 0) {
            try {
                value1 = Double.parseDouble(editText1.getText().toString());
            } catch (NumberFormatException e) {
                textView1.setText("数値以外が入力されました。");
                return;
            }
        } else {
            textView1.setText("未入力です。数値を入力してください。");
            return;
        }

        EditText editText2 = findViewById(R.id.editText2);
        if (editText2.getText().toString().length() != 0) {
            try {
                value2 = Double.parseDouble(editText2.getText().toString());
            } catch (NumberFormatException e) {
                textView1.setText("数値以外が入力されました。");
                return;
            }
        } else {
            textView1.setText("未入力です。数値を入力してください。");
            return;
        }

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
                if (value2 == 0) {
                    textView1.setText("0で割ることはできません。");
                    return;
                }
                result = value1 / value2;
                break;
            default:
                break;
        }

        intent.putExtra("VALUE1", result);
        startActivity(intent);
    }
}
