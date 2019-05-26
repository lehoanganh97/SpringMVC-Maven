<%@page import="com.servicingportal.entity.OrderService"%>
<%@page import="com.servicingportal.entity.CustomerAccount"%>
<%@page import="com.servicingportal.entity.ServicePost"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%> 
<!-- Khai báo sử dụng JSTL Core Tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><td>ID
	<td>IsAccept
	<td>Create Date
	<td>Accept Date
	<td>Total Price
	<td>Status
	<td>IsDelete
	<td>Delete Date
	<td>Delete Note
<c:forEach items = "${orders}" var="order">
<tr><td>${order.getOrderID()}
		<form action="detailOrder">
		<input type="hidden" name = "orderServiceID" value=${order.getOrderID()}>
		<input type="submit" value="Xem chi tiết">
		</form>
	<td>${order.getIsAccept()}
	<td>${order.getCreateDate()}
	<td>${order.getAcceptDate()}
	<td>${order.getOrderTotalPrice()}
	<td>${order.getOrderStatus()}
	<td>${order.getIsDelete()}
	<td>${order.getDeleteDate()}
	<td>${order.getDeleteNote()}
</tr>
</c:forEach>
</table>
</body>
</html>