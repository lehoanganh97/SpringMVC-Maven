<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Fill Infomation for Booking Service</h2>
	<form action="/PortalServiceMVC/fillInfo">
	Điền thời gian thực hiện:<input type="date" name="dateUsing"></br>
	<input type="hidden" name="idSP" value="${idsvp}">
	<input type="text" name="note"></br>
	<input type="submit" value="Đặt dịch vụ">
	</form>
</body>
</html>