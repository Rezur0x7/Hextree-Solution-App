package io.hextree.attacksurface.providers;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import io.hextree.attacksurface.FlagDatabaseHelper;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.activities.Flag31Activity;
import java.util.UUID;
/* loaded from: classes.dex */
public class Flag31Provider extends ContentProvider {
    public static final String AUTHORITY = "io.hextree.flag31";
    private static final int FLAGS = 1;
    private static final int FLAG_ID = 2;
    public static String secret = UUID.randomUUID().toString();
    private static final UriMatcher uriMatcher;
    private FlagDatabaseHelper dbHelper;

    static {
        UriMatcher uriMatcher2 = new UriMatcher(-1);
        uriMatcher = uriMatcher2;
        uriMatcher2.addURI(AUTHORITY, "flags", 1);
        uriMatcher2.addURI(AUTHORITY, "flag/#", 2);
    }

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
        StringBuilder append = new StringBuilder("Flag31Provider.query('").append(uri.getPath()).append("'): ");
        UriMatcher uriMatcher2 = uriMatcher;
        Log.i("Flag31", append.append(uriMatcher2.match(uri)).toString());
        SQLiteDatabase readableDatabase = this.dbHelper.getReadableDatabase();
        int match = uriMatcher2.match(uri);
        if (match != 1) {
            if (match == 2) {
                long parseId = ContentUris.parseId(uri);
                Log.i("Flag31", "FLAG_ID: " + parseId);
                if (parseId == 31) {
                    LogHelper logHelper = new LogHelper(getContext());
                    logHelper.addTag(uri.getPath());
                    success(logHelper);
                }
                return readableDatabase.query(FlagDatabaseHelper.TABLE_FLAG, strArr, "name=? AND visible=1", new String[]{"flag" + parseId}, null, null, str2);
            }
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        throw new IllegalArgumentException("FLAGS not implemented yet: " + uri);
    }

    public String success(LogHelper logHelper) {
        ContentValues contentValues = new ContentValues();
        String appendLog = logHelper.appendLog(Flag31Activity.FLAG);
        contentValues.put(FlagDatabaseHelper.COLUMN_VALUE, appendLog);
        this.dbHelper.getReadableDatabase().update(FlagDatabaseHelper.TABLE_FLAG, contentValues, "name=?", new String[]{"flag31"});
        try {
            Intent intent = new Intent();
            intent.setClass(getContext(), Flag31Activity.class);
            intent.putExtra("secret", secret);
            intent.addFlags(268435456);
            intent.putExtra("hideIntent", true);
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Flag31Provider", "Exception in start activity. Restart the target app and try again.", e);
        }
        return appendLog;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
