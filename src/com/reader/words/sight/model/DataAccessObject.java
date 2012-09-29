package com.reader.words.sight.model;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public abstract class DataAccessObject {
	
	private SQLiteDatabase mDb;
	private SightWordsDbHelper mDbHelper;
	private Context mContext;
	
	
	public DataAccessObject(Context context) {
		this.mContext = context;
		mDbHelper = new SightWordsDbHelper(context);
	}
	
	protected SQLiteDatabase getDb() {
		return mDb;
	}
	
	protected Context getContext() {
		return mContext;
	}
	
	public void open() throws SQLException {
		mDb = mDbHelper.getWritableDatabase();
	}

	public void close() {
		mDbHelper.close();
	}
	
	/**
	 * 1 == true, 0 == false
	 * @param value
	 * @return
	 */
	protected boolean dbIntToBool(int value) {
		return value == 1;
	}

	protected int boolToDbInt(boolean value) {
		return value ? 1 : 0;
	}
}
