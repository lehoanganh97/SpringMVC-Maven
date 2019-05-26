<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%--
/* -----------------------------------------------------------------------------
 Version 2.0
--------------------------------------------------------------------------------
 @author OnePAY JSC
------------------------------------------------------------------------------*/
--%>
<%@ page
	import="java.util.*,
                 java.util.ArrayList,
                 java.util.Collections,
                 java.util.Iterator,
                 java.util.Enumeration,
                 java.util.Map,
                 javax.crypto.*,
                 javax.crypto.spec.*,
                 java.util.HashMap,
                 java.io.ByteArrayOutputStream"%>

<%!// static final String SECURE_SECRET = "your-secure-hash-secret";
	static final String SECURE_SECRET = "A3EFDFABA8653DF2342E8DAC29B51AF0";
	static final char[] HEX_TABLE = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D',
			'E', 'F' };
	private static byte[] decodeHexArray = new byte[103];

	static {
		int i = 0;
		for (byte b : new byte[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' }) {
			decodeHexArray[b] = (byte) i++;
		}
		decodeHexArray['a'] = decodeHexArray['A'];
		decodeHexArray['b'] = decodeHexArray['B'];
		decodeHexArray['c'] = decodeHexArray['C'];
		decodeHexArray['d'] = decodeHexArray['D'];
		decodeHexArray['e'] = decodeHexArray['E'];
		decodeHexArray['f'] = decodeHexArray['F'];
	}

	String hashAllFields(Map fields) {
		List fieldNames = new ArrayList(fields.keySet());
		Collections.sort(fieldNames);
		StringBuffer buf = new StringBuffer();
		Iterator itr = fieldNames.iterator();
		while (itr.hasNext()) {
			String fieldName = (String) itr.next();
			String fieldValue = (String) fields.get(fieldName);
			if ((fieldValue != null) && (fieldValue.length() > 0) && fieldName.indexOf("vpc_") == 0) {
				buf.append(fieldName + "=" + fieldValue);
				if (itr.hasNext()) {
					buf.append('&');
				}
			}
		}
		byte[] mac = null;
		try {
			byte[] b = decodeHexa(SECURE_SECRET.getBytes());
			SecretKey key = new SecretKeySpec(b, "HMACSHA256");
			Mac m = Mac.getInstance("HMACSHA256");
			m.init(key);
			m.update(buf.toString().getBytes("UTF-8"));
			mac = m.doFinal();
		} catch (Exception e) {

		}
		String hashValue = hex(mac);
		return hashValue;

	}

	public static byte[] decodeHexa(byte[] data) throws Exception {
		if (data == null) {
			return null;
		}
		if (data.length % 2 != 0) {
			throw new Exception("Invalid data length:" + data.length);
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte b1, b2;
		int i = 0;
		while (i < data.length) {
			b1 = decodeHexArray[data[i++]];
			b2 = decodeHexArray[data[i++]];
			out.write((b1 << 4) | b2);
		}
		out.flush();
		out.close();
		return out.toByteArray();
	}

	static String hex(byte[] input) {
		StringBuffer sb = new StringBuffer(input.length * 2);
		for (int i = 0; i < input.length; i++) {
			sb.append(HEX_TABLE[(input[i] >> 4) & 0xf]);
			sb.append(HEX_TABLE[input[i] & 0xf]);
		}
		return sb.toString();
	}

	String getResponseDescription(String vResponseCode) {
		Map<String, String> map_result = new HashMap<String, String>() {
			{
				put("0", "Giao dịch thành công");
				put("1", "Ngân hàng từ chối giao dịch");
				put("3", "Mã đơn vị không tồn tại");
				put("4", "Không đúng access code");
				put("5", "Số tiền không hợp lệ");
				put("6", "Mã tiền tệ không tồn tại");
				put("7", "Lỗi không xác định");
				put("8", "Số thẻ không đúng");
				put("9", "Tên chủ thẻ không đúng");
				put("10", "Thẻ hết hạn/Thẻ bị khóa");
				put("11", "Thẻ chưa đăng ký sử dụng dịch vụ");
				put("12", "Ngày phát hành/Hết hạn không đúng");
				put("13", "Vượt quá hạn mức thanh toán");
				put("21", "Số tiền không đủ để thanh toán");
				put("99", "Người sủ dụng hủy giao dịch");
			}
		};
		String result = "";
		result = map_result.get(vResponseCode);
		if (result != null)
			return result;
		else
			return "No Value Returned";
	}

	private static String null2unknown(String in) {
		if (in == null || in.length() == 0) {
			return "No Value Returned";
		} else {
			return in;
		}
	}%>
<%
	Map fields = new HashMap();
	for (Enumeration enum1 = request.getParameterNames(); enum1.hasMoreElements();) {
		String fieldName = (String) enum1.nextElement();
		String fieldValue = request.getParameter(fieldName);
		if ((fieldValue != null) && (fieldValue.length() > 0)) {
			fields.put(fieldName, fieldValue);
		}
	}
	String vpc_Txn_Secure_Hash = null2unknown((String) fields.remove("vpc_SecureHash"));
	String hashValidated = null;
	if (fields.get("vpc_TxnResponseCode") != null || fields.get("vpc_TxnResponseCode") != "No Value Returned") {
		String secureHash = hashAllFields(fields);
		if (vpc_Txn_Secure_Hash.equalsIgnoreCase(secureHash)) {
			hashValidated = "CORRECT";
		} else {
			hashValidated = "INVALID HASH";
		}
	} else {
		hashValidated = "INVALID HASH";
	}
	String amount = null2unknown((String) fields.get("vpc_Amount"));
	String message = null2unknown((String) fields.get("vpc_Message"));
	String orderInfo = null2unknown((String) fields.get("vpc_OrderInfo"));
	String merchantID = null2unknown((String) fields.get("vpc_Merchant"));
	String merchTxnRef = null2unknown((String) fields.get("vpc_MerchTxnRef"));
	String transactionNo = null2unknown((String) fields.get("vpc_TransactionNo"));
	String txnResponseCode = null2unknown((String) fields.get("vpc_TxnResponseCode"));

	String transStatus = "";
	if (hashValidated.equals("CORRECT") && txnResponseCode.equals("0")) {
		transStatus = "Giao dịch thành công";
	} else if (hashValidated.equals("INVALID HASH") && txnResponseCode.equals("0")) {
		transStatus = "Giao dịch Pendding";
	} else {
		transStatus = "Giao dịch thất bại";
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Payment Result</title>
<meta http-equiv="Content-Type" content="text/html, charset=utf8">
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

input {
	font-family: Verdana, Arial, sans-serif;
	font-size: 8pt;
	color: #08185A;
	background-color: #CED7EF;
	font-weight: bold
}

#background-image {
	font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
	font-size: 12px;
	width: 80%;
	text-align: left;
	border-collapse: collapse;
	background: url("...") 330px 59px no-repeat;
	margin: 20px;
}

#background-image th {
	font-weight: normal;
	font-size: 14px;
	color: #339;
	padding: 12px;
}

#background-image td {
	color: #669;
	border-top: 1px solid #fff;
	padding: 9px 12px;
}

#background-image tfoot td {
	font-size: 11px;
}

#background-image tbody td {
	background: url("./back.png");
}

* html
#background-image tbody td {
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src= 'table-images/back.png',
		sizingMethod= 'crop');
	background: none;
}

#background-image tbody tr:hover td {
	color: #339;
	background: none;
}
-->
</style>

</head>
<body>
	<table width='100%' border='2' cellpadding='2' bgcolor='#0074C4'>
		<tr>
			<td bgcolor='#CED7EF' width='90%'>
				<h2 class='co'>&nbsp;Payment Client Example</h2>
			</td>
			<td bgcolor='#0074C4' align='center'>
				<h3 class='co'>OnePAY</h3>
			</td>
		</tr>
	</table>
	<center>
		<h1>
			<%
				out.println(transStatus);
			%>
		</h1>
	</center>


	<center>
		<table id="background-image" summary="Meeting Results">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Value</th>
					<th scope="col">Description</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td align="center" colspan="4"></td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td><strong><i>Merchant ID </i></strong></td>
					<td>
						<%
							out.println(merchantID);
						%>
					</td>
					<td>Được cấp bởi OnePAY</td>
				</tr>
				<tr>
					<td><strong><i>Merchant Transaction Reference</i></strong></td>
					<td>
						<%
							out.println(merchTxnRef);
						%>
					</td>
					<td>ID của giao dịch gửi từ website merchant</td>
				</tr>
				<tr>
					<td><strong><i>Transaction OrderInfo</i></strong></td>
					<td>
						<%
							out.println(orderInfo);
						%>
					</td>
					<td>Tên hóa đơn</td>
				</tr>
				<tr>
					<td><strong><i>Purchase Amount</i></strong></td>
					<td>
						<%
							out.println(amount);
						%>
					</td>
					<td>Số tiền được thanh toán</td>
				</tr>

				<tr>
					<td><strong><i>VPC Transaction Response Code </i></strong></td>
					<td>
						<%
							out.println(txnResponseCode);
						%>
					</td>
					<td>Mã trạng thái giao dịch trả về</td>
				</tr>
				<tr>
					<td><strong><i>Transaction Response Code
								Description </i></strong></td>
					<td>
						<%
							out.println(getResponseDescription(txnResponseCode));
						%>
					</td>
					<td>Trạng thái giao dịch</td>
				</tr>
				<tr>
					<td><strong><i>Message</i></strong></td>
					<td>
						<%
							out.println(message);
						%>
					</td>
					<td>Thông báo từ cổng thanh toán</td>
				</tr>
				<%
					// only display the following fields if not an error condition
					if (txnResponseCode != "7" && txnResponseCode != "No Value Returned") {
				%>
				<tr>
					<td><strong><i>Transaction Number</i></strong></td>
					<td>
						<%
							out.println(transactionNo);
						%>
					</td>
					<td>ID giao dịch trên cổng thanh toán</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</center>
</body>
</html>