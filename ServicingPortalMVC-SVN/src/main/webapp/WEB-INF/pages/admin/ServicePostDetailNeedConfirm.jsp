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
	<div class="container-fluid">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ServicePostTitle</td>
					<th>Price</td>
					<th>PriceNew</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${spds}" var="spd" varStatus="memberStatus">
				  <tr>
				    <td>${spd.getServicepost().getServicePostTitle()}</td>
				    <td>${spd.getSpdprice()}</td>
				    <td>${spd.getSpdpriceNew()}</td>
				    <td>
				    	<form action="confirmSPD" method="post">
				    		<input type="hidden" name="servicePostDetailID" value="${spd.getSpdid()}">
				    		<button class="btn btn-primary" type="submit">Xác nhận</button>
				    	</form>
				    </td>
				  </tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>