package io.hextree.attacksurface.activities;

import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
/* loaded from: classes.dex */
public class Flag1Activity extends AppCompactActivity {
    public Flag1Activity() {
        this.name = "Flag 1 - Basic exported activity";
        this.flag = "zABitOReWutKdkrMKx2NPVXklOmLz1SB85u2kJjUe1ojI9LMWkbEKkjANz15WHmb";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        this.f.addTag("basic-main-activity-avd2");
        success(this);
    }
}
