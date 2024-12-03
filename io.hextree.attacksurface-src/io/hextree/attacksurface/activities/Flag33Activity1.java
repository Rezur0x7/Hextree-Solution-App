package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.providers.Flag33Provider1;
/* loaded from: classes.dex */
public class Flag33Activity1 extends AppCompactActivity {
    public static String FLAG = "rB3JCu28J539ayh6bZRI1JHCy+GaWVphuIxf7FiCaZ1vvZ5k7McF5A97w/Jw9ozr";

    public Flag33Activity1() {
        this.name = "Flag 33.1 - Return Provider Access";
        this.tag = "Content Provider";
        this.tagColor = R.color.purple;
        this.flag = FLAG;
        this.description = Flag33Activity1.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("secret");
        if (stringExtra == null) {
            if (intent.getAction() == null || !intent.getAction().equals("io.hextree.FLAG33")) {
                return;
            }
            intent.setData(Uri.parse("content://io.hextree.flag33_1/flags"));
            intent.addFlags(1);
            setResult(-1, intent);
            finish();
        } else if (Flag33Provider1.secret.equals(stringExtra)) {
            this.f = new LogHelper(this);
            this.f.addTag("access-notes-table");
            this.f.addTag("flag33");
            checkStatus(this);
        }
    }
}
