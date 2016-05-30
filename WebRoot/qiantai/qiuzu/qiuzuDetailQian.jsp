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
	          <!-- <h1 style="font-size: 22px;">
	              &nbsp;
	          </h1> -->
	          <div>
		           <table width="100%" border="0" cellpadding="5" cellspacing="5">
							    <tr>
							       <td align="left">户型要求：${requestScope.qiuzu.huxing }</td>
							    </tr>
							    <tr>
							       <td align="left">面积要求：${requestScope.qiuzu.mianji }</td>
							    </tr>
							    <tr>
							       <td align="left">装修情况：${requestScope.qiuzu.zhuangxiu }</td>
							    </tr>
							    <tr>
							       <td align="left">价格要求(元/月)：${requestScope.qiuzu.jiage }</td>
							    </tr>
							    <tr>
							       <td align="left">地址要求：${requestScope.qiuzu.dizhi }</td>
							    </tr>
							    <tr>
							       <td align="left">联系人：${requestScope.qiuzu.lianxiren }</td>
							    </tr>
							    <tr>
							       <td align="left">联系电话：${requestScope.qiuzu.lianxihua }</td>
							    </tr>
							    <tr>
							       <td align="left">发布时间：<fmt:formatDate value="${requestScope.qiuzu.fabushi }" pattern="yyyy-MM-dd"/></td>
							    </tr>
			                </table>
	          </div>
	      </div>
      </div>
      
      
      
      
      
      <footer>
          <a href="<%=path %>/login.jsp">系统后台</a>
          
         
<TBODY>
  <tr>
    <td align=middle>
	<div align=center>
	  建议使用IE6.0或以上版本浏览 <br>
	 </div>
    </td>
 </tr>
</TBODY>

          
          
          
          
          
          
      </footer>
  </div>
</body>
</html>
