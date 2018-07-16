<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png" href="img/suitcase.png">
<title>SPA - Spreadsheet Process Automation</title>

<link rel="stylesheet" href="css/login.css" type="text/css" media="all">
<script type="text/javascript" src="js/lib/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/index/index.js"></script>
</head>
<body>

<div class="main">

	<div class="header">
		<img alt="" src="img/logo_att.png">
		<h1>SPA - Spreadsheet Process Automation</h1>
	</div>
	
	<div class="content">
	
		<div class="form">
			<span></span>
				<form action="login" method="POST">
						<p>
						<label>Username:</label>
						<input class="val_name" name="login" type="text" value="">
					</p>
					<p>
						<label>Password:</label>
						<input class="val_password" name="password" type="password" >
					</p>
					<p>
						<button type="button" class="i_forget" value="">Forgot My Password</button>
						<!-- <button type="button" class="i_login" value="">Log in</button> -->
						<input type="submit" class="i_login" value="Submit">
					</p>
				
				</form>
			
			${msg}
		</div>
	
	</div>
	
		<div class="footer">
			<p>&copy; Copyright IBM Corporation 2016</p>
		</div>
	
</div>

</body>
</html>