package io.hextree.attacksurface.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.Utils;
import io.hextree.attacksurface.activities.Flag16Activity;
/* loaded from: classes.dex */
public class Flag16Receiver extends BroadcastReceiver {
    public static String FlagSecret = "give-flag-16";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i("Flag16Receiver.onReceive", Utils.dumpIntent(context, intent));
        if (intent.getStringExtra("flag").equals(FlagSecret)) {
            success(context, FlagSecret);
        }
    }

    private void success(Context context, String str) {
        Flag16Activity flag16Activity = new Flag16Activity();
        flag16Activity.f = new LogHelper(context);
        flag16Activity.f.addTag(str);
        flag16Activity.success(null);
        Toast.makeText(context, "Flag: " + flag16Activity.f.appendLog(flag16Activity.flag), 0).show();
        Log.i("Flag16Receiver", "Flag: " + flag16Activity.f.appendLog(flag16Activity.flag));
    }
}
