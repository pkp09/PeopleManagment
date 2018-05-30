<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to People Managment System</title>


<link rel="stylesheet" type="text/css" href="../css/peoplemanagment.css">
<script src="../jquery/jquery-1.8.2.js"></script>
<script src="../js/peoplemanagment.js"></script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

</head>
<body>
	<table id="headerTable">
		<tr>
			<th><img src="../img/url.jpg" />
			</th>
		</tr>
	</table>

	<table id="menu" class="selectable" align="center">
		<tr>
			<td class="ui-widget-content"><a href="people_home.jsp">Home</a>
			</td>
			<td class="ui-widget-content"><a
				href="people_profile_managment.jsp">Profile Managment</a></td>
			<td class="ui-widget-content"><a
				href="<%=request.getContextPath()%>/jsps/Search?actionHidden=search">Search	User</a></td>			
			<td class="ui-widget-content"><a href="<%=request.getContextPath()%>/jsps/Modify?actionHidden=modifyView">Modify details</a> </td>	
			<!-- <td class="ui-widget-content"><a href="people_user_modify_details.jsp">Modify details</a> </td> -->
			<td class="ui-widget-content"><a href="/PeopleManagment/jsps/people_home.jsp"> Leave request </a> </td>
			<td class="ui-widget-content"><a href="/PeopleManagment/jsps/people_home.jsp"> Transport request</a> </td>
			<td class="ui-widget-content"><a href="/PeopleManagment/logout">Logout</a> </td>
	</table>
	<BR>
	<table align="center">
		<tr>
		<td> <img src="../img/user.png"></td>
		<td>Hello : <%
				out.println(session.getAttribute("User_id"));
				%>
			</td>
		</tr>
	</table>
</body>
</html>