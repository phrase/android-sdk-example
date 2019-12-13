package com.phrase.example;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import com.phrase.android.sdk.Phrase;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(Phrase.wrap(newBase));
    }
}
