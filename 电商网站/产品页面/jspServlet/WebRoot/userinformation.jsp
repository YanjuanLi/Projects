<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
 <%@ page import=" jspservlet.dao.impl.SUserDAOImpl,jspservlet.vo.User" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Tab Login Form Flat Responsive Widget Template :: w3layouts</title>
<!--Custom Theme files-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Tab Login Form widget template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Custom Theme files -->
<link href="css/style00.css" rel="stylesheet" type="text/css" media="all" />
<!--web-fonts-->
<link href='//fonts.googleapis.com/css?family=Signika:400,300,600,700' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Righteous' rel='stylesheet' type='text/css'>
<style type="text/css">
.main .login-form .login-right .logo {
	font-family: Georgia, Times New Roman, Times, serif;
}
.main .login-form .login-right .login-top {
	font-family: Courier New, Courier, monospace;
}
.main .login-form .login-right .login-top {
	font-family: Verdana, Geneva, sans-serif;
}
.main .login-form .login-right .login-top {
	font-family: Georgia, Times New Roman, Times, serif;
}
#cart {
			position:fixed;
			bottom:0;
		}
</style>
<!--//web-fonts-->
<!--js-->
<script src="js/jquery.min01.js"></script>
<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$('#horizontalTab').easyResponsiveTabs({
				type: 'default', //Types: default, vertical, accordion           
				width: 'auto', //auto or any width like 600px
				fit: true   // 100% fit in a container
			});
		});
	   </script>
<!--//js-->
</head>
<body>
	<!-- main -->
	<div class="main">
		<h1>Personal Center</h1>
		<div class="login-form">
			<div class="login-left">
				<div class="logo">
					<img src="images/img1.jpg" alt=""/>
					<h2>Welcome</h2>
					
				  <p>&nbsp; </p>
				</div>
				<div class="social-icons">
					<ul>
						<li><a href="#"><img src="images/i1.png" alt=""/></a></li>
						<li><a href="#" class="twt"><img src="images/i2.png" alt=""/></a></li>
						<li><a href="#" class="ggl"><img src="images/i3.png" alt=""/></a></li>
					</ul>
				</div>
			</div>
			<%String username = request.getParameter("param1");
			  SUserDAOImpl user = new SUserDAOImpl();
          
          
		      User u=user.getUserInfo(username);
			  
			 %>
			 
			 
			
			<div class="login-right">
			  <p class="login-top">   name:<%=u.getRealname() %></p>
			  <p class="login-top">mobile phone:<%=u.getPhone() %></p>
              <p class="login-top">address:<%=u.getAddress() %></p>
              <p class="login-top">account balance:<%=u.getMoney() %></p>
              <p class="login-top">&nbsp;</p>
   			</div>
   			<a href="demoWelcome001.jsp?param1=<%=username%>">back to first page</a>
			</div>
			<div class="clear"> </div>
		</div>
	</div>
	<!--//main -->
<div id="cart">
		<a href="Cart.jsp?param1=<%=username%>"><img src="images/cart.jpg" alt=""/></a>
        </div>
	
	<div class="copyright">
		<p> &copy;  Copyright 2016 - Group 40. All rights reserved.	
</p></div></body>
</html>