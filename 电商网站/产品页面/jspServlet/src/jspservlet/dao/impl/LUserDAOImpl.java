package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;

import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;
//实现了UserDAO的方法，将用户名确定后，密码进行对比。
//正确返回1，错误返回0.
public class LUserDAOImpl implements UserDAO {

	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		String sql = "select * from userInformation where username=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		
		
		
		try{
			//进行数据库连接
			dbc = new DBConnect();
			System.out.println(dbc);
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			pstmt.setString(1,user.getUsername());	
			
			//结果集  语句查询的结果都在结果集中。
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				//判断用户密码是否跟用户名相对应。
				if(rs.getString("password").equals(user.getPassword())){
					flag = 1;
				}
			}
			rs.close();
			pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				dbc.close();
			}
			
		//返回一个flag值。
		return flag;
	}

}
