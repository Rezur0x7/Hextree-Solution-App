package io.hextree.attacksurface.services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;
import io.hextree.attacksurface.Utils;
import io.hextree.attacksurface.activities.Flag27Activity;
import java.util.UUID;
/* loaded from: classes.dex */
public class Flag27Service extends Service {
    public static final int MSG_ECHO = 1;
    public static final int MSG_GET_FLAG = 3;
    public static final int MSG_GET_PASSWORD = 2;
    public static String secret = UUID.randomUUID().toString();
    final Messenger messenger = new Messenger(new IncomingHandler(Looper.getMainLooper()));

    /* loaded from: classes.dex */
    class IncomingHandler extends Handler {
        String echo;
        String password;

        IncomingHandler(Looper looper) {
            super(looper);
            this.echo = "";
            this.password = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Log.i("Flag27Service", "handleMessage(" + message.what + ")");
            int i = message.what;
            if (i == 1) {
                this.echo = message.getData().getString("echo");
                Toast.makeText(Flag27Service.this.getApplicationContext(), this.echo, 0).show();
            } else if (i != 2) {
                if (i == 3) {
                    String string = message.getData().getString("password");
                    if (!this.echo.equals("give flag") || !this.password.equals(string)) {
                        Flag27Service.this.sendReply(message, "no flag");
                        return;
                    }
                    Flag27Service.this.sendReply(message, "success! Launching flag activity");
                    Flag27Service.this.success(this.echo);
                    return;
                }
                super.handleMessage(message);
            } else if (message.obj == null) {
                Flag27Service.this.sendReply(message, "Error");
            } else {
                Message obtain = Message.obtain((Handler) null, message.what);
                Bundle bundle = new Bundle();
                String uuid = UUID.randomUUID().toString();
                this.password = uuid;
                bundle.putString("password", uuid);
                obtain.setData(bundle);
                try {
                    message.replyTo.send(obtain);
                    Flag27Service.this.sendReply(message, "Password");
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.i("Flag27Service", Utils.dumpIntent(this, intent));
        return this.messenger.getBinder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendReply(Message message, String str) {
        try {
            Message obtain = Message.obtain((Handler) null, message.what);
            obtain.getData().putString("reply", str);
            message.replyTo.send(obtain);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void success(String str) {
        Intent intent = new Intent(this, Flag27Activity.class);
        intent.putExtra("secret", secret);
        intent.putExtra("echo", str);
        intent.addFlags(268468224);
        intent.putExtra("hideIntent", true);
        startActivity(intent);
    }
}
