package com.phrase.example;

import android.app.Application;

import com.phrase.android.sdk.Phrase;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Phrase.setup(this, "", "");
        Phrase.updateTranslations();
    }
}