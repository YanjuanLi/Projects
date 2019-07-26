package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;

import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;
//查重方法：如果用户名存在，返回0，不存在，返回1.
public class RUserDAOImpl implements UserDAO {

	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		//SQL中的查询语句
		String sql = "select * from userInformation where username=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		
		
		
		try{
			//建立数据库连接
			dbc = new DBConnect();
			System.out.println(dbc);
			//在数据库中执行sql语句
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			pstmt.setString(1,user.getUsername());	
			//所有额查询结果都放入结果集中
			ResultSet rs = pstmt.executeQuery();
			
			//如果已有存在的用户名，返回0
			if(rs.next()){
				
					flag = 0;
				
			}else{ flag = 1;}
			rs.close();
			pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				dbc.close();
			}
			
		//返回flag值
		return flag;
	}

}
