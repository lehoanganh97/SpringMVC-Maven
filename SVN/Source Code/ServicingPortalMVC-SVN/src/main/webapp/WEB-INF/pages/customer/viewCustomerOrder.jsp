<%@page import="com.servicingportal.entity.OrderService"%>
<%@page import="com.servicingportal.entity.CustomerAccount"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Order</title>
</head>
<body>
	<table border="1">
	<tr>
		<td>OrderID</td>
		<td>Ngày tạo</td>
		<td>Ngày xác nhận</td>
		<td>Tổng tiền</td>
		<td>Trạng thái</td>
		<td>Ghi chú</td>
		<td>Thao tác</td>
	</tr>
	<c:forEach items ="${lsOrderServices}" var="orderService">
	<tr>
		<td>${orderService.getOrderId()}</td>
		<td>${orderService.getCreateDate()}</td>
		<td>${orderService.getAcceptDate()}</td>
		<td>${orderService.getOrderTotalPrice()}</td>
		<td>${orderService.getOrderStatus()}</td>
		<td>${orderService.getDeleteNote()}</td>
		<td>
			<form action="payment">		
				<input type="hidden" name="OrderID" value="${orderService.getOrderId() }">
				<input type="hidden" name="OrderTotalPrice" value="${orderService.getOrderTotalPrice()*100}">
				<input type="submit" value="Pay">	
			</form>
		</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>