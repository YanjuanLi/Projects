package jspservlet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jspservlet.dao.OrderDAO;
import jspservlet.dao.SUserDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Orders;
import jspservlet.vo.User;

public class OrderDAOImpl implements OrderDAO{
	public List<Orders> all(String username){
		//�½�һ���Ʒ��Ϣ��arraylist
    	List<Orders> userList = new ArrayList<Orders>();
		
		try{
			//��ݿ�l��
    		DBConnect db = new DBConnect();
            Connection connection = db.getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement("select a.id,b.pictures,b.proname,b.price from orders a,products b where a.pid = b.id and a.username =?");
            //���в�ѯ�Ľ���ڽ���С�
            pStatement.setString(1,username);
            ResultSet rs = pStatement.executeQuery();
            
            while(rs.next()){
            	Orders q = new Orders();
            	q.setId(rs.getInt(1));
            	q.setPictures(rs.getString(2));
            	q.setProname(rs.getString(3));
            	q.setPrice(rs.getInt(4));
            	userList.add(q);
            }
            rs.close();
            pStatement.close();
            connection.close();
		}catch (Exception e) {
            e.printStackTrace();
        }
		
		return userList;
	}
	
	public void del(int id){
		try{
			//��ݿ�l��
    		DBConnect db = new DBConnect();
            Connection connection = db.getConnection();
            PreparedStatement pStatement = connection.prepareStatement("delete from orders where id =?");
            pStatement.setInt(1,id);
            pStatement.executeUpdate();
            pStatement.close();
           connection.close();
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	
	public void add(String username,int pid){
		try{
			//��ݿ�l��
    		DBConnect db = new DBConnect();
            Connection connection = db.getConnection();
            PreparedStatement pStatement = connection.prepareStatement("insert into orders(username,pid)values(?,?)");
            pStatement.setString(1, username);
            pStatement.setInt(2,pid);
            pStatement.executeUpdate();
            pStatement.close();
           connection.close();
		}catch (Exception e) {
            e.printStackTrace();
        }
	}

}
