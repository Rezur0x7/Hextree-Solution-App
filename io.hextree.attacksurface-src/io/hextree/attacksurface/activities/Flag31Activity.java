package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.providers.Flag31Provider;
/* loaded from: classes.dex */
public class Flag31Activity extends AppCompactActivity {
    public static String FLAG = "dteh9owFVzfLjft8NpBJE0+CIdGRShQ/1SvlY+wNE2A=";

    public Flag31Activity() {
        this.name = "Flag 31 - Provider URI Matching";
        this.tag = "Content Provider";
        this.tagColor = R.color.purple;
        this.flag = FLAG;
        this.description = Flag31Provider.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Log.i("Flag30", "In flag30 activity");
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        this.f.addTag("/flag/31");
        if (Flag31Provider.secret.equals(intent.getStringExtra("secret"))) {
            checkStatus(this);
        }
    }
}
