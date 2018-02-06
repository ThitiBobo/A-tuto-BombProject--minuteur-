package com.thiti.bombproject;

import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by canard on 06/02/18.
 */

public class MyFirstTimer implements MyTimer {

    /**
     *
     */
    private static final int TIME_MINUTE = 60;

    private ProgressBar mTimeProgress;
    private TextView mPrimaryText;
    private TextView mSecondaryText;

    private int mStatusProgress;

    private int mMilliseconde;
    private int mSeconde;
    private int mMinute;
    private int mHours;

    public int getTime() {
        return 0;
    }

    public void setTime(int time) {
        init(time);
    }


    public MyFirstTimer(ProgressBar progressBar, TextView primaryText, TextView secondaryText){
        mTimeProgress = progressBar;
        mPrimaryText = primaryText;
        mSecondaryText = secondaryText;
        init(0);
    }

    private void init(int time){
        mMilliseconde = 0;
        mSeconde = time % 60;
        time = time / 60;

        mMinute = time % 60;
        time = time / 60;

        mHours = time % 60;
        time = time / 60;

        mStatusProgress = mSeconde;
        display();
    }

    public void display(){
        mTimeProgress.setProgress(mStatusProgress);
        if (mHours > 0){
            mPrimaryText.setText(mHours + "h" + mMinute);
            mSecondaryText.setText(":" + mSeconde);
        }else{
            mPrimaryText.setText(mMinute + ":" + mSeconde);
            mSecondaryText.setText("." + mMilliseconde);
        }
    }

    @Override
    public void onIncrementSeconde() {

    }

    @Override
    public void onDecrementSeconde() {

    }

    @Override
    public void onIncrementMilliSeconde() {

    }

    @Override
    public void onDecrementMilliSeconde() {

    }
}
