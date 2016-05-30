<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
          
           
           function liuyanDetail(liuyanId)
           {
                 var url="<%=path %>/liuyanDetail.action?liuyanId="+liuyanId;
                 //var n="";
                 //var w="400px";
                 //var h="400px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 window.location=url;
           }
           
           
           
           function huifuDetail(liuyanId)
           {
                 var url="<%=path %>/huifuDetail.action?liuyanId="+liuyanId;
                  // var n="";
                 //var w="400px";
                 //var h="400px";
                // var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location=url;
           }
           
           
           function over(picPath)
	       {
			  if (picPath=="")picPath="/img/default.jpg";
			  x = event.clientX;
			  y = event.clientY;      
			  document.all.tip.style.display = "block";
			  document.all.tip.style.top = y;
			  document.all.tip.style.left = x+10;
			  document.all.photo.src = ".."+picPath; 
		   }
		   function out()
	       {
			  document.all.tip.style.display = "none";
		   }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="14" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="40%">标题</td>
					<td width="10%">留言内容</td>
					<td width="10%">发布时间</td>
					
					<td width="10%">回复内容</td>
					<td width="10%">回复时间</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.liuyanList" id="liuyan" status="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#ss.index+1"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="#liuyan.liuyanTitle"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					    <a href="#" onclick="liuyanDetail(<s:property value="#liuyan.liuyanId"/>)" class="pn-loperator">查看内容</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#liuyan.liuyanDate"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					    <a href="#" onclick="huifuDetail(<s:property value="#liuyan.liuyanId"/>)" class="pn-loperator">查看回复内容</a>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#liuyan.huifuDate"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<!-- <a class="pn-loperator" href="<%=path %>/adminliuyanDel.action?liuyanId=<s:property value="#liuyan.liuyanId"/>">删除</a><br>  -->
						<a class="pn-loperator" href="<%=path %>/huifuEdit.action?liuyanId=<s:property value="#liuyan.liuyanId"/>">回复</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			
		    
		    <div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
				<TABLE id="tipTable" border="0" bgcolor="#ffffee">
					<TR align="center">
						<TD><img id="photo" src="" height="150" width="150"></TD>
					</TR>
				</TABLE>
			</div>
	</body>
</html>
