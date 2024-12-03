package io.hextree.attacksurface.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import io.hextree.attacksurface.FlagDatabaseHelper;
import io.hextree.attacksurface.Utils;
import io.hextree.attacksurface.activities.Flag20Activity;
/* loaded from: classes.dex */
public class Flag20Receiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i("Flag20Receiver.onReceive", Utils.dumpIntent(context, intent));
        if (intent.getBooleanExtra("give-flag", false)) {
            success(context);
        } else {
            Toast.makeText(context, "Conditions not correct for flag", 0).show();
        }
    }

    private void success(Context context) {
        Intent intent = new Intent();
        intent.setAction(Flag20Activity.GET_FLAG);
        intent.addFlags(intent.getFlags());
        intent.putExtra(FlagDatabaseHelper.COLUMN_VALUE, "Flag20Success");
        intent.setComponent(new ComponentName(context, Flag20Activity.class));
        Toast.makeText(context, "Success! Open the app to trigger the flag activity", 0).show();
        context.startActivity(intent);
    }
}
