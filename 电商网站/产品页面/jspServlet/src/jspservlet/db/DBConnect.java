package jspservlet.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private final String DBDRIVER = "com.mysql.jdbc.Driver";
	private final String DBURL = "jdbc:mysql://127.0.0.1:3306/cInformation";
	private final String DBUSER = "root";
	private final String DBPASSWORD = "";
	private Connection conn = null;
	
	public DBConnect(){
		try{
			Class.forName(DBDRIVER);
			this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close(){
		try{
			this.conn.close();
		}catch(Exception e){}
	}

}
