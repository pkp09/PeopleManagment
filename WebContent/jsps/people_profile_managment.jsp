<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>People Managment System</title>
</head>
<body>
<div id="divBody" align="center">
<%@ include file="people_section_header.jsp"%>
<%-- <table align="center">
		<tr>
		<td> <img src="../img/user.png"></td>
		<td>Hello : <%
				out.println(session.getAttribute("User_id"));
			%>
			
		</tr>
	</table> --%>
</div>
<div align="center">
	<%@ include file="people_footer.jsp"%>
	</div>
</body>
</html>