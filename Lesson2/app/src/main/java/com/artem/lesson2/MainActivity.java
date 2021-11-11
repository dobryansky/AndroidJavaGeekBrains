package com.artem.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_clear, btn_sqr, btn_percent, btn_divide, btn_multiply,
            btn_seven, btn_nine, btn_eight, btn_five, btn_four, btn_minus,
            button_six, btn_two, btn_one, btn_plus, btn_three, btn_dot, btn_equal, btn_null;

    private TextView display;
   StringBuilder out1 = new StringBuilder();
    StringBuilder out2 = new StringBuilder();

    Boolean switchNum = true;
    String operand = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
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
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_one:
                if (switchNum) {
                    out1 = out1.append(1);
                } else {
                    out2=out2.append(1);
                }
                break;
            case R.id.btn_two:
                if (switchNum) {
                    out1 = out1.append(2);
                } else {
                    out2=out2.append(2);
                }
                break;
            case R.id.btn_three:
                if (switchNum) {
                    out1 = out1.append(3);
                } else {
                    out2=out2.append(3);
                }
                break;
            case R.id.btn_four:
                if (switchNum) {
                    out1 = out1.append(4);
                } else {
                    out2=out2.append(4);
                }
                break;
            case R.id.btn_five:
                if (switchNum) {
                    out1 = out1.append(5);
                } else {
                    out2=out2.append(5);
                }
                break;
            case R.id.button_six:
                if (switchNum) {
                    out1 = out1.append(6);
                } else {
                    out2=out2.append(6);
                }
                break;
            case R.id.btn_seven:
                if (switchNum) {
                    out1 = out1.append(7);
                } else {
                    out2=out2.append(7);
                }
                break;
            case R.id.btn_eight:
                if (switchNum) {
                    out1 = out1.append(8);
                } else {
                    out2=out2.append(8);
                }
                break;
            case R.id.btn_nine:
                if (switchNum) {
                    out1 = out1.append(9);
                } else {
                    out2=out2.append(9);
                }
                break;
            case R.id.btn_null:
                if (switchNum) {
                    out1 = out1.append(0);
                } else {
                    out2=out2.append(0);
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
            case R.id.btn_clear:
                out1.setLength(0);
                out2.setLength(0);
                operand="";
                switchNum=true;
                break;
            default:

                break;

        }
        display.setText(out1.toString()+operand+out2.toString());

    }


}