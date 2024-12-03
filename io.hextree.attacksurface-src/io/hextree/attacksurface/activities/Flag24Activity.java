package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.services.Flag24Service;
/* loaded from: classes.dex */
public class Flag24Activity extends AppCompactActivity {
    public Flag24Activity() {
        this.name = "Flag 24 - Basic service start";
        this.tag = "Service";
        this.tagColor = R.color.blue;
        this.flag = "LyawUjxPt4tx+lYns1wrupDU3YaQ2t8bJmYW6BA+QUk=";
        this.description = Flag24Service.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("secret");
        this.f.addTag(intent.getAction());
        if (Flag24Service.secret.equals(stringExtra)) {
            success(this);
        }
    }
}
