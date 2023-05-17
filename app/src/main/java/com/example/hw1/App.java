package com.example.hw1;

import android.app.Application;

import com.example.hw1.Utilities.MySp;
import com.example.hw1.Utilities.SignalGenerator;
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MySp.init(this);
        SignalGenerator.init(this);
    }


}
