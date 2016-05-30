<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<meta http-equiv="X-UA-Compatible" content="IE=8" />
	
	<link rel="stylesheet" href="<%=path %>/css/leftMenu.css" type="text/css"></link>
  
    <script type="text/javascript" src="<%=path %>/js/jquery-1.4.1.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery-common.js"></script>
	
    <script type="text/javascript">
        var state = 0;
        $(document).ready(function () {
            /********* 菜单收缩效果***********/
            $(".navcontent").hide();
            $(".navhead").click(function () {
                $(".navcontent").not($(this).next()).hide();
                $(this).next().slideToggle(200);
                $("a[type='Module']").not($(this)).attr("class", "navhead");
                if ($(this).attr("class") == "navhead") {
                    $(this).attr("class", "navheadOpen");
                }
                else {
                    $(this).attr("class", "navhead");
                }
            });
            $(".navhead").first().click();
        });
    </script>
    
    <style type="text/css">
        html
        {
            _overflow-x: hidden;
            height: 100%;
        }
        body
        {
            background-color: #D9F3FF;
            padding: 0px;
            margin: 0px;
            height: 100%;
        }
        ul
        {
            margin: 0px;
            padding: 0px;
        }
        li
        {
            list-style: none;
            margin: 0px;
            padding: 0px;
        }
    </style>
  </head>
  
  
  
  
 


<c:if test="${sessionScope.userType==1 }">
  <body style="margin: 0px;">
        
        <div id="Menu" style="width: 190px; float: left; margin: 2px 0px 0px 2px; _margin-left: 2.5px;overflow: hidden;">
            <div style="margin-left: 2px; width: 180px; height: 25px; vertical-align: middle;line-height: 25px; font-size: 16px; font-weight: bold; color: White;font-family: 微软雅黑; background-image: url('<%=path %>/images/menutop.png')">
            
            
             <!-- 管理菜单 -->
            </div>
            
            <ul id="identifier">
          
                <li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
                <img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;个人信息管理</a>
                    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />
						&nbsp;<a target="main" href="<%=path %>/auser/userinfo/userPw.jsp" style="font-family: 微软雅黑;">修改登录密码</a></li>
	               
	               <li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />
						&nbsp;<a target="main" href="<%=path %>/auser/userinfo/userEdit.jsp" style="font-family: 微软雅黑;">修改详细信息</a></li>
	                
	                </ul>
                </li>
                
                
                
                	
			<li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;房屋信息管理</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />
						&nbsp;<a target="main" href="<%=path %>/chushouMine.action" style="font-family: 微软雅黑;">出售信息管理</a></li>
                      
                      <li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />
						&nbsp;<a target="main" href="<%=path %>/chuzuMine.action" style="font-family: 微软雅黑;">出租信息管理</a></li>

                   <li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />
						&nbsp;<a target="main" href="<%=path %>/qiugouMine.action" style="font-family: 微软雅黑;">求购信息管理</a></li>

                   <li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />
						&nbsp;<a target="main" href="<%=path %>/qiuzuMine.action" style="font-family: 微软雅黑;">求租信息管理</a></li>

				    </ul>
				</li>
				
                
                
                
                
            
        
		
            
            
            
			 
			 <li><a class="navhead" type='Module' style="font-family: 微软雅黑;">
				<img style='vertical-align:middle' src="<%=path %>/images/group.png" />&nbsp;留言管理</a>
				    <ul class="navcontent">
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />
						&nbsp;<a target="main" href="<%=path %>/liuyanMine.action" style="font-family: 微软雅黑;">查看留言</a></li>
						<li><img  style='vertical-align:middle' src="<%=path %>/images/vcard_add.png" />
						&nbsp;<a target="main" href="<%=path %>/auser/liuyan/liuyanAdd.jsp" style="font-family: 微软雅黑;">发布留言</a></li>
					</ul>
			  </li>
            <div style="margin-left: 2px; width: 180px; height: 28px; background-image: url('<%=path %>/images/foot.png')"></div>
        </div>



</body>
</c:if>

</html>
