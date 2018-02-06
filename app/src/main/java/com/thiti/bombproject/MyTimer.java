package com.thiti.bombproject;

/**
 * Created by canard on 06/02/18.
 */

public interface MyTimer {

    public int getTime();
    public void setTime(int time);

    public void onIncrement();
    public void onDecrement();

    public void display();

}
