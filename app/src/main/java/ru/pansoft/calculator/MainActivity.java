package ru.pansoft.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String MY_RESULT = "0";
    public static final String KEY_RESULT = MainActivity.class.getCanonicalName() + ".ResultCalc";

    public boolean mLightNight = false;
    private String KEY_LN = "KEY_LN";


    private ResultCalc resultCalc = new ResultCalc();

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
        Button ButtonSettings = findViewById(R.id.ButtonSettings);
        ButtonSettings.setOnClickListener(buttonSettings_onClick);

    }

    public View.OnClickListener buttonSettings_onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainActivity.this, SettingActivity.class);
            intent.putExtra(KEY_LN, mLightNight);
            startActivityForResult(intent, 1);

        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("01", "_themSelect");
        if (data != null){
            mLightNight = data.getBooleanExtra(KEY_LN,false);
            Log.e("02", String.valueOf(mLightNight));
            Log.e("mLightNight = " , String.valueOf(mLightNight));
            if (mLightNight) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            recreate();
        }
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(resultCalc.expression , "_resultCalc.expression");
        outState.putString(KEY_RESULT, resultCalc.expression);
        Log.e("onSaveLightNight=" , String.valueOf(mLightNight));
        outState.putBoolean(KEY_LN, mLightNight);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resultCalc.expression = savedInstanceState.getString(KEY_RESULT, "0");
        mLightNight = savedInstanceState.getBoolean(KEY_LN, false);
        Log.e("onRestoreLightNight=" , String.valueOf(mLightNight));
        TextView textView = findViewById(R.id.textView);
        Log.e(resultCalc.expression , "resultCalc.expression_");
        textView.setText(resultCalc.expression);
    }
}