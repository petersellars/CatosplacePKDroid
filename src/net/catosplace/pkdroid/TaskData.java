package net.catosplace.pkdroid;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class TaskData extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "pkdroid.db";
	private static final int DATABASE_VERSION = 1;
	
	public static final String TABLE_NAME = "tasks";
	
	public static final String _ID = BaseColumns._ID;
	public static final String TASK = "task";
	public static final String STATUS = "status";
	
	public TaskData(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// CREATE TABLE teas 
		// (id INTEGER PRIMARY KEY AUTOINCREMENT, task TEXT NOT NULL, status INTEGER);
		String sql =
			"CREATE TABLE " + TABLE_NAME + " ("
			+ _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ TASK + " TEXT NOT NULL, "
			+ STATUS + " INTEGER"
			+ ");";
	
	  	db.execSQL(sql);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	  	onCreate(db);
	}
	
	public void insert(String task, int status) {
		SQLiteDatabase db = getWritableDatabase();

	  	ContentValues values = new ContentValues();
	  	values.put(TASK, task);
	  	values.put(STATUS, status);

	  	db.insertOrThrow(TABLE_NAME, null, values);
	}
	
	public Cursor all(Activity activity) {
		String[] from = { _ID, TASK, STATUS };
		String order = TASK;

		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, from, null, null, null, null, order);
		activity.startManagingCursor(cursor);

		return cursor;
	}
	
	public long count() {
	    SQLiteDatabase db = getReadableDatabase();
	    return DatabaseUtils.queryNumEntries(db, TABLE_NAME);
	}

}
