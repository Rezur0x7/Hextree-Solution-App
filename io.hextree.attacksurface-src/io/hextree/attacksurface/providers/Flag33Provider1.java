package io.hextree.attacksurface.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Intent;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import io.hextree.attacksurface.FlagDatabaseHelper;
import io.hextree.attacksurface.LogHelper;
import io.hextree.attacksurface.activities.Flag33Activity1;
import java.util.UUID;
/* loaded from: classes.dex */
public class Flag33Provider1 extends ContentProvider {
    public static final String AUTHORITY = "io.hextree.flag33_1";
    private static final int FLAGS = 1;
    private static final int NOTES = 2;
    public static String secret = UUID.randomUUID().toString();
    private static final UriMatcher uriMatcher;
    private FlagDatabaseHelper dbHelper;

    static {
        UriMatcher uriMatcher2 = new UriMatcher(-1);
        uriMatcher = uriMatcher2;
        uriMatcher2.addURI(AUTHORITY, "flags", 1);
        uriMatcher2.addURI(AUTHORITY, "notes", 2);
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
        StringBuilder append = new StringBuilder("Flag33Provider1.query('").append(uri.getPath()).append("'): ");
        UriMatcher uriMatcher2 = uriMatcher;
        Log.i("Flag33Provider1", append.append(uriMatcher2.match(uri)).toString());
        SQLiteDatabase readableDatabase = this.dbHelper.getReadableDatabase();
        int match = uriMatcher2.match(uri);
        if (match != 1) {
            if (match == 2) {
                throw new IllegalArgumentException("access to Notes table not yet implemented");
            }
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        LogHelper logHelper = new LogHelper(getContext());
        logHelper.addTag("access-notes-table");
        logHelper.addTag("flag33");
        prepareDB(logHelper);
        Cursor query = readableDatabase.query(FlagDatabaseHelper.TABLE_FLAG, strArr, str, strArr2, null, null, str2);
        if (containsFlag33(query)) {
            success(logHelper);
        }
        return query;
    }

    void prepareDB(LogHelper logHelper) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(FlagDatabaseHelper.COLUMN_CONTENT, logHelper.appendLog(Flag33Activity1.FLAG));
        this.dbHelper.getReadableDatabase().update(FlagDatabaseHelper.TABLE_NOTE, contentValues, "title=?", new String[]{"flag33"});
    }

    public boolean containsFlag33(Cursor cursor) {
        if (cursor == null) {
            return false;
        }
        boolean z = false;
        while (cursor.moveToNext()) {
            int i = 0;
            while (true) {
                if (i >= cursor.getColumnCount()) {
                    break;
                } else if ("flag33".equals(cursor.getString(i))) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        return z;
    }

    public void success(LogHelper logHelper) {
        try {
            Intent intent = new Intent();
            intent.setClass(getContext(), Flag33Activity1.class);
            intent.putExtra("secret", secret);
            intent.addFlags(268435456);
            intent.putExtra("hideIntent", true);
            getContext().startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Flag33Provider1", "Exception in start activity. Restart the target app and try again.", e);
        }
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
