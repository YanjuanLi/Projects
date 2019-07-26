<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
 <%@ page import=" jspservlet.dao.impl.ProductDAOImpl,jspservlet.vo.Product" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>THE MUSIC</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Omega Watches Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />
<link href='//fonts.googleapis.com/css?family=Josefin+Sans:400,100,100italic,300,300italic,400italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Cabin:400,400italic,500,500italic,600,600italic,700,700italic' rel='stylesheet' type='text/css'>
</head>
<body>
	
	<!-- main -->
	
	<%  ProductDAOImpl product = new ProductDAOImpl();
          
          
		  Product p=product.getProductInfo(13);
          
          
     %>
	
  <h1>The <%=p.getProname() %></h1>
<li>
  <div class="main-grid">
	    <div class="main-grid-left"> </div>
    <div class="main-grid-right">
		    <div class="main-grid-right1">
			    <div class="main-grid-right1-left">
				    <h2>The <%=p.getProname() %></h2>
				    <p>This is the introduction:</p>
				    <p><%=p.getProIntro() %></p>
		        </div>
			    <div class="main-grid-right1-right">
				    <p>$ <%=p.getPrice() %></p>
				    <p>There are <%=p.getNumbers() %> <%=p.getProname() %> boxes left.</p>
		        </div>
			    <div class="clear"> </div>
			    <div class="bottom">
				<p></p>
                
		        </div>
			    
			    <div class="bottom-left bottom-left1">
				    <a href="#">buy now</a>
		        </div>
			    <div class="clear"> </div>
	        </div>
		    <div class="logo"></div>
      </div>
    </div>
</li>
<div class="clear"> </div>
<div class="clear"> </div>
<!--FlexSlider-->
			  <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script defer src="js/jquery.flexslider.js"></script>
<script type="text/javascript">
					$(window).load(function(){
					  $('.flexslider').flexslider({
						animation: "slide",
						start: function(slider){
						  $('body').removeClass('loading');
						}
					  });
					});
				  </script>
	  <!--End-slider-script-->
  <div class="footer">
	  <p>Â© Copyright 2016 - Group 40. All rights reserved.</p>
  </div>
	<!-- //main -->
</body>
</html>