package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.providers.Flag33Provider2;
/* loaded from: classes.dex */
public class Flag33Activity2 extends AppCompactActivity {
    public static String FLAG = Flag33Activity1.FLAG;

    public Flag33Activity2() {
        this.name = "Flag 33.2 - Implicit Provider Access";
        this.tag = "Content Provider";
        this.tagColor = R.color.purple;
        this.flag = FLAG;
        this.description = Flag33Activity2.class.getCanonicalName();
        this.allowOpenActivity = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("secret");
        if (stringExtra == null) {
            Intent intent = new Intent();
            intent.setAction("io.hextree.FLAG33");
            intent.setData(Uri.parse("content://io.hextree.flag33_2/flags"));
            intent.addFlags(1);
            startActivity(intent);
        } else if (Flag33Provider2.secret.equals(stringExtra)) {
            this.f = new LogHelper(this);
            this.f.addTag("access-notes-table");
            this.f.addTag("flag33");
            checkStatus(this);
        }
    }
}
