package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.services.Flag26Service;
/* loaded from: classes.dex */
public class Flag26Activity extends AppCompactActivity {
    public Flag26Activity() {
        this.name = "Flag 26 - Basic message handler";
        this.tag = "Service";
        this.tagColor = R.color.blue;
        this.flag = "YDQWrV9sGD7Nzk/QRe4kDvclqav0b+Jyl8sxjNF3N/c=";
        this.description = Flag26Service.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("secret");
        this.f.addTag(Integer.valueOf(intent.getIntExtra("what", -1)));
        if (Flag26Service.secret.equals(stringExtra)) {
            success(this);
        }
    }
}
