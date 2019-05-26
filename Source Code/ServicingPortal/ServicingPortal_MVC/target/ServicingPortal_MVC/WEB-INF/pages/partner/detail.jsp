<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Partner || Detail</title>
</head>
<body>
	<form align="center" method="post" action="${pageContext.request.contextPath}/partner/edit">
		<p>${partner.partnerID}</p>
		<p>Email: <input type="text" id="partnerEmail" name="partnerEmail" value="${partner.partnerEmail}"></p>
		<p>Full Name: <input type="text" id="partnerFullName" name="partnerFullName" value="${partner.partnerFullName}"></p>
		<p>Identity Number: <input type="text" id="partnerIdentityNumber" name="partnerIdentityNumber" value="${partner.partnerIdentityNumber}"></p>
		<p>Image: <input type="text" id="partnerImage" name="partnerImage" value="${partner.partnerImage}"></p>
		<p>Name: <input type="text" id="partnerName" name="partnerName" value="${partner.partnerName}"></p>
		<p>DOB: <input type="text" id="partnerDOB" name="partnerDOB" value="${partner.partnerDOB}"></p>
		<p>Address: <input type="text" id="partnerAddress" name="partnerAddress" value="${partner.partnerAddress}"></p>
	</form>
</body>
</html>