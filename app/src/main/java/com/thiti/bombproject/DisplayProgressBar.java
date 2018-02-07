package com.thiti.bombproject;

import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by canard on 06/02/18.
 */

public class DisplayProgressBar implements TimeDisplay {

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

    public DisplayProgressBar(ProgressBar progressBar, TextView primaryText, TextView secondaryText){
        mTimeProgress = progressBar;
        mPrimaryText = primaryText;
        mSecondaryText = secondaryText;
        display(0);
    }

    private void findTime(long time){
        mCentiseconde = 0;
        mSeconde = (int)time % 60;
        time = time / 60;

        mMinute = (int)time % 60;
        time = time / 60;

        mHours = (int)time % 60;
        time = time / 60;

        mStatusProgress = (mSeconde / 60) * 100;
    }

    @Override
    public void display(long time){
        findTime(time);
        mTimeProgress.setProgress(mStatusProgress);
        if (mHours > 0){
            mPrimaryText.setText(mHours + "h" + mMinute);
            mSecondaryText.setText(":" + mSeconde);
        }else{
            mPrimaryText.setText(mMinute + ":" + mSeconde);
            mSecondaryText.setText("." + mCentiseconde);
        }
    }
}
