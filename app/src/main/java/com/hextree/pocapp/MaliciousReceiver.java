package com.hextree.pocapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MaliciousReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //Receive broadcast intents and send resultdata (resultcode only) (Flag18)
        String action = intent.getAction();
        Log.d("BroadcastReceiver", "Received broadcast with action: " + action);
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String flag = extras.getString("flag");
            Log.d("BroadcastReceiver", flag);
        }
        setResultCode(1);
        Bundle resultExtras = new Bundle();
        setResultExtras(resultExtras);
    }
}