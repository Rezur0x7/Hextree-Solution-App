package io.hextree.attacksurface.activities;

import android.os.Bundle;
import android.widget.Toast;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.receivers.Flag16Receiver;
/* loaded from: classes.dex */
public class Flag16Activity extends AppCompactActivity {
    public Flag16Activity() {
        this.name = "Flag 16 - Basic exposed receiver";
        this.flag = "JqU8fjotmwbiGC9VoSA+HoXezSd+4u/B19vOue9o1Lg=";
        this.tag = "BroadcastReceiver";
        this.tagColor = R.color.green;
        this.description = Flag16Receiver.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        String stringExtra = getIntent().getStringExtra("flag");
        if (stringExtra != null && stringExtra.equals(Flag16Receiver.FlagSecret)) {
            this.f.addTag(stringExtra);
            success(this);
            return;
        }
        Toast.makeText(this, "Investigate the broadcast receiver", 0).show();
        finish();
    }
}
