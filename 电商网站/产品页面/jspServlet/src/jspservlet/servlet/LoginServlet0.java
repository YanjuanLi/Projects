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
	//doPost�������������Ƿ���ȷ��
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{
			User user = new User();
			//�ӵ�һ��ҳ��������õ��û�������û����Լ�����
			//��������û����������װ��user������
			user.setUsername(req.getParameter("username"));
			user.setPassword(req.getParameter("password"));
			
			UserDAO dao = new LUserDAOImpl();
			//����һ��ʵ�ֽӿڵĶ���
			int flag = 0;
			try{
				//��queryByUsername�����ж��û����������Ƿ�ƥ��
				flag = dao.queryByUsername(user);
			}catch(Exception e){
				e.printStackTrace();
			}
			//������ȷ ��ת��ӭҳ�档
			if(flag == 1){
				HttpSession session=req.getSession();
				session.setAttribute("username", user.getUsername());
				
				res.sendRedirect("./DIYDetails1.jsp");	
			}
			//���������תerrorҳ�档
			else{
				res.sendRedirect("./error.jsp");
			}
		
	};

}
