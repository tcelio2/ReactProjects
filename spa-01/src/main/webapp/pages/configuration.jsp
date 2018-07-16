<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" type="image/png" href="img/suitcase.png">
	<title>SPA - Spreadsheet Process Automation</title>

	<link rel="stylesheet" href='css/admin.css' type='text/css'>


	<script type="text/javascript" src="js/lib/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery.ba-hashchange.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery.easytabs.min.js"></script>

	
	<script type="text/javascript" src="js/configuration/index.js"></script>
	<!-- <script type="text/javascript" src="js/dashboard/tabScripts.js"></script> -->
	
</head>

<body>

	<div class="main">

		<div class="header"><%@ include file="includes/user.jsp"%></div>
		<div class="menu"><h2>Configuration</h2><%@ include file="includes/menu.jsp"%></div>



		<div class="content">

					<fieldset class="form">
								<legend>Password</legend>
								<p>
									<label>Change password: </label>
								</p>
								<p>
									<button type="button" class="update_password" value="">Change</button>
								</p>
   					</fieldset>

    

 		
 		
 			
 		<div class="dinamic-ajax"></div>




		<!-- 	<div class="dashboard-box">
				<span class="x">X</span>
			</div> -->


		</div>


	


	<%@ include file="includes/footer.jsp"%>






</div><!-- end of main -->

	<!-- POPUP EDIT -->
<div style="display: none;" class="pop-up-edit-configuration" id="" tab="" fieldset="" bgColor="">
		<span class="x">X</span>
		<span><p>Change your password:</p></span>
		<div><p>New password:</p></div>
		<input class="input_edit" value="" id="first_value" type="password">
		<div><p>Retype new password:</p></div>
		<input class="input_edit" value="" id="second_value" type="password">
		<p><a href="#" style="color:white;float: right;margin-right: 56px;margin-top: -60px;" id="update_btn">Update</a></p>
		<p id="at"></p>
	</div>

		<!-- POPUP EDIT -->
<div style="display: none;" class="pop-up-edit-confirmation" id="" tab="" fieldset="" bgColor="">
		<span class="x">X</span>
		<span><p></p></span>
		<div class="msg_c">Your password has been changed successfully!</div>
	</div>


	<!-- MODAL LOADER -->
	<div class="modal-loader">
		<img src="img/loader.gif" />
	</div>


	

	<!-- MODAL BOXES -->
	<div class="modal-box">
		<span class="x">X</span>
		<h2>SPA Users</h2>

	</div>
	
	<div class="modal"></div>

</body>
</html>