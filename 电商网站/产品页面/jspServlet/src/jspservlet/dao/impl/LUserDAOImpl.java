package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import java.sql.SQLException;

import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;
//ʵ����UserDAO�ķ��������û���ȷ����������жԱȡ�
//��ȷ����1�����󷵻�0.
public class LUserDAOImpl implements UserDAO {

	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
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
				//�ж��û������Ƿ���û������Ӧ��
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
			
		//����һ��flagֵ��
		return flag;
	}

}
