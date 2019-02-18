package com.phraseapp.example;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import com.phraseapp.android.sdk.PhraseApp;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(PhraseApp.wrap(newBase));
    }
}
