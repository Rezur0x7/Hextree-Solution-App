package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.providers.Flag32Provider;
/* loaded from: classes.dex */
public class Flag32Activity extends AppCompactActivity {
    public static String FLAG = "tXRw27D88Ckc8bTBuO5e7aNgGD7s/VwMXgQLK9KYbt3RehLILoGwRCBj1BI1BhsP";

    public Flag32Activity() {
        this.name = "Flag 32 - Injections in Content Provider";
        this.tag = "Content Provider";
        this.tagColor = R.color.purple;
        this.flag = FLAG;
        this.description = Flag32Provider.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        this.f.addTag("/flags");
        this.f.addTag("flag32");
        if (Flag32Provider.secret.equals(intent.getStringExtra("secret"))) {
            checkStatus(this);
        }
    }
}
