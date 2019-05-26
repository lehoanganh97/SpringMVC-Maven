<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>List Staffs</title>
<link href="<c:url value="../resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="../resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="../resources/js/bootstrap.min.js" />"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>CRM - staffs Relationship Manager</h2>
   <hr />

   <input type="button" value="Add staffs"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">List Staffs</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>Full Name</th>
       <th>PassWord</th>
       <th>Email</th>
       <!-- <th>Role</th> -->
       <!-- <th>Create By</th>
       <th>In Active By</th> -->
       <th>BirthDay</th>
       <th>Address</th>
       <th>Phone</th>
       <th>Identity Number</th>
       <th>Create Date</th>
       <th>Is Active</th>
       <th>Image</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our staffs -->
      <c:forEach var="tempstaffs" items="${staffs}">

       <!-- construct an "edit" link with staffs id -->
       <c:url var="editLink" value="/admin/updateForm">
        <c:param name="staffId" value="${tempstaffs.getEmpId()}" />
       </c:url>

       <!-- construct an "delete" link with staffs id -->
       <c:url var="deleteLink" value="/admin/delete">
        <c:param name="staffId" value="${tempstaffs.getEmpId()}" />
       </c:url>

       <tr>
        <td>${tempstaffs.getEmpFullName()}</td>
        <td>${tempstaffs.getEmpPassword()}</td>
        <td>${tempstaffs.getEmpEmail()}</td>
        <%-- <td>${tempstaffs.getRole().getRoleDescription()}</td> --%>
        <%-- <td>${tempstaffs.getEmployeemanagefservicesForCreateBy()}</td>
        <td>${tempstaffs.getWorkingareasForInActiveBy()}</td> --%>
        <td>${tempstaffs.getEmpDob()}</td>
        <td>${tempstaffs.getEmpAddress()}</td>
        <td>${tempstaffs.getEmpPhone()}</td>
        <td>${tempstaffs.getEmpIdentityNumber()}</td>
        <td>${tempstaffs.getCreateDate()}</td>
        <td>${tempstaffs.isIsActive()}</td>
        <td>${tempstaffs.getEmpImage()}</td>

        <td>
         <!-- display the edit link --> <a href="${editLink}">Edit</a>
         | <a href="${deleteLink}"
         onclick="if (!(confirm('Are you sure you want to delete this staffs?'))) return false">Delete</a>
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
</body>
</html>