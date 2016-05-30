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
    
    
    <script type='text/javascript'     src='<%=path%>/dwr/interface/loginService.js'></script>
		<script type='text/javascript' src='<%=path%>/dwr/engine.js'></script>
		<script type='text/javascript' src='<%=path%>/dwr/util.js'></script>
    
    
    <script language="javascript">
            function check()
            {
               
                 loginService.userEdit(document.formEdit.userRealname.value, document.formEdit.userSex.value,document.formEdit.userAge.value,document.formEdit.userAddress.value,document.formEdit.userTel.value,callback);
            }
            
            function callback(data)
            {
                //document.getElementById("indicator").style.display="none";
                if(data=="OK"){
                	alert("修改成功");
                }else if(data=="LOGIN"){
                	alert("会话已失效");
                }
            }
        </script>
    
    
    
    
    
    
	<script type="text/javascript">
	    $(document).ready(function() 
	    {
	      $('ul.sf-menu').sooperfish();
	      $('.top').click(function() {$('html, body').animate({scrollTop:0}, 'fast'); return false;});
	    });
	</script>
	
	
  </head>
   
  <body>
 
      
      
      <body leftmargin="2" topmargin="9" background='<%=path%>/images/allbg.gif'>
		<form method="post" action="<%=path%>/userEdit.action" name="formEdit">
			<table width="98%" align="center" border="0" cellpadding="4"
				cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom: 8px">
				<tr bgcolor="#EEF4EA">
					<td colspan="2" background="<%=path%>/images/wbg.gif"
						class='title'>
						<span>用戶信息修改</span>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td width="10%" bgcolor="#FFFFFF" align="right">
						登录名
					</td>
					<td width="90%" bgcolor="#FFFFFF">
						<input type="text" value="${sessionScope.user.userName }"
							name="userName" style="margin:5px;width:200px; height:20px;" disabled="disabled" />
					</td>
				</tr>
				
				
				
				
				
				<tr bgcolor="#FFFFFF">
					<td width="10%" bgcolor="#FFFFFF" align="right">
						姓名：
					</td>
					<td width="90%" bgcolor="#FFFFFF">
						<input type="text" id="userRealname" name="userRealname" style="margin:5px;width:200px; height:20px;" />
					</td>
				</tr>
				
				
				<tr bgcolor="#FFFFFF">
					<td width="10%" bgcolor="#FFFFFF" align="right">
						性別：
					</td>
					
					<td width="90%" bgcolor="#FFFFFF"> &nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="userSex" value="男" checked="checked" style="margin:5px;"/>男
											    &nbsp;&nbsp;&nbsp;&nbsp;
					   <input type="radio" name="userSex" value="女" style="margin:5px;"/>女
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td width="10%" bgcolor="#FFFFFF" align="right">
						年龄：
					</td>
					<td width="90%" bgcolor="#FFFFFF">
						<input type="text" id="userAge" name="userAge"  style="margin:5px;width:200px; height:20px;" />
					</td>
				</tr>
				
				
				<tr bgcolor="#FFFFFF">
					<td width="10%" bgcolor="#FFFFFF" align="right">
					  地址：
					</td>
					<td width="90%" bgcolor="#FFFFFF">
						<input type="text" id="userAddress" name="userAddress" style="margin:5px;width:200px; height:20px;" />
					</td>
				</tr>
				
				
				<tr bgcolor="#FFFFFF">
					<td width="10%" bgcolor="#FFFFFF" align="right">
					  电话：
					</td>
					<td width="90%" bgcolor="#FFFFFF">
						<input type="text" id="userTel" name="userTel" style="margin:5px;width:200px; height:20px;" />
					</td>
				</tr>
				
				<tr bgcolor="#FFFFFF">
					<td width="10%" bgcolor="#FFFFFF" align="right">
						&nbsp;
					</td>
					<td width="90%" bgcolor="#FFFFFF">
						<input type="button" value="修改" onclick="check()"  style="margin:5px;" />
						&nbsp;&nbsp;&nbsp;
						<input type="reset" value="重置"  style="margin:5px;"/>
						<img id="indicator" src="<%=path%>/images/loading.gif"
							alt="Loading..." style="display: none" />
					</td>
				</tr>
			</table>
		</form>
	</body>
      
      
   
  
</html>
