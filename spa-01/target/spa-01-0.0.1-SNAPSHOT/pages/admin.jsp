<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" type="image/png" href="img/suitcase.png">
<title>SPA - Spreadsheet Process Automation</title>


<link rel="stylesheet" type="text/css" href="css/lib/jquery.dataTables.min.css" >
<link rel="stylesheet" type="text/css" href="css/admin.css" >

<!-- <link rel="stylesheet" type="text/css" href="css/style.css" > -->
<script type="text/javascript" src="js/lib/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/admin/index.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

</head>
<body>

<div class="main">

	<div class="header">
		<%@ include file="includes/user.jsp" %>
	</div>

	<div class="menu">
		<h2>Admin</h2>
		<%@ include file="includes/menu.jsp" %>
	</div>

	<div class="content">
		
		

		<form action="">
			<fieldset class="form">
				<legend>Register a New User</legend>
				<p>
					<label>Name:</label>
					<input class="a_name" type="text">
				</p>
				<p>
					<label>Last Name:</label>
					<input class="a_last_name" type="text">
				</p>
				<p>
					<label>User Name:</label>
					<input class="a_user_name" type="text">
				</p>
				<p>
					<label>Email:</label>
					<input class="a_email" type="text">
				</p>
				
				<p>
					<label>Role:</label>
					<select class="a_role">
						
						<option value="2">MANAGER</option>
						<option value="3">TEAM LEADER</option>
						<option value="4">DEVELOPER</option>
						<option value="1">ADMIN</option>
					</select>
				</p>
				<p>
					
					<button type="button" class="a_insert" value="">Submit</button>
				</p>
			</fieldset>
		</form>
		
		<fieldset class="form">
			<legend>Create Project</legend>
			
			
			
			<p>
					<label>project Name:</label>
					<input class="a_project_name" type="text">
				</p>
				<p>
					<label>Project ID:</label>
					<input class="a_project_id" type="text">
				</p>
				
				
			<p>
					<label>Methodology:</label>
					<select class="a_methodology">
						<option value="1">AGIL</option>
						<option value="2">WATERFALL</option>
					</select>
				</p>
			
			
			
			<p>
				<button type="button"  class="a_create_project"  value="">Create</button>
			</p>
		</fieldset>
		<fieldset class="form">
			<legend>Delete Project</legend>
			
			
				<button type="button" class="a_delete_project" value="">Display Projects</button>
			</p>
		</fieldset>


		<fieldset class="form">
			<legend>Bind Project x User</legend>
			
			
				<button type="button" class="display_projects_managers" value="">Display Projects / Users</button>
			</p>
		</fieldset>


	<fieldset class="form">
			<legend>List all users</legend>
			<p>
				<label>View / Edit / Delete users: </label>
				
			</p>
			<p>
				<button type="button" class="list" value="">List all users</button>
			</p>
		</fieldset>

	</div>
	
	
	<div class="footer">
			<p>&copy; Copyright IBM Coporation 2016</p>
		</div>

</div><!-- main -->
	
	
	
	
		<!-- POPUP EDIT -->
<div style="display: none;" class="pop-up-edit" id="" table="">
		<span class="x3">X</span>
		<input class="input_edit" value="" id="" type="text">
		<p><a href="#" style="color:white;float: right;margin-right: 56px;margin-top: -60px;" id="update_btn">Update</a></p>
	</div>
	
	
	<!-- MODAL BOXES -->
	<div class="modal-box">
		<span class="x">X</span>
		<h2>SPA Users</h2>
		${userTable}
	</div>
	
	
	<!-- MODAL BOXES -->
	<div class="modal-box2">
		<span class="x">X</span>
		<h2>SPA Projects</h2>
		${projectsTable}
	</div>

	<!-- MODAL BOXES -->
	<div class="modal-box3">
		<span class="x">X</span>
		<h2>SPA Projects</h2>
		${projectsAndManagersTable}
	</div>
	
	
		<!-- MODAL BOXES -->
	<div class="modal-box4" dashboard_id="" project_name="" project_id="">
		<span class="x4">X</span>
		<h2>SPA Managers</h2>
		 <select class="manager_select">
			  ${managers}
		</select> 
	</div>
	
			<!-- POPUP EDIT -->
	<div style="display: none;" class="pop-up-edit-confirmation" id="" tab="" fieldset="" bgColor="">
		<span class="x">X</span>
		<span><p></p></span>
		<div class="msg_c">User inserted successfully!</div>
			
	</div>
				<!-- POPUP EDIT -->
	<div style="display: none;" class="pop-up-edit-confirmation2" id="" tab="" fieldset="" bgColor="">
		<span class="x">X</span>
		<span><p></p></span>
		<div class="msg_c">User updated successfully!</div>
			
	</div>
				<!-- POPUP EDIT -->
	<div style="display: none;" class="pop-up-edit-confirmation3" id="" tab="" fieldset="" bgColor="">
		<span class="x">X</span>
		<span><p></p></span>
		<div class="msg_c">Project created successfully!</div>
			
	</div>



	<!-- BOX LOADER -->
	<div class="modal-loader">
		<img src="img/loader.gif" />
	</div>
	
	<!-- MODAL -->
	<div class="modal"></div>

</body>
</html>