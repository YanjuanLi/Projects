package jspservlet.dao;

import jspservlet.vo.User;
//�½���һ������UserDAO�Ľӿ� �ýӿڵķ�������һ���û���Ϣ��arraylist
public interface UserDAO {
	public int queryByUsername(User user)throws Exception;

}
