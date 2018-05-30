<%@ page import="java.util.*" language="java"
	contentType="text/html;  charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Welcome to People Managment System - Login</title>
<script src="../jquery/jquery-1.8.2.js"></script>
<script src="js/peoplemanagment.js"></script>
</head>
<body>
<div id="divBody" align="center">
	<%@ include file="people_welcome_header.jsp"%>
	<form id="ForgetPasswordForm" name="ForgetPasswordForm" method="Post"
		action="UserForgetPasswordServlet">
		
		<%
		ArrayList<String> alErrMsg = (ArrayList<String>) request.getAttribute("error_message");
		
		
		if (alErrMsg != null && alErrMsg.size() > 0)
	       {
	       %>
	       <table class="errorFormTable" >
		       	<tr>
		       		<td width= "40"> <img src="../img/error.png"></td>
		       		<td>
		       		<%
		       		for (int i = 0; i < alErrMsg.size(); i++)
		           		{	       		
		        	%>
					<font color="red">
					<%
		        	out.println(alErrMsg.get(i));
		        	%>
		        	</font>
		        	<br></br>
		        	
		        	<%
		           		}
		        	%>
		        	
		       		</td>
		       	</tr>
	       </table><br>
	       	<%
	       	
	       }
	       %>
		
		
		<table class="loginForm" >
			<tr>
				<td height="50">User Id<font color="red"> *</font></td>
				<td height="50"><input type="text" class="inputtext"
					name="user_id" id="user_id" />
					</tr>
					<tr>
				<td height="50" width="110">User Name <font color="red">
						*</font></td>
				<td height="50"><input type="text" class="inputtext"
					name="user_name" id="user_name" />
			</tr>
			<%
				String sPassword = (String) request.getAttribute("Password");
				if (!"".equals(sPassword) && sPassword != null) {
			%>
			<tr>
				<td width="150" height="50" align="left"><font color="green">Your Password is</font>
				</td>
				<td align="left"><font color="green"><%=sPassword%> </font><%
 	}
 %>
			<tr>
				<td align="right"></td>
				<td>
					<input type="hidden" value="" name="actionHidden" id="actionHidden" />
					<input type="button" name="Confirm" value="Confirm" id="Confirm" onClick="validateForgetPasswordForm()">
			        <input type="reset"	name="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
	</div>
	<div align="center">
	<%@ include file="people_footer.jsp"%>
	</div>
</body>
</html>