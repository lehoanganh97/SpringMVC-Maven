<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee || List Question</title>
</head>
<body>
<div align="center">
		<h1>List Question</h1>
		
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Email Customer</th>
				<th>Content</th>
				<th>Date</th>
				<th></th>
			</tr>
			<c:forEach var="QnA" items="${listQnA}">
				<tr>
					<td>${QnA.qnAID}</td>
					<td>${QnA.qnACusEmail}</td>
					<td>${QnA.qnAContent}</td>
					<td>${QnA.createDate}</td>
					<td>
						<a href="${pageContext.request.contextPath}/employee/question/+${QnA.qnAID}">Chọn</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>