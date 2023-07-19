package com.example.practical06

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log


class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {

        Log.d("MyReceiver", "Received the intent action: ${intent.action}")

    }
}