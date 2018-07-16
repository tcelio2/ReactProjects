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
					
					<%-- <c:forEach items="${schedules}" var="del">
					 	<div class="rTableRow" id="${del.projectId}${del.deliverable}${del.type}">
						<div class="rTableRow" id="${del.projectId}">
							<div class="rTableCell d_project_id" id="projectid" style="text-align: left;">${del.projectId}</div>
							<div class="rTableCell d_project_name" id="projectname" style="text-align: left;">${del.projectName}</div>
							<div class="rTableCell d_methodology" id="deliverable" style="text-align: left;">${del.deliverable}</div>
							<div class="rTableCell d_deliverable" id="type">${del.type}</div>
							<div class="rTableCell Edit d_start_date" id="stardate">${del.startDate}</div>
							<div class="rTableCell Edit d_end_date" id="enddate">${del.endDate}</div>																												
							<div class="rTableCell Edit d_comments" id="comment" style="text-align: left;">${del.comment}</div>	
	
							<div class="rTableCell">
							 <a class="b_delete" id="${del.projectId}"><img alt="" src="img/paper-bin.png"></a>
							</div>
						</div>
					</c:forEach> --%>
				</div>
<%--  				
				<table class="schedule_submited">
					<thead>
						<tr>
							<th>Project ID</th>
							<th>Deliverable</th>
							<th>Type</th>
							<th>Start Date</th>
							<th>End Date</th>
							<th>Comments</th>
							<th></th>
						</tr>
					</thead>

					<tbody>


						<c:forEach items="${schedules}" var="del">
							<tr>
								<td class="d_project_id">${del.projectId}</td>
								<td class="d_methodology">${del.deliverable}</td>
								<td class="d_deliverable">${del.type}</td>
								<td class="d_start_date">${del.startDate}</td>
								<td class="d_end_date">${del.endDate}</td>
								<td class="d_comments">${del.comment}</td>
								<td>
									<a class="b_delete" id="${del.id}"><img alt="" src="img/paper-bin.png"></a>
								 	<button type="button" class="b_delete" id="${del.id}">Delete</button>
									<button type="button" class="b_edit" id="${del.id}">Edit</button>
									<button type="button" class="b_view" id="${del.id}">View</button>
								</td>

							</tr>
						</c:forEach>


					</tbody>
				</table>
			 --%>
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

		<div class="footer">
			<p>&copy; Copyright IBM Coporation 2016</p>
		</div>

	</div>
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