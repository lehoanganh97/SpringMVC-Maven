<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sửa chữa thiết bị nước</title>
</head>
<body>
	 <h1>suachuadien.jsp</h1>
    <input type="text" name="test" >
    <form name="formdetailservice" onsubmit="checkBoxValidation()" action="sldetail" method="POST">
            <h3>Select your Service you want to 1 use</h3>
            <c:forEach var="detailservice" items="${listdetailservice}">
            <p><input type="checkbox" name="serviceselected" value="${detailservice.detailServiceID}"/>${detailservice.detailServiceName}</p>
            
            </c:forEach>
            
            <p><input type="submit" value="submit"/>
            </p>
      </form>
     <h3>${errorofnullservice}</h3>
      <table style="witdth:100%">
      	<tr>
      		<th>ServicePost Title</th>
      		<th>ServicePost Rate</th>
      		<th>ServicePost Content</th>
      		<th>ServicePost Detail</th>
      	</tr>
      	<c:forEach var="servicepost" items="${liHintServicePost}">
      	<tr>
      		<td>${servicepost.servicePostTitle}</td>
      		<td>${servicepost.servicePostRate}</td>
      		<td>${servicepost.servicePostContent }</td>
      		<td>
      			<form action="/PortalServiceMVC/detailsp"  target="_blank" method="GET">
    			<input type="hidden" name="spID" value="${servicepost.servicePostID}" />
    			<input id="button" type="submit" value="Xem chi tiết" >
				</form>
      		</td>
      		
      	</tr>	
      	</c:forEach>
      </table>
</body>
</html>