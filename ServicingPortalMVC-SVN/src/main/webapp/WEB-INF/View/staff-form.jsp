<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>Form</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body onload="getSelectValue()">
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">Form Staff</h2>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Add Staff</div>
    </div>
    <div class="panel-body">
	     <form:form action="saveStaff" cssClass="form-horizontal"  method="post" commandName="staff"> <%-- modelAttribute="staff"> --%>
<!--            define row 1 include 2 entity-->
            <div class="row justify-content-around">
            
<!--                entity-->
                <div class="col col-md-5">
                    <!-- need to associate this data with staff id -->
                    <form:hidden path="empId" />
                    
                    <!-- File browser -->
                    <!-- <div class="custom-file">
					  <input type="file" class="custom-file-input" id="customFile">
					  <label class="custom-file-label" for="customFile">Choose file</label>
					</div> -->
					
                    <div class="form-group form-row">
                        <label for="empImage" class="col-md-5 control-label">Image</label>                    
                         <form:input path="empImage" cssClass="form-control col-md-9" />
                    </div>
                    
                    <div class="form-group form-row">
                        <label for="empFullName" class="col-md-5 control-label">Full Name</label>                    
                         <form:input path="empFullName" cssClass="form-control col-md-9" />
                         
                    </div>
                    
                    <div class="form-group form-row">
                        <label for="empPassword" class="col-md-5 control-label">PassWord</label>
                            <form:input path="empPassword" cssClass="form-control col-md-9" />
                    </div>

                    <div class="form-group form-row">
                        <label for="empEmail" class="col-md-5 control-label">Email</label>
                            <form:input path="empEmail" cssClass="form-control col-md-9" />
                    </div>
                    
                    <div class="form-group form-row">
                        <label for="empAddress" class="col-md-5 control-label">Address</label>
                            <form:input path="empAddress" cssClass="form-control col-md-9" />
                    </div>
                    
                    <div class="form-group form-row">
                        <label for="empDob" class="col-md-5 control-label">BirthDay</label>
                            <form:input path="empDob" type="date" cssClass="form-control col-md-9" />
                    </div>
                    
                    <div class="form-group form-row">
                        <label for="empPhone" class="col-md-5 control-label">Phone</label>
                            <form:input path="empPhone" cssClass="form-control col-md-9" />
                    </div>
                    
                    <div class="form-group form-row">
                        <label for="empIdentityNumber" class="col-md-5 control-label">IdentityNumber</label>
                            <form:input path="empIdentityNumber"  cssClass="form-control col-md-9" />
                    </div>
                    
                    <div class="form-group form-row">
                        <label for="createDate" class="col-md-5 control-label">Create Date</label>
                            <input Class="form-control col-md-9" readonly placeholder="${staff.getCreateDate()}"/>
                            <form:hidden path="createDate" />
                            
                    </div>
                    
                    <div class="form-group form-row">
                        <label for="createDate" class="col-md-5 control-label">Is Active</label>
                            <input Class="form-control col-md-9" readonly placeholder="${staff.isIsActive()}"/>
                            <form:hidden path="isActive" />
                            
                    </div>
                </div>
               
               <!-- Co cach nao thuc hien nhanh hon -->
               <!-- <input type="hidden" name="createBy" value="1"> -->
               
               
<!--                entity-->
                <div class="col col-md-5">
                  <!-- VIEW ACCOUNT CREATED THIS ACCOUNT -->
                    <div class="card" style="width: 18rem;">
					  <div class="card-body">
					    <h5 class="card-title">Created by</h5>
					    <p class="card-text">
					    	<div>${staff.getEmployeeaccountByCreateBy().getEmpFullName()}</div>
					    	<div>${staff.getEmployeeaccountByCreateBy().getEmpEmail()}</div>
					    	<!-- 		CREATE BY -->
               				<form:hidden path="employeeaccountByCreateBy.empId"/>				    	
						</p>
						
					    <a href="#" class="btn btn-primary">Detail</a>
					  </div>
					</div>
					
				<!-- LOADING ALL ROLES TO SELECT -->
				
				<!-- Script to load form of service of fields -->
				<script type="text/javascript">
					function getSelectValue() {
						var form = "#fServiceManager";
				        var val = document.getElementById("listofrole").value;
					    /* number 2 -> id of role : Field Service Manager */
					    if (val == 2) {
					    	$(form).siblings(".hiddenForm").hide();
						    $(form).show();
					    } else{
					    	$(form).hide();
					    }
					    
					}

				</script>
				
				
				<!-- Roles to select -->
                    <div class="input-group mb-3">
			            <div class="input-group-prepend">
			                <label class="input-group-text" for="roleId">Role</label>
			            </div>
			            <form:hidden path="role.roleId"/>
			            
			            <%-- <form:select path="role.roleId" items="${roles}"/> --%>
			            
			            
			            <select class="custom-select" id="listofrole" onchange="getSelectValue();" >              
			                <c:forEach var="role" items="${roles}">
			                	<!-- loading role current -->
			                	<c:choose>
								    <c:when test="${role.getRoleId() == staff.getRole().getRoleId()}">
								        <option selected = "selected" value="${role.getRoleId()}" >${role.getRoleName()}</option>
								    </c:when>    
								    <c:otherwise>
								        <option value="${role.getRoleId()}" >${role.getRoleName()}</option>
								    </c:otherwise>
								</c:choose>			                	
			                </c:forEach>
			            </select>
			            
			            <!--HIDDEN CHOOSE FIELD SERVICE OF MANAGER -->
			            <div id="fServiceManager" class="hiddenForm form">
			            	<div class="text-primary">
				                Choose Field Service Manager : 
				            </div>
				            
					        <select class="custom-select" id="listoffields">
				                <option selected value="${s} }">${s}</option>
				                
				                <c:forEach var="field" items="${fields}">
				                	<option value="${field.getFserviceId()}">${field.getFserviceName()}</option>
				                </c:forEach>
				            </select>
			            
						</div>
						
						<div id="hhh">
						</div>
						
						
						
			        </div>
                    
                </div>
                
                
                
            </div>


            
            <div class="form-group">
                <!-- Button -->
                <div class="col-md-offset-3 col-md-9">
                    <form:button cssClass="btn btn-primary">Submit</form:button>
                </div>
            </div>
        </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>