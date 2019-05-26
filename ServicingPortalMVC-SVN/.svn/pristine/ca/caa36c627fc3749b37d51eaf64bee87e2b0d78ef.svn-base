<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ServicePostTitle</th>
					<th>ServicePostContent</th>
					<th>ServicePostContentOld</th>
					<th>ServicePostContentModify</th>
					<th>ServicePostDescription</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sps}" var="sp" varStatus="memberStatus">
				  <tr>
				    <td>${sp.getServicePostTitle()}</td>
				    <td>${sp.getServicePostContent()}</td>
				    <td>${sp.getServicePostContentOld()}</td>
				    <td>${sp.getServicePostContentModify()}</td>
				    <td>${sp.getServicePostDescription()}</td>
				    <td>
				    	<form action="confirmSP" method="post">
				    		<input type="hidden" name="servicePostId" value="${sp.getServicePostId()}">
				    		<button class="btn btn-primary" type="submit">Chấp nhận</button>
				    	</form>
				    </td>
				    <td>
				    	<form action="getSPDNeedConfirm" method="post">
				    		<input type="hidden" name="servicePostId" value="${sp.getServicePostId()}">
				    		<button class="btn btn-primary" type="submit">Xem chi tiết</button>
				    	</form>
				    </td>
				  </tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>