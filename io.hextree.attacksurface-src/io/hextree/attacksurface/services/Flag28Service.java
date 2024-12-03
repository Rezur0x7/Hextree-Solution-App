package io.hextree.attacksurface.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import io.hextree.attacksurface.Utils;
import io.hextree.attacksurface.activities.Flag28Activity;
import io.hextree.attacksurface.services.IFlag28Interface;
import java.util.UUID;
/* loaded from: classes.dex */
public class Flag28Service extends Service {
    public static String secret = UUID.randomUUID().toString();
    private final IFlag28Interface.Stub binder = new IFlag28Interface.Stub() { // from class: io.hextree.attacksurface.services.Flag28Service.1
        @Override // io.hextree.attacksurface.services.IFlag28Interface
        public boolean openFlag() throws RemoteException {
            return success();
        }

        public boolean success() {
            Intent intent = new Intent();
            intent.setClass(Flag28Service.this, Flag28Activity.class);
            intent.putExtra("secret", Flag28Service.secret);
            intent.addFlags(268468224);
            intent.putExtra("hideIntent", true);
            Flag28Service.this.startActivity(intent);
            return true;
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.i("Flag28Service", Utils.dumpIntent(this, intent));
        return this.binder;
    }
}
