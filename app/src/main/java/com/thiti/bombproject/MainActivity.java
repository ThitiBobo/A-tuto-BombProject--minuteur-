package com.thiti.bombproject;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private NumberPicker mNumberPickerMinute;
    private NumberPicker mNumberPickerHeure;
    private ProgressBar mProgressBar;
    private TextView mPrimaryText;
    private TextView mSecondaryText;
    private Button mStartButton;

    private MyClock mClock;
    private boolean mClockActif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberPickerHeure = (NumberPicker)findViewById(R.id.numberPicker1);
        mNumberPickerMinute = (NumberPicker)findViewById(R.id.numberPicker2);
        mProgressBar = (ProgressBar)findViewById(R.id.activity_main_time_progressbar);
        mSecondaryText = (TextView)findViewById(R.id.activity_main_secondary_text);
        mPrimaryText = (TextView)findViewById(R.id.activity_main_primary_text);
        mStartButton = (Button)findViewById(R.id.activity_main_start_button);

        mNumberPickerHeure.setMinValue(0);
        mNumberPickerHeure.setMaxValue(24);
        mNumberPickerHeure.setWrapSelectorWheel(true);

        mNumberPickerMinute.setMinValue(0);
        mNumberPickerMinute.setMaxValue(60);
        mNumberPickerMinute.setWrapSelectorWheel(true);

        mStartButton.setTextColor(Color.rgb(0,150,0));

        mClock = new MyClock(
                this,
                new DisplayProgressBar(mProgressBar,mPrimaryText,mSecondaryText),
                0
        );
        mClockActif = false;

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mClockActif){
                    mClock.setTime(mNumberPickerMinute.getValue()*60*100);
                    mClock.execute();
                    mStartButton.setTextColor(Color.RED);
                    mStartButton.setText("Stop");
                    mClockActif = true;
                }
                else{
                    mClock.cancel(true);
                    mStartButton.setTextColor(Color.rgb(0,150,0));
                    mStartButton.setText("Start");
                    mClockActif = false;
                }
            }
        });

    }
}
