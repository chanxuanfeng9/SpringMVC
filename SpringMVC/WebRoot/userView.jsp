<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>
		</div>
			<div class="content">
				<table class="box"> 
					<tbody><tr>
						<td class="field">用户编号：</td>
						<td>${user.id}<input type="hidden" id="userId" value="1"></td>
						
					</tr>
					<tr>
						<td class="field">用户名：</td>
						<td>${user.userName}</td>
					</tr>
					<tr>
						<td class="field">用户账号：</td>
						<td>${user.userCode}</td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td>
								${user.gender==1?"男":"女"}
								
							
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>${user.birthday}
						</td>
					</tr>					
					<tr>
						<td class="field">用户电话：</td>
						<td>${user.phone}
						</td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td>${user.address}
						</td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>

						<td>
							
							${user.userRole.id==1?"管理员":user.userRole.id==2?"经理":"普通员工"}
							
						</td>
					</tr>
				</tbody></table>
			</div>
			<div class="buttons">
				<form action="${pageContext.request.contextPath }/user/findUser/${user.id}" method="post">
					<input type="hidden" name="_method" value="put">
					<input type="submit" id="update" value="修改" class="input-button">
				</form>				
				<form action="${pageContext.request.contextPath }/user/findUser/${user.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" id="del" value="删除" class="input-button">
				</form> 
				<input type="button" id="repassword" value="重置密码" class="input-button"> 
				<input type="button" id="backButton" onclick="history.back(-1)" value="返回" class="input-button">
			</div>
	</div>
	<!-- <script type="text/javascript" src="js/user/view.js"></script> -->


</body></html>