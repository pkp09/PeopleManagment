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
			<td><img src="../img/user.png">
			</td>
			<td>: <%
				out.println(session.getAttribute("User_id"));
			%>
			</td>
		</tr>
	</table> --%>

	<form id="SearchForm" name="SearchForm" method="Post" action="Search">

		<table class="registerForm">
			<tr>
				<td height="50">User Id<font color="red"> *</font></td>
				<td height="50"><input type="text" class="inputtext"
					name="user_id" id="user_id" />
				<td height="50" width="110">User Name <font color="red">
						*</font></td>
				<td height="50"><input type="text" class="inputtext"
					name="user_name" id="user_name" />
			</tr>

			<tr>
				<td height="50">e-mail <font color="red"> *</font>
				</td>
				<td height="50"><input type="text" class="inputtext"
					name="email" id="email" />
				<td height="50" width="110">Phone</td>
				<td height="50"><input type="text" class="inputtext"
					name="phone" id="phone" />
			</tr>

			<tr>
				<td height="50">Mobile <font color="red"> *</font>
				</td>
				<td height="50"><input type="text" class="inputtext"
					name="mobile" id="mobile" />
				<td height="50" width="110">Date of birth <font color="red">
						*</font>
				</td>
				<td height="50"><input type="text" class="inputtext" name="dob"
					id="dob" />
			</tr>

			<tr>
				<td colspan="4" align="center">
				<input type="hidden" value=""   name="actionHidden" id="actionHidden" />
				<input type="button"
					name="search" value="Search" id="search" onclick="setSearchHiddenData()">
				</td>
			</tr>
		</table>
	</form>
	<br></br>
	<table class="registerForm">
		<tr>
			<th bgcolor="#f1f1f1">User Id</th>
			<th bgcolor="#f1f1f1">User Name</th>
			<th bgcolor="#f1f1f1">Address1</th>
			<th bgcolor="#f1f1f1">Address2</th>
			<th bgcolor="#f1f1f1">Email</th>
			<th bgcolor="#f1f1f1">Date Of Birth</th>
			<th bgcolor="#f1f1f1">Mobile</th>
			<th bgcolor="#f1f1f1">Phone</th>
		</tr>

		<%
			ArrayList<UserRegistrationDbObj> al = (ArrayList<UserRegistrationDbObj>) request
					.getAttribute("ResultTable");
			int i = 0;
			for (UserRegistrationDbObj s : al) {
		%>
		<tr>
			<%
					if (i % 2 == 0) {
			%>
			<td bgcolor="<%="white"%>"><a href="<%=request.getContextPath()%>/jsps/Search?user_id=<%=s.getUserId() %>&actionHidden=searchView&view=true">
				<%
					} else {
				%>
			
			<td bgcolor="<%="#f1f1f1"%>"><a href="<%=request.getContextPath()%>/jsps/Search?user_id=<%=s.getUserId() %>&actionHidden=searchView&view=true">
				<%
					}
						out.println(s.getUserId());
				%>
			</a></td>
			
			
			<%
					if (i % 2 == 0) {
			%>
			<td bgcolor="<%="white"%>">
				<%
					} else {
				%>
			
			<td bgcolor="<%="#f1f1f1"%>">
				<%
					}
						out.println(s.getUserName());
				%>
			</td>
			
			
			<%
					if (i % 2 == 0) {
			%>
			<td bgcolor="<%="white"%>">
				<%
					} else {
				%>
			
			<td bgcolor="<%="#f1f1f1"%>">
				<%
					}
						out.println(s.getAddress1());
				%>
			</td>

			<%
					if (i % 2 == 0) {
			%>
			<td bgcolor="<%="white"%>">
				<%
					} else {
				%>
			
			<td bgcolor="<%="#f1f1f1"%>">
				<%
					}
						out.println(s.getAddress2());
				%>
			</td>
			<%
					if (i % 2 == 0) {
			%>
			<td bgcolor="<%="white"%>">
				<%
					} else {
				%>
			
			<td bgcolor="<%="#f1f1f1"%>">
				<%
					}
						out.println(s.getEmail());
				%>
			</td>
			<%
					if (i % 2 == 0) {
			%>
			<td bgcolor="<%="white"%>">
				<%
					} else {
				%>
			
			<td bgcolor="<%="#f1f1f1"%>">
				<%
					}
						out.println(s.getDob());
				%>
			</td>
			<%
					if (i % 2 == 0) {
			%>
			<td bgcolor="<%="white"%>">
				<%
					} else {
				%>
			
			<td bgcolor="<%="#f1f1f1"%>">
				<%
					}
						out.println(s.getMobile());
				%>
			</td>
			<%
					if (i % 2 == 0) {
			%>
			<td bgcolor="<%="white"%>">
				<%
					} else {
				%>
			
			<td bgcolor="<%="#f1f1f1"%>">
				<%
					}
						out.println(s.getPhone());
				%>
			</td>
		</tr>
		<%
			i++; }
		%>

	</table>
<br></br>
</div>
<div align="center">
	<%@ include file="people_footer.jsp"%>
	</div>
</body>
</html>