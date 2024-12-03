package io.hextree.attacksurface;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/* loaded from: classes.dex */
public class FlagDatabaseHelper extends SQLiteOpenHelper {
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_VALUE = "value";
    public static final String COLUMN_VISIBLE = "visible";
    private static final String CREATE_TABKE_NOTE = "CREATE TABLE Note (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, content TEXT NOT NULL );";
    private static final String CREATE_TABLE_FLAG = "CREATE TABLE Flag (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, value TEXT NOT NULL, visible INTEGER NOT NULL DEFAULT 1);";
    private static final String DATABASE_NAME = "flag.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_FLAG = "Flag";
    public static final String TABLE_NOTE = "Note";

    public FlagDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.i("FlagDatabaseHelper", "database created");
        sQLiteDatabase.execSQL(CREATE_TABLE_FLAG);
        sQLiteDatabase.execSQL(CREATE_TABKE_NOTE);
        sQLiteDatabase.execSQL("INSERT INTO Flag (name, value, visible) VALUES ('flag30', 'HXT{censored}', 1);");
        sQLiteDatabase.execSQL("INSERT INTO Flag (name, value, visible) VALUES ('flag31', 'HXT{censored}', 1);");
        sQLiteDatabase.execSQL("INSERT INTO Flag (name, value, visible) VALUES ('flag32', 'HXT{censored}', 0);");
        sQLiteDatabase.execSQL("INSERT INTO Note (title, content) VALUES ('secret', 'This is a secret note');");
        sQLiteDatabase.execSQL("INSERT INTO Note (title, content) VALUES ('flag33', 'HXT{censored}');");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS Flag");
        onCreate(sQLiteDatabase);
    }
}
