package com.thiti.bombproject;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;

import java.sql.Time;


/**
 * Created by canard on 02/02/18.
 */

public class MyClock extends AsyncTask {

    private final Context cContect;
    private TimeDisplay mTimeDisplay;
    private long mTime;

    public MyClock(Context context,TimeDisplay timeDisplay,long time){
        cContect = context;
        mTimeDisplay = timeDisplay;
        mTime = time;

    }

    @Override
    protected String doInBackground(Object[] objects) {
        try {
            while(mTime > 0){
                Thread.sleep(10);
                mTime--;
                publishProgress(mTime);
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "terminé";
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        mTimeDisplay.display(mTime);
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }
}
