package edu.galileo.android.tipcalc;

import android.app.Application;

/**
 * Created by user2 on 13-jun-16.
 */
public class TipCalcApp extends Application {
    private final static String ABOUT_URL = "http://about.me/adriancatalan";

    public String getAboutUrl(){
        return ABOUT_URL;
    }
}




