<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Schedule Templates</title>
		<link rel="icon" type="image/png" href="img/suitcase.png">
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<link rel="stylesheet" href="css/schedule.css" type="text/css">
	<link rel="stylesheet" href="css/lib/themes/smoothness/jquery-ui.css">

	<script type="text/javascript" src="js/lib/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/schedule/index.js"></script>
	<!-- <script src="js/lib/sorttable.js"></script> -->

</head>

<body>

	<div class="main">

		<div class="header">
			<%@ include file="includes/user.jsp"%>
		</div>

		<div class="menu">
			<h2>Schedule Templates</h2>
			<%@ include file="includes/menu.jsp"%>
		</div>

		<div class="content">

			<form action="" method="get">

				<fieldset class="form">
					<legend>New Schedule</legend>

					<p>
						<label>Project ID:</label> 
						<select id="project_id_schedule" name="ProjectID">
							<option></option>  <!-- add a empty line on the list -->
							<c:forEach items="${projects}" var="val">
								<option id="${val.dashboardId}" class="${val.projectId}" >${val.projectName} (${val.projectId})</option>
							</c:forEach>
						</select>
					<p>
						<label>Deliverable:</label> 
						<select class="deliverables" name="Methodoly">
							<option></option>	<!-- add a empty line on the list -->
							<c:forEach items="${deliverables}" var="del">
								<option id="${del.id}">${del.title}</option>
							</c:forEach>
						</select>
					</p>
					<br>

					<table class="table_deliverable">
						<thead>
							<tr>
								<th>Type</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Comments</th>
							</tr>
						</thead>
						<tbody></tbody> <!-- it's necessary only to show the deliverable list -->
					</table>
					<br>
					<button class="submit_schedule" type="button">Submit</button> 		
				</fieldset>
			</form>

			<fieldset class="form">
				<legend>Current Schedule Templates</legend>
				
				<div class="rTable">
					<div class="rTableRow">
						<div class="rTableHead" style="text-align: left;">Project ID</div>
						<div class="rTableHead" style="text-align: left;">Project Name</div>
						<div class="rTableHead" style="text-align: left;">Deliverable</div>
						<div class="rTableHead">Type</div>
						<div class="rTableHead">Start Date</div>
						<div class="rTableHead">End Date</div>
						<div class="rTableHead" style="text-align: left;">Comments</div>
						<div class="rTableHead"></div>																									
					</div>
					
					
					${schedules}
			
			</fieldset>
			
			<div class="dinamic-ajax"></div>
 		
 			<div class="dashboard-box">
				<span class="x">X</span>
			</div>

			<!-- POPUP EDIT -->
			<div style="display: none;" class="pop-up-edit" id="" deliverable="" typedel="" fieldset="" bgColor="">
				<span class="x">X</span>
				<input class="input_edit" value="" id="" deliverable="" typedel="" type="text">
				<p><a href="#" style="color:white;float: right;margin-right: 56px;margin-top: -60px;" id="update_btn">Update</a></p>
			</div>			
		</div>

		<%@ include file="includes/footer.jsp"%>

	</div><!-- end of main -->
	<!-- MODAL BOXES -->
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