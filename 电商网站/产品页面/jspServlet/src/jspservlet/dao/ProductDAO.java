package jspservlet.dao;

//新建了一个叫做ProductDAO的接口 该接口的方法返回一个产品信息的arraylist

import java.util.ArrayList;
import java.util.List;

import jspservlet.vo.Product;

public interface ProductDAO {
      public List<Product> productInfo() throws Exception;
}
