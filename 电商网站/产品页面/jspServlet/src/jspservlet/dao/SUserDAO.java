package jspservlet.dao;

import java.util.List;

import jspservlet.vo.User;

public interface SUserDAO {
    public List<User> userInfo() throws Exception;
}
