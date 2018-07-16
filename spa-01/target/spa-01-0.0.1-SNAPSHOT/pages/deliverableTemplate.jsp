<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="icon" type="image/png" href="img/suitcase.png">
	<title>SPA - Spreadsheet Process Automation</title>

 	<link rel="stylesheet" href="css/style.css" type="text/css">
	<link rel="stylesheet" href="css/deliverable.css" type="text/css">

	<script type="text/javascript" src="js/lib/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/deliverableTemplate/index.js"></script>
<!-- 	<script src="js/lib/sorttable.js"></script> -->

</head>
<body>

	<div class="main">

		<div class="header">
			<%@ include file="includes/user.jsp"%>
		</div>

		<div class="menu">
			<h2>Deliverable Template</h2>
			<%@ include file="includes/menu.jsp"%>
		</div>

		<div class="content">

			<form action="" method="get">

				<fieldset class="form">
					<legend>New Deliverable Template</legend>
					<p>
						<label>Deliverable:</label> <input type="text" class="d_name" />
					</p>
					<p>
						<label>Description:</label> <input type="text"
							class="d_description" />
					</p>
					
					<p>
						<label>Type:</label>
						<input type="checkbox" name="" class="d_hld" value="HLD" /> HLD
						<input type="checkbox" name="" class="d_ia" value="IA" /> IA 
						<input type="checkbox" name="" class="d_ad" value="AD" /> AD 
						<input type="checkbox" name="" class="d_cw" value="CW" /> CW
					</p>

					<p>
						<button type="button" value="b_view" class="b_submit">Submit</button>
					</p>
				</fieldset>
			</form>

			<fieldset class="form">
				<legend>Current Deliverable Templates</legend>



				<div class="rTable">
						<div class="rTableRow">
							 <div class="rTableHead">ID</div>
							 <div class="rTableHead" style="text-align: left;">Deliverable</div>
							 <div class="rTableHead" style="text-align: left;">Description</div>					 
							 <div class="rTableHead">HLD</div>
							 <div class="rTableHead">IA</div>
							 <div class="rTableHead">AD</div>
							 <div class="rTableHead">CW</div>						 
							 <div class="rTableHead"></div>
						</div>
						
						<c:forEach items="${deliverables}" var="del">
						    <div class="rTableRow" id="${del.id}">
								 <div class="rTableCell d_id" id="id">${del.id}</div>
								 <div class="rTableCell Edit d_title" id="title" style="text-align: left;">${del.title}</div>
								 <div class="rTableCell Edit d_descriptione" id="description" style="text-align: left;">${del.description}</div>
								 <div class="rTableCell Edit d_hld" id="hld">${del.hld}</div>
								 <div class="rTableCell Edit d_ia" id="ia">${del.ia}</div>
								 <div class="rTableCell Edit d_ad" id="ad">${del.ad}</div>
								 <div class="rTableCell Edit d_cw" id="cw">${del.cw}</div>
	
								 <div class="rTableCell">
									 <a class="b_delete" id="${del.id}"><img alt="" src="img/paper-bin.png"></a>
								 </div>
							</div>
						</c:forEach>		 
				</div>

<%-- 

				<table id="deliverableTable" class="sortable">
					<thead>
						<tr>
							<th>ID</th>
							<th>Deliverable Template</th>
							<th>Description</th>
							<th>HLD</th>
							<th>IA</th>
							<th>AD</th>
							<th>CW</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${deliverables}" var="del">
							<tr>
								<td class="d_id">${del.id}</td>
								<td class="d_title">${del.title}</td>
								<td class="d_description">${del.description}</td>
								<td class="d_hld">${del.hld}</td>
								<td class="d_ia">${del.ia}</td>
								<td class="d_ad">${del.ad}</td>
								<td class="d_cw">${del.cw}</td>
								<td>
									<button type="button" class="b_delete" id="${del.id}">Delete</button>
									<button type="button" hld="${del.hld}" ia="${del.ia}" ad="${del.ad}" cw="${del.cw}" class="b_edit" value="b_edit" id="${del.id}">Edit</button>
									<button type="button" hld="${del.hld}" ia="${del.ia}" ad="${del.ad}" cw="${del.cw}" class="b_view" value="b_view" id="${del.id}">View</button>
								</td>		
							</tr>
						</c:forEach>
					</tbody>
				</table> --%>
			</fieldset>

			<div class="dinamic-ajax"></div>
 		
 			<div class="dashboard-box">
				<span class="x">X</span>
			</div>

			<!-- POPUP EDIT -->
			<div style="display: none;" class="pop-up-edit" id="" tab="" fieldset="" bgColor="">
				<span class="x">X</span>
				<input class="input_edit" value="" id="" type="text">
				<p><a href="#" style="color:white;float: right;margin-right: 56px;margin-top: -60px;" id="update_btn">Update</a></p>
			</div>

		</div>

		<div class="footer">
			<p>&copy; Copyright IBM Corporation 2016</p>
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