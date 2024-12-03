package io.hextree.attacksurface.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import io.hextree.attacksurface.Utils;
import java.io.File;
/* loaded from: classes.dex */
public class Flag34Activity extends AppCompactActivity {
    public static String FLAG = "odku80B0ub1HAB/HVRDwNmNGdmHGt9fO13eZ9cK7QqNvWiWnSZ2U7dH7Mnl2BAb+";

    public Flag34Activity() {
        this.name = "Flag 34 - Simple File Provider";
        this.tag = "File Provider";
        this.tagColor = R.color.purple;
        this.flag = FLAG;
        this.description = Flag34Activity.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("filename");
        if (stringExtra != null) {
            prepareFlag(this, stringExtra);
            Uri uriForFile = FileProvider.getUriForFile(this, "io.hextree.files", new File(getFilesDir(), stringExtra));
            Intent intent = new Intent();
            intent.setData(uriForFile);
            intent.addFlags(3);
            setResult(0, intent);
            return;
        }
        Uri uriForFile2 = FileProvider.getUriForFile(this, "io.hextree.files", new File(getFilesDir(), "secret.txt"));
        Intent intent2 = new Intent();
        intent2.setData(uriForFile2);
        intent2.addFlags(3);
        setResult(-1, intent2);
    }

    void prepareFlag(Context context, String str) {
        if (str.contains("flag34.txt") && new File(getFilesDir(), str).exists()) {
            LogHelper logHelper = new LogHelper(context);
            logHelper.addTag("file-provider");
            logHelper.addTag("flag34");
            Utils.writeFile(this, "flags/flag34.txt", logHelper.appendLog(FLAG));
        }
    }
}
