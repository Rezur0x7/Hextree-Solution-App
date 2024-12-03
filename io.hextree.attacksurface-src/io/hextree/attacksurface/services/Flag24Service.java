package io.hextree.attacksurface.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import io.hextree.attacksurface.Utils;
import io.hextree.attacksurface.activities.Flag24Activity;
import java.util.UUID;
/* loaded from: classes.dex */
public class Flag24Service extends Service {
    public static String secret = UUID.randomUUID().toString();

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i("Flag24Service", Utils.dumpIntent(this, intent));
        if (intent.getAction().equals("io.hextree.services.START_FLAG24_SERVICE")) {
            success();
        }
        return super.onStartCommand(intent, i, i2);
    }

    private void success() {
        Intent intent = new Intent(this, Flag24Activity.class);
        intent.setAction("io.hextree.services.START_FLAG24_SERVICE");
        intent.putExtra("secret", secret);
        intent.addFlags(268468224);
        intent.putExtra("hideIntent", true);
        startActivity(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
