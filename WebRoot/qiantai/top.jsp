<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
   String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
     
  </head>
  
  <body>
   
    
      <ul class="sf-menu" id="nav">
                                
          <li><a href="<%=path %>/index.action">网站首页</a></li>
          <li><a href="<%=path %>/chushouAll.action?first=0&max=10">出售信息</a></li>
          <li><a href="<%=path %>/chuzuAll.action?first=0&max=10">出租信息</a></li>
          
          <li><a href="<%=path %>/qiugouAll.action?first=0&max=10">求购信息</a></li>
          <li><a href="<%=path %>/qiuzuAll.action?first=0&max=10">求租信息</a></li>
          <li><a href="<%=path %>/qiantai/chaxun/chaxunPre.jsp">查询模块</a></li>
         
          <li><a href="<%=path %>/gonggaoAll.action">公告信息</a></li>
         <!--   <li><a href="<%=path %>/qiantai/picture/html/picture.jsp">图片资讯</a> </li>   -->
           <li><a href="<%=path %>/qiantai/userreg/userreg.jsp">用户注册</a></li>
             <li><a href="<%=path %>/login.jsp">管理员登录</a></li>       
      </ul>
  </body>
</html>
