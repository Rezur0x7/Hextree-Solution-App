package io.hextree.attacksurface.activities;

import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
/* loaded from: classes.dex */
public class Flag2Activity extends AppCompactActivity {
    public Flag2Activity() {
        this.name = "Flag 2 - Intent with extras";
        this.flag = "isqgqnB4bH/YSoOdSSLAG9gapPgYCyFBT7e3/3lUoAfTX5K9HeR5F8xSBndpPZT1";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        String action = getIntent().getAction();
        if (action == null || !action.equals("io.hextree.action.GIVE_FLAG")) {
            return;
        }
        this.f.addTag(action);
        success(this);
    }
}
