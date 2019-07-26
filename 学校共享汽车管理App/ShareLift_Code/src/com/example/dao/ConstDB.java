package com.example.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition of tables and fields
 * 
 */
public class ConstDB {

	public static class Table {

		public static final String TABLE_PARENT = "tb_parent";
		public static final String TABLE_TEACHER = "tb_teacher";

		public static final String TABLE_REQUEST = "tb_request";
		public static final String TABLE_OFFER = "tb_offer";

	}

	public static class ParentTable {
		public static final String USERNAME = "userName";
		public static final String PASSWORD = "password";
		public static final String CHILDNAME = "childName";
		public static final String CHILDSTUDENTID = "childStudentID";
		public static final String CHILDCLASSNUMBER = "childClassNumber";
		public static final String PHONENUMBER = "phoneNumber";
		public static final String HOMEADDRESS = "homeAddress";
		public static final String DISTRICT = "district";
		public static final String SEAT = "seat";
		public static final String CAR = "car";
		public static final String DRIVER = "driver";
	}

	public static class TeacherTable {
		public static final String USERNAME = "userName";
		public static final String PASSWORD = "password";
		public static final String PHONENUMBER = "phoneNumber";
		public static final String EMPLOYEEID = "employeeID";
	}

	public static class RequestTable {
		public static final String ID = "id";
		public static final String OFFERID = "offerId";
		public static final String USERNAME = "userName";
		public static final String DATE = "date";
		public static final String BORADDINGTIME = "boraddingTime";
		public static final String ADDRESS = "address";
		public static final String DISTRICT = "district";
		public static final String PASSENGERS = "passengers";
		public static final String STATUS = "status";// status of request£¬0 is ordering£¬1 is finish
	}

	public static class OfferTable {
		public static final String ID = "id";
		public static final String REQUESTID = "requestId";
		public static final String USERNAME = "userName";
		public static final String DATE = "date";
		public static final String BORADDINGTIME = "boraddingTime";
		public static final String ADDRESS = "address";
		public static final String DISTRICT = "district";
		public static final String SEAT = "seat";
		public static final String STATUS = "status";// status of request£¬0 is ordering£¬1 is finish
	}

	public static List<String> studentId;
	public static List<String> employeeId;
	public static List<String> roads;
	static {
		studentId = new ArrayList<String>();
		studentId.add("2015117136");
		studentId.add("2015118012");
		studentId.add("2015119317");
		studentId.add("1");
		studentId.add("2");
		employeeId = new ArrayList<String>();
		employeeId.add("0117132145");
		employeeId.add("0119113239");
		employeeId.add("0118283132");
		employeeId.add("1");
		employeeId.add("2");

		roads = new ArrayList<String>();
		roads.add("Huangtingzi Road");
		roads.add("Shidabei Road");
		roads.add("Xueyuannan Road");
		roads.add("Wenhuiyuanxi Road");
		roads.add("Xitucheng Road");
		roads.add("Sidaokou Road");
		roads.add("Xingtan Road");
		roads.add("Furen Road");
		roads.add("Dazhongsidong Road");
		roads.add("Zhichun Road");
		roads.add("Jiaodadong Road");
		roads.add("Fanghua Road");
		roads.add("Wenhuiyuanbei Road");
		roads.add("Hongliandongcun Road");
		roads.add("Beituchengxi Road");
		roads.add("Huayuan Road");
	}

}