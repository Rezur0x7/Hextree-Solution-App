package io.hextree.attacksurface.activities;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import io.hextree.attacksurface.AppCompactActivity;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public class Flag37Activity extends AppCompactActivity {
    public static String FLAG = "WoNPOlspyGCBEQZwaAnwlwMA37TJAykybd/GzI3E2kM=";

    public Flag37Activity() {
        this.name = "Flag 37 - Filename Traversal";
        this.tag = "File Provider";
        this.tagColor = R.color.purple;
        this.flag = FLAG;
        this.description = Flag37Activity.class.getCanonicalName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.hextree.attacksurface.AppCompactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f = new LogHelper(this);
        Uri data = getIntent().getData();
        Cursor cursor = null;
        try {
            try {
                cursor = getContentResolver().query(data, null, null, null, null);
                if (cursor != null && cursor.moveToFirst()) {
                    String string = cursor.getString(cursor.getColumnIndex("_display_name"));
                    long j = cursor.getLong(cursor.getColumnIndex("_size"));
                    this.f.addTag(Long.valueOf(j));
                    this.f.addTag(string);
                    if ("../flag37.txt".equals(string) && j == 1337) {
                        InputStream openInputStream = getContentResolver().openInputStream(data);
                        if (openInputStream != null) {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openInputStream));
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            openInputStream.close();
                            this.f.addTag(sb.toString());
                            if ("give flag".equals(sb.toString())) {
                                success(this);
                            } else {
                                Log.i("Flag37", "File content '" + ((Object) sb) + "' is not 'give flag'");
                            }
                        }
                    } else {
                        Log.i("Flag37", "File name '" + string + "' or size '" + j + "' does not match");
                    }
                }
                if (cursor == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (0 == 0) {
                    return;
                }
            }
            cursor.close();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }
}
