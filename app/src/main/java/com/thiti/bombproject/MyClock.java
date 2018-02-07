package com.thiti.bombproject;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;


/**
 * Created by canard on 02/02/18.
 */

public class MyClock extends AsyncTask {

    private final Context cContext;
    private TimeDisplay mTimeDisplay;
    private long mTime;

    public void setTime(long time){
        mTime = time;
    }

    public MyClock(Context context,TimeDisplay timeDisplay,long time){
        cContext = context;
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
        mTimeDisplay.display(mTime);
    }

    @Override
    protected void onPostExecute(Object o) {
        mTimeDisplay.display(mTime);
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        mTimeDisplay.display(mTime);
    }

    @Override
    protected void onCancelled(Object o) {
        Toast.makeText(cContext, "Stop", Toast.LENGTH_SHORT).show();
    }
}
