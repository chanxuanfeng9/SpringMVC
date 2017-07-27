<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/calendar/WdatePicker.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<script type="text/javascript">
		$(function(){			
			$("#add").click(function(){
			var password1=$("#password1").val();
			var password2=$("#password2").val();
				if(password1!=password2){
					alert("两次输入的密码不一致！");
				}else{
					$("#fform").submit();
				}
			});
		})
	</script>
		
	<form id="fform" action="${pageContext.request.contextPath}/user/addUserSave" method="post" enctype="multipart/form-data">	
		<!-- <input type="hidden" name="_method" value="get"> -->
		<!-- 设置隐藏于，和session中获取id(前提是设置了session) -->
		<input type="hidden" name="createdBy" value="${suser.id }">
		<div class="content">
			<table class="box">
			   <tbody><tr>
					<td class="field">用户名：</td>
					<td><input type="text" name="userName" class="text" id="name" value=""><font color="red">*</font><font color="red" id="name_span"></font>
					<f:form modelAttribute="smbmsUser">
						<f:errors path="userName" cssStyle="color:red"></f:errors>
					</f:form>
					</td>
				</tr>
				 <tr>
					<td class="field">用户账号：</td>
					<td><input type="text" name="userCode" class="text" id="loginName" value=""><font color="red">*</font><font color="red" id="loginName_span"></font>
					
					</td>
				</tr>
				 <tr>
					<td class="field">用户密码：</td>
					<td><input type="password" name="userPassword" class="text" id="password1" value=""> <font color="red">*</font><font color="red" id="password_span"></font>
					<f:form modelAttribute="smbmsUser">
						<f:errors path="userPassword" cssStyle="color:red"></f:errors>
					</f:form></td>
				</tr>
				 <tr>
					<td class="field">确认密码：</td>
					<td><input type="password" name="repassword" class="text" id="password2" value=""><font color="red">*</font></td>
				</tr>
				<tr>
					<td class="field">用户性别：</td>
					<td><select name="gender" id="gender">
						    <option value="1" checked="">男</option>
						    <option value="2">女</option>
						 </select></td>
				</tr>
				<tr>
					<td class="field">出生日期：</td>
					<td><input type="text" name="birthday" onfocus="WdatePicker()" value="<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/>"> <font color="red">*</font><font color="red" id="birthDate_span"></font>
					<f:form modelAttribute="smbmsUser">
						<f:errors path="birthday" cssStyle="color:red"></f:errors>
					</f:form>
					</td>
				</tr>
				<tr>
					<td class="field">用户电话：</td>
					<td><input type="text" name="phone" class="text" id="phone" value=""><font color="red">*</font><font color="red" id="phone_span"></font></td>

				</tr>
				<tr>
					<td class="field">用户地址：</td>
					<td><input name="address" id="address" class="text" value=""></td>
				</tr>
				<tr>
					<td class="field">用户权限：</td>

					<td><input type="radio" name="userRole.id" value="1">系统管理员<input type="radio" name="userRole.id" value="2" checked="true">经理
					<input type="radio" name="userRole.id" value="3" checked="checked">普通用户</td>
				</tr>
				<tr>
					<td class="field">证件照：</td>
					<td><input type="file" name="multipartFile"/></td>
				</tr>
				<tr>
					<td class="field">工作照：</td>
					<td><input type="file" name="multipartFile"/></td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="button" name="add" id="add" value="保存" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

	</form>
</div>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/user/add.js"></script> --%>


</body></html>