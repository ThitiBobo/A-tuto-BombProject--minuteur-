package com.thiti.bombproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private NumberPicker mNumberPickerMinute;
    private NumberPicker mNumberPickerHeure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberPickerHeure = (NumberPicker)findViewById(R.id.numberPicker);
        mNumberPickerMinute = (NumberPicker)findViewById(R.id.numberPicker2);
        ProgressBar pb = (ProgressBar)findViewById(R.id.pb);

        mNumberPickerHeure.setMinValue(0);
        mNumberPickerHeure.setMaxValue(24);
        mNumberPickerHeure.setWrapSelectorWheel(true);

        mNumberPickerMinute.setMinValue(0);
        mNumberPickerMinute.setMaxValue(60);
        mNumberPickerMinute.setWrapSelectorWheel(true);

    }
}
