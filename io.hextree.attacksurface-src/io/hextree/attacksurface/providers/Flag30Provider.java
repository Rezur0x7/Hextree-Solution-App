package io.hextree.attacksurface.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import io.hextree.attacksurface.FlagDatabaseHelper;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.activities.Flag30Activity;
import java.util.UUID;
/* loaded from: classes.dex */
public class Flag30Provider extends ContentProvider {
    public static String secret = UUID.randomUUID().toString();
    private FlagDatabaseHelper dbHelper;

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.dbHelper = new FlagDatabaseHelper(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Log.i("Flag30", "Flag30Provider.query('" + uri.getPath() + "')");
        if (uri.getPath().equals("/success")) {
            LogHelper logHelper = new LogHelper(getContext());
            logHelper.addTag(uri.getPath());
            Cursor query = this.dbHelper.getReadableDatabase().query(FlagDatabaseHelper.TABLE_FLAG, strArr, "name=? AND visible=1", new String[]{"flag30"}, null, null, str2);
            query.setNotificationUri(getContext().getContentResolver(), uri);
            success(logHelper);
            return query;
        }
        return null;
    }

    public String success(LogHelper logHelper) {
        ContentValues contentValues = new ContentValues();
        String appendLog = logHelper.appendLog(Flag30Activity.FLAG);
        contentValues.put(FlagDatabaseHelper.COLUMN_VALUE, appendLog);
        this.dbHelper.getReadableDatabase().update(FlagDatabaseHelper.TABLE_FLAG, contentValues, "name=?", new String[]{"flag30"});
        try {
            Intent intent = new Intent();
            intent.setClass(getContext(), Flag30Activity.class);
            intent.putExtra("secret", secret);
            intent.addFlags(268435456);
            intent.putExtra("hideIntent", true);
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Flag30Provider", "Exception in start activity. Restart the target app and try again.", e);
        }
        return appendLog;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
