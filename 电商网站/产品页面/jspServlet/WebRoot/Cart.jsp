
<%@page import="jspservlet.dao.OrderDAO"%>
<%@page import="jspservlet.dao.impl.OrderDAOImpl"%>
<%@page import="java.util.List"%>
<%@page import="jspservlet.vo.Orders"%><!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>demo</title>
    <link rel="stylesheet" href="css/style0.css"/>
    <script type="text/javascript" src="js/demo.js"></script>
</head>
<body>
<%
List<Orders> list = null;
if (session.getAttribute("username") !=null)
{
	
	String username = session.getAttribute("username")+""; 
	String pid = request.getParameter("pid");
	String did = request.getParameter("did");
	OrderDAO dao = new OrderDAOImpl();
	if (pid != null && !pid.equals(""))
	{
		dao.add(username,Integer.parseInt(pid));
	}
	
	if (did != null && !did.equals(""))
	{
		dao.del(Integer.parseInt(did));
	}
	
	
	list = dao.all(username);
	%>welcome ${sessionScope.username}!<%
}



%>
<%String user =  request.getParameter("param"); %>
<li><a href="demoWelcome001.jsp?param1=<%=user%>">see more</a></li>
<table id="cartTable">
    <thead>
        <tr>
            <th><label><input class="check-all check" type="checkbox"/>&nbsp;Select all</label></th>
            <th>Commodity</th>
            <th>Unit-price</th>
            <th>Quantity</th>
            <th>Subtotal</th>
            <th>Operation</th>
        </tr>
    </thead>
    <tbody>
    <%
    	for (Orders q : list)
    	{
    		%>
    		        <tr>
		            <td class="checkbox"><input class="check-one check" type="checkbox"/></td>
		            <td class="goods"><img src="<%=q.getPictures() %>" alt=""/><span><%=q.getProname() %></span></td>
		            <td class="price"><%=q.getPrice() %></td>
		            <td class="count"><span class="reduce"></span><input class="count-input" type="text" value="1"/><span class="add">+</span></td>
		            <td class="subtotal"><%=q.getPrice() %></td>
		            <td class="operation"><a href="Cart.jsp?did=<%=q.getId() %>"><span class="delete">Delete</span></a></td>
		       		</tr>
    		<%
    	}
    %>
    </tbody>
</table>
<div class="foot" id="foot">
    <label class="fl select-all"><input type="checkbox" class="check-all check"/>&nbsp;Select all</label>
    <a class="fl delete" id="deleteAll" href="javascript:;">Delete</a>
    <div class="fr closing">Account</div>
    <div class="fr total">account all:<span id="priceTotal">0.00</span></div>
    <div class="fr selected" id="selected">you have choose:<span id="selectedTotal">0</span>products<span class="arrow up">︽</span><span class="arrow down">︾</span></div>
    <div class="selected-view">
        <div id="selectedViewList" class="clearfix">
            <div><img src="images/1.jpg"><span>取消选择004</span></div>
        </div>
        <span class="arrow">◆<span>◆</span></span>
    </div>
</div>

</body>
</html>