package com.thiti.bombproject;

import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by canard on 06/02/18.
 *
 * Cette classe permet d'afficher des temps en implémentant l'nterface TimeDisplay.
 * Elle affiche le temps dans deux textview, une petit et une grande, et a une progress bar en
 * cercle(quimarche pas encore) pour symboliser l'avancement ou le recule des minutes
 * Elle affiche le temps heure,minute,seconde,centiseconde,   en deux temps :
 * - si le temps est supérieur a 1h, l'affichage serat (HH h MM : ss) <- schéma
 *   avec heure et minute afficher dans la Primary TextView et les secondes dans la seconde tv
 * - se le temps est inférieur a 1h, l' affichage serat (MM : SS . cc)
 *   avec minute et seconde afficher dans la Primary TextView et les centiseconde
 *   dans la seconde tv.
 */

public class DisplayProgressBar implements TimeDisplay {

    /**
     * mTimeProgress est la progressbar ronde
     * mPrimaryText est la Première textview
     * mSecondaryText est la Seconde textview
     */
    private ProgressBar mTimeProgress;
    private TextView mPrimaryText;
    private TextView mSecondaryText;

    /**
     * mStatusProgress est l'avancement de mTimeProgress
     * mCentiseconde = centiseconde
     * mSeconde = seconde
     * mMinute = minute
     * mHours = heures
     */
    private int mStatusProgress;
    private int mCentiseconde;
    private int mSeconde;
    private int mMinute;
    private int mHours;

    /**
     * retourne les centisecondes sous forme de string,
     * si les centiseconde sont inférieur a 10, rajoute un 0 devant;
     * @return les centisecondes sous forme de string
     */
    private String getCentiseconde() {
        if (mCentiseconde < 10)
            return "0" + mCentiseconde;
        return Integer.toString(mCentiseconde);
    }

    /**
     * retourne les secondes sous forme de string,
     * si les seconde sont inférieur a 10, rajoute un 0 devant;
     * @return les secondes sous forme de string
     */
    private String getSeconde() {
        if (mSeconde < 10)
            return "0" + mSeconde;
        return Integer.toString(mSeconde);
    }

    /**
     * retourne les minutes sous forme de string,
     * si les minutes sont inférieur a 10, rajoute un 0 devant;
     * @return les minutes sous forme de string
     */
    private String getMinute() {
        if (mMinute < 10)
            return "0" + mMinute;
        return Integer.toString(mMinute);
    }

    /**
     * retourne les heures sous forme de string,
     * si les heures sont inférieur a 10, rajoute un 0 devant;
     * @return les heures sous forme de string
     */
    private String getHours() {
        if (mHours < 10)
            return "0" + mHours;
        return Integer.toString(mHours);
    }

    /**
     * Constructeur de DisplayProgressBar
     * @param progressBar la barre de progrée
     * @param primaryText le texte primaire
     * @param secondaryText le texte secondaire
     */
    public DisplayProgressBar(ProgressBar progressBar, TextView primaryText, TextView secondaryText){
        mTimeProgress = progressBar;
        mPrimaryText = primaryText;
        mSecondaryText = secondaryText;
        display(0);
    }

    /**
     * prend en entrée une durée en centiseconde et la décompose en heure, minute, seconde ...
     * @param time une durée en centiseconde
     */
    private void findTime(long time){
        mCentiseconde = (int)time % 100;
        time = time / 100;

        mSeconde = (int)time % 60;
        time = time / 60;

        mMinute = (int)time % 60;
        time = time / 60;

        mHours = (int)time % 60;
        time = time / 60;

        //mStatusProgress = mSeconde;
        //mStatusProgress = mTimeProgress.getMax() - 15;
    }

    /**
     * affiche le temps en entrée
     * @param time une durée en centiseconde
     */
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
