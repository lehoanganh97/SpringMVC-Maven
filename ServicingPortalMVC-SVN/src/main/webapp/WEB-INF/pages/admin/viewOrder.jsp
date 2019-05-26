<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
</head>
<body>
<table class="table table-striped">
	<thead>
		<tr>
		<td>ID
		<td>IsAccept
		<td>Create Date
		<td>Accept Date
		<td>Total Price
		<td>Status
		<td>IsDelete
		<td>Delete Date
		<td>Delete Note
		<td>Delete
		</tr>
	</thead>
<c:forEach items = "${orders}" var="order">
<tr>
	<td>
		<form action="detailOrder">
		<input type="hidden" name = "orderServiceID" value=${order.getOrderId()}>
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
	<td><form action="deleteOrder">
		<input type="submit" value="Delete">
	</form>
</tr>
</c:forEach>
</table>
</body>
</html>