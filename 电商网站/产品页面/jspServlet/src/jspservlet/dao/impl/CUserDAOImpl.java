package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;

public class CUserDAOImpl implements UserDAO{
	public int queryByUsername(User user) throws Exception {
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
				flag = 1;
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
