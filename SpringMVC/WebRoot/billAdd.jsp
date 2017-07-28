<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
	<form id="form1" name="form1" method="post" action="${pageContext.request.contextPath}/bill/addBill">		
		<div class="content">
			<table class="box">
			   <tbody><tr>
					<td class="field">商品名称：</td>
					<td><input type="text" name="productName" class="text" id="productName" value="${bill.productName}"> <font color="red">*</font><font color="red" id="productName_span"></font></td>
				</tr>
				 <tr>
					<td class="field">商品单位：</td>
					<td><input type="text" name="productUnit" class="text" id="productUnit" value="${bill.productUnit}"> <font color="red">*</font><font color="red" id="productUnit_span"></font></td>
				</tr>
				<tr>
					<td class="field">商品数量：</td>
					<td><input type="text" name="productCount" class="text" id="productCount" value="${bill.productCount}"> <font color="red">*</font><font color="red" id="productCount_span"></font></td>
				</tr>
				<tr>
					<td class="field">总额：</td>
					<td><input name="totalPrice" id="totalPrice" class="text" value="${bill.totalPrice}"><font color="red">*</font><font color="red" id="billMoney_span"></font></td>
				</tr>
			   <tr>			   		
					<td class="field">供应商：</td>
					<td>
						<select name="providerId.id" id="proId">
							<c:forEach items="${providers}" var="p">								
								<option value="${p.id}">${p.proName}</option>													
							</c:forEach>
						</select>
						<font color="red">*</font><font color="red" id="proId_span"></font>
					</td>
				</tr>
				 <tr>
					<td class="field">是否付款：</td>
					<td><input type="radio" name="isPayment" value="2">是<input type="radio" name="isPayment" checked="" value="1">否</td>
				</tr>
			</tbody></table>
		</div>
		<div class="buttons">
			<input type="submit" name="add" id="add" value="保存" class="input-button">
			<input type="button" name="button" id="button" onclick="history.back(-1)" value="返回" class="input-button"> 
		</div>

	</form>
</div>
<!-- <script type="text/javascript" src="js/bill/add.js"></script> -->


</body></html>