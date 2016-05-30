<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="error.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
   <head>
</head>


<frameset border=0 frameSpacing=0 rows=120,* frameBorder=NO>
    <frame name=topFrame src="<%=path %>/auser/top.jsp" noResize scrolling=no>
    
	          <h1 style="width: 700px;"><a href="#" style="font-size: 30px;">房屋供求信息网</a></h1>
	       
 
    <frameset border=0 name=content frameSpacing=0 frameBorder=0 cols=192,*>
	    <frame name=BoardMenu marginWidth=0 marginHeight=0 src="<%=path %>/auser/leftMenu.jsp" noResize scrolling=no target="main">
	    <frame name=main marginWidth=0 marginHeight=0 src="<%=path %>/auser/index/sysPro.jsp" noResize>
    </frameset>
</frameset>
</HTML>