package com.example.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.entry.Parent;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ParentDao {
	
	public static List<Parent> findAllData(Context context) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		List<Parent> parents = new ArrayList<Parent>();
		try {
			db = getDataBase(context);
			Parent parent = null;
			Cursor c = db.query(ConstDB.Table.TABLE_PARENT, null, null, null, null, null, null);
			while (c.moveToNext()) {
				parent = new Parent();
				parent.id = c.getInt(c.getColumnIndex("id"));
				parent.seat = c.getInt(c.getColumnIndex(ConstDB.ParentTable.SEAT));
				parent.userName = c.getString(c.getColumnIndex(ConstDB.ParentTable.USERNAME));
				parent.password = c.getString(c.getColumnIndex(ConstDB.ParentTable.PASSWORD));
				parent.childName = c.getString(c.getColumnIndex(ConstDB.ParentTable.CHILDNAME));
				parent.childStudentID = c.getString(c.getColumnIndex(ConstDB.ParentTable.CHILDSTUDENTID));
				parent.childClassNumber = c.getString(c.getColumnIndex(ConstDB.ParentTable.CHILDCLASSNUMBER));
				parent.phoneNumber = c.getString(c.getColumnIndex(ConstDB.ParentTable.PHONENUMBER));
				parent.homeAddress = c.getString(c.getColumnIndex(ConstDB.ParentTable.HOMEADDRESS));
				parent.car = c.getString(c.getColumnIndex(ConstDB.ParentTable.CAR));
				parent.driver = c.getString(c.getColumnIndex(ConstDB.ParentTable.DRIVER));
				parent.district = c.getString(c.getColumnIndex(ConstDB.ParentTable.DISTRICT));
				parents.add(parent);
			}
			c.close();
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}

		return parents;
	}
	
	public static void insert(Context context, Parent parent) {
		SQLiteDatabase db;
		try {
			db = getDataBase(context);
			ContentValues cv = new ContentValues();
			cv.put(ConstDB.ParentTable.USERNAME, parent.userName);
			cv.put(ConstDB.ParentTable.PASSWORD, parent.password);
			cv.put(ConstDB.ParentTable.CHILDCLASSNUMBER, parent.childClassNumber);
			cv.put(ConstDB.ParentTable.CHILDNAME, parent.childName);
			cv.put(ConstDB.ParentTable.CHILDSTUDENTID, parent.childStudentID);
			cv.put(ConstDB.ParentTable.CAR, parent.car);
			cv.put(ConstDB.ParentTable.HOMEADDRESS, parent.homeAddress);
			cv.put(ConstDB.ParentTable.PHONENUMBER, parent.phoneNumber);
			cv.put(ConstDB.ParentTable.DISTRICT, parent.district);
			cv.put(ConstDB.ParentTable.DRIVER, parent.driver);
			cv.put(ConstDB.ParentTable.SEAT, parent.seat);
			db.insert(ConstDB.Table.TABLE_PARENT, null, cv);
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.toString());
		}
	}
	
	
	public static int update(Context context, Parent parent) {
		SQLiteDatabase db = null;
		try {
			db = getDataBase(context);
			ContentValues cv = new ContentValues();
			cv.put(ConstDB.ParentTable.PASSWORD, parent.password);
			cv.put(ConstDB.ParentTable.CHILDCLASSNUMBER, parent.childClassNumber);
			cv.put(ConstDB.ParentTable.CHILDNAME, parent.childName);
			cv.put(ConstDB.ParentTable.CHILDSTUDENTID, parent.childStudentID);
			cv.put(ConstDB.ParentTable.CAR, parent.car);
			cv.put(ConstDB.ParentTable.HOMEADDRESS, parent.homeAddress);
			cv.put(ConstDB.ParentTable.PHONENUMBER, parent.password);
			cv.put(ConstDB.ParentTable.DISTRICT, parent.district);
			cv.put(ConstDB.ParentTable.DRIVER, parent.driver);
			cv.put(ConstDB.ParentTable.SEAT, parent.seat);
			int result = db.update(ConstDB.Table.TABLE_PARENT, cv, ConstDB.ParentTable.USERNAME+"=?",
					new String[] { parent.userName });
			return result;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.toString());
		}
		return -1;
	}
	
	public static Parent findSimpleData(Context context, String name) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		Parent parent = null;
		try {
			db = getDataBase(context);
			Cursor c = db.rawQuery("select * from "+ConstDB.Table.TABLE_PARENT+" where "+ConstDB.ParentTable.USERNAME+"=?",
					new String[] { name });
			if (c.moveToNext()) {
				parent = new Parent();
				parent.id = c.getInt(c.getColumnIndex("id"));
				parent.seat = c.getInt(c.getColumnIndex(ConstDB.ParentTable.SEAT));
				parent.userName = c.getString(c.getColumnIndex(ConstDB.ParentTable.USERNAME));
				parent.password = c.getString(c.getColumnIndex(ConstDB.ParentTable.PASSWORD));
				parent.childName = c.getString(c.getColumnIndex(ConstDB.ParentTable.CHILDNAME));
				parent.childStudentID = c.getString(c.getColumnIndex(ConstDB.ParentTable.CHILDSTUDENTID));
				parent.childClassNumber = c.getString(c.getColumnIndex(ConstDB.ParentTable.CHILDCLASSNUMBER));
				parent.phoneNumber = c.getString(c.getColumnIndex(ConstDB.ParentTable.PHONENUMBER));
				parent.homeAddress = c.getString(c.getColumnIndex(ConstDB.ParentTable.HOMEADDRESS));
				parent.car = c.getString(c.getColumnIndex(ConstDB.ParentTable.CAR));
				parent.driver = c.getString(c.getColumnIndex(ConstDB.ParentTable.DRIVER));
				parent.district = c.getString(c.getColumnIndex(ConstDB.ParentTable.DISTRICT));
				
			}
			c.close();
			db.close();
			return parent;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}
		return null;
	}
	
	public static Parent findSimpleData(Context context, int id) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		Parent parent = null;
		try {
			db = getDataBase(context);
			Cursor c = db.rawQuery("select * from "+ConstDB.Table.TABLE_PARENT+" where id=?",
					new String[] { id+"" });
			if (c.moveToNext()) {
				parent = new Parent();
				parent.id = c.getInt(c.getColumnIndex("id"));
				parent.seat = c.getInt(c.getColumnIndex(ConstDB.ParentTable.SEAT));
				parent.userName = c.getString(c.getColumnIndex(ConstDB.ParentTable.USERNAME));
				parent.password = c.getString(c.getColumnIndex(ConstDB.ParentTable.PASSWORD));
				parent.childName = c.getString(c.getColumnIndex(ConstDB.ParentTable.CHILDNAME));
				parent.childStudentID = c.getString(c.getColumnIndex(ConstDB.ParentTable.CHILDSTUDENTID));
				parent.childClassNumber = c.getString(c.getColumnIndex(ConstDB.ParentTable.CHILDCLASSNUMBER));
				parent.phoneNumber = c.getString(c.getColumnIndex(ConstDB.ParentTable.PHONENUMBER));
				parent.homeAddress = c.getString(c.getColumnIndex(ConstDB.ParentTable.HOMEADDRESS));
				parent.car = c.getString(c.getColumnIndex(ConstDB.ParentTable.CAR));
				parent.driver = c.getString(c.getColumnIndex(ConstDB.ParentTable.DRIVER));
				parent.district = c.getString(c.getColumnIndex(ConstDB.ParentTable.DISTRICT));
				
			}
			c.close();
			db.close();
			return parent;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}
		return null;
	}
	public static boolean hasSameDirection(String s1,String s2){
		int i1 = ConstDB.roads.indexOf(s1);
		int i2 = ConstDB.roads.indexOf(s2);
		if(Math.abs(i1-i2)<=1){
			if(i1<i2){
				return i1%2==0;
			}else if(i1>i2){
				return i2%2==0;
			}else{
				return true;
			}
		}
		return false;
	}
	public static String getDirection(String s){
		int i = ConstDB.roads.indexOf(s);
		switch (i) {
		case 0:
		case 1:
			return "N";
		case 2:
		case 3:
			return "S";
		case 4:
		case 5:
			return "W";
		case 6:
		case 7:
			return "E";
		case 8:
		case 9:
			return "NW";
		case 10:
		case 11:
			return "SW";
		case 12:
		case 13:
			return "SE";
		case 14:
		case 15:
			return "NE";
		default:
			break;
		}
		return "N";
	}
	public static SQLiteDatabase getDataBase(Context context)
			throws IOException {
		SQLiteDatabase db = new ContactSqliteOpenHelper(context)
				.getWritableDatabase();
		return db;
	}
}
