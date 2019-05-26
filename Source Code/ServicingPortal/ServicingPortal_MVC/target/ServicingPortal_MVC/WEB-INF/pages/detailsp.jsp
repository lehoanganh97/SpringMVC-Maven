<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${servicepostselected.servicePostTitle}</title>
</head>
<body>
	<h2>View detail servicepost</h2>
	<table>
		<tr>
			<th>Detail Service</th>
			<th>ServicePost Detail Rate</th>
			<th>ServicePost Detail Price</th>
			<th>Book Service</th>
		</tr>
		
		<c:forEach var="dsp" items="${liservicepostdetail}">
		<tr>
			<td>${dsp.detailservice.detailServiceName}</td>
			<td>${dsp.servicepost.servicePostRate}</td>
			<td>${dsp.SPDPrice}</td>
			<td><input type="checkbox" name="detailservicepostselected" value="${dsp.spdID}"></td>
		</tr>
		</c:forEach>
		
		
	</table>
	<h3>Tổng tiền: </h3>
	<form action="/PortalServiceMVC/toLoginforBooking" method="post">
	<input type="hidden" name="idSP" value="${idsvp}">
	<input type="submit" value="Tiếp tục">
	</form>
</body>
</html>