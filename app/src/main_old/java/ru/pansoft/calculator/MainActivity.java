package ru.pansoft.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ResultCalc resultCalc = new ResultCalc();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(button_onClick);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(button_onClick);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(button_onClick);
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(button_onClick);
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(button_onClick);
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(button_onClick);
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(button_onClick);
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(button_onClick);
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(button_onClick);
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(button_onClick);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(button_onClick);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(button_onClick);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(button_onClick);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(button_onClick);
        Button buttonPeriod = findViewById(R.id.buttonPeriod);
        buttonPeriod.setOnClickListener(button_onClick);
        Button buttonEqually = findViewById(R.id.buttonEqually);
        buttonEqually.setOnClickListener(button_onClick);
    }

    public View.OnClickListener button_onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = findViewById(view.getId());
            String s = button.getText().toString();
            resultCalc.setTextMonitor(s);
            setResultOnScreen();
        }
    };

    private void setResultOnScreen() {
        TextView textView = findViewById(R.id.textView);
        textView.setText(resultCalc.expression);
    }

//    private void setTextMonitor(String s){
//        resultCalc.setTextMonitor(s);
//        setResultOnScreen();
//    }
}