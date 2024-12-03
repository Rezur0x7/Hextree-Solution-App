package io.hextree.attacksurface.activities;

import android.os.Bundle;
import android.util.Log;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.Flag36Preferences;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
/* loaded from: classes.dex */
public class Flag36Activity extends AppCompactActivity {
    public static String FLAG = "fA3OGvf5xbAywb2Y5tTulR2SVet9RPuk4pDvuaTFz9KME9rmgNI7m3wuwcemr/Sc";

    public Flag36Activity() {
        this.name = "Flag 36 - Overwriting Shared Prefs";
        this.tag = "File Provider";
        this.tagColor = R.color.purple;
        this.flag = FLAG;
        this.description = Flag36Activity.class.getCanonicalName();
        this.allowOpenActivity = true;
        this.hideIntentDialog = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        this.f.addTag(Boolean.valueOf(Flag36Preferences.getBoolean("solved", false)));
        if (Flag36Preferences.getBoolean("solved", false)) {
            this.f.addTag(Flag36Preferences.class);
            success(this);
            return;
        }
        Log.i("Flag36", "The flag36 shared preferences say this is not solved yet");
    }
}
