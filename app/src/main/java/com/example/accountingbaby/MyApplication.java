package com.example.accountingbaby;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 啟動Stetho
        Stetho.initializeWithDefaults(this);
    }
}
