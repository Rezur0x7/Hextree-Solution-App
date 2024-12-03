package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.providers.Flag30Provider;
/* loaded from: classes.dex */
public class Flag30Activity extends AppCompactActivity {
    public static String FLAG = "1OA7PCr94n2JGOvDNzepAn2Q8BRQNlwMZm4zIkDGYqM=";

    public Flag30Activity() {
        this.name = "Flag 30 - Content Provider Query";
        this.tag = "Content Provider";
        this.tagColor = R.color.purple;
        this.flag = FLAG;
        this.description = Flag30Provider.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Log.i("Flag30", "In flag30 activity");
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        this.f.addTag("/success");
        if (Flag30Provider.secret.equals(intent.getStringExtra("secret"))) {
            checkStatus(this);
        }
    }
}
