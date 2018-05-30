<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to People Managment System</title>

<link rel="stylesheet" type="text/css" href="css/peoplemanagment.css">
<script src="../jquery/jquery-1.8.2.js"></script>
<script src="/js/peoplemanagment.js"></script>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
</head>
<body>
<%
					Cookie[] cookies = (Cookie[]) request.getCookies();
					String sCookieUser = "";
					String sCookiePassword = "";
					String sCookieRememberMe = "";
					String sDecodedValue = null;
					if (cookies != null) {
						 request.setAttribute("actionHidden", "login");
						for (Cookie cookie : cookies) {
							sDecodedValue = cookie.getName();
							System.out.println(sDecodedValue);
							if (!"".equals(sDecodedValue) && sDecodedValue != null  && "username".equals(sDecodedValue)) {
								sCookieUser = cookie.getValue();
								System.out.println("sCookieUser : "+sCookieUser);
								request.setAttribute("User_id", sCookieUser);
							}
							if (!"".equals(sDecodedValue) && sDecodedValue != null  && "password".equals(sDecodedValue)) {
								sCookiePassword = cookie.getValue();
								System.out.println("sCookiePassword : "+sCookiePassword);
								request.setAttribute("User_pswd", sCookiePassword);
							}
							if (!"".equals(sDecodedValue) && sDecodedValue != null  && "RememberMe".equals(sDecodedValue)) {
								sCookieRememberMe = cookie.getValue();
								System.out.println("sRememberMe : "+sCookieRememberMe);
								request.setAttribute("sRememberMe", sCookieRememberMe);
							}
						}
					}
				%>
<% if("".equals(sCookieRememberMe) || sCookieRememberMe == null ){ %>
	<table align="center" border="1">
		<tr>
			<th width="750"><img src="img/url.jpg" />
			</th>
		</tr>
	</table>

	<table id="menu" class="selectable" align="center">
		<tr>
			<td class="ui-widget-content"><a
				href="jsps/people_user_login.jsp">login</a></td>
			<td class="ui-widget-content"><a
				href="jsps/people_user_register.jsp">Register</a></td>
			<td class="ui-widget-content"><a href="jsps/people_user_reset_password.jsp">Reset password</a>
			</td>
			<td class="ui-widget-content"><a href="jsps/people_about_us.jsp">About us</a>
			</td>
			<td class="ui-widget-content"><a href="jsps/people_faq.jsp">FAQ</a>
			</td>
		</tr>
	</table>
	<%}else{
		session.setAttribute("User_id", sCookieUser);
		 RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/jsps/login");
   requestDispatcher.forward(request, response);
	} %>
</body>
</html>