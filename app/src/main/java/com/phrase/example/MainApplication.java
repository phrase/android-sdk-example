package com.phrase.example;

import android.app.Application;
import android.content.Context;

import com.phrase.android.sdk.Phrase;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Phrase.setup(this, "", "");
        Phrase.updateTranslations();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Phrase.wrapApplicationContext(newBase));
    }
}