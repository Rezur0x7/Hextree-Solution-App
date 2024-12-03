package io.hextree.attacksurface.activities;

import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.services.Flag28Service;
/* loaded from: classes.dex */
public class Flag28Activity extends AppCompactActivity {
    public Flag28Activity() {
        this.name = "Flag 28 - Basic AIDL Service";
        this.tag = "Service";
        this.tagColor = R.color.blue;
        this.flag = "Kh+41ed3rpIX4JGInDS5ZL/etvbR8UbBDiqAEC2Q1Es=";
        this.description = Flag28Service.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        if (Flag28Service.secret.equals(getIntent().getStringExtra("secret"))) {
            this.f.addTag("authenticated");
            success(this);
        }
    }
}
