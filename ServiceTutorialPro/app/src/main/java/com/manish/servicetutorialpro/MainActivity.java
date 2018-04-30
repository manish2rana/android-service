package com.manish.servicetutorialpro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private Intent startIntent;
    // /storage/emulated/0/Download/Dil Chori .mp3
    MyBoundService mBoundService;
    boolean mServiceBound = false;
    TextView timestampText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timestampText = findViewById(R.id.tv);
    }

    public void startService(View view) {
        intent = new Intent(MainActivity.this, MyBackgroundService.class);
        startService(intent);
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
    }

    public void stopService(View view) {
        stopService(intent);
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
    }

    public void startForegroundService(View view) {
        startIntent = new Intent(MainActivity.this, MyForegroundService.class);
        startIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
        startService(startIntent);
        Toast.makeText(this, "Foreground Service Started", Toast.LENGTH_SHORT).show();
    }

    public void stopForegroundService(View view) {
        startIntent = new Intent(MainActivity.this, MyForegroundService.class);
        startIntent.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
        startService(startIntent);
        Toast.makeText(this, "Foreground Service Stopped", Toast.LENGTH_SHORT).show();
    }

    public void startBoundService(View view) {
        Intent intent = new Intent(this, MyBoundService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    public void stopBoundService(View view) {
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
        Intent intent = new Intent(MainActivity.this,
                MyBoundService.class);
        stopService(intent);
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };

    public void showTimeStamp(View view) {
        if (mServiceBound) {
            timestampText.setText(mBoundService.getTimestamp());
        }
    }
}
