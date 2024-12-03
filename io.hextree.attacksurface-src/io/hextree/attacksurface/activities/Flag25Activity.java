package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.services.Flag25Service;
/* loaded from: classes.dex */
public class Flag25Activity extends AppCompactActivity {
    public Flag25Activity() {
        this.name = "Flag 25 - Service lifecycle";
        this.tag = "Service";
        this.tagColor = R.color.blue;
        this.flag = "vzcn6M5nWarsA5e4srAhLeW9yeCGYKu6UN2ZuJP5PvSzR9JcgYD4a7Nw82ah0h5J";
        this.description = Flag25Service.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("secret");
        String stringExtra2 = intent.getStringExtra("lock");
        String stringExtra3 = intent.getStringExtra("lock2");
        this.f.addTag(stringExtra2);
        this.f.addTag(stringExtra3);
        if (Flag25Service.secret.equals(stringExtra)) {
            success(this);
        }
    }
}
