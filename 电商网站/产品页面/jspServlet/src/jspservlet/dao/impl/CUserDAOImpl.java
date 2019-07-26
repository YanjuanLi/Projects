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
			//�������ݿ�����
			dbc = new DBConnect();
			System.out.println(dbc);
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			pstmt.setString(1,user.getUsername());	
			
			//�����  ����ѯ�Ľ�����ڽ�����С�
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
		
	    //����һ��flagֵ��
	    return flag;
	}

}
