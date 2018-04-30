package com.manish.servicetutorialpro;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyBackgroundService extends Service {

    public MyBackgroundService() {
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("manish","Started");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }
}
