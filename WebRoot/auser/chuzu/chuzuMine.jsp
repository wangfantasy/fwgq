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
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
		<script language="JavaScript" src="<%=path %>/js/public.js" type="text/javascript"></script>
		
        <script language="javascript">
           function chuzuAdd()
           {
              var url="<%=path %>/auser/chuzu/chuzuAdd.jsp";
              window.location.href=url;
           }
           
           function chuzuDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/chuzuDel.action?id="+id;
               }
           }
           
            function over(picPath)
	       {
			  if (picPath=="")picPath="/images/default.jpg";
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
					<td height="14" colspan="20" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					
					<td width="5%">户型要求</td>
					<td width="5%">面积要求</td>
					<td width="10%">装修情况</td>
					<td width="5%">价格要求(元/月)</td>
					
					<td width="10%">地址要求</td>
					<td width="5%">联系人</td>
					<td width="8%">联系电话</td>
					
					<td width="8%">房屋图片</td>	
					
					<td width="8%">发布时间</td>
					<td width="8%">状态</td>
					<td width="8%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.chuzuList}" var="chuzu" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuzu.huxing}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuzu.mianji}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuzu.zhuangxiu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuzu.jiage}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuzu.dizhi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuzu.lianxiren}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuzu.lianxihua}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					    <div onmouseover = "over('<%=path %>/${chuzu.fujian}')" onmouseout = "out()" style="cursor:hand;">
							房屋图片
				        </div>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 ${chuzu.fabushi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${chuzu.zt}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 <input type="button" value="删除" onclick="chuzuDel(${chuzu.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			 <div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
				<TABLE id="tipTable" border="0" bgcolor="#ffffee">
					<TR align="center">
						<TD><img id="photo" src="" height="80" width="120"></TD>
					</TR>
				</TABLE>
			</div>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			        &nbsp;<input type="button" value="发布出租信息" style="width: 123px;" onclick="chuzuAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
