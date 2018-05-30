<%@ page import="java.util.*,  java.io.FileInputStream" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
	<%@ page import="com.people.utils.Utils" %>
	<%@ page import="com.people.registration.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to People Managment System - Register</title>

<link rel="stylesheet" type="text/css" href="css/peopelmanagment.css">

<script src="../jquery/jquery-1.8.2.js"></script>
<script src="js/peoplemanagment.js"></script>
</head>
<body>
<div id="divBody" align="center">
	<%@ include file="people_section_header.jsp" %>
	<%-- <table align="center">
		<tr>
		<td> <img src="../img/user.png"></td>
		<td> : <%
				out.println(session.getAttribute("User_id"));
				%>
			</td>
		</tr>
	</table> --%>
	<% UserRegistrationDbObj dbObj = (UserRegistrationDbObj) request.getAttribute("UserDetail"); %>
	<table class="registerForm">
			<tr>
				<td height="50">User Id	</td>
				<td height="50"><%= dbObj.getUserId() %></td>
				<td height="50" width="110">User Name </td>
				<td height="50"><%= dbObj.getUserName() %></td>
			</tr>

			<tr>
				<td height="50">Address line1 </td>
				<td height="50"><%= dbObj.getAddress1() %></td>
				<td height="50" width="110">Address line2 </td>
				<td height="50"><%= dbObj.getAddress2() %></td>
			</tr>

			<tr>
				<td height="50">e-mail </td>
				<td height="50"><%= dbObj.getEmail() %></td>
				<td height="50" width="110">Phone</td>
				<td height="50"><%= dbObj.getPhone() %></td>
			</tr>

			<tr>
				<td height="50">Mobile </td>
				<td height="50"><%= dbObj.getMobile() %></td>
				<td height="50" width="110">Date of birth </td>
				<td height="50"><%= dbObj.getDob() %></td>
			</tr>

			<tr>
				<td height="50">Gender </td>
				<td height="50">
				<%
				String sGender = "";
				if("M".equals(dbObj.getGender()))
					sGender = "Male";
				else
					sGender = "Female";
				%>				
				<%=sGender  %> </td>
				<td height="50" width="110">Nationality </td>
				<td height="50"><%= dbObj.getNationality() %> </td> 
			</tr>
		</table>
</div><div align="center">
	<%@ include file="people_footer.jsp"%>
	</div>
</body>
</html>