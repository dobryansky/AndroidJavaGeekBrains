package com.artem.lesson2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_clear, btn_sqr, btn_percent, btn_divide, btn_multiply,
            btn_seven, btn_nine, btn_eight, btn_five, btn_four, btn_minus,
            button_six, btn_two, btn_one, btn_plus, btn_three, btn_dot, btn_equal, btn_null;

    private Button btn_switch_theme;

    private TextView display;
    int switch_theme=  0;
    StringBuilder num1 = new StringBuilder();
    StringBuilder num2 = new StringBuilder();
    String out = "";
    double outEqual  = 0;
    Boolean isEqualPress= false;
    Boolean switchNum = true;
    String operand = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkTheme (savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
        if(savedInstanceState!=null){
           out = savedInstanceState.getString("out");
           display.setText(out);
        }
    }

    private void checkTheme(Bundle savedInstanceState) {
        if(savedInstanceState !=null) {
            if (savedInstanceState.getInt("Theme") == 1) {
                setTheme(R.style.Theme_pink);
                switch_theme=  1;
            }
            else{
                setTheme(R.style.Theme_Lesson2);
                switch_theme=  0;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("out",out);
        outState.putInt("Theme",switch_theme);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        display.setText(savedInstanceState.getString("out"));
    }

    private void initViews() {
        btn_clear = findViewById(R.id.btn_clear);
        btn_sqr = findViewById(R.id.btn_sqr);
        btn_percent = findViewById(R.id.btn_percent);
        btn_divide = findViewById(R.id.btn_divide);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_seven = findViewById(R.id.btn_seven);
        btn_nine = findViewById(R.id.btn_nine);
        btn_eight = findViewById(R.id.btn_eight);
        btn_five = findViewById(R.id.btn_five);
        btn_four = findViewById(R.id.btn_four);
        btn_minus = findViewById(R.id.btn_minus);
        button_six = findViewById(R.id.button_six);
        btn_two = findViewById(R.id.btn_two);
        btn_one = findViewById(R.id.btn_one);
        btn_plus = findViewById(R.id.btn_plus);
        btn_three = findViewById(R.id.btn_three);
        btn_dot = findViewById(R.id.btn_dot);
        btn_equal = findViewById(R.id.btn_equal);
        btn_null = findViewById(R.id.btn_null);
        display=findViewById(R.id.txt_display);
        btn_switch_theme=findViewById(R.id.btn_theme);
        display.setText("");
    }

    private void initListeners() {
        btn_clear.setOnClickListener(this);
        btn_sqr.setOnClickListener(this);
        btn_percent.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        button_six.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_one.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_null.setOnClickListener(this);
        btn_switch_theme.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_one:
                if (switchNum) {
                    num1 = num1.append(1);
                } else {
                    num2 = num2.append(1);
                }
                break;
            case R.id.btn_two:
                if (switchNum) {
                    num1 = num1.append(2);
                } else {
                    num2 = num2.append(2);
                }
                break;
            case R.id.btn_three:
                if (switchNum) {
                    num1 = num1.append(3);
                } else {
                    num2 = num2.append(3);
                }
                break;
            case R.id.btn_four:
                if (switchNum) {
                    num1 = num1.append(4);
                } else {
                    num2 = num2.append(4);
                }
                break;
            case R.id.btn_five:
                if (switchNum) {
                    num1 = num1.append(5);
                } else {
                    num2 = num2.append(5);
                }
                break;
            case R.id.button_six:
                if (switchNum) {
                    num1 = num1.append(6);
                } else {
                    num2 = num2.append(6);
                }
                break;
            case R.id.btn_seven:
                if (switchNum) {
                    num1 = num1.append(7);
                } else {
                    num2 = num2.append(7);
                }
                break;
            case R.id.btn_eight:
                if (switchNum) {
                    num1 = num1.append(8);
                } else {
                    num2 = num2.append(8);
                }
                break;
            case R.id.btn_nine:
                if (switchNum) {
                    num1 = num1.append(9);
                } else {
                    num2 = num2.append(9);
                }
                break;
            case R.id.btn_null:
                if (switchNum) {
                    num1 = num1.append(0);
                } else {
                    num2 = num2.append(0);
                }
                break;

            case R.id.btn_dot:
                if (switchNum) {
                    num1 = num1.append(".");
                } else {
                    num2 = num2.append(".");
                }
                break;

            case R.id.btn_divide:
               switchNum=false;
               operand="/";
                break;
            case R.id.btn_plus:
                switchNum=false;
                operand="+";
                break;
            case R.id.btn_minus:
                switchNum=false;
                operand="-";
                break;
            case R.id.btn_multiply:
                switchNum=false;
                operand="x";
                break;
            case R.id.btn_clear:
                num1.setLength(0);
                num2.setLength(0);
                operand="";
                switchNum=true;
                break;
            case R.id.btn_sqr:
                num1.insert(0,"√",0,1);
                operand="";
                switchNum=false;
                break;
            case R.id.btn_theme:
                if(switch_theme==0){
                switch_theme=1;
                } else {
                    switch_theme=0;
                }
                recreate();
                break;

            case R.id.btn_equal:
                Calculator calculator= new Calculator(num1.toString(),num2.toString(),operand);
                if(calculator.getOperation().equals("x") ){

                }
                if(calculator.getOperation().equals("+") ){
                    outEqual= calculator.sum();
                    isEqualPress =true;
                }
                if(calculator.getOperation().equals("-") ){

                }
                switchNum=false;
                break;
            default:

                break;

        }
        out=num1.toString()+operand+ num2.toString();

        display.setText(out);
        if(isEqualPress){
            display.setText(String.valueOf(outEqual));
        }
    }


}