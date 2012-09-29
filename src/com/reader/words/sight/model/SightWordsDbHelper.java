package com.reader.words.sight.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SightWordsDbHelper extends SQLiteOpenHelper{
	
	private static final String DB_NAME = "sightwords_reader_data";
	private static final String TAG = "SightWordsDbHelper";
	
	private Context context;
	
	private static final int DATABASE_VERSION = 2;

	
	public SightWordsDbHelper(Context context) {
		super(context, DB_NAME, null, DATABASE_VERSION);
		this.context = context; 
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		initDatabaseData(db, "create.txt");
		initDatabaseData(db, "seed.txt");
//		db.openDatabase(path, factory, flags)
		String dbPath = db.getPath();
		
	}
	
	private void initDatabaseData(SQLiteDatabase db, String fileName) {
		
		BufferedReader br = null;
	    try {
	    	
	        br = new BufferedReader(new InputStreamReader(context.getAssets().open(fileName)), 1024 * 4);
	        String line = null;
	        db.beginTransaction();
	        
	        while ((line = br.readLine()) != null) {
	            db.execSQL(line);
	        }
	        
	        db.setTransactionSuccessful();
	        
	    } catch (IOException e) {
	        Log.e(TAG, "read database init file error");
	    } finally {
	    	
	        db.endTransaction();
	        if (br != null) {
	            try {
	                br.close();
	            } catch (IOException e) {
	                Log.e(TAG, "buffer reader close error");
	            }
	        }
	    }
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
				+ newVersion + ", which will destroy all old data");

		
		
		initDatabaseData(db, "drop.txt");
		
		onCreate(db);
	}
}
