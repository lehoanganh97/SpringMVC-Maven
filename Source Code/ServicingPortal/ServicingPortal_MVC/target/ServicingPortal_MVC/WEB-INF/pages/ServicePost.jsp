<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add ServicePost</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/4.11.1/standard/ckeditor.js"></script>
</head>
<body>
	<input type="hidden" id="services" value="${services}"> 

	<form action="/PortalServiceMVC/SPost/addSP" method="post">
		<label>Select Field:</label>
		<select id="comboboxField" name="cbField" onchange="comboboxField_SelectionChanged(this.value)">
			<c:forEach var="field" items="${fields}">
				<option value="${field.FServiceID }">${field.FServiceName}</option>
			</c:forEach>
		</select>
		<br/>
		
		<label>Select Service:</label>
		<select id="comboboxService" name="cbService" onchange="comboboxService_SelectionChanged(this.value)">
			<c:forEach var="ser" items="${services}">
				<option value="${ser.FServiceID }">${ser.FServiceName}</option>
			</c:forEach>
		</select>
		
		<br/>
		<label>Select detailservice and fill its price:</label>
		<div id="detailservice">
			<table>
				<tr>
					<th></th>
					<th>Tên dịch vụ chi tiết</th>
					<th>Giá cung cấp</th>
				</tr>
				<c:forEach var="dser" items="${dservices}">
					<tr>
						<td><input type='checkbox' name='ckb${dser.detailServiceID}' value='${dser.detailServiceID}' onclick='removeDisableTextbox(${dser.detailServiceID})'></td>
						<td>${dser.detailServiceName }</td>
						<td><input type='text' name='txtckb${dser.detailServiceID}' disabled='disabled'/></td>						
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<Label>Title:</Label>
		<input type="text" name="txtTitle"/>
		
		<textarea name="SPContent"></textarea>
		
		<input type='submit' value='Xác nhận' />
	</form>
	
	
	
	<script language="JavaScript">
		CKEDITOR.replace( 'SPContent' );

		function comboboxField_SelectionChanged(mid) {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getService?fieldID="+ mid,
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					var str = "";
					console.log("SUCCESS: ", data);
					for(i = 0; i<data.length; i++)
					{
						str += "<option value='"+data[i].fserviceID+"'>"+data[i].fserviceName+"</option>";
					}
					$("#comboboxService").html(str);
					comboboxService_SelectionChanged(data[0].fserviceID);
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		}
		
		function comboboxService_SelectionChanged(sid) {
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "getDetailService?serviceid="+ sid,
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					var str = "<table><tr><th></th><th>Tên dịch vụ chi tiết</th><th>Giá cung cấp</th></tr>";
					console.log("SUCCESS: ", data);
					for(i = 0; i<data.length; i++)
					{
						str += "<tr><td><input type='checkbox' name='ckb"+data[i].detailServiceID+"' value='"+data[i].detailServiceID+"' onclick=removeDisableTextbox('"+data[i].detailServiceID+"')></td><td>" + data[i].detailServiceName 
						+ "</td><td><input type='text' name='txtckb"+data[i].detailServiceID+"' disabled='disabled'/></td></tr>"
					}
					$("#detailservice").html(str+"</table>");
					
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		}
		
		function removeDisableTextbox(dsid)
		{
			var cb = ($("[name='ckb" + dsid + "']").get([0])).checked;
			var txtTB = $("[name='txtckb" + dsid + "']").get([0]);
			
			if(cb == true)
				txtTB.disabled = false;
			else
				txtTB.disabled = true;
		}
	</script>
</body>
</html>