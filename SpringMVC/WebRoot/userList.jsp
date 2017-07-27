<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统-用户管理</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td>				
					<form method="post" action="${pageContext.request.contextPath}/user/getUser">
					<input name="method" value="query" class="input-text" type="hidden"> 用户名：<input name="userName" class="input-text" type="text" value="">&nbsp;&nbsp;&nbsp;&nbsp;	
							<input type="hidden" name="_method" value="get"/>													
							<input value="查 询" type="submit" id="select">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<form action="${pageContext.request.contextPath }/user/addUser" method="post">
				<input type="hidden" name="_method" value="get">
				<em><input value="添加用户" class="input-button" onclick="window.location='userAdd.html'" type="submit"></em>
			</form>
			<div class="title">用户管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">用户名</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">用户账号</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">性别</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">出生日期</div>
						</td>
						<td width="150"><div class="STYLE1" align="center">电话</div>
						</td>
						<td width="150"><div class="STYLE1" align="center">权限</div>
						</td>
					</tr>
					<c:forEach items="${users}" var="user">
						<tr>
							<td height="23"><span class="STYLE1">${user.id}</span>
							</td>
							<td><span class="STYLE1">${user.userName} </span>
							</td>
							<td><span class="STYLE1"><a href="${pageContext.request.contextPath }/user/findUser/${user.id}"> ${user.userCode}</a>
							</span>
							</td>
	
							<td><span class="STYLE1">
								${user.gender==1?"男":"女"}						
							 </span>
							</td>
							<td><span class="STYLE1">${user.birthday}</span>
							</td>
							<td><span class="STYLE1">${user.phone}</span>
							</td>
							<td><span class="STYLE1">
								${user.userRole.id==1?"管理员":user.userRole.id==2?"经理":"普通员工"}
					     </span>
							</td>
						</tr>
					</c:forEach>				
				</tbody>
			</table>
		</div>
	</div>

</body></html>