<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
 <%@ page import=" jspservlet.dao.impl.ProductDAOImpl,jspservlet.vo.Product" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        body {
            font-size: 12px;
            line-height: 1.7;
        }

        li {
	/* [disabled]list-style: none; */
        }

        #content {
            width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        #content h1 {
            color: #0088bb;
        }

        #content .item {
            padding: 20px;
            margin-bottom: 20px;
            border: 1px dotted #0088bb;
        }

        #content .item h2 {
            font-size: 16px;
            font-weight: bold;
            border-bottom: 2px solid #0088bb;
            margin-bottom: 10px;
        }

        #content .item li {
            display: inline;
            margin-right: 10px;
        }

        #content .item li a img {
            width: 230px;
            height: 230px;
            border: none;
        }

        #menu {
            position: fixed;
            top: 100px;
            left: 50%;
            margin-left: 400px;
            width: 50px;
        }
		#cart {
			position:fixed;
			bottom:0;
		}
		#login{
			position:fixed;
			top:0;
			}

        #menu ul li a {
            display: block;
            margin: 5px 0;
            font-size: 14px;
            font-weight: bold;
            color: #333;
            width: 80px;
            height: 50px;
            line-height: 50px;
            text-decoration: none;
            text-align: center;
        }

        #menu ul li a:hover,
        #menu ul li a.current {
            color: #fff;
            background: #0088bb;
        }

        * html, * html body {
            background-image: url(about:blank);
            background-attachment: fixed;
        }

        * html #menu {
            position: absolute;
            bottom: auto;
            top: expression(100+((e=document.documentElement.scrollTop)?e:document.body.scrollTop)+'px');
        }
    </style>
    <script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(window).scroll(function () {
                var items = $("#content").find(".item");
                var menu = $("#menu");
                var top = $(document).scrollTop();
                var currentId = ""; 
                items.each(function () {
                    var m = $(this);
                   
                    if (top > m.offset().top - 300) {
                        currentId = "#" + m.attr("id");
                    } else {
                        return false;
                    }
                });

                var currentLink = menu.find(".current");
                if (currentId && currentLink.attr("href") != currentId) {
                    currentLink.removeClass("current");
                    menu.find("[href=" + currentId + "]").addClass("current");
                }
            });
        });
    </script>
</head>





<body>
    <%String username = (String)session.getAttribute("username"); %>
   
    welcome <%= username %>
    
    <%%>
    
    <%
       ProductDAOImpl product = new ProductDAOImpl();   
         
     %>
    
    
    <input type="button" value="log-off" name="reset" onClick="window.location.href('./TheFirst.jsp')" />
	<a href="userinformation.jsp?param1=<%=username%>"><img src="person.png" alt=""/></a>
    
    
		
		
<div id="menu">
    <ul>
        <li><a href="#item1" class="current">1F merry-go-round</a></li>
        <li><a href="#item2">2F crystal</a></li>
        <li><a href="#item3">3F piano</a></li>
        <li><a href="#item4">4F log cabin</a></li>
        <li><a href="#item5">5F wood box</a></li>
        <li><a href="#item6">6F DIY box</a></li>
    </ul>
</div>
<div id="content">
    <h1>THE BOX</h1>

    <div id="item1" class="item">
        <h2>1F merry-go-round</h2>

        <ul><%Product p11=product.getProductInfo(11); %>
            <li><a href="ourproducts.jsp?param1=11&param2=<%=username%>"><img src="<%=p11.getPictures() %>" alt=""/></a></li>
            <%Product p12=product.getProductInfo(12); %>
            <li><a href="ourproducts.jsp?param1=12&param2=<%=username%>"><img src="<%=p12.getPictures() %>" alt=""/></a></li>
            <%Product p13=product.getProductInfo(13); %>
            <li><a href="ourproducts.jsp?param1=13&param2=<%=username%>"><img src="<%=p13.getPictures() %>" alt=""/></a></li>
           
        </ul>
    </div>
    <div id="item2" class="item">
        <h2>2F crystal</h2>
        <ul>
            <%Product p21=product.getProductInfo(21); %>
            <li><a href="ourproducts.jsp?param1=21&param2=<%=username%>"><img src="<%=p21.getPictures()%> " alt=""/></a></li>
            <%Product p22=product.getProductInfo(22); %>
            <li><a href="ourproducts.jsp?param1=22&param2=<%=username%>"><img src="<%=p22.getPictures() %>" alt=""/></a></li>
            <%Product p23=product.getProductInfo(23); %>
            <li><a href="ourproducts.jsp?param1=23&param2=<%=username%>"><img src="<%=p23.getPictures() %>" alt=""/></a></li>
            <%Product p24=product.getProductInfo(24); %>
            <li><a href="ourproducts.jsp?param1=24&param2=<%=username%>"><img src="<%=p24.getPictures() %>" alt=""/></a></li>
            <%Product p25=product.getProductInfo(25); %>
            <li><a href="ourproducts.jsp?param1=25&param2=<%=username%>"><img src="<%=p25.getPictures() %>" alt=""/></a></li>
            <%Product p26=product.getProductInfo(26); %>
            <li><a href="ourproducts.jsp?param1=26&param2=<%=username%>"><img src="<%=p26.getPictures() %>" alt=""/></a></li>
           
        </ul>
    </div>
    <div id="item3" class="item">
        <h2>3F piano</h2>

        <ul> 
            <%Product p31=product.getProductInfo(31); %>
            <li><a href="ourproducts.jsp?param1=31&param2=<%=username%>"><img src="<%=p31.getPictures() %>" alt=""/></a></li>
            <%Product p32=product.getProductInfo(32); %>
            <li><a href="ourproducts.jsp?param1=32&param2=<%=username%>"><img src="<%=p32.getPictures() %>" alt=""/></a></li>
            <%Product p33=product.getProductInfo(33); %>
            <li><a href="ourproducts.jsp?param1=33&param2=<%=username%>"><img src="<%=p33.getPictures() %>" alt=""/></a></li>
            <%Product p34=product.getProductInfo(34); %>
            <li><a href="ourproducts.jsp?param1=34&param2=<%=username%>"><img src="<%=p34.getPictures() %>" alt=""/></a></li>
            <%Product p35=product.getProductInfo(35); %>
            <li><a href="ourproducts.jsp?param1=35&param2=<%=username%>"><img src="<%=p35.getPictures() %>" alt=""/></a></li>
            <%Product p36=product.getProductInfo(36); %>
            <li><a href="ourproducts.jsp?param1=36&param2=<%=username%>"><img src="<%=p36.getPictures() %>" alt=""/></a></li>
           
        </ul>
    </div>
    <div id="item4" class="item">
        <h2>4F log cabin</h2>

        <ul>
            <%Product p41=product.getProductInfo(41); %>
            <li><a href="ourproducts.jsp?param1=41&param2=<%=username%>"><img src="<%=p41.getPictures() %>" alt=""/></a></li>
            <%Product p42=product.getProductInfo(42); %>
            <li><a href="ourproducts.jsp?param1=42&param2=<%=username%>"><img src="<%=p42.getPictures() %>" alt=""/></a></li>
            <%Product p43=product.getProductInfo(43); %>
            <li><a href="ourproducts.jsp?param1=43&param2=<%=username%>"><img src="<%=p43.getPictures() %>" alt=""/></a></li>
 
        </ul>
    </div>
    <div id="item5" class="item">
        <h2>5F wood box</h2>

        <ul>
            <%Product p51=product.getProductInfo(51); %>
            <li><a href="ourproducts.jsp?param1=51&param2=<%=username%>"><img src="<%=p51.getPictures() %>" alt=""/></a></li>
            <%Product p52=product.getProductInfo(52); %>
            <li><a href="ourproducts.jsp?param1=52&param2=<%=username%>"><img src="<%=p52.getPictures() %>" alt=""/></a></li>
            <%Product p53=product.getProductInfo(53); %>
            <li><a href="ourproducts.jsp?param1=53&param2=<%=username%>"><img src="<%=p53.getPictures() %>" alt=""/></a></li>
           
        </ul>
    </div>
     <div id="item6" class="item">
        <h2>6F DIY box</h2>

        <ul>
            <%Product p0=product.getProductInfo(0); %>
            <li><a href="ourproducts.jsp?param1=0&param2=<%=username%>"><img src="<%=p0.getPictures() %>" alt=""/></a></li>
           
        </ul>
    </div>
</div>
<div id="cart">
		<a href="Cart.jsp"><img src="cart.jpg" alt=""/></a>
</div>


		
		
		
     

</body>
</html>