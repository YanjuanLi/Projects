package jspservlet.dao;

import jspservlet.vo.User;
//新建了一个叫做UserDAO的接口 该接口的方法返回一个用户信息的arraylist
public interface UserDAO {
	public int queryByUsername(User user)throws Exception;

}
