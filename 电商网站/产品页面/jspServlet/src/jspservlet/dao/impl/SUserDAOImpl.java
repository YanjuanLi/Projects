package jspservlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jspservlet.dao.SUserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.User;

public class SUserDAOImpl implements SUserDAO{
	public List<User> userInfo(){
		//�½�һ����Ʒ��Ϣ��arraylist
    	List<User> userList = new ArrayList<User>();
		
		try{
			//���ݿ�����
    		DBConnect db = new DBConnect();
            Connection connection = db.getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement("select * from userInformation");
            //���в�ѯ�Ľ�����ڽ�����С�
            ResultSet resultSet = pStatement.executeQuery();
            
            while(resultSet.next()){
            	User user = new User();
            	user.setUsername(resultSet.getString(1));
            	user.setPassword(resultSet.getString(2));
            	user.setAddress(resultSet.getString(3));
            	user.setPhone(resultSet.getString(4));
            	user.setMoney(resultSet.getDouble(5));
            	user.setRealname(resultSet.getString(6));
            	
            	userList.add(user);
            }
            resultSet.close();
            pStatement.close();
            connection.close();
		}catch (Exception e) {
            e.printStackTrace();
        }
		
		return userList;
	}
	
	
	public User getUserInfo(String username){
		User user1 = new User();
		
		try{
			//���ݿ�����
    		DBConnect db = new DBConnect();
            Connection connection = db.getConnection();
            PreparedStatement pStatement = connection.prepareStatement("select * from userInformation where username=?");
            pStatement.setString(1, username);
            ResultSet resultSet = pStatement.executeQuery();
            
            while(resultSet.next()){
            	user1.setUsername(resultSet.getString(1));
            	user1.setAddress(resultSet.getString(3));
            	user1.setPhone(resultSet.getString(4));
            	user1.setMoney(resultSet.getDouble(5));
            	user1.setRealname(resultSet.getString(6));
            }
            
           resultSet.close();
           pStatement.close();
           connection.close();
		}catch (Exception e) {
            e.printStackTrace();
        }
		
		return user1;
         
	}

}
