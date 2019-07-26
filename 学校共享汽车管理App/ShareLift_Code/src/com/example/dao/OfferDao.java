package com.example.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.entry.Offer;
import com.example.entry.Request;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

/**
 * Operations of offer table
 * 
 */
public class OfferDao {
	/**
	 * Search for all offers
	 * 
	 * @param context
	 * @return
	 */
	public static List<Offer> findAllData(Context context) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		List<Offer> offers = new ArrayList<Offer>();
		try {
			db = getDataBase(context);
			Offer offer = null;
			Cursor c = db.query(ConstDB.Table.TABLE_OFFER, null, null, null,
					null, null, null);
			while (c.moveToNext()) {
				offer = new Offer();
				offer.id = c.getInt(c.getColumnIndex(ConstDB.OfferTable.ID));
				offer.requestId = c.getInt(c
						.getColumnIndex(ConstDB.OfferTable.REQUESTID));
				offer.seat = c
						.getInt(c.getColumnIndex(ConstDB.OfferTable.SEAT));
				offer.status = c.getInt(c
						.getColumnIndex(ConstDB.OfferTable.STATUS));
				offer.userName = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.USERNAME));
				offer.date = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.DATE));
				offer.boraddingTime = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.BORADDINGTIME));
				offer.address = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.ADDRESS));
				offers.add(offer);
			}
			c.close();
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}

		return offers;
	}
	public static List<Offer> findAllData(Context context,String userName) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		List<Offer> offers = new ArrayList<Offer>();
		try {
			db = getDataBase(context);
			Offer offer = null;
			Cursor c = db.rawQuery("select * from " + ConstDB.Table.TABLE_OFFER
					+ " where " + ConstDB.OfferTable.USERNAME + "=?",new String[]{userName});
			while (c.moveToNext()) {
				offer = new Offer();
				offer.id = c.getInt(c.getColumnIndex(ConstDB.OfferTable.ID));
				offer.requestId = c.getInt(c
						.getColumnIndex(ConstDB.OfferTable.REQUESTID));
				offer.seat = c
						.getInt(c.getColumnIndex(ConstDB.OfferTable.SEAT));
				offer.status = c.getInt(c
						.getColumnIndex(ConstDB.OfferTable.STATUS));
				offer.userName = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.USERNAME));
				offer.date = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.DATE));
				offer.boraddingTime = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.BORADDINGTIME));
				offer.address = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.ADDRESS));
				offers.add(offer);
			}
			c.close();
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}
		
		return offers;
	}

	public static List<Offer> findDataByRequest(Context context, Request request) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		List<Offer> offers = new ArrayList<Offer>();
		try {
			db = getDataBase(context);
			Offer offer = null;
			Cursor c = db.rawQuery("select * from " + ConstDB.Table.TABLE_OFFER
					+ " where " + ConstDB.OfferTable.DATE + "=? and "
					+ ConstDB.OfferTable.ADDRESS + "=? and  "
					+ ConstDB.OfferTable.BORADDINGTIME + "=? and  "
					+ ConstDB.OfferTable.SEAT + ">=? and  "+ConstDB.OfferTable.DISTRICT+ "=? and "+ConstDB.OfferTable.STATUS+"=0", new String[] {
					request.date, request.address, request.boraddingTime,
					request.passengers + "",request.district });
			while (c.moveToNext()) {
				offer = new Offer();
				offer.id = c.getInt(c.getColumnIndex(ConstDB.OfferTable.ID));
				offer.requestId = c.getInt(c
						.getColumnIndex(ConstDB.OfferTable.REQUESTID));
				offer.seat = c
						.getInt(c.getColumnIndex(ConstDB.OfferTable.SEAT));
				offer.status = c.getInt(c
						.getColumnIndex(ConstDB.OfferTable.STATUS));
				offer.userName = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.USERNAME));
				offer.date = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.DATE));
				offer.boraddingTime = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.BORADDINGTIME));
				offer.address = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.ADDRESS));
				offer.district = c.getString(c
						.getColumnIndex(ConstDB.RequestTable.DISTRICT));
				offers.add(offer);
			}
			c.close();
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}
		return offers;
	}

	/**
	 * Add an offer
	 * 
	 * @param context
	 * @param offer
	 */
	public static void insert(Context context, Offer offer) {
		SQLiteDatabase db;
		try {
			db = getDataBase(context);
			ContentValues cv = new ContentValues();
			cv.put(ConstDB.OfferTable.USERNAME, offer.userName);
			cv.put(ConstDB.OfferTable.REQUESTID, offer.requestId);
			cv.put(ConstDB.OfferTable.BORADDINGTIME, offer.boraddingTime);
			cv.put(ConstDB.OfferTable.ADDRESS, offer.address);
			cv.put(ConstDB.OfferTable.DISTRICT, offer.district);
			cv.put(ConstDB.OfferTable.STATUS, offer.status);
			cv.put(ConstDB.OfferTable.DATE, offer.date);
			cv.put(ConstDB.OfferTable.SEAT, offer.seat);
			db.insert(ConstDB.Table.TABLE_OFFER, null, cv);
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.toString());
		}
	}

	/**
	 * Update offer
	 * 
	 * @param context
	 * @param offer
	 * @return
	 */
	public static int update(Context context, Offer offer) {
		SQLiteDatabase db = null;
		try {
			db = getDataBase(context);
			ContentValues cv = new ContentValues();
			cv.put(ConstDB.OfferTable.USERNAME, offer.userName);
			cv.put(ConstDB.OfferTable.REQUESTID, offer.requestId);
			cv.put(ConstDB.OfferTable.BORADDINGTIME, offer.boraddingTime);
			cv.put(ConstDB.OfferTable.ADDRESS, offer.address);
			cv.put(ConstDB.OfferTable.DISTRICT, offer.district);
			cv.put(ConstDB.OfferTable.STATUS, offer.status);
			cv.put(ConstDB.OfferTable.DATE, offer.date);
			cv.put(ConstDB.OfferTable.SEAT, offer.seat);
			int result = db.update(ConstDB.Table.TABLE_OFFER, cv,
					ConstDB.OfferTable.ID + "=?",
					new String[] { offer.id+"" });
			return result;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.toString());
		}
		return -1;
	}

	/**
	 * Search for an offer
	 * 
	 * @param context
	 * @param name
	 * @return
	 */
	public static Offer findSimpleData(Context context, String name) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		Offer offer = null;
		try {
			db = getDataBase(context);
			Cursor c = db.rawQuery("select * from " + ConstDB.Table.TABLE_OFFER
					+ " where " + ConstDB.OfferTable.USERNAME + "=?",
					new String[] { name });
			if (c.moveToNext()) {
				offer = new Offer();
				offer.id = c.getInt(c.getColumnIndex(ConstDB.OfferTable.ID));
				offer.requestId = c.getInt(c
						.getColumnIndex(ConstDB.OfferTable.REQUESTID));
				offer.seat = c
						.getInt(c.getColumnIndex(ConstDB.OfferTable.SEAT));
				offer.status = c.getInt(c
						.getColumnIndex(ConstDB.OfferTable.STATUS));
				offer.userName = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.USERNAME));
				offer.date = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.DATE));
				offer.boraddingTime = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.BORADDINGTIME));
				offer.address = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.ADDRESS));
				offer.district = c.getString(c
						.getColumnIndex(ConstDB.RequestTable.DISTRICT));
			}
			c.close();
			db.close();
			return offer;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}
		return null;
	}

	
	public static Offer findSimpleData(Context context, int id) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		Offer offer = null;
		try {
			db = getDataBase(context);
			Cursor c = db.rawQuery("select * from " + ConstDB.Table.TABLE_OFFER
					+ " where " + ConstDB.OfferTable.ID + "=?",
					new String[] { id + "" });
			if (c.moveToNext()) {
				offer = new Offer();
				offer.id = c.getInt(c.getColumnIndex(ConstDB.OfferTable.ID));
				offer.requestId = c.getInt(c
						.getColumnIndex(ConstDB.OfferTable.REQUESTID));
				offer.seat = c
						.getInt(c.getColumnIndex(ConstDB.OfferTable.SEAT));
				offer.status = c.getInt(c
						.getColumnIndex(ConstDB.OfferTable.STATUS));
				offer.userName = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.USERNAME));
				offer.date = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.DATE));
				offer.boraddingTime = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.BORADDINGTIME));
				offer.address = c.getString(c
						.getColumnIndex(ConstDB.OfferTable.ADDRESS));
				offer.district = c.getString(c
						.getColumnIndex(ConstDB.RequestTable.DISTRICT));

			}
			c.close();
			db.close();
			return offer;
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
