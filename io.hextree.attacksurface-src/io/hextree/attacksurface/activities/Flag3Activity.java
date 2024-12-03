package io.hextree.attacksurface.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
/* loaded from: classes.dex */
public class Flag3Activity extends AppCompactActivity {
    public Flag3Activity() {
        this.name = "Flag 3 - Intent with a data URI";
        this.flag = "G4yi3uCGLvKhT12+f6RPn1Uc8iMapJnbjGnILAvtdOA=";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null || !action.equals("io.hextree.action.GIVE_FLAG")) {
            return;
        }
        this.f.addTag(action);
        Uri data = intent.getData();
        if (data == null || !data.toString().equals("https://app.hextree.io/map/android")) {
            return;
        }
        this.f.addTag(data);
        success(this);
    }
}
