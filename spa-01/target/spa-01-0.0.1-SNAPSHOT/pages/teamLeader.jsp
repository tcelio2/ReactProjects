<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="icon" type="image/png" href="img/suitcase.png">
	<title>SPA - Spreadsheet Process Automation</title>

	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/teamleader.css">

	<script type="text/javascript" src="js/lib/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/lib/jquery-ui.min.js"></script>	
		
</head>

<body>
	<div class="main">
		<div class="header">
			<%@ include file="includes/user.jsp"%>
		</div>
		
		<div class="menu">
			<h2>Team leader Overview</h2>
			<%@ include file="includes/menu.jsp"%>
		</div>
		
		
		<div class="content">
		
		

		
		
		


	<fieldset class="form">
			<legend>Status</legend>
			<p>
				<label>Page under construction!</label>
				
			</p>
			
		</fieldset>

	</div>
		
		<%-- <div class="content">
			<form action="" method="get">
				<fieldset class="form">
					<legend>Filter</legend>
					<p>
						<label>????</label> 
						
					</p>
				</fieldset>
			</form>			
			
	 		<fieldset class="scroll">
				<legend>Agile</legend>
							
				<div class="rTable">
					<div class="rTableRow">
						<div class="rTableHead"><span style="font-weight: bold;">Application</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Release</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Project ID</span></div>						
						<div class="rTableHead"><span style="font-weight: bold;">Project name</span></div>							 
						<div class="rTableHead"><span style="font-weight: bold;">Prism status</span></div>					
						<div class="rTableHead"><span style="font-weight: bold;">Owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Target IST</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Area</span></div>							 		 
						<div class="rTableHead"><span style="font-weight: bold;">Status</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Issue</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Comments</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Sprint</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Task</span></div>				
						<div class="rTableHead"><span style="font-weight: bold;">%</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Sprint schedule</span></div>							 
						<div class="rTableHead"><span style="font-weight: bold;">Peer review</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Docs in KMS</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">CR</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">IST schedule</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">HLD</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">HLD owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">AD</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">AD owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">UTC</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">UTC owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">CODE</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">CODE owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">UT</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">UT owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Methodology</span></div>
					</div>				

					<c:forEach items="${teamLeaderAgile}" var="agile">
					    <div class="rTableRow">
							 <div class="rTableCell">${agile.application}</div>
							 <div class="rTableCell">${agile.release}</div>
							 <div class="rTableCell">${agile.projectId}</div>							
							 <div class="rTableCell">${agile.projectName}</div>
							 <div class="rTableCell">${agile.prismStatus}</div>
							 <div class="rTableCell">${agile.owner}</div>
							 <div class="rTableCell">${agile.targetIst}</div>
							 <div class="rTableCell">${agile.area}</div>
							 <div class="rTableCell">${agile.status}</div>
							 <div class="rTableCell">${agile.issue}</div>
							 <div class="rTableCell">${agile.comments}</div>
							 <div class="rTableCell">${agile.sprint}</div>
							 <div class="rTableCell">${agile.task}</div>
							 <div class="rTableCell">${agile.percentage}</div>
							 <div class="rTableCell">${agile.sprintSchedule}</div>
							 <div class="rTableCell">${agile.peerReview}</div>								 
							 <div class="rTableCell">${agile.docsKms}</div>
							 <div class="rTableCell">${agile.cr}</div>
							 <div class="rTableCell">${agile.istSchedule}</div>
							 <div class="rTableCell">${agile.hld}</div>
							 <div class="rTableCell">${agile.hldOwner}</div>
							 <div class="rTableCell">${agile.ad}</div>
							 <div class="rTableCell">${agile.adOwner}</div>
							 <div class="rTableCell">${agile.utc}</div>
							 <div class="rTableCell">${agile.utcOwner}</div>
							 <div class="rTableCell">${agile.code}</div>
							 <div class="rTableCell">${agile.codeOwner}</div>
							 <div class="rTableCell">${agile.ut}</div>
							 <div class="rTableCell">${agile.utOwner}</div>
							 <div class="rTableCell">${agile.methodology}</div>								
						</div>								
					</c:forEach>			
				</div>						
 			</fieldset> 
 			
 			<fieldset class="scroll">
				<legend>Waterfall</legend>
							
				<div class="rTable">
					<div class="rTableRow">
						<div class="rTableHead"><span style="font-weight: bold;">Application</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Release</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Project ID</span></div>						
						<div class="rTableHead"><span style="font-weight: bold;">Project name</span></div>							 
						<div class="rTableHead"><span style="font-weight: bold;">Prism status</span></div>					
						<div class="rTableHead"><span style="font-weight: bold;">Owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Target IST</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Area</span></div>							 		 
						<div class="rTableHead"><span style="font-weight: bold;">Status</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Issue</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Comments</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Sprint</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Task</span></div>				
						<div class="rTableHead"><span style="font-weight: bold;">%</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Sprint schedule</span></div>							 
						<div class="rTableHead"><span style="font-weight: bold;">Peer review</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Docs in KMS</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">CR</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">IST schedule</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">HLD</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">HLD owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">AD</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">AD owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">UTC</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">UTC owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">CODE</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">CODE owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">UT</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">UT owner</span></div>
						<div class="rTableHead"><span style="font-weight: bold;">Methodology</span></div>
					</div>				

					<c:forEach items="${teamLeaderWaterfall}" var="waterfall">
					    <div class="rTableRow">
							 <div class="rTableCell">${waterfall.application}</div>
							 <div class="rTableCell">${waterfall.release}</div>
							 <div class="rTableCell">${waterfall.projectId}</div>							
							 <div class="rTableCell">${waterfall.projectName}</div>
							 <div class="rTableCell">${waterfall.prismStatus}</div>
							 <div class="rTableCell">${waterfall.owner}</div>
							 <div class="rTableCell">${waterfall.targetIst}</div>
							 <div class="rTableCell">${waterfall.area}</div>
							 <div class="rTableCell">${waterfall.status}</div>
							 <div class="rTableCell">${waterfall.issue}</div>
							 <div class="rTableCell">${waterfall.comments}</div>
							 <div class="rTableCell">${waterfall.sprint}</div>
							 <div class="rTableCell">${waterfall.task}</div>
							 <div class="rTableCell">${waterfall.percentage}</div>
							 <div class="rTableCell">${waterfall.sprintSchedule}</div>
							 <div class="rTableCell">${waterfall.peerReview}</div>								 
							 <div class="rTableCell">${waterfall.docsKms}</div>
							 <div class="rTableCell">${waterfall.cr}</div>
							 <div class="rTableCell">${waterfall.istSchedule}</div>
							 <div class="rTableCell">${waterfall.hld}</div>
							 <div class="rTableCell">${waterfall.hldOwner}</div>
							 <div class="rTableCell">${waterfall.ad}</div>
							 <div class="rTableCell">${waterfall.adOwner}</div>
							 <div class="rTableCell">${waterfall.utc}</div>
							 <div class="rTableCell">${waterfall.utcOwner}</div>
							 <div class="rTableCell">${waterfall.code}</div>
							 <div class="rTableCell">${waterfall.codeOwner}</div>
							 <div class="rTableCell">${waterfall.ut}</div>
							 <div class="rTableCell">${waterfall.utOwner}</div>
							 <div class="rTableCell">${waterfall.methodology}</div>								
						</div>						
					</c:forEach>			
				</div>						
 			</fieldset>			
		</div> --%>
		
		<div class="footer">
			<p>&copy; Copyright IBM Coporation 2016</p>
		</div>
		
	</div>	
</body>
</html>