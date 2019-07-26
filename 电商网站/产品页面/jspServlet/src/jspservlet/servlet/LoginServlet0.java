package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jspservlet.dao.UserDAO;
import jspservlet.dao.impl.LUserDAOImpl;
import jspservlet.vo.User;

public class LoginServlet0 extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		
	};
	//doPost方法检验密码是否正确。
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
			User user = new User();
			//从第一个页面的输入框得到用户输入的用户名以及密码
			//将输入的用户名和密码封装到user对象中
			user.setUsername(req.getParameter("username"));
			user.setPassword(req.getParameter("password"));
			
			UserDAO dao = new LUserDAOImpl();
			//建立一个实现接口的对象
			int flag = 0;
			try{
				//由queryByUsername方法判断用户名和密码是否匹配
				flag = dao.queryByUsername(user);
			}catch(Exception e){
				e.printStackTrace();
			}
			//密码正确 跳转欢迎页面。
			if(flag == 1){
				HttpSession session=req.getSession();
				session.setAttribute("username", user.getUsername());
				
				res.sendRedirect("./DIYDetails1.jsp");	
			}
			//密码错误，跳转error页面。
			else{
				res.sendRedirect("./error.jsp");
			}
		
	};

}
