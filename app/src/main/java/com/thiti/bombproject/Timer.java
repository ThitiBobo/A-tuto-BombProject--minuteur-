package com.thiti.bombproject;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;

/**
 * Created by canard on 02/02/18.
 */

public class Timer extends AsyncTask {

    private final Context cContect;

    private int mTime;

    public Timer(Context context,int time,Handler progressBar){
        cContect = context;
        mTime = time;
    }

    @Override
    protected String doInBackground(Object[] objects) {
        try {
            while(mTime > 0){
                Thread.sleep(0);
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
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }
}
