package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.services.Flag29Service;
/* loaded from: classes.dex */
public class Flag29Activity extends AppCompactActivity {
    public Flag29Activity() {
        this.name = "Flag 29 - AIDL Service";
        this.tag = "Service";
        this.tagColor = R.color.blue;
        this.flag = "bQflULGhtSl8+vo0LaSnA8hhuw5FVmeKfI3Fd4oupJk=";
        this.description = Flag29Service.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        if (intent.getBooleanExtra("authenticated", false)) {
            this.f.addTag("authenticated");
            if (Flag29Service.secret.equals(intent.getStringExtra("secret"))) {
                success(this);
            }
        }
    }
}
