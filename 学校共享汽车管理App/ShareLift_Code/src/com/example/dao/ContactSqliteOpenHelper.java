package com.example.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Create tables
 *
 */
public class ContactSqliteOpenHelper extends SQLiteOpenHelper {
	public ContactSqliteOpenHelper(Context context) {
		super(context, "share_db.db", null, 4);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
				db.execSQL("create table " + ConstDB.Table.TABLE_PARENT + "("
						+ " id integer primary key autoincrement ,"
						+ ConstDB.ParentTable. USERNAME+ " varchar(50) ,"
						+ ConstDB.ParentTable. PASSWORD+ " varchar(50) ,"
						+ ConstDB.ParentTable. CHILDNAME+ " varchar(50) ,"
						+ ConstDB.ParentTable. CHILDCLASSNUMBER+ " varchar(50) ,"
						+ ConstDB.ParentTable. CHILDSTUDENTID+ " varchar(50) ,"
						+ ConstDB.ParentTable. PHONENUMBER+ " varchar(50) ,"
						+ ConstDB.ParentTable.HOMEADDRESS + " varchar(10) ,"
						+ ConstDB.ParentTable.DISTRICT + " varchar(100) ,"
						+ ConstDB.ParentTable.DRIVER + " varchar(100) ,"
						+ ConstDB.ParentTable.CAR + " varchar(100) ,"
						+ ConstDB.ParentTable.SEAT + " integer)");
				
				db.execSQL("create table " + ConstDB.Table.TABLE_TEACHER + "("
						+ " id integer primary key autoincrement ,"
						+ ConstDB.TeacherTable. USERNAME+ " varchar(50) ,"
						+ ConstDB.TeacherTable. PASSWORD+ " varchar(50) ,"
						+ ConstDB.TeacherTable. PHONENUMBER+ " varchar(50) ,"
						+ ConstDB.TeacherTable.EMPLOYEEID + " varchar(50))");
		
				db.execSQL("create table " + ConstDB.Table.TABLE_OFFER + "("
						+ " id integer primary key autoincrement ,"
						+ ConstDB.OfferTable. REQUESTID+ " integer ,"
						+ ConstDB.OfferTable. USERNAME+ " varchar(50) ,"
						+ ConstDB.OfferTable. DATE+ " varchar(50) ,"
						+ ConstDB.OfferTable. BORADDINGTIME+ " varchar(50) ,"
						+ ConstDB.OfferTable. ADDRESS+ " varchar(50) ,"
						+ ConstDB.OfferTable. DISTRICT+ " varchar(50) ,"
						+ ConstDB.OfferTable. SEAT+ " integer ,"
						+ ConstDB.OfferTable.STATUS + " integer)");
				
				db.execSQL("create table " + ConstDB.Table.TABLE_REQUEST + "("
						+ " id integer primary key autoincrement ,"
						+ ConstDB.RequestTable. OFFERID+ " integer ,"
						+ ConstDB.RequestTable. USERNAME+ " varchar(50) ,"
						+ ConstDB.RequestTable. DATE+ " varchar(50) ,"
						+ ConstDB.RequestTable. BORADDINGTIME+ " varchar(50) ,"
						+ ConstDB.RequestTable. ADDRESS+ " varchar(50) ,"
						+ ConstDB.RequestTable. DISTRICT+ " varchar(50) ,"
						+ ConstDB.RequestTable. PASSENGERS+ " integer ,"
						+ ConstDB.RequestTable.STATUS + " integer)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
