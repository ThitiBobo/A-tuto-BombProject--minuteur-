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

    private int mCentiseconde;
    private int mSeconde;
    private int mMinute;
    private int mHours;

    @Override
    public int getTime() {
        return 0;
    }

    @Override
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
        mCentiseconde = 0;
        mSeconde = time % 60;
        time = time / 60;

        mMinute = time % 60;
        time = time / 60;

        mHours = time % 60;
        time = time / 60;

        mStatusProgress = 100;
        display();
    }

    @Override
    public void display(){
        mTimeProgress.setProgress(mStatusProgress);
        if (mHours > 0){
            mPrimaryText.setText(mHours + "h" + mMinute);
            mSecondaryText.setText(":" + mSeconde);
        }else{
            mPrimaryText.setText(mMinute + ":" + mSeconde);
            mSecondaryText.setText("." + mCentiseconde);
        }

        mTimeProgress.setProgress(mStatusProgress);
    }


    @Override
    public void onIncrement() {
        mCentiseconde++;
        if (mCentiseconde > 99){
            mCentiseconde = 0;
            mSeconde++;
            if (mSeconde > 59){
                mSeconde = 0;
                mMinute++;
                if (mMinute > 59){
                    mMinute= 0;
                    mMinute++;
                    if (mMinute > 59){
                        mMinute = 0;
                        mHours++;
                        if(mHours > 23){
                            init(0);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onDecrement() {
        mCentiseconde--;
        if (mCentiseconde < 0){
            mCentiseconde = 99;
            mSeconde--;
            mStatusProgress--;
            if (mStatusProgress < 0){
                mStatusProgress = 99;
            }
            if (mSeconde < 0){
                mSeconde = 59;
                mMinute--;
                if (mMinute < 0){
                    mMinute = 59;
                    mHours--;
                    if (mHours < 0){
                        mHours--;
                    }
                }
            }
        }

    }
}
