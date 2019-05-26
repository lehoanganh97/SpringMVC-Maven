<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Service 1 Page</h1>
	<form action="Script URL" method="GET">
    	<input name="gioitinh" type="radio" value="electric"/>Sửa chữa điện
		<input name="gioitinh" type="radio" value="warter" />Sửa chữa nước
		</br>
		Họ và tên:<input name="name" type="text"/></br>
		Địa chỉ: <input name="adress" type="text"/></br>
		Số điện thoại:<input name="name" type="text"/></br>
		Ngày thực hiện: <input name="date" type="date"></br>
		Giờ thực hiện: <input name="hours" type="time"></br>
		
		<button type="submit">Submit</button>
	</body>
</html>