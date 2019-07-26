package jspservlet.dao;

import java.util.List;

import jspservlet.vo.Orders;
import jspservlet.vo.User;
public interface OrderDAO {
	public void add(String username,int pid);
	public List<Orders> all(String username);
	public void del(int id);
}
