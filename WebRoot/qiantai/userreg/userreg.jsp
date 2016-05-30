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
	    
	    function check()
        {
              if( document.form1.userName.value=="")
              {
	               alert("请输入账号");
	               return false;
              }
              if( document.form1.userPw.value=="")
              {
	               alert("请输入密码");
	               return false;
              }
              document.form1.submit();
        }
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
	                                        用户注册
	          </h1>
	          <div>
		           <form action="<%=path %>/userReg.action" name="form1" method="post">
	                                  <div class="c1-bline" style="padding:7px 0px;">
	                                       <div class="f-left" style="margin-left: 5px;">
	                                                  账号：<input style="width: 200px;" name="userName" type="text" />
	                                       </div>
	                                       <div class="f-right"></div>
	                                       <div class="clear"></div>
	                                  </div>
	                                  <div class="c1-bline" style="padding:7px 0px;">
	                                       <div class="f-left" style="margin-left: 5px;">
	                                                  密码：<input type="password" name="userPw" style="width: 200px;"/>
	                                       </div>
	                                       <div class="f-right"></div>
	                                       <div class="clear"></div>
	                                  </div>
	                                  <div class="c1-bline" style="padding:7px 0px;">
	                                       <div class="f-left" style="margin-left: 5px;">
	                                                  姓名：<input type="text" name="userRealname" style="width: 200px;"/>
	                                       </div>
	                                       <div class="f-right"></div>
	                                       <div class="clear"></div>
	                                  </div>
	                                  <div class="c1-bline" style="padding:7px 0px;">
	                                       <div class="f-left" style="margin-left: 5px;">
	                                                  性别：
	                                            <input type="radio" name="userSex" value="男" checked="checked"/>男
											    &nbsp;&nbsp;
											    <input type="radio" name="userSex" value="女"/>女
	                                       </div>
	                                       <div class="f-right"></div>
	                                       <div class="clear"></div>
	                                  </div>
	                                  <div class="c1-bline" style="padding:7px 0px;">
	                                       <div class="f-left" style="margin-left: 5px;">
	                                                  年龄：<input style="width: 200px;" name="userEmail" type="text"/>
	                                       </div>
	                                       <div class="f-right"></div>
	                                       <div class="clear"></div>
	                                  </div>
	                                  <div class="c1-bline" style="padding:7px 0px;">
	                                       <div class="f-left" style="margin-left: 5px;">
	                                                  住址：<input type="text" name="userAddress" style="width: 200px;"/>
	                                       </div>
	                                       <div class="f-right"></div>
	                                       <div class="clear"></div>
	                                  </div>
	                                  
	                                  <div class="c1-bline" style="padding:7px 0px;">
	                                       <div class="f-left" style="margin-left: 5px;">
	                                                  电话：<input type="text" name="userTel" style="width: 200px;"/>
	                                                  &nbsp;&nbsp;
	                                           
	                                          
	                                         </div>
	                                       
	                                       
	                                       
	                                       
	                                       <div class="f-right"></div>
	                                       <div class="clear"></div>
	                                  </div>
	                                  
	                                  
	                                  <div>
	                                            <input type="button" value="注册" onclick="check()" style=" margin: 20px; width: 100px;height: 24px;"/>
	                                            &nbsp; &nbsp; &nbsp; &nbsp;
	                                            <input type="reset" value="重置"   style="width: 100px;height: 24px;"/>
	                                   </div>
	                                  
	                                  
                                  </form>
	          </div>
	      </div>
      </div>
      
      
      
      
      
      <footer>
          <a href="<%=path %>/login.jsp">系统后台</a>
      </footer>
  </div>
</body>
</html>
