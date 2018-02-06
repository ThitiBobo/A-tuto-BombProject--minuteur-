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
    private ProgressBar mProgressBar;
    private int mTime;
    private int mStatusProgressBar;

    public MyClock(Context context,int time,ProgressBar progressBar){
        cContect = context;
        mProgressBar = progressBar;
        mTime = time;
        mStatusProgressBar = 100;

    }

    @Override
    protected String doInBackground(Object[] objects) {
        try {
            while(mTime > 0){
                Thread.sleep(100);
                mStatusProgressBar--;
                mTime--;
                if (mStatusProgressBar < 0){
                    mStatusProgressBar = 100;
                }
                publishProgress(mTime,mStatusProgressBar);
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
        mProgressBar.setProgress(mStatusProgressBar);

    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }
}
