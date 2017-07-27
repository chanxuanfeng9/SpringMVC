<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="main">
	<div class="optitle clearfix">
		<div class="title">账单管理&gt;&gt;</div>
	</div>
		<div class="content">
			<table class="box">
			  <tbody><tr>
					<td class="field">账单编号：</td>
					<td>${bill.id}<input type="hidden" id="billId" value="6"></td>
				</tr>
			   <tr>
					<td class="field">商品名称：</td>
					<td>${bill.productName }</td>
				</tr>
				 <tr>
					<td class="field">商品单位：</td>
					<td>${bill.productUnit }</td>
				</tr>
				<tr>
					<td class="field">商品数量：</td>
					<td>${bill.productCount }</td>
				</tr>
				<tr>
					<td class="field">总额：</td>
					<td>${bill.totalPrice }</td>
				</tr>
			   <tr>
					<td class="field">供应商：</td>
					<td>${bill.providerId.proName }</td>
				</tr>
				 <tr>
					<td class="field">是否付款：</td>
						<td>							
							 ${bill.isPayment==1?"否":"是"}
						</td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<form action="${pageContext.request.contextPath}/bill/findBill/${bill.id}" method="post">
				<input type="hidden" name="_method" value="put">
				<input type="submit" name="update" id="update" value="修改" class="input-button">
			</form>
			<form action="${pageContext.request.contextPath}/bill/findBill/${bill.id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" name="del" id="del" value="删除" class="input-button">
			</form>
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bill/view.js"></script>


</body></html>