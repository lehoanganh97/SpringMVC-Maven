<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee || Answer</title>
</head>
<body>
<div align="center">
<form method="get" action="${pageContext.request.contextPath}/employee/saveanswer/+${qna.qnAID}">
	<p>${qna.qnAID}</p>
	<p>Câu hỏi: ${qna.qnAContent}: <input type="text" id="strAnswer" name="strAnswer"></p>
	<input type="submit" name="btnSubmit" value="Gửi"> 
</form>
</div>
</body>
</html>