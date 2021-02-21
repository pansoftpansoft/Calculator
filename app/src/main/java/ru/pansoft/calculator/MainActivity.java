package ru.pansoft.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonNext = (Button) findViewById(R.id.buttonNext);

        // создаем обработчик нажатия
        View.OnClickListener btnNext = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Меняем текст в TextView (tvOut)
                setContentView(R.layout.activity_main2);
            }
        };
        // присвоим обработчик кнопке OK (btnOk)
        buttonNext.setOnClickListener(btnNext);
    }

}