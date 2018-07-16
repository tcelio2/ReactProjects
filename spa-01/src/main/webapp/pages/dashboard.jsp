<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" type="image/png" href="img/suitcase.png">
	<title>SPA - Spreadsheet Process Automation</title>

	<link rel="stylesheet" href='css/dashboard.css' type='text/css'>
	<link rel="stylesheet" href='css/lib/bootstrap.css' type="text/css">

	<script type="text/javascript" src="js/lib/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery.ba-hashchange.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery.easytabs.min.js"></script>

	
	<script type="text/javascript" src="js/dashboard/index.js"></script>
	<script type="text/javascript" src="js/dashboard/tabScripts.js"></script>
	
</head>

<body>

	<div class="main">

		<div class="header">
			<%@ include file="includes/user.jsp"%>
		</div>

		<div class="menu">
			<h2>Dashboard Overview</h2>
			<%@ include file="includes/menu.jsp"%>
		</div>


<a href="#" style="color:white" class="filter_btn">Filter</a>

		<div class="content">



${dashboardByManager}



${dashboardByMethodology}








 		
 		
 		
 		
 		
 		
 			
 		<div class="dinamic-ajax"></div>
 		
 		
 		
 			
<div class="dashboard-box">
<span class="x">X</span>
</div>
</div>


	


		<%@ include file="includes/footer.jsp"%>






</div><!-- end of main -->

	<!-- POPUP EDIT -->
<div style="display: none;" class="pop-up-edit" id="" tab="" fieldset="" bgColor="" tab_especial="">
		<span class="x">X</span>
		<input class="input_edit" value="" id="" type="text">
		<p><a href="#" style="color:white;float: right;margin-right: 56px;margin-top: -60px;" id="update_btn">Update</a></p>
	</div>

		<!-- POPUP EDIT ESPECIAL-->
    <div style="display: none;" class="pop-up-edit-especial" id="" tab="" fieldset="" bgColor="" tab_especial="">
		<span class="x">X</span>
					<select id="" class="status_led">
							<option id=""></option>
							<option id="Green">GREEN</option>
							<option id="Yellow">YELLOW</option>
							<option id="Red">RED</option>
					</select>
		<p><a href="#" style="color:white;float: right;margin-right: 56px;margin-top: -60px;" id="update_btn_especial">Update</a></p>
	</div>

	<!-- MODAL LOADER -->
	<div class="modal-loader">
		<img src="img/loader.gif" />
	</div>

	
	<!-- MODAL BOXE FILTER -->
	<div class="modal-box-filter">
		<span class="x">X</span>
		
		<span><p>Filter by:</p></span>
		

						
						<select class="dropdown_filter_manager">
							<option id="0">All Projects</option>
							<c:forEach items="${manager}" var="user">
								<option id="${user.managerId}">${user.managerName} ${user.managerLastName}</option>
							
							</c:forEach>
								
						</select>
				
		
		

		<span><p>Group by:</p></span>
		<select class="dropdown_filter_group">
			<option id="0">Methodology</option>
			<option id="1" value="">PM</option>
				
		</select>
		
		<p><a href="#" style="color:white;float: right;margin-right: 56px;margin-top: 40px;" class="filter_btn" id="go_btn">GO</a></p>
		
		
	</div>

	<!-- MODAL BOXES -->
	<div class="modal-box">
		<span class="x">X</span>
		<h2>SPA Users</h2>

	</div>
	
	<div class="modal"></div>

</body>
</html>