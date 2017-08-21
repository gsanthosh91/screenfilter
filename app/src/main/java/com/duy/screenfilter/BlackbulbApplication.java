package com.duy.screenfilter;

import android.app.Application;

import com.duy.screenfilter.utils.Utility;

public class BlackbulbApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utility.updateAlarmSettings(this);
    }

}