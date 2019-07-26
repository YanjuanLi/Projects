package jspservlet.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import jspservlet.dao.ProductDAO;
import jspservlet.db.DBConnect;
import jspservlet.vo.Product;

public class ProductDAOImpl implements ProductDAO {

	public List<Product> productInfo() {
		//�½�һ����Ʒ��Ϣ��arraylist
    	List<Product> productList = new ArrayList<Product>();
    	
    	try {
    		//���ݿ�����
    		DBConnect db = new DBConnect();
            Connection connection = db.getConnection();
            
            PreparedStatement pStatement = connection.prepareStatement("select * from products");
            //���в�ѯ�Ľ�����ڽ�����С�
            ResultSet resultSet = pStatement.executeQuery();
            //��������е���Ϣ����arraylist��
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setProname(resultSet.getString(2));
                product.setPrice(resultSet.getInt(3));
                product.setProIntro(resultSet.getString(4));
                product.setNumbers(resultSet.getInt(5));
                product.setPictures(resultSet.getString(6));
               
                
                productList.add(product);
            }
            resultSet.close();
            pStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return productList;
	}
	
	
	public Product getProductInfo(int id) {
		
    	//�½�һ��product����
    	Product product1 = new Product();
    	try {
    		//���ݿ�����
    		DBConnect db = new DBConnect();
            Connection connection = db.getConnection();
            PreparedStatement pStatement = connection.prepareStatement("select * from products where id=?");
            pStatement.setInt(1, id);
            ResultSet resultSet = pStatement.executeQuery();
           
            
           
            while (resultSet.next()) {
               
                product1.setId(resultSet.getInt(1));
                product1.setProname(resultSet.getString(2));
                product1.setPrice(resultSet.getInt(3));
                product1.setProIntro(resultSet.getString(4));
                product1.setNumbers(resultSet.getInt(5));
                product1.setPictures(resultSet.getString(6));
        
                        
            }
            resultSet.close();
            pStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product1;
	}

	}
