package jspservlet.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.SQLException;

import jspservlet.dao.UserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;
//���ط���������û������ڣ�����0�������ڣ�����1.
public class RUserDAOImpl implements UserDAO {

	public int queryByUsername(User user) throws Exception {
		// TODO Auto-generated method stub
		int flag = 0;
		//SQL�еĲ�ѯ���
		String sql = "select * from userInformation where username=?";
		PreparedStatement pstmt = null;
		DBConnect dbc = null;
		
		
		
		try{
			//�������ݿ�����
			dbc = new DBConnect();
			System.out.println(dbc);
			//�����ݿ���ִ��sql���
			pstmt = dbc.getConnection().prepareStatement(sql);
			
			pstmt.setString(1,user.getUsername());	
			//���ж��ѯ���������������
			ResultSet rs = pstmt.executeQuery();
			
			//������д��ڵ��û���������0
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
			
		//����flagֵ
		return flag;
	}

}
