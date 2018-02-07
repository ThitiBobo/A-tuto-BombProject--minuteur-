package com.thiti.bombproject;

/**
 * Created by canard on 06/02/18.
 * l'interface TimeDisplay est a implémenter si vous voulez faire des afficheurs pour
 * le temps.
 * Ceux qui permet au classe qui utilise des afficheur qui implémente TimeDisplay de ne pas se
 * soucier de l'affichage avec la méthode display. ^^
 */

public interface TimeDisplay {

    public void display(long time);

}
