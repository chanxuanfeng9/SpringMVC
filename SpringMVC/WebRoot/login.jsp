<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录 - 超市账单管理系统</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
  function validate(){
 
  		var usercode=$(":text").val();
  		if(usercode==""){
  			usercode=null;
  		}
  		var password=$(":password").val();
  		if(password==""){
  			password=null;
  		} 		
  		$("#loginNameSpan").html("");
  		$("#passwordSpan").html("");  		
  		$.post("user/login/"+usercode+"/"+password,{},function(data){
  			if(data!=null){
  				if(data.flag==1){
  					$("#loginNameSpan").html(data.msg);
  				}else if(data.flag==2){
  					$("#passwordSpan").html(data.msg);
  				}else{
  					window.location.href="frame.html";
  				} 					
  			}
  		},"json")
	}
  </script>
</head>
<body class="blue-style">
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form  action="${pageContext.request.contextPath }/user/login"  name="actionForm" id="actionForm"  method="post" >
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" class="input-text" name="userCode"/> <span id="loginNameSpan">${rd.msg }</span></dd>
				<dt>密　码：</dt>
				<dd><input type="password"  class="input-text" name="password"/><span id="passwordSpan"></span></dd>
			</dl>
			<div class="buttons">
				<input type="submit"   value="登录系统" class="input-button" onclick="validate();" />
				<input type="reset"  value="重　　填" class="input-button" />
			</div>
		</form>
	</div>
</div>
</body>
</html>
