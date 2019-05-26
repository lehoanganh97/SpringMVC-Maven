<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="com.servicingportal.entity.OrderService"%>
<%
	Random rn = new Random();
	String merRef = "TEST_" + System.currentTimeMillis() + rn.nextInt();
	String ipClient = request.getRemoteAddr();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Virtual Payment Client Example</title>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
<style type="text/css">
<!--
h1 {
	font-family: Arial, sans-serif;
	font-size: 24pt;
	color: #08185A;
	font-weight: 100
}

h2.co {
	font-family: Arial, sans-serif;
	font-size: 24pt;
	color: #08185A;
	margin-top: 0.1em;
	margin-bottom: 0.1em;
	font-weight: 100
}

h3.co {
	font-family: Arial, sans-serif;
	font-size: 16pt;
	color: #000000;
	margin-top: 0.1em;
	margin-bottom: 0.1em;
	font-weight: 100
}

body {
	font-family: Verdana, Arial, sans-serif;
	font-size: 10pt;
	color: #08185A background-color: #FFFFFF
}

a:link {
	font-family: Verdana, Arial, sans-serif;
	font-size: 8pt;
	color: #08185A
}

a:visited {
	font-family: Verdana, Arial, sans-serif;
	font-size: 8pt;
	color: #08185A
}

a:hover {
	font-family: Verdana, Arial, sans-serif;
	font-size: 8pt;
	color: #FF0000
}

a:active {
	font-family: Verdana, Arial, sans-serif;
	font-size: 8pt;
	color: #FF0000
}

.shade {
	height: 25px;
	background-color: #CED7EF
}

tr.title {
	height: 25px;
	background-color: #0074C4
}

td {
	font-family: Verdana, Arial, sans-serif;
	font-size: 8pt;
	color: #08185A
}

th {
	font-family: Verdana, Arial, sans-serif;
	font-size: 10pt;
	color: #08185A;
	font-weight: bold;
	background-color: #CED7EF;
	padding-top: 0.5em;
	padding-bottom: 0.5em
}

.background-image {
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	width: 80%;
	text-align: left;
	border-collapse: collapse;
	background: url("...") 330px 59px no-repeat;
	margin: 0px;
}

.background-image th {
	font-weight: normal;
	font-size: 14px;
	color: #339;
	padding: 12px;
}

.background-image td {
	color: #669;
	border-top: 1px solid #fff;
	padding: 9px 12px;
}

.background-image tfoot td {
	font-size: 11px;
}

.background-image tbody td {
	background: url("./back.png");
}

* html
.background-image tbody td {
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src= 'table-images/back.png',
		sizingMethod= 'crop');
	background: none;
}

.background-image tbody tr:hover td {
	color: #339;
	background: none;
}

.background-image .tb_title {
	font-family: Verdana, Arial, sans-serif;
	color: #08185A;
	background-color: #CED7EF;
	font-size: 14px;
	color: #339;
	padding: 12px;
}
-->
</style>

