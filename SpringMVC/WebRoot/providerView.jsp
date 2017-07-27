<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
			<div class="content">
				<table class="box"> 
					<tbody><tr>
						<td class="field">供应商编号：</td>
						<td>5<input type="hidden" id="proId" value="${provider.proCode}"></td>
						
					</tr>
					<tr>
						<td class="field">供应商名称：</td>
						<td>${provider.proName}</td>
					</tr>
					 <tr>
					<td class="field">联系人：</td>
					<td>${provider.proContact}</td>
				</tr>
				<tr>
					<td class="field">联系电话：</td>
					<td>${provider.proPhone}</td>

				</tr>
				<tr>
					<td class="field">联系地址：</td>
					<td>${provider.proAddress}</td>
				</tr>
			   <tr>
					<td class="field">传真：</td>
					<td>${provider.proFax}</td>

				</tr>
				 <tr>
					<td class="field">描述：</td>
					<td>${provider.proDesc}</td>

				</tr>
				</tbody></table>
			</div>
			<div class="buttons">
				<form action="${pageContext.request.contextPath}/provider/findProvider/${provider.id}" method="post">
					<input type="hidden" name="_method" value="put">
					<input type="submit" id="update" value="修改" class="input-button" >
				</form>
				<form action="${pageContext.request.contextPath}/provider/findProvider/${provider.id}" method="post">
					<input type="hidden" name="_method" value="delete">
					<input type="submit" id="del" value="删除" class="input-button">
				</form> 
				<input type="button" id="backButton" onclick="history.back(-1)" value="返回" class="input-button">
			</div>
	</div>
	<script type="text/javascript" src="js/provider/view.js"></script>


</body></html>