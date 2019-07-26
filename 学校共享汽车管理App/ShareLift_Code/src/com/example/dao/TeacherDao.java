package com.example.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.entry.Teacher;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * Operations of parent table
 *
 */
public class TeacherDao {
	
	public static List<Teacher> findAllData(Context context) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			db = getDataBase(context);
			Teacher teacher = null;
			Cursor c = db.query(ConstDB.Table.TABLE_TEACHER, null, null, null, null, null, null);
			while (c.moveToNext()) {
				teacher = new Teacher();
				teacher.userName = c.getString(c.getColumnIndex(ConstDB.TeacherTable.USERNAME));
				teacher.password = c.getString(c.getColumnIndex(ConstDB.TeacherTable.PASSWORD));
				teacher.phoneNumber = c.getString(c.getColumnIndex(ConstDB.TeacherTable.PHONENUMBER));
				teacher.employeeID = c.getString(c.getColumnIndex(ConstDB.TeacherTable.EMPLOYEEID));
				teachers.add(teacher);
			}
			c.close();
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}

		return teachers;
	}
	
	public static void insert(Context context, Teacher teacher) {
		SQLiteDatabase db;
		try {
			db = getDataBase(context);
			ContentValues cv = new ContentValues();
			cv.put(ConstDB.TeacherTable.USERNAME, teacher.userName);
			cv.put(ConstDB.TeacherTable.PASSWORD, teacher.password);
			cv.put(ConstDB.TeacherTable.PHONENUMBER, teacher.phoneNumber);
			cv.put(ConstDB.TeacherTable.EMPLOYEEID, teacher.employeeID);
			db.insert(ConstDB.Table.TABLE_TEACHER, null, cv);
			db.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.toString());
		}
	}
	
	
	public static int update(Context context, Teacher teacher) {
		SQLiteDatabase db = null;
		try {
			db = getDataBase(context);
			ContentValues cv = new ContentValues();
			cv.put(ConstDB.TeacherTable.PASSWORD, teacher.password);
			cv.put(ConstDB.TeacherTable.EMPLOYEEID, teacher.employeeID);
			cv.put(ConstDB.TeacherTable.PHONENUMBER, teacher.password);
			int result = db.update(ConstDB.Table.TABLE_TEACHER, cv, ConstDB.TeacherTable.USERNAME+"=?",
					new String[] { teacher.userName });
			return result;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e.toString());
		}
		return -1;
	}
	
	public static Teacher findSimpleData(Context context, String name) {
		// TODO Auto-generated method stub
		SQLiteDatabase db = null;
		Teacher teacher = null;
		try {
			db = getDataBase(context);
			Cursor c = db.rawQuery("select * from "+ConstDB.Table.TABLE_TEACHER+" where "+ConstDB.TeacherTable.USERNAME+"=?",
					new String[] { name });
			if (c.moveToNext()) {
				teacher = new Teacher();
				teacher.userName = c.getString(c.getColumnIndex(ConstDB.TeacherTable.USERNAME));
				teacher.password = c.getString(c.getColumnIndex(ConstDB.TeacherTable.PASSWORD));
				teacher.phoneNumber = c.getString(c.getColumnIndex(ConstDB.TeacherTable.PHONENUMBER));
				teacher.employeeID = c.getString(c.getColumnIndex(ConstDB.TeacherTable.EMPLOYEEID));
				
				
			}
			c.close();
			db.close();
			return teacher;
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
