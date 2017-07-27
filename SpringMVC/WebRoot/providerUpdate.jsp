<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">供应商管理&gt;&gt;</div>

	</div>
	<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/provider/updateProvider">
		<input type="hidden" name="_method" value="put">
		
		<input type="hidden" name="method" value="update">
		<input type="hidden" name="userId" value="-1">
		<div class="content">
			<font color="red"></font><table class="box">
			<tbody><tr>
					<td class="field">供应商编号：</td>
					<td><input type="hidden" name="id" value="${provider.id}">${provider.id}</td>

				</tr>
			 <tr>
					<td class="field">供应商名称：</td>
					<td><input type="hidden" name="proName" value="${provider.proName}">${provider.proName}</td>
				</tr>
				 <tr>
					<td class="field">联系人：</td>
					<td><input type="text" name="proContact" class="text" id="proContact" value="${provider.proContact}"> <font color="red">*</font><font color="red" id="proContact_span"></font></td>
				</tr>
				<tr>
					<td class="field">联系电话：</td>
					<td><input type="text" name="proPhone" class="text" id="proPhone" value="${provider.proPhone}"> <font color="red">*</font><font color="red" id="proPhone_span"></font></td>
				</tr>
				<tr>
					<td class="field">联系地址：</td>
					<td><input name="proAddress" id="proAddress" class="text" value="${provider.proAddress}"></td>
				</tr>
			   <tr>
					<td class="field">传真：</td>
					<td><input type="text" name="proFax" class="text" id="proFax" value="${provider.proFax}"> </td>

				</tr>
				 <tr>
					<td class="field">描述：</td>
					<td><input type="text" name="proDesc" class="text" id="proDesc" value="${provider.proDesc}"></td>

				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="submit" name="update" id="update" value="修改" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

	</form>
</div>
<!-- <script type="text/javascript" src="js/provider/update.js"></script> -->


</body></html>