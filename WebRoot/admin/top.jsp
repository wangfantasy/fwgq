<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=utf-8">
		<style type="text/css">
	        .Header {background: url(<%=path %>/images/topleft.jpg) #d10e00 repeat-x left top; height: 118px;}
	        .HeaderTop {margin: 0px auto;}
        </style>
        
        <script type="text/javascript">
		    function logout()
			{
			   if(confirm("确定要退出本系统吗??"))
			   {
				   window.parent.location="<%=path %>/login.jsp";
			   }
			}
	    </script>
	</head>





	<body text=#000000 bgColor=#ffffff leftMargin=0 rightmargin="0" topMargin=0 marginheight="0" marginwidth="0">
		<div class="Header HeaderTop">
            <div class="list_bar">
				 <span style="float:left;font-size: 33px;color: white;font-weight: bolder;display: block;text-align: left;margin-top: 38px;margin-left: 30px;">
				    房屋供求信息网
				 </span>
				 
				 
				 
				 <span style="float:right;font-size: 13px;color: white;font-weight: bolder;display: block;text-align: left;margin-top: 28px;margin-right: 10px;">			    
				     <script>setInterval("clock.innerHTML=new Date().toLocaleString()+'&nbsp;&nbsp;'+''.charAt(new Date().getDay());",1000)</script>
				     
				     <span id=clock></span>
                     &nbsp;&nbsp;&nbsp;
                     <!-- <a href="#" onclick="logout()" style="color: white;font-size: 14px;font-family: 微软雅黑">退出系统</a> -->
                 </span>
				 
				 
				 <span style="float:right;font-size: 13px;color: white;font-weight: bolder;display: block;text-align: left;margin-top: 28px;margin-right: 10px;">
				 
			        	<font style="font-size:16px; font-weight: bold;">
			        	    您好,管理员&nbsp;&nbsp;&nbsp;&nbsp;
			        	</font>
			        	
			        	[<a href="/fwgq/index.action" target="_blank">网站主页</a>]
			        	[<a href="#" onclick="logout()">注销退出</a>]
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  
				 </span>
				 
				 
				
				 
				 
			</div>
		</div>
		</body>
</html>
