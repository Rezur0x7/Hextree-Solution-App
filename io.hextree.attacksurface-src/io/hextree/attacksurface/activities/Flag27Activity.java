package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.services.Flag27Service;
/* loaded from: classes.dex */
public class Flag27Activity extends AppCompactActivity {
    public Flag27Activity() {
        this.name = "Flag 27 - Message replies";
        this.tag = "Service";
        this.tagColor = R.color.blue;
        this.flag = "TsWBtgmdnZt/EgIh08hv4TFLkoGRYhHoMAxirw/5sKY=";
        this.description = Flag27Service.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("secret");
        this.f.addTag(intent.getStringExtra("echo"));
        if (Flag27Service.secret.equals(stringExtra)) {
            success(this);
        }
    }
}
