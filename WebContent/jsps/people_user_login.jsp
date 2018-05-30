<%@ page language="java" 
	contentType="text/html;  charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.people.utils.*"%>
<%@ page import="org.apache.log4j.Logger" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Welcome to People Managment System - Login</title>
<script src="../jquery/jquery-1.8.2.js"></script>
<script src="js/peoplemanagment.js"></script>
<script src="js/tooltipsy.min.js"></script>

<script type="text/javascript">
$('.hastip').tooltipsy();
</script>

<%
					Cookie[] cookies = (Cookie[]) request.getCookies();
					String sCookieUser = "";
					String sCookiePassword = "";
					String sCookieRememberMe = "";
					String sDecodedValue = null;
					if (cookies != null) {
						for (Cookie cookie : cookies) {
							sDecodedValue = cookie.getName();
							System.out.println(sDecodedValue);
							if (!"".equals(sDecodedValue) && sDecodedValue != null  && "username".equals(sDecodedValue)) {
								sCookieUser = cookie.getValue();
								System.out.println("sCookieUser : "+sCookieUser);
							}
							if (!"".equals(sDecodedValue) && sDecodedValue != null  && "password".equals(sDecodedValue)) {
								sCookiePassword = cookie.getValue();
								System.out.println("sCookiePassword : "+sCookiePassword);
							}
							if (!"".equals(sDecodedValue) && sDecodedValue != null  && "RememberMe".equals(sDecodedValue)) {
								sCookieRememberMe = cookie.getValue();
								System.out.println("sRememberMe : "+sCookieRememberMe);
							}
						}
					}
				%>

</head>
<body>
<%! static Logger logger = Logger.getLogger("people_user_login_jsp.class"); %>
<div id="divBody" align="center">
	<%@ include file="people_welcome_header.jsp"%>
	
	<form id="loginForm" name="loginForm" method="Post" action="login">
		<%
			ArrayList<String> al = (ArrayList<String>) request
					.getAttribute("error_message");
			ArrayList<String> alSuccessMsg = (ArrayList<String>) request
					.getAttribute("success_message");
			if (al != null && al.size() > 0) {
		%>
		<table class="errorFormTable">
			<tr>
				<td width="40"><img src="../img/error.png">
				</td>
				<td>
					<%
						for (int i = 0; i < al.size(); i++) {
					%> <font color="red"> <%
							logger.info(al.get(i));
 	out.println(al.get(i));
 %> </font> <br></br> <%
 	}
 %>
				</td>
			</tr>
		</table>
		<%
			} else if (alSuccessMsg != null && alSuccessMsg.size() > 0) {
		%>
		<table height="50" width="400" align="center">
			<tr>
				<td width="20"><img src="../img/confirmation.png">
				</td>
				<td>
					<%
						for (int i = 0; i < alSuccessMsg.size(); i++) {
					%> <font color="green"> <%
							logger.info(alSuccessMsg.get(i));
 	out.println(alSuccessMsg.get(i));
 %> </font></td>
			</tr>
		</table>
		<%
			}
			}
		%>
		<table class="loginForm">
			<tr>
				<td>User Id</td>
				
				<td><input type="text"  title="showtext" class="hastip" name="User_id" id="user_id"
					maxlength="10" value="<%=sCookieUser%>" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password"  class="inputtext" name="User_pswd" id="user_pswd"
					value="<%=sCookiePassword%>" />
				</td>
			</tr>
			<tr>
				<td><input type="hidden" value="" name="actionHidden"
					id="actionHidden" />
				<input type="hidden" value="" name="errorMsg"
					id="errorMsg" />
					<input type="checkbox" name="RememberMe" id="RememberMe"
					<% if(!"".equals(sCookieRememberMe)){
					%>
					checked= <%= "checked" %><% } %>					 
					value="RememberMe"> Remember me</td>
				<td colspan="2" align="left"><input type="button"
					name="login" value="login" id="login" onclick="validateLoginForm()">
					<a href="people_user_forget_password.jsp">Forget password</a></td>
			</tr>
		</table>
	</form>
	
	</div>
	<div align="center">
	<%@ include file="people_footer.jsp"%>
	</div>
</body>
</html>