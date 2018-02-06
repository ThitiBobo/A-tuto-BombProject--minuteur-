package com.thiti.bombproject;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.ProgressBar;

/**
 * Created by canard on 02/02/18.
 */

public class MyClock extends AsyncTask {

    private final Context cContect;
    private MyTimer mTimer;
    private int mTime;

    public MyClock(Context context,MyTimer timer,int time){
        cContect = context;
        mTimer = timer;
        mTime = time;
        mTimer.setTime(time);
    }

    @Override
    protected String doInBackground(Object[] objects) {
        try {
            while(mTime > 0){
                Thread.sleep(10);
                mTimer.onDecrement();
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
        mTimer.display();
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }
}
