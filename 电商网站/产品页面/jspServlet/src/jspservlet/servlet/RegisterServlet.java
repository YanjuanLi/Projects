
package jspservlet.servlet;

import java.io.IOException;
import java.sql.Statement;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.impl.RUserDAOImpl;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.RUserDAOImpl;


import jspservlet.db.DBConnect;

import jspservlet.vo.User;



public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
	};
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
		User user = new User();
		//从第一个页面得到用户输入的用户名 密码 地址 以及电话
		user.setUsername(req.getParameter("username"));
		user.setPassword(req.getParameter("password"));
		user.setAddress(req.getParameter("email"));
		user.setPhone(req.getParameter("phone"));
		user.setRealname(req.getParameter("realname"));
		
		String rusername = user.getUsername();
		String rpassword = user.getPassword();
		String raddress = user.getAddress();
		String rphone = user.getPhone();
		String rrealname = user.getRealname();
		
		
		//建立实现RUserDAO接口的对象dao
		RUserDAOImpl dao = new RUserDAOImpl();
		int flag = 0;
		
		try{
			//由queryByUsername方法判断是否已经存在该用户
			flag = dao.queryByUsername(user);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//如果不存在 就更新数据库，将用户信息更新在数据库中
		if(flag==1){
		try{
		String sql = "INSERT INTO userInformation(username,password,address,phone,money,realname)"+"VALUES("+"'"+rusername+"','"+rpassword+"','"+raddress+"','"+rphone+"',0,'"+rrealname+"');";
		DBConnect dbc = new DBConnect();
		Connection conn = dbc.getConnection();
		
		System.out.println(dbc);

		Statement statement = conn.createStatement();

	
		statement.executeUpdate(sql);
		
		statement.close();
		
		conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			
		HttpSession session = req.getSession();
		session.setAttribute("username", user.getUsername());
		res.sendRedirect("./Finish.jsp");
		}
		else{res.sendRedirect("./Rerror.jsp");}
		
	};
}	


