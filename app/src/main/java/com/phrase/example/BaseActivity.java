package com.phrase.example;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.phrase.android.sdk.Phrase;

public class BaseActivity extends AppCompatActivity {
    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        return Phrase.getDelegate(this, super.getDelegate());
    }
}
