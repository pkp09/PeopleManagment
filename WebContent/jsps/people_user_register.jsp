<%@ page import="java.util.*,  java.io.FileInputStream" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
	<%@ page import="com.people.utils.Utils" %>
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
	<%@ include file="people_welcome_header.jsp" %>

	<form id="RegistrationForm" name="RegistrationForm" method="Post" action="Registration">
		<table class="registerForm"><!-- border="1" bgcolor="#f1f1f1" align="center" width="760" -->
			<tr>
				<td height="50">User Id<font color="red"> *</font>
				</td>
				<td height="50"><input type="text" class="inputtext"
					name="user_id" id="user_id" />
				<td height="50" width="110">User Name <font color="red">
						*</font>
				</td>
				<td height="50"><input type="text" class="inputtext"
					name="user_name" id="user_name" />
			</tr>

			<tr>
				<td height="50">Password <font color="red"> *</font>
				</td>
				<td height="50"><input type="password" class="inputtext"
					name="password" id="password" />
				<td height="50" width="110">Confirm password <font color="red">
						*</font>
				</td>
				<td height="50"><input type="password" class="inputtext"
					name="confirm_password" id="confirm_password" />
			</tr>

			<tr>
				<td height="50">Address line1 <font color="red"> *</font>
				</td>
				<td height="50"><input type="text" class="inputtext"
					name="address1" id="address1" />
				<td height="50" width="110">Address line2 <font color="red">
						*</font>
				</td>
				<td height="50"><input type="text" class="inputtext"
					name="address2" id="address2" />
			</tr>

			<tr>
				<td height="50">e-mail <font color="red"> *</font>
				</td>
				<td height="50"><input type="text" class="inputtext"
					name="email" id="email"/>
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
				<td height="50">Gender <font color="red"> *</font></td>
				<td height="50"><input type="radio" name="gender" id="genderM" value="M">Male 
								<input type="radio" name="gender" id="genderF" value="F">Female
				</td>
				

				<td height="50" width="110">Nationality <font color="red"> * </font></td>
				<td height="50">
					<Select id = "dropdowntext" name="nationality" class="nationality">
					<% String sXmlPath = application.getInitParameter("propertyFile");
					System.out.println("sXmlPath : "+sXmlPath);
					 Properties prop = new Properties();
					 prop.load(new FileInputStream(sXmlPath));
					 String sNationalityPath = prop.getProperty("xmlFile4Nationality");
					%>
						<%= com.people.utils.Utils.createDropDown(sNationalityPath) %>
					</Select>
				</td> 
			</tr>
			<tr>
				<td colspan="4" align="center">
				<input type="hidden" value=""   name="actionHidden" id="actionHidden" /><input type="button"
					name="Registration" value="Registration" id="Registration" onclick="validateRegistrationForm()">
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