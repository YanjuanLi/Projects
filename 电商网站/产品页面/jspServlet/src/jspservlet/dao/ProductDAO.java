package jspservlet.dao;

//�½���һ������ProductDAO�Ľӿ� �ýӿڵķ�������һ����Ʒ��Ϣ��arraylist

import java.util.ArrayList;
import java.util.List;

import jspservlet.vo.Product;

public interface ProductDAO {
      public List<Product> productInfo() throws Exception;
}
