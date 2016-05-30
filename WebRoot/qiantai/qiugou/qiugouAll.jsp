<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<meta http-equiv="pragma" content="no-cache"/>
	<meta http-equiv="cache-control" content="no-cache"/>
	<meta http-equiv="expires" content="0"/>    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
	<meta http-equiv="description" content="This is my page"/>
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css" />
    <script type="text/javascript" src="<%=path %>/js/modernizr-1.5.min.js"></script>
   
    <script type="text/javascript" src="<%=path %>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.easing-sooper.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery.sooperfish.js"></script>
    
	<script type="text/javascript">
	    $(document).ready(function() 
	    {
	      $('ul.sf-menu').sooperfish();
	      $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
	    });
	    
	    
	</script>
	
	<style type="text/css">
		.c1-bline{border-bottom:#999 1px dashed;border-top:1px;}
		.f-right{float:right}
		.f-left{float:left}
		.clear{clear:both}
	</style>
  </head>
   
  <body>
  <div id="main">
      <header>
	       <div id="logo">
	        <div id="logo_text">
	          <br/><br/><br/>
	          <h1 style="width: 700px;"><a href="#" style="font-size: 30px;">房屋供求信息网</a></h1>
	        </div>
	      </div>
	      
	      
          <div id="menu_container">
	          <jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
          </div>
      </header>
      
      
      
      
      <div id="site_content">
	      <jsp:include flush="true" page="/qiantai/right.jsp"></jsp:include>
	      <div class="content">
	          <!-- <h1 style="font-size: 22px;">新闻喜讯</h1>
	          <p>
		           This simple, fixed width website template is released under a Creative Commons Attribution 3.0 Licence
		           This means you are free to download and use it for personal and commercial proj
	          </p>
	          <p>1111</p>
	          <p>2222</p> -->
	          <h1 style="font-size: 22px;">
	                                        求购信息
	          </h1>
	          	          
<div>
<c:forEach items="${requestScope.qiugouList}" var="qiugou">

 <div class="c1-bline" style="padding:7px 0px;">
    <tr class="font1">
<td width="30" align="center" height="25">  <img border="0" src="images/netubiao.gif"></td>
																	
<td><a href="<%=path %>/qiugouDetailQian.action?id=${qiugou.id}" target="_self"><font color="#333333">${qiugou.dizhi} </font> </a></td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<td><a href="<%=path %>/qiugouDetailQian.action?id=${qiugou.id}" target="_self"><font color="#333333">${qiugou.zhuangxiu}</font> </a></td>&nbsp;
																			
<td><a href="<%=path %>/qiugouDetailQian.action?id=${qiugou.id}" target="_self"><font color="#333333">${qiugou.huxing}</font> </a></td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="<%=path %>/qiugouDetailQian.action?id=${qiugou.id}"  target="_self"><font color="#333333">${qiugou.jiage}</font> </a></td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="<%=path %>/qiugouDetailQian.action?id=${qiugou.id}" target="_self"><font color="#333333"><fmt:formatDate value="${qiugou.fabushi}" pattern="yyyy-MM-dd"/></font> </a></td>
   
    </tr>

<div class="clear"></div>

</div>
</c:forEach>
</div>

	          
	          <div style="text-align:right;">
	      <a href="<%=path %>/qiugouAll.action?first=${requestScope.prefirst}&max=10">上一页</a>
	      <a href="<%=path %>/qiugouAll.action?first=${requestScope.nextfirst}&max=10">下一页</a>
	      </div>
	          
	          
	      </div>
      </div>
      
      
      
      
      
      <footer>
          <a href="<%=path %>/login.jsp">系统后台</a>
      </footer>
  </div>
</body>
</html>
