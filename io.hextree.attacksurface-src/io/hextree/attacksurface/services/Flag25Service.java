package io.hextree.attacksurface.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import io.hextree.attacksurface.Utils;
import io.hextree.attacksurface.activities.Flag25Activity;
import java.util.UUID;
/* loaded from: classes.dex */
public class Flag25Service extends Service {
    public static String secret = UUID.randomUUID().toString();
    boolean lock1 = false;
    boolean lock2 = false;
    boolean lock3 = false;

    private void resetLocks() {
        this.lock1 = false;
        this.lock2 = false;
        this.lock3 = false;
        Log.i("Flag25Service", "resetting locks");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i("Flag25Service", Utils.dumpIntent(this, intent));
        if (intent != null) {
            if (intent.getAction().equals("io.hextree.services.UNLOCK1")) {
                this.lock1 = true;
            }
            if (intent.getAction().equals("io.hextree.services.UNLOCK2")) {
                if (this.lock1) {
                    this.lock2 = true;
                } else {
                    resetLocks();
                }
            }
            if (intent.getAction().equals("io.hextree.services.UNLOCK3")) {
                if (this.lock2) {
                    this.lock3 = true;
                } else {
                    resetLocks();
                }
            }
            if (this.lock1 && this.lock2 && this.lock3) {
                success();
                resetLocks();
            }
        }
        Log.i("Flag25Service", "lock1:" + this.lock1 + " lock2:" + this.lock2 + " lock3:" + this.lock3);
        return super.onStartCommand(intent, i, i2);
    }

    private void success() {
        Intent intent = new Intent(this, Flag25Activity.class);
        intent.putExtra("secret", secret);
        intent.putExtra("lock", "lock1");
        intent.putExtra("lock2", "lock3");
        intent.addFlags(268468224);
        intent.putExtra("hideIntent", true);
        startActivity(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
