package com.example.chaitanya.mycalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    boolean isOperator = true;
    EditText edit1;
    String op="+";
    String oldNumber,newNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
    }

    public void numberEvent(View view) {
        if(isOperator){
            edit1.setText("");
        }
        isOperator=false;
        String number = edit1.getText().toString();
        switch (view.getId()){
            case R.id.button0:
                number += "0";
                break;
            case R.id.button1:
                number += "1";
                break;
            case R.id.button2:
                number += "2";
                break;
            case R.id.button3:
                number += "3";
                break;
            case R.id.button4:
                number += "4";
                break;
            case R.id.button5:
                number += "5";
                break;
            case R.id.button6:
                number += "6";
                break;
            case R.id.button7:
                number += "7";
                break;
            case R.id.button8:
                number += "8";
                break;
            case R.id.button9:
                number += "9";
                break;
            case R.id.buttonPoint:
                number += ".";
                break;
            case R.id.sign:
                number += "-"+number;
                break;

        }
        edit1.setText(number);
    }

    public void operatorEvent(View view) {
        isOperator=true;
        oldNumber=edit1.getText().toString();
        switch (view.getId()){
            case R.id.buttonAdd:
                op = "+";
                break;
            case R.id.buttonMinus:
                op = "-";
                break;
            case R.id.buttonMultiply:
                op = "*";
                break;
            case R.id.buttonDivide:
                op = "/";
                break;

        }
    }

    public void equalEvent(View view) {
        newNumber = edit1.getText().toString();
        double result =0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        edit1.setText(result+"");
    }

    public void ACEvent(View view) {
        edit1.setText("0");
        isOperator=true;
    }

    public void percentEvent(View view) {
        double no = Double.parseDouble(edit1.getText().toString())/100;
        edit1.setText(no+"");
        isOperator= true;
    }
}