<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %> 
<%
  String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
      <div id="sidebar_container">
          <div class="sidebar">
	          <h4 style="margin-top: 10px;">
	             <jsp:include flush="true" page="/qiantai/userlogin/userlogin.jsp"></jsp:include>
	          </h4>
          </div>
          <div class="sidebar">
	          <h3 style="font-size: 11px;">站内公告</h3>
	          <MARQUEE onmouseover=this.stop() onmouseout=this.start() direction=up height=90 width=100% scrollAmount=3 scrollDelay=166 border="0">
	                                             本系统与2016-04-20号正式上线，欢迎广大用户踊跃注册，各类信息应有尽有
	          </MARQUEE>
          </div>
          <div class="sidebar">
	          <h4 style="margin-top: 10px;">
	             <jsp:include flush="true" page="/qiantai/rili/rili.jsp"></jsp:include>
	          </h4>
          </div>
	  </div>
  </body>
</html>
