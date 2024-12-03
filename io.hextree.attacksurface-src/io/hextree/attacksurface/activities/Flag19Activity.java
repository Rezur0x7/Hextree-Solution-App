package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.receivers.Flag19Widget;
/* loaded from: classes.dex */
public class Flag19Activity extends AppCompactActivity {
    public Flag19Activity() {
        this.name = "Flag 19 - Widget system intents";
        this.flag = "YXCt3QYfH3MoDMQ+xs92zpuhh6EE/vZ0kBQzOled4CvbnmDZqQ9Fv8Zp6VjQ6TXF";
        this.tag = "BroadcastReceiver";
        this.tagColor = R.color.green;
        this.description = Flag19Widget.class.getCanonicalName();
        this.hideIntentDialog = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("appWidgetMaxHeight", -1);
        this.f.addTag(Integer.valueOf(intExtra));
        int intExtra2 = intent.getIntExtra("appWidgetMinHeight", -1);
        this.f.addTag(Integer.valueOf(intExtra2));
        if (intExtra == 1094795585 && intExtra2 == 322376503) {
            success(this);
            return;
        }
        Toast.makeText(this, "Add the widget to the home screen", 0).show();
        sendBroadcast(Flag19Widget.refreshIntent(this));
    }
}
