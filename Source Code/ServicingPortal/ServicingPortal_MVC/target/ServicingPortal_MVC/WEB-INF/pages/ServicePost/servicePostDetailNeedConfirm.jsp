<%@page import="com.servicingportal.entity.ServicePostDetail"%>
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
<tr><td>SpdID
	<td>CreateDate
	<td>IsModify
	<td>ModifyDate
	<td>SPDPrice
	<td>SPDPriceNew
<c:forEach items = "${spds}" var ="spd">
<tr><td>${spd.getSpdID()}
	<td>${spd.getCreateDate()}
	<td>${spd.getIsModify()}
	<td>${spd.getModifyDate()}
	<td>${spd.getSPDPrice()}
	<td>${spd.getSPDPriceNew()}
	<td><form action ="confirmSPD">
		<input type = "hidden" name="servicePostDetailID" value = ${spd.getSpdID()}>
		<input type = "submit" value ="Xác nhận">
		</form>
</tr>
</c:forEach>
</table>
</body>
</html>