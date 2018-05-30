<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/peopelmanagment.css">
<script src="../jquery/jquery-1.8.2.js"></script>
<script src="../js/Test.js">
	
</script>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

</head>
<body>
	<p id="p1">If you click on me, I will disappear.</p>
	<p>Click me away!</p>
	<p>Click me too!</p>
	<input type="button" id="submit1" value="Submit1" />


	<h3>Island Trading</h3>
	<div class="ex">
		<button class="hide">Hide me</button>
		<p>
			Contact: Helen Bennett<br> Garden House Crowther Way<br>
			London
		</p>
	</div>

	<h3>Paris spécialités</h3>
	<div class="ex">
		<button class="hide">Hide me</button>
		<p>
			Contact: Marie Bertrand<br> 265, Boulevard Charonne<br>
			Paris
		</p>
	</div>

	<p id="hideshow">If you click on the "Hide" button, I will
		disappear.</p>
	<button id="hide">Hide</button>
	<button id="show">Show</button>


	<form name="loginForm" method="Post" action="login">
		User Id <input type="text" name="User_id" id="user_id" title="Enter Username" /> <Br>
		Password <input type="text" name="User_pswd" id="user_pswd" /><Br>
		<input type="submit" name="login" value="login" id="login">
	</form>


	<p id="togg1">This is a paragraph with little content.</p>
	<p id="togg2">This is another small paragraph.</p>
	<button>Toggle</button>




	<table id="menu" class ="selectable">
		<tr>
			<td class="ui-widget-content"><a href="#">Aberdeen</a></td>
			<td class="ui-widget-content"><a href="#">Ada</a></td>
			<td class="ui-widget-content"><a href="#">Adamsville</a></td>
			<td class="ui-widget-content"><a href="#">Delphi</a> </td>
	</table>

	<ul id="menu">
		<li class="ui-state-disabled"><a href="#">Aberdeen</a></li>
		<li><a href="#">Ada</a></li>
		<li><a href="#">Adamsville</a></li>
		<li><a href="#">Addyston</a></li>
		<li><a href="#">Delphi</a>
			<ul>
				<li class="ui-state-disabled"><a href="#">Ada</a></li>
				<li><a href="#">Saarland</a></li>
				<li><a href="#">Salzburg</a></li>
			</ul></li>
		<li><a href="#">Saarland</a></li>
		<li><a href="#">Salzburg</a>
			<ul>
				<li><a href="#">Delphi</a>
					<ul>
						<li><a href="#">Ada</a></li>
						<li><a href="#">Saarland</a></li>
						<li><a href="#">Salzburg</a></li>
					</ul></li>
				<li><a href="#">Delphi</a>
					<ul>
						<li><a href="#">Ada</a></li>
						<li><a href="#">Saarland</a></li>
						<li><a href="#">Salzburg</a></li>
					</ul></li>
				<li><a href="#">Perch</a></li>
			</ul></li>
		<li class="ui-state-disabled"><a href="#">Amesville</a></li>
	</ul>
</body>
</html>