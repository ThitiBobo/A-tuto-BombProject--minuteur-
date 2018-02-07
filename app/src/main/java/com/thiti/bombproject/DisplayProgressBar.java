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

    private String getCentiseconde() {
        if (mCentiseconde < 10)
            return "0" + mCentiseconde;
        return Integer.toString(mCentiseconde);
    }

    private String getSeconde() {
        if (mSeconde < 10)
            return "0" + mSeconde;
        return Integer.toString(mSeconde);
    }

    private String getMinute() {
        if (mMinute < 10)
            return "0" + mMinute;
        return Integer.toString(mMinute);
    }

    private String getHours() {
        if (mHours < 10)
            return "0" + mHours;
        return Integer.toString(mHours);
    }

    public DisplayProgressBar(ProgressBar progressBar, TextView primaryText, TextView secondaryText){
        mTimeProgress = progressBar;
        mPrimaryText = primaryText;
        mSecondaryText = secondaryText;
        display(0);
    }

    private void findTime(long time){
        mCentiseconde = (int)time % 100;
        time = time / 100;

        mSeconde = (int)time % 60;
        time = time / 60;

        mMinute = (int)time % 60;
        time = time / 60;

        mHours = (int)time % 60;
        time = time / 60;

        mStatusProgress = new Integer(((mMinute / 60) * mTimeProgress.getMax()));
        //mStatusProgress = mTimeProgress.getMax() - 15;
    }

    @Override
    public void display(long time){
        findTime(time);
        mTimeProgress.setProgress(mStatusProgress);
        if (mHours > 0){
            mPrimaryText.setText(getHours() + "h" + getMinute());
            mSecondaryText.setText(":" + getSeconde());
        }else{
            mPrimaryText.setText(getMinute() + ":" + getSeconde());
            mSecondaryText.setText("." + getCentiseconde());
        }
    }
}