</head>
<body>

	<!-- Start Branding Table -->
	<table width='100%' border='0' cellpadding='0' bgcolor='#0074C4'>
		<tr>
			<td bgcolor='#CED7EF' width='90%'>
				<h2 class='co'>&nbsp;Cổng nội địa - JSP</h2>
			</td>
			<td bgcolor='#0074C4' align='center'>
				<h3 class='co'>OnePAY</h3>
			</td>
		</tr>
	</table>
	<!-- End Branding Table -->

	<!-- The "Pay Now!" button submits the form, transferring control -->
	<form action="do" method="post">
		<input type="hidden" name="Title" value="JSP VPC 3-Party" />
		<!-- get user input -->
		<table width="80%" align="center" border="0" cellpadding='0'
			style="padding-top: 10px;" cellspacing='0'>
			<tr class="shade">
				<td width="1%">&nbsp;</td>
				<td width="40%" align="right"><strong><em>Virtual
							Payment Client URL:&nbsp;</em></strong></td>
				<td width="59%"><input type="text"
					name="virtualPaymentClientURL" size="63"
					value="https://mtf.onepay.vn/onecomm-pay/vpc.op" maxlength="250" /></td>
			</tr>
		</table>


		<center>
			<table class="background-image" summary="Meeting Results">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Input</th>
						<th scope="col">Description</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><strong><em>Merchant ID</em></strong></td>
						<td><input type="text" name="vpc_Merchant" value="ONEPAY"
							size="30" maxlength="16" /></td>
						<td>Được cấp bởi OnePAY</td>
					</tr>
					<tr>
						<td><strong><em>Merchant AccessCode</em></strong></td>
						<td><input type="text" name="vpc_AccessCode" value="D67342C2"
							size="30" maxlength="8" /></td>
						<td>Được cấp bởi OnePAY</td>
					</tr>
					<tr>
						<td><strong><em>Merchant Transaction Reference</em></strong></td>
						<td><input type="text" name="vpc_MerchTxnRef"
							value="<%out.println(merRef);%>" size="30" maxlength="40" /></td>
						<td>ID của giao dịch, các giá trị phải khác nhau trong mỗi
							lần thanh toán</td>
					</tr>
					<tr>					
						<td><strong><em>Transaction OrderInfo</em></strong></td>
						<td><input type="text" name="vpc_OrderInfo" 
							value="${OrderID}" size="30" maxlength="34" /></td>
						<td>Mã hóa đơn</td>
					</tr>
					<tr>
						<td><strong><em>Purchase Amount</em></strong></td>
						<td><input type="text" name="vpc_Amount" value="${OrderTotalPrice}"
							size="30" maxlength="10" /></td>
						<td>Số tiền cần thanh toán (Đã được nhân với 100)</td>					
					</tr>
					<tr>
						<td><strong><em>Receipt ReturnURL</em></strong></td>
						<td><input type="text" name="vpc_ReturnURL" size="50"
							value="http://localhost:8080/PortalServiceMVC/customer/dr" maxlength="250" /></td>
						<td>Url nhận kết quả trả về sau khi giao dịch hoàn thành.</td>
					</tr>
					<tr>
						<td><strong><em> VPC Version</em></strong></td>
						<td><input type="text" name="vpc_Version" value="2" size="30"
							maxlength="8" /></td>
						<td>Phiên bản modul (cố định)</td>
					</tr>
					<tr>
						<td><strong><em>Command Type</em></strong></td>
						<td><input type="text" name="vpc_Command" value="pay"
							size="30" maxlength="16" /></td>
						<td>Loại request (cố định)</td>
					</tr>
					<tr>
						<td><strong><em>Payment Server Display Language
									Locale</em></strong></td>
						<td><input type="text" name="vpc_Locale" value="vn" size="30"
							maxlength="5" /></td>
						<td>Ngôn ngữ hiện thị trên cổng (vn/en)</td>
					</tr>
					<tr>
						<td><strong><em>Currency code</em></strong></td>
						<td><input type="text" name="vpc_Currency" value="VND"
							size="30" maxlength="5" /></td>
						<td>Loại tiền tệ (VND)</td>
					</tr>
				</tbody>
			</table>
			<table class="background-image" summary="Meeting Results">
				<thead>
					<tr>
						<th scope="col" colspan="3">Addition Infomation</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<td align="center" colspan="4"><input type="submit"
							value="Pay Now!" /></td>
					</tr>
				</tfoot>
				<tbody>
					<tr>
						<td><strong><em>IP address</em></strong></td>
						<td><input type="text" name="vpc_TicketNo" maxlength="15"
							value="<%out.println(ipClient);%>" /></td>
						<td>IP khách hàng</td>
					</tr>
					<tr>
						<td width="270"><strong><em>Shipping Address</em></strong></td>
						<td width="330"><input type="text" name="vpc_SHIP_Street01"
							value="39A Ngo Quyen" size="30" maxlength="500" /></td>
						<td>Địa chỉ gửi hàng</td>
					</tr>
					<tr>
						<td><strong><em>Shipping Province</em></strong></td>
						<td><input type="text" name="vpc_SHIP_Provice"
							value="Hoan Kiem" size="30" maxlength="50" /></td>
						<td>Quận Huyện(địa chỉ gửi hàng)</td>
					</tr>
					<tr>
						<td><strong><em>Shipping City</em></strong></td>
						<td><input type="text" name="vpc_SHIP_City" value="Ha Noi"
							size="30" maxlength="50" /></td>
						<td>Tỉnh/thành phố (địa chỉ khách hàng)</td>
					</tr>
					<tr>
						<td><strong><em>Shipping Country</em></strong></td>
						<td><input type="text" name="vpc_SHIP_Country"
							value="Viet Nam" size="30" maxlength="50" /></td>
						<td>Quốc gia(địa chỉ khách hàng)</td>
					</tr>
					<tr>
						<td><strong><em>Customer Phone</em></strong></td>
						<td><input type="text" name="vpc_Customer_Phone"
							value="840904280949" size="30" maxlength="50" /></td>
						<td>Số điện thoại khách hàng</td>
					</tr>
					<tr>
						<td><strong><em>Customer email</em></strong></td>
						<td><input type="text" name="vpc_Customer_Email" size="30"
							value="thanhvt@onepay.vn" maxlength="50" /></td>
						<td>Địa chỉ hòm thư của khách hàng</td>
					</tr>
					<tr>
						<td><strong><em>Customer User Id</em></strong></td>
						<td><input type="text" name="vpc_Customer_Id" value="thanhvt"
							size="30" maxlength="50" /></td>
						<td>Tên tài khoản khách hàng trên hệ thống</td>
					</tr>
					<tr>
						<td><strong><em>Note</em></strong></td>
						<td colspan="2">Không sử dụng tiếng việt có dấu trong các
							tham số gửi sang cổng thanh toán</td>
					</tr>
				</tbody>
			</table>
		</center>
	</form>
</body>
</html>
