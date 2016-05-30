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
	
	<script type="text/javascript">
function switchAction(){
if(document.formAdd.query[0].checked==true){
document.formAdd.action="<%=path %>/chushouAll.action";
	
	
}else if(document.formAdd.query[1].checked==true){
   document.formAdd.action="<%=path %>/chuzuAll.action";
	
}else if(document.formAdd.query[2].checked==true){
	document.formAdd.action="<%=path %>/qiugouAll.action";
}else{
	document.formAdd.action="<%=path %>/qiuzuAll.action";
}

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
	          
	          
	          
	          
	          <h1 style="font-size: 22px;">
	             &nbsp;
	          </h1>
	          <div>
	        
              
              
             
						    <form  onsubmit="switchAction()"  name="formAdd" method="post">
								<table align="left" border="0" cellpadding="2" cellspacing="2">
								
									<tr align='center'>
										<td style="width: 80px;" >
											房屋户型：										    
										</td>
										
										<td align="left">
											<input type="text" name="huxing" size="20" style="margin:5px;width:200px; height:20px;" />
										</td>
										
										
									</tr>
								
								
								
									
									<tr align='center'>
										<td style="width: 80px;">
											装修情况：										    
										</td>
										<td align="left">
											<input type="text" name="zhuangxiu" size="20" style="margin:5px;width:200px; height:20px;"/>
										</td>
									</tr>
									
									
									<tr align='center'>
										<td style="width: 80px;">
											所在地址：									    
										</td>
										<td align="left">
											<input type="text" name="dizhi" size="20" style="margin:5px;width:200px; height:20px;"/>
										</td>
									</tr>
									
									
									
									
															
		                         
		                         
                               	<td style="width: 180px;padding:5px"align="center" >搜索类型：</td>
									<td align="left">
										<input name="query" type="radio" value="chushou" checked>出售</input>&nbsp; &nbsp; &nbsp; 
										<input name="query" type="radio" value="chuzu">出租</input>&nbsp; &nbsp; &nbsp; 
										<input name="query" type="radio" value="qiugou">求购</input>&nbsp; &nbsp; &nbsp; 
										<input name="query" type="radio" value="qiuzu">求租</input>&nbsp; &nbsp; &nbsp; 
									</td>
									
							    </td>
		                  	
									
		
									
									
									
									
									<tr align='center'>
									   <td style="width: 80px;" align="left"></td>
									   <td align="left">
									      <input type="submit" value="查询" style="width: 100px; height:30px"/>&nbsp; &nbsp; &nbsp; 
									      <input type="reset" value="重置" style="width: 100px; height:30px"/>&nbsp;	
									   </td>
									</tr>
									
									
								</table>
						
						
						
						
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
