package io.hextree.attacksurface.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import io.hextree.attacksurface.Utils;
import io.hextree.attacksurface.activities.Flag26Activity;
import java.util.UUID;
/* loaded from: classes.dex */
public class Flag26Service extends Service {
    public static final int MSG_SUCCESS = 42;
    public static String secret = UUID.randomUUID().toString();
    final Messenger messenger = new Messenger(new IncomingHandler(Looper.getMainLooper()));

    /* loaded from: classes.dex */
    class IncomingHandler extends Handler {
        String echo;

        IncomingHandler(Looper looper) {
            super(looper);
            this.echo = "";
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.i("Flag26Service", "handleMessage(" + message.what + ")");
            if (message.what == 42) {
                Flag26Service.this.success(this.echo);
            } else {
                super.handleMessage(message);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.i("Flag26Service", Utils.dumpIntent(this, intent));
        return this.messenger.getBinder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void success(String str) {
        Intent intent = new Intent(this, Flag26Activity.class);
        intent.putExtra("secret", secret);
        intent.putExtra("what", 42);
        intent.addFlags(268468224);
        intent.putExtra("hideIntent", true);
        startActivity(intent);
    }
}
