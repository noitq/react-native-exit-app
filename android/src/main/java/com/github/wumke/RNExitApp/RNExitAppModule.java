package com.github.wumke.RNExitApp;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RNExitAppModule extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;
    AlarmManager alarmManager;

    public RNExitAppModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        alarmManager = (AlarmManager) reactContext.getSystemService(Context.ALARM_SERVICE);
    }

    @Override
    public String getName() {
        return "RNExitApp";
    }

    @ReactMethod
    public void exitApp() {
        // this way remain instance in "recent app" after calling this function
        // android.os.Process.killProcess(android.os.Process.myPid());

        // this way clear instance in "recent app" after calling this function
        if(android.os.Build.VERSION.SDK_INT >= 21){
                getCurrentActivity().finishAndRemoveTask();
        }
        else{
            getCurrentActivity().finish();
        }
    }
}
