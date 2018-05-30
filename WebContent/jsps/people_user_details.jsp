<%@ page import="java.util.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.people.registration.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>People Managment System</title>

<link rel="stylesheet" type="text/css" href="css/peoplemanagment.css">
<script src="../jquery/jquery-1.8.2.js"></script>
<script src="js/peoplemanagment.js"></script>
</head>
<body>
<div id="divBody" align="center">
	<%@ include file="people_section_header.jsp"%>

	<%-- <table align="center">
		<tr>
			<td><img src="../img/user.png"></td>
			<td>: <%
				out.println(session.getAttribute("User_id"));
			%>
			</td>
		</tr>
	</table> --%>

	<form id="SearchForm" name="SearchForm" method="Post" action="Search">
		<%
			ArrayList<UserRegistrationDbObj> al = (ArrayList<UserRegistrationDbObj>) request
					.getAttribute("UserDetail");
			for (UserRegistrationDbObj objUserRegistrationDbObj : al) {
		%>
		<table  bgcolor="#f1f1f1" align="center" width="760">
			<tr>
				<td height="50">User Id</td>
				<td height="50"><%=objUserRegistrationDbObj.getUserId()%></td>
				<td height="50" width="110">User Name</td>
				<td height="50"><%=objUserRegistrationDbObj.getUserName()%></td>
			</tr>

			<tr>
				<td height="50">e-mail</td>
				<td height="50"><%=objUserRegistrationDbObj.getEmail()%></td>
				<td height="50" width="110">Phone</td>
				<td height="50"><%=objUserRegistrationDbObj.getPhone()%></td>
			</tr>

			<tr>
				<td height="50">Mobile</td>
				<td height="50"><%=objUserRegistrationDbObj.getMobile()%></td>
				<td height="50" width="110">Date of birth</td>
				<td height="50"><%=objUserRegistrationDbObj.getUserName()%></td>
			</tr>
		
		</table>
		<%
			}
		%>
	</form>
	<br></br>
</div>
<div align="center">
	<%@ include file="people_footer.jsp"%>
	</div>
</body>
</html>