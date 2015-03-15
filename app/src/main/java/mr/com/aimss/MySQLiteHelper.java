package mr.com.aimss;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by MR on 2/9/2015.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_NOTES = "notes";

    public static final String COLUMN_ID = "_id";

    public static final String COLUMN_NOTE = "note";

    private static final String DATABASE_NAME = "notes.db";

    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NOTES + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_NOTE
            + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        onCreate(db);
    }

}