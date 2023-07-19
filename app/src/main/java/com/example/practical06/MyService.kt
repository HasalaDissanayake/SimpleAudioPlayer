package com.example.practical06

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.d("MyService", "Service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("MyService", "Service started")
        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}