<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>超市账单管理系统-账单管理</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form method="post" action="${pageContext.request.contextPath}/bill/getBill">
							<input name="method" value="query" class="input-text" type="hidden">							
							商品名称：<input name="productName" class="input-text" type="text" value="">
							供应商名称：<input name="proName" class="input-text" type="text" value="">							
							是否付款：<input type="radio" name="payed" value="2">是<input type="radio" name="payed" value="1">否
							<input name="_method" value="get" type="hidden"> 
							<input value="查 询" type="submit">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">

		<div class="optitle clearfix">
			<form action="${pageContext.request.contextPath}/bill/addBillBy" method="post">
				<input type="hidden" name="_method" value="get">
				<em><input value="添加账单" class="input-button" onclick="window.location='billAdd.jsp'" type="submit"></em>
			</form>
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">商品名称</div>
						</td>
						<td width="80"><div class="STYLE1" align="center">供应商</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">账单金额</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">是否付款</div>
						</td>
						<td width="100"><div class="STYLE1" align="center">操作时间</div>
						</td>
					</tr>
					<c:forEach items="${bills}" var="bill">
						<tr>
							<td height="23"><span class="STYLE1">${bill.id}</span>
							</td>
							<td><span class="STYLE1"><a href="${pageContext.request.contextPath}/bill/findBill/${bill.id}" style="color:red" >${bill.productName}</a>
							</span>
							</td>
							<td><span class="STYLE1">${bill.providerId.proName}</span>
							</td>
							<td><span class="STYLE1">${bill.totalPrice}</span>
							</td>
							<td><span class="STYLE1">
								
								${bill.isPayment==1?"否":"是"}
							</span>
							</td>
							<td><span class="STYLE1">${bill.creationDate}</span>
							</td>
						</tr>
					</c:forEach>				
				</tbody>
			</table>
		</div>
	</div>
	<div>
	<input type="hidden" name="page" value="${page}">
		<A class=p_pre
			href="${pageContext.request.contextPath}/bill/billList/1">首页</A>
		<A class=cur
			href="${pageContext.request.contextPath}/bill/billList/1">1</A>
		<A
			href="${pageContext.request.contextPath}/bill/billList/2">2</A>	
		<A class=p_pre
			href="${pageContext.request.contextPath}/bill/billList/${page.n+1}">下一页</A>
		<A class=p_pre
			href="${pageContext.request.contextPath}/bill/billList/${page.totalPage}">尾页</A>
		</div>
</body></html>