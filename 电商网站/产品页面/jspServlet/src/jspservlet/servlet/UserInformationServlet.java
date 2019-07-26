package jspservlet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import jspservlet.vo.User;

public class UserInformationServlet extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws IOException,ServletException{
				
	};
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
		User user = new User();
		//�ӵ�һ��ҳ��������õ��û�������û���
		//��������û����������װ��user������
		user.setUsername(req.getParameter("user"));
		
		
		
		HttpSession session=req.getSession();
		session.setAttribute("user", user.getUsername());
			
		res.sendRedirect("./userinformation.jsp");
		
	}
}
