package com.thiti.bombproject;

import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by canard on 06/02/18.
 */

public class MyFirstTimer implements MyTimer {

    private static final int TIME_MINUTE = 60;

    private ProgressBar mTimeProgress;
    private TextView mTimeText;

    private int mStatusProgress;
    private int mTime;

    public int getTime() {
        mStatusProgress = TIME_MINUTE;
        return mTime;
    }

    public void setTime(int seconde) {
        ///calcule a faire
        mTime = seconde;
    }

    public MyFirstTimer(ProgressBar progressBar, TextView text){
        mTimeProgress = progressBar;
        mTimeText = text;
        mTime = 0;
        mStatusProgress = 0;
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
