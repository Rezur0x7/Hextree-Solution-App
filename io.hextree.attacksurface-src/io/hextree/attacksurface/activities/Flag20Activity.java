package io.hextree.attacksurface.activities;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.FlagDatabaseHelper;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.receivers.Flag20Receiver;
/* loaded from: classes.dex */
public class Flag20Activity extends AppCompactActivity {
    public static String GET_FLAG = "io.hextree.broadcast.GET_FLAG";

    public Flag20Activity() {
        this.name = "Flag 20 - Notification button intents";
        this.flag = "8eCaS3fQmTRC6Ovk+TXQ0kPDOihOczsLbmI8FcBBs1XwzV9KOuevZhIzDlr6knoy";
        this.tag = "BroadcastReceiver";
        this.tagColor = R.color.green;
        this.hideIntentDialog = true;
    }

    private void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_ID", "Hextree Notifications", 3);
        notificationChannel.setDescription("Notifications related to various intent attack surface features. Probably good idea to reverse engineer this notification.");
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        createNotificationChannel();
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (action != null && action.equals(GET_FLAG)) {
            this.f.addTag(GET_FLAG);
            this.f.addTag(intent.getStringExtra(FlagDatabaseHelper.COLUMN_VALUE));
            success(this);
            return;
        }
        Flag20Receiver flag20Receiver = new Flag20Receiver();
        IntentFilter intentFilter = new IntentFilter(GET_FLAG);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(flag20Receiver, intentFilter, 2);
        } else {
            registerReceiver(flag20Receiver, intentFilter);
        }
        NotificationCompat.Builder addAction = new NotificationCompat.Builder(this, "CHANNEL_ID").setSmallIcon(R.drawable.hextree_logo).setContentTitle(this.name).setContentText("Reverse engineer classes Flag20Activity and Flag20Receiver").setPriority(0).setAutoCancel(true).addAction(R.drawable.hextree_logo, "Get Flag", PendingIntent.getBroadcast(this, 0, new Intent(GET_FLAG), 201326592));
        if (ActivityCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1);
                return;
            }
            return;
        }
        NotificationManagerCompat.from(this).notify(1, addAction.build());
        Toast.makeText(this, "Check your notifications", 0).show();
    }
}
