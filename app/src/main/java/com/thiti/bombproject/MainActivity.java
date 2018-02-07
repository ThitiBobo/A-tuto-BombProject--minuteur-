package com.thiti.bombproject;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // les widgets
    private NumberPicker mNumberPickerMinute;
    private NumberPicker mNumberPickerHeure;
    private NumberPicker mNumberPickerSeconde;
    private ProgressBar mProgressBar;
    private TextView mPrimaryText;
    private TextView mSecondaryText;
    private Button mStartButton;

    /**
     * un objet Myclock mClock
     * un afficheur mDisplay
     */
    private MyClock mClock;
    private TimeDisplay mDisplay;

    //création de l'acivité
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberPickerHeure = (NumberPicker)findViewById(R.id.activity_main_hour_np);
        mNumberPickerMinute = (NumberPicker)findViewById(R.id.activity_main_minute_np);
        mNumberPickerSeconde = (NumberPicker)findViewById(R.id.activity_main_seconde_np);
        mProgressBar = (ProgressBar)findViewById(R.id.activity_main_time_progressbar);
        mSecondaryText = (TextView)findViewById(R.id.activity_main_secondary_text);
        mPrimaryText = (TextView)findViewById(R.id.activity_main_primary_text);
        mStartButton = (Button)findViewById(R.id.activity_main_start_button);

        // initialisation des numberPickers
        mNumberPickerHeure.setMinValue(0);
        mNumberPickerHeure.setMaxValue(24);
        mNumberPickerHeure.setWrapSelectorWheel(true);

        mNumberPickerMinute.setMinValue(0);
        mNumberPickerMinute.setMaxValue(60);
        mNumberPickerMinute.setWrapSelectorWheel(true);

        mNumberPickerSeconde.setMinValue(0);
        mNumberPickerSeconde.setMaxValue(60);
        mNumberPickerSeconde.setWrapSelectorWheel(true);

        // paramétrage du texte du boutton en vert foncé ^^
        mStartButton.setTextColor(Color.rgb(0,150,0));

        mDisplay = new DisplayProgressBar(mProgressBar,mPrimaryText,mSecondaryText);

        mStartButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mClock == null){
            mClock = new MyClock(this,mDisplay,0);
            mClock.setTime(getTime());
            mClock.execute();
            mStartButton.setTextColor(Color.RED);
            mStartButton.setText("Stop");
        }
        else{
            mClock.cancel(true);
            mClock = null;
            mStartButton.setTextColor(Color.rgb(0,150,0));
            mStartButton.setText("Start");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if(mClock != null){
           mClock.cancel(true);
        }
        super.onSaveInstanceState(outState);
        outState.putLong("time",mClock.getTime());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mClock = new MyClock(this,mDisplay,0);
        mClock.setTime(savedInstanceState.getLong("time",0));
        mClock.execute();
        mStartButton.setTextColor(Color.RED);
        mStartButton.setText("Stop");

    }

    /**
     * convertit les données des numberPicker en centiseconde
     * @return les centisecondes en long
     */
    private long getTime(){
        long time = mNumberPickerHeure.getValue();
        time = time * 60 + mNumberPickerMinute.getValue();
        time = time * 60 + mNumberPickerSeconde.getValue();
        return time * 100;
    }
}
