<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
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

		<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css" />
		<link rel="stylesheet" type="text/css" href="<%=path%>/css/iLv.css" />

		<script type="text/javascript" src="<%=path%>/js/modernizr-1.5.min.js"></script>

		<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
		<script type="text/javascript"
			src="<%=path%>/js/jquery.easing-sooper.js"></script>
		<script type="text/javascript" src="<%=path%>/js/jquery.sooperfish.js"></script>
		<style type="text/css">
</style>
	</head>

	<body>


		

		<header>
		<div id="main">

			<div id="logo">
				<div id="logo_text">
					<br />
					<br />
					<br />
					<h1 style="width: 500px;">

						<a href="<%=path %>/index.action" style="font-size: 30px;">房屋供求信息网</a>
					</h1>
				</div>
			</div>



			<div id="menu_container">

				<jsp:include flush="true" page="/qiantai/top.jsp"></jsp:include>
			</div>

			</header>




			<div id="site_content">
				<jsp:include flush="true" page="/qiantai/right.jsp"></jsp:include>
				<table border="0" width="800" cellspacing="0" cellpadding="0">
					
					
					
					
					
					<tbody>
						<tr>
						
						
						
						
							<td width="375">
							
								<table border="0" width="375" cellspacing="0" cellpadding="0">
									<tbody>
									
										<tr>
											<td height="27" class="menut1">
												<table border="0" width="100%" cellspacing="0"
													cellpadding="0">
													<tbody>
														<tr>
															<td width="20"></td>
															<td width="86" align="center" height="27"
																class="font2 menus style15">
																
																<a href="<%=path %>/chushouAll.action?first=0&max=10">出售信息</a>
															</td>
															<td width="268"></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										
										
										<tr>
											<td height="100">
												<table border="0" width="100%" cellspacing="0" cellpadding="0">
													
													<tbody>
														<tr>
														
															<td class="color2" width="1"></td>
															
															  <td width="370" height="100" align="center" valign="top">
																<table border="0" width="365" cellpadding="0" cellspacing="0">
																	<tbody>
																	
																	
																	
																	   
	                                                                    																		
                                                                 <c:forEach items="${requestScope.chushouList}" var="chushou">
                                                                     <tr class="font1">
																			<td width="30" align="center" height="25">
																				<img border="0" src="images/netubiao.gif">
																			</td>
																			<td>
																				<a href="<%=path %>/chushouDetailQian.action?id=${chushou.id}" target="_self"><font
																					color="#333333">${chushou.dizhi} </font> </a>
																			</td>
																			
																			
																			<td><a href="<%=path %>/chushouDetailQian.action?id=${chushou.id}" target="_self"><font color="#333333">${chushou.zhuangxiu}</font> </a></td>&nbsp;
																			
																			<td>
																				<a href="<%=path %>/chushouDetailQian.action?id=${chushou.id}" target="_self"><font
																					color="#333333">${chushou.huxing}</font> </a>
																			</td>
																			<td>
																				<a href="<%=path %>/chushouDetailQian.action?id=${chushou.id}"  target="_self"><font
																					color="#333333">${chushou.jiage}</font> </a>
																			</td>
																			
																		</tr>
							  
		                                                   </c:forEach>
		                                                   
		                                                   
		                                               	
																		
																		
																		
																		<tr>
																			<td height="1" colspan="5" background="images/News_Hot.gif"></td>
																		</tr>
																	
																	</tbody>
																</table>
																
																
																<table width="370" border="0">
																	<tbody>
																		<tr>
																			<td align="right" height="22" colspan="2">
																				<a href="<%=path %>/chushouAll.action?first=0&max=10"> <img border="0"
																						src="images/case_n.gif" width="117" height="18"
																						alt="房屋出售信息">
																				</a>
																			</td>
																		</tr>
																	</tbody>
																</table>
																
															</td>
															<td class="color2" width="1"></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										<tr>
											<td height="20" class="menue1"></td>
										</tr>
									</tbody>
								</table>
							</td>
							
							
							
							
							
							
							<td width="50"></td>
							<td width="375">
								<table border="0" width="375" cellspacing="0" cellpadding="0">
									<tbody>
									
										<tr>
											<td height="27" class="menut1">
												<table border="0" width="100%" cellspacing="0"
													cellpadding="0">
													<tbody>
														<tr>
															<td width="20"></td>
															<td width="86" align="center" height="27"
																class="font2 menus style15">
																<a href="<%=path %>/chuzuAll.action?first=0&max=10">出租信息</a>
															</td>
															<td width="268"></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										
										<tr>
											<td height="100">
												<table border="0" width="100%" cellspacing="0"
													cellpadding="0">
													<tbody>
														<tr>
															<td class="color2" width="1"></td>
															<td width="308" height="100" align="center" valign="top">
																<table border="0" width="365" cellpadding="0"
																	cellspacing="0">
																	<tbody>
																	
																	
																		
																		
																		
																		
																	 <c:forEach items="${requestScope.chuzuList}"  var="chuzu">
                                                                     <tr class="font1">
																			<td width="30" align="center" height="25">
																				<img border="0" src="images/netubiao.gif">
																			</td>
																			<td>
																				<a href="<%=path %>/chuzuDetailQian.action?id=${chuzu.id}" target="_self"><font color="#333333">${chuzu.dizhi} </font> </a>
																			</td>
																			
																			<td><a href="<%=path %>/chuzuDetailQian.action?id=${chuzu.id}" target="_self"><font color="#333333">${chuzu.zhuangxiu}</font> </a></td>&nbsp;
																			
																			
																			<td>
																				<a href="<%=path %>/chuzuDetailQian.action?id=${chuzu.id}" target="_self"><font color="#333333">${chuzu.huxing}</font> </a>
																			</td>
																			<td>
																				<a href="<%=path %>/chuzuDetailQian.action?id=${chuzu.id}"  target="_self"><font color="#333333">${chuzu.jiage}</font> </a>
																			</td>
																			
																		</tr>
		                                                   
		                                               	 </c:forEach>
																		
																		
																		
																		<tr>
																			<td height="1" colspan="5" background="images/News_Hot.gif"></td>
																		</tr>
																		
																
																		
																		
																	</tbody>
																</table>
																<table width="370" border="0">
																	<tbody>
																		<tr>
																			<td align="right" height="22" colspan="2">
																				<a href="<%=path %>/chuzuAll.action?first=0&max=10"> <img border="0"
																						src="images/case_n.gif" width="117" height="18"
																						alt="房屋出租信息">
																				</a>
																			</td>
																		</tr>
																	</tbody>
																</table>
															</td>
															<td class="color2" width="1"></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										<tr>
											<td height="20" class="menue1"></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td height="60" colspan="3"></td>
						</tr>
						
						
						
						
						
						
						<tr>
							<td width="375">
								<table border="0" width="375" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td height="27" class="menut1">
												<table border="0" width="100%" cellspacing="0"
													cellpadding="0">
													<tbody>
														<tr>
															<td width="20"></td>
															<td width="86" align="center" height="27"
																class="font2 menus style15">
																<a href="<%=path %>/qiugouAll.action?first=0&max=10">求购信息</a>
															</td>
															<td width="268"></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										<tr>
											<td height="100">
												<table border="0" width="100%" cellspacing="0"
													cellpadding="0">
													<tbody>
														<tr>
															<td class="color2" width="1"></td>
															<td width="308" height="100" align="center" valign="top">
																<table border="0" width="365" cellpadding="0"
																	cellspacing="0">
																	<tbody>
																	
																	
																		
																		
																			
																		
																	 <c:forEach items="${requestScope.qiugouList}" var="qiugou">
                                                                     <tr class="font1">
																			<td width="30" align="center" height="25">
																				<img border="0" src="images/netubiao.gif">
																			</td>
																			<td>
																				<a href="<%=path %>/qiugouDetailQian.action?id=${qiugou.id}" target="_self"><font
																					color="#333333">${qiugou.dizhi} </font> </a>
																			</td>
																			
																			<td><a href="<%=path %>/qiugouDetailQian.action?id=${qiugou.id}" target="_self"><font color="#333333">${qiugou.zhuangxiu}</font> </a></td>&nbsp;
																			
																			
																			<td>
																				<a href="<%=path %>/qiugouDetailQian.action?id=${qiugou.id}" target="_self"><font
																					color="#333333">${qiugou.huxing}</font> </a>
																			</td>
																			<td>
																				<a href="<%=path %>/qiugouDetailQian.action?id=${qiugou.id}"  target="_self"><font
																					color="#333333">${qiugou.jiage}</font> </a>
																			</td>
																			
																		</tr>
							  
		                                                   </c:forEach>
		                                                   
		                                                   
		                                               	
																		
																		
																		
																		<tr>
																			<td height="1" colspan="5" background="images/News_Hot.gif"></td>
																		</tr>
																		
																	</tbody>
																</table>
																<table width="370" border="0">
																	<tbody>
																		<tr>
																			<td align="right" height="22" colspan="2">
																				<a href="<%=path %>/qiugouAll.action?first=0&max=10"> <img border="0"
																						src="images/case_n.gif" width="117" height="18"
																						alt="房屋求购信息">
																				</a>
																			</td>
																		</tr>
																	</tbody>
																</table>
															</td>
															<td class="color2" width="1"></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										<tr>
											<td height="20" class="menue1"></td>
										</tr>
									</tbody>
								</table>
							</td>
							
							
							
							
							<td width="20"></td>
							<td width="375">
								<table border="0" width="375" cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<td height="27" class="menut1">
												<table border="0" width="100%" cellspacing="0"
													cellpadding="0">
													<tbody>
														<tr>
															<td width="20"></td>
															<td width="86" align="center" height="27"
																class="font2 menus style15">
																<a href="<%=path %>/qiuzuAll.action?first=0&max=10">求租信息</a>
															</td>
															<td width="268"></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										
										
										
										<tr>
											<td height="100">
												<table border="0" width="100%" cellspacing="0"
													cellpadding="0">
													<tbody>
														<tr>
															<td class="color2" width="1"></td>
															<td width="308" height="100" align="center" valign="top">
																<table border="0" width="365" cellpadding="0"
																	cellspacing="0">
																	<tbody>
																	
																	
																	
																		
																		 <c:forEach items="${requestScope.qiuzuList}" var="qiuzu">
                                                                     <tr class="font1">
																			<td width="30" align="center" height="25">
																				<img border="0" src="images/netubiao.gif">
																			</td>
																			
																			<td>
																				<a href="<%=path %>/qiuzuDetailQian.action?id=${qiuzu.id}" target="_self"><font color="#333333">${qiuzu.dizhi} </font> </a>
																			</td>
																			
																			<td><a href="<%=path %>/qiuzuDetailQian.action?id=${qiuzu.id}" target="_self"><font color="#333333">${qiuzu.zhuangxiu}</font> </a></td>&nbsp;
																			
																			
																			
																			<td>
																				<a href="<%=path %>/qiuzuDetailQian.action?id=${qiuzu.id}" target="_self"><font color="#333333">${qiuzu.huxing}</font> </a>
																			</td>
																			
																			<td>
																				<a href="<%=path %>/qiuzuDetailQian.action?id=${qiuzu.id}"  target="_self"><font color="#333333">${qiuzu.jiage}</font> </a>
																			</td>
																			
																		</tr>
							  
		                                                     </c:forEach>
		                                                   
		                                                   
		                                               	
																		
																		
																		
																		<tr>
																			<td height="1" colspan="5" background="images/News_Hot.gif"></td>
																		</tr>
																		
																	</tbody>
																</table>
																<table width="370" border="0">
																	<tbody>
																		<tr>
																			<td align="right" height="22" colspan="2">
																				<a href="<%=path %>/qiuzuAll.action?first=0&max=10"> <img border="0"
																						src="images/case_n.gif" width="117" height="18"
																						alt="房屋求租信息">
																				</a>
																			</td>
																		</tr>
																	</tbody>
																</table>
															</td>
															<td class="color2" width="1"></td>
														</tr>
													</tbody>
												</table>
											</td>
										</tr>
										<tr>
											<td height="20" class="menue1"></td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			
			
			<footer>
			<a href="<%=path%>/login.jsp">系统后台</a>
			</footer>
		</div>
	</body>
</html>
