package ru.pansoft.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {
    public boolean mLightNight = false;
    private String KEY_LN = "KEY_LN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        // получить данные из Intent
        Switch aSwitch = findViewById(R.id.switch2);
        Boolean text = getIntent().getExtras().getBoolean(KEY_LN);
        Log.e(text.toString(), "aSwitch.toString()");
        // Сохранить их в поле на экране
        aSwitch.setChecked(text);

        Button ButtonSet = findViewById(R.id.buttonSet);
        ButtonSet.setOnClickListener(buttonSet_onClick);
    }

    public View.OnClickListener buttonSet_onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Switch aSwitch = findViewById(R.id.switch2);
            Boolean text = aSwitch.isChecked();
            Log.e(String.valueOf(text), "text");
            Intent intentResult = new Intent();
            intentResult.putExtra(KEY_LN, text);
            setResult(RESULT_OK, intentResult);
            finish();
        }
    };
}