package com.example.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.entry.Request;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class RequestDao {
	
	public static List<Request> findAllData(Context context) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		List<Request> requests = new ArrayList<Request>();
		try {
			db = getDataBase(context);
			Request request = null;
			Cursor c = db.query(ConstDB.Table.TABLE_REQUEST, null, null, null, null, null, null);
			while (c.moveToNext()) {
				request = new Request();
				request.id = c.getInt(c.getColumnIndex(ConstDB.RequestTable.ID));
				request.offerId = c.getInt(c.getColumnIndex(ConstDB.RequestTable.OFFERID));
				request.passengers = c.getInt(c.getColumnIndex(ConstDB.RequestTable.PASSENGERS));
				request.status = c.getInt(c.getColumnIndex(ConstDB.RequestTable.STATUS));
				request.userName = c.getString(c.getColumnIndex(ConstDB.RequestTable.USERNAME));
				request.date = c.getString(c.getColumnIndex(ConstDB.RequestTable.DATE));
				request.boraddingTime = c.getString(c.getColumnIndex(ConstDB.RequestTable.BORADDINGTIME));
				request.address = c.getString(c.getColumnIndex(ConstDB.RequestTable.ADDRESS));
				request.district = c.getString(c.getColumnIndex(ConstDB.RequestTable.DISTRICT));
				requests.add(request);
			}
			c.close();
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}

		return requests;
	}
	
	public static List<Request> findAllData(Context context,String userName) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		List<Request> requests = new ArrayList<Request>();
		try {
			db = getDataBase(context);
			Request request = null;
			Cursor c = db.rawQuery("select * from " + ConstDB.Table.TABLE_REQUEST
					+ " where " + ConstDB.RequestTable.USERNAME + "=?",new String[]{userName});
			while (c.moveToNext()) {
				request = new Request();
				request.id = c.getInt(c.getColumnIndex(ConstDB.RequestTable.ID));
				request.offerId = c.getInt(c.getColumnIndex(ConstDB.RequestTable.OFFERID));
				request.passengers = c.getInt(c.getColumnIndex(ConstDB.RequestTable.PASSENGERS));
				request.status = c.getInt(c.getColumnIndex(ConstDB.RequestTable.STATUS));
				request.userName = c.getString(c.getColumnIndex(ConstDB.RequestTable.USERNAME));
				request.date = c.getString(c.getColumnIndex(ConstDB.RequestTable.DATE));
				request.boraddingTime = c.getString(c.getColumnIndex(ConstDB.RequestTable.BORADDINGTIME));
				request.address = c.getString(c.getColumnIndex(ConstDB.RequestTable.ADDRESS));
				request.district = c.getString(c.getColumnIndex(ConstDB.RequestTable.DISTRICT));
				requests.add(request);
			}
			c.close();
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}

		return requests;
	}
	
	public static void insert(Context context, Request request) {
		SQLiteDatabase db;
		try {
			db = getDataBase(context);
			ContentValues cv = new ContentValues();
			cv.put(ConstDB.RequestTable.USERNAME, request.userName);
			cv.put(ConstDB.RequestTable.OFFERID, request.offerId);
			cv.put(ConstDB.RequestTable.BORADDINGTIME, request.boraddingTime);
			cv.put(ConstDB.RequestTable.ADDRESS, request.address);
			cv.put(ConstDB.RequestTable.DISTRICT, request.district);
			cv.put(ConstDB.RequestTable.STATUS, request.status);
			cv.put(ConstDB.RequestTable.DATE, request.date);
			cv.put(ConstDB.RequestTable.PASSENGERS, request.passengers);
			db.insert(ConstDB.Table.TABLE_REQUEST, null, cv);
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.toString());
		}
	}
	
	
	public static int update(Context context, Request request) {
		SQLiteDatabase db = null;
		try {
			db = getDataBase(context);
			ContentValues cv = new ContentValues();
			cv.put(ConstDB.RequestTable.USERNAME, request.userName);
			cv.put(ConstDB.RequestTable.OFFERID, request.offerId);
			cv.put(ConstDB.RequestTable.BORADDINGTIME, request.boraddingTime);
			cv.put(ConstDB.RequestTable.ADDRESS, request.address);
			cv.put(ConstDB.RequestTable.DISTRICT, request.district);
			cv.put(ConstDB.RequestTable.STATUS, request.status);
			cv.put(ConstDB.RequestTable.DATE, request.date);
			cv.put(ConstDB.RequestTable.PASSENGERS, request.passengers);
			int result = db.update(ConstDB.Table.TABLE_REQUEST, cv, ConstDB.RequestTable.USERNAME+"=?",
					new String[] { request.userName });
			return result;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.toString());
		}
		return -1;
	}
	
	public static Request findSimpleData(Context context, String name) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		Request request = null;
		try {
			db = getDataBase(context);
			Cursor c = db.rawQuery("select * from "+ConstDB.Table.TABLE_REQUEST+" where "+ConstDB.RequestTable.USERNAME+"=?",
					new String[] { name });
			if (c.moveToNext()) {
				request = new Request();
				request.id = c.getInt(c.getColumnIndex(ConstDB.RequestTable.ID));
				request.offerId = c.getInt(c.getColumnIndex(ConstDB.RequestTable.OFFERID));
				request.status = c.getInt(c.getColumnIndex(ConstDB.RequestTable.STATUS));
				request.passengers = c.getInt(c.getColumnIndex(ConstDB.RequestTable.PASSENGERS));
				request.userName = c.getString(c.getColumnIndex(ConstDB.RequestTable.USERNAME));
				request.date = c.getString(c.getColumnIndex(ConstDB.RequestTable.DATE));
				request.boraddingTime = c.getString(c.getColumnIndex(ConstDB.RequestTable.BORADDINGTIME));
				request.address = c.getString(c.getColumnIndex(ConstDB.RequestTable.ADDRESS));
				request.district = c.getString(c.getColumnIndex(ConstDB.RequestTable.DISTRICT));
				
			}
			c.close();
			db.close();
			return request;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}
		return null;
	}
	
	public static Request findSimpleData(Context context, int id) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		Request request = null;
		try {
			db = getDataBase(context);
			Cursor c = db.rawQuery("select * from "+ConstDB.Table.TABLE_REQUEST+" where "+ConstDB.RequestTable.ID+"=?",
					new String[] { id+"" });
			if (c.moveToNext()) {
				request = new Request();
				request.id = c.getInt(c.getColumnIndex(ConstDB.RequestTable.ID));
				request.offerId = c.getInt(c.getColumnIndex(ConstDB.RequestTable.OFFERID));
				request.passengers = c.getInt(c.getColumnIndex(ConstDB.RequestTable.PASSENGERS));
				request.status = c.getInt(c.getColumnIndex(ConstDB.RequestTable.STATUS));
				request.userName = c.getString(c.getColumnIndex(ConstDB.RequestTable.USERNAME));
				request.date = c.getString(c.getColumnIndex(ConstDB.RequestTable.DATE));
				request.boraddingTime = c.getString(c.getColumnIndex(ConstDB.RequestTable.BORADDINGTIME));
				request.address = c.getString(c.getColumnIndex(ConstDB.RequestTable.ADDRESS));
				request.district = c.getString(c.getColumnIndex(ConstDB.RequestTable.DISTRICT));
				
			}
			c.close();
			db.close();
			return request;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}
		return null;
	}
	public static SQLiteDatabase getDataBase(Context context)
			throws IOException {
		SQLiteDatabase db = new ContactSqliteOpenHelper(context)
				.getWritableDatabase();
		return db;
	}
}
