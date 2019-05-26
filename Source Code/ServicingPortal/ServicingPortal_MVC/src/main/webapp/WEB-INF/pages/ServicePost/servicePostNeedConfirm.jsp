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
<tr>
	<td>Service Post ID
	<td>Create Date
	<td>Is Accept
	<td>Is Modify
	<td>Is Modify Date
	<td>ServicePost Content
	<td>ServicePost Content Modify
	<td>ServicePost Content Old
	<td>ServicePost Description
	<td>ServicePost Rate
	<td>ServicePost Title
<c:forEach items="${sps}" var="sp">
<tr>
	<td>${sp.getServicePostID()}
	<td>${sp.getCreateDate()}
	<td>${sp.getIsAccept()}
	<td>${sp.getIsModify()}
	<td>${sp.getModifyDate()}
	<td>${sp.getServicePostContent()}
	<td>${sp.getServicePostContentModify()}
	<td>${sp.getServicePostContentOld()}
	<td>${sp.getServicePostDescription()}
	<td>${sp.getServicePostRate()}
	<td>${sp.getServicePostTitle()}
	<td>
	<form method="post" action="getSPDNeedConfirm">
	<input type="hidden" name="servicePostID" value="${sp.getServicePostID()}">
	<input type="submit" value="Xem chi tiết">
	</form>
	<form method="post" action="confirmSP">
	<input type="hidden" name="servicePostID" value="${sp.getServicePostID()}">
	<input type="submit" value="Xác nhận">
	</form>
	<form method="post" action="notConfirmSP">
	<input type="hidden" name="servicePostID" value="${sp.getServicePostID()}">
	<input type="submit" value="Không xác nhận">
	</form>
</tr>
</c:forEach>
</table>
</body>
</html>