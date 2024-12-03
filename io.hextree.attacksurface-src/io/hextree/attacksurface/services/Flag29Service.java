package io.hextree.attacksurface.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import io.hextree.attacksurface.Utils;
import io.hextree.attacksurface.activities.Flag29Activity;
import io.hextree.attacksurface.services.IFlag29Interface;
import java.util.UUID;
/* loaded from: classes.dex */
public class Flag29Service extends Service {
    public static String secret = UUID.randomUUID().toString();
    private final IFlag29Interface.Stub binder = new IFlag29Interface.Stub() { // from class: io.hextree.attacksurface.services.Flag29Service.1
        final String pw = UUID.randomUUID().toString();
        Intent intent = new Intent();

        @Override // io.hextree.attacksurface.services.IFlag29Interface
        public String init() throws RemoteException {
            Log.i("Flag29", "service.init()");
            return this.pw;
        }

        @Override // io.hextree.attacksurface.services.IFlag29Interface
        public void authenticate(String str) throws RemoteException {
            Log.i("Flag29", "service.authenticate(" + str + ")");
            if (str.equals(this.pw)) {
                this.intent.putExtra("authenticated", true);
            } else {
                this.intent.removeExtra("authenticated");
            }
        }

        @Override // io.hextree.attacksurface.services.IFlag29Interface
        public void success() throws RemoteException {
            Log.i("Flag29", "service.success()");
            this.intent.setClass(Flag29Service.this, Flag29Activity.class);
            if (this.intent.getBooleanExtra("authenticated", false)) {
                this.intent.putExtra("secret", Flag29Service.secret);
                this.intent.addFlags(268435456);
                this.intent.putExtra("hideIntent", true);
                Flag29Service.this.startActivity(this.intent);
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.i("Flag29Service", Utils.dumpIntent(this, intent));
        return this.binder;
    }
}
