package com.example.legend;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class JugadorSQL extends SQLiteOpenHelper{

	public static final String TABLE_COMMENTS = "jugador";
	public static final String COLUMN_ID = "id_jugador";
	public static final String COLUMN_COMMENT = "comment";

	private static final String DATABASE_NAME = "jugadores.db";
	private static final int DATABASE_VERSION = 1;
	  
	
	public JugadorSQL(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }
	
	
	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	

}
