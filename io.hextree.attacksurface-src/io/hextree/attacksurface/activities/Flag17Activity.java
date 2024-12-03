package io.hextree.attacksurface.activities;

import android.os.Bundle;
import android.widget.Toast;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.receivers.Flag17Receiver;
/* loaded from: classes.dex */
public class Flag17Activity extends AppCompactActivity {
    public Flag17Activity() {
        this.name = "Flag 17 - Receiver with response";
        this.flag = "7ZA7MBPhM0qp41ivFuDRJu/32LOn7/2sDN+6nmfTwis=";
        this.tag = "BroadcastReceiver";
        this.tagColor = R.color.green;
        this.description = Flag17Receiver.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Toast.makeText(this, "Investigate the broadcast receiver", 0).show();
        finish();
    }
}
