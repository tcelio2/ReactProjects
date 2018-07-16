<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png" href="img/suitcase.png">
<title>SPA - Spreadsheet Process Automation</title>

<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<link rel="stylesheet" href="css/manager.css" type="text/css" >

<script type="text/javascript" src="js/lib/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/manager/index.js"></script>

</head>
<body>



<div class="main">

	<div class="header">
		<a href="#"><img alt="" src="img/logo_att.png"></a>
		<h1>SPA - Spreadsheet Process Automation</h1>
		
		<ul>
			<li>Hello, user!</li>
			<li>|</li>
			<li><a href="#">Log out</a></li>
		</ul>
	</div>

	<div class="menu">
	<h2>Manager</h2>
		<ul>
			<li><a href="deliverable">Deliverable</a></li>
			<li><a id="schedule" href="schedule">Schedule</a></li>
			<li><a href="admin">Admin</a></li>
		</ul>
	</div>
	
	<div class="content">
	
		<fieldset>
			<legend>My projects (Waterfall)</legend>
			
			<p>
				<button type="button" onclick="" value="">Find Project</button>
			</p>	
			
			<table>
				<thead>
					<tr>
						<th>Release</th>
						<th>Project ID</th>
						<th>Prism Status</th>
						<th>CR</th>
						<th>Project Name</th>
						<th>Owner</th>
						<th>Target IST</th>
						<th>IST Schedule</th>
						<th>Area</th>
						<th>Status</th>
						<th>Details</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>2016/04</td>
						<td>213234</td>
						<td>IN PROGRESS</td>		
						<td>942244</td>
						<td>NFOD MoW Enablement Continuation</td>
						<td>Renan </td>
						<td>IST C2</td>
						<td>02/02/16 - 03/15/16</td>
						<td>BIR/801 MOW</td>
						<td>RED</td>
						<td><button type="button" class="view" value="">More details</button></td>
					</tr>
					<tr>
						<td>2016/04</td>
						<td>213234</td>
						<td>IN PROGRESS</td>		
						<td>942244</td>
						<td>UB2L</td>
						<td>Renan </td>
						<td>IST C2</td>
						<td>02/02/16 - 03/15/16</td>
						<td>BIR/801 MOW</td>
						<td>RED</td>
						<td><button type="button" class="view" value="">More details</button></td>
					</tr>
					<tr>
						<td>2016/04</td>
						<td>213234</td>
						<td>IN PROGRESS</td>		
						<td>942244</td>
						<td>Mainframe Modernization</td>
						<td>Renan </td>
						<td>IST C2</td>
						<td>02/02/16 - 03/15/16</td>
						<td>BIR/801 MOW</td>
						<td>RED</td>
						<td><button type="button" class="view" value="">More details</button></td>
					</tr>
					<tr>
						<td>2016/04</td>
						<td>213234</td>
						<td>IN PROGRESS</td>		
						<td>942244</td>
						<td>New Regression</td>
						<td>Renan </td>
						<td>IST C2</td>
						<td>02/02/16 - 03/15/16</td>
						<td>BIR/801 MOW</td>
						<td>RED</td>
						<td><button type="button" class="view" value="">More details</button></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
		
		<fieldset>
			<legend>New projects (Waterfall and Agile)</legend>
			
			<p>
				<button type="button" onclick="" value="">Find Project</button>
			</p>
			
			<table class="tb_manager">
				<thead>
					<tr>
						<th>Project Name</th>
						<th>Metodology</th>
						<th>Team Leader</th>		
						<th>Percent</th>
						<th>View</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>ABC</td>
						<td>AGIL</td>
						<td>Jackson</td>		
						<td>94</td>
						<td><button type="button" class="view" value="">More details</button></td>
						<td><button type="button" value="">Add</button></td>
					</tr>
					<tr>
						<td>UB2L</td>
						<td>AGIL</td>
						<td>Doe</td>		
						<td>80</td>
						<td><button type="button" class="view" value="">More details</button></td>
						<td><button type="button" value="">Add</button></td>
					</tr>
					<tr>
						<td>Mainframe Note</td>
						<td>WATERFALL</td>
						<td>Johnson</td>		
						<td>67</td>
						<td><button type="button" class="view" value="">More details</button></td>
						<td><button type="button" value="">Add</button></td>
					</tr>
					<tr>
						<td>BigData</td>
						<td>WATERFALL</td>
						<td>Smith</td>		
						<td>50</td>
						<td><button type="button" class="view" value="">More details</button></td>
						<td><button type="button" value="">Add</button></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</div>
	
	<div class="footer">
		<p>&copy; Copyright IBM Corporation 2016</p>
	</div>
</div>

	<!-- MODAL BOXES -->
	<div class="modal-box">
		<span class="x">X</span>
		<h2>Details about the project</h2>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eleifend eget leo ut scelerisque. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris sit amet massa sed augue egestas consequat. Vestibulum ultrices volutpat bibendum. Vestibulum molestie, felis vitae aliquam eleifend, dui ante vestibulum risus, eget convallis leo sapien eu nulla. Sed interdum nulla nisl, vel imperdiet nisl vehicula ullamcorper. Vivamus auctor metus sit amet mattis lacinia. Vivamus tempus euismod risus in tincidunt. Pellentesque dignissim urna ac ligula hendrerit, sed elementum tortor laoreet. Nam suscipit lorem in iaculis maximus. Aenean sagittis auctor risus, sed placerat dolor lobortis eget. Vivamus nisl nunc, tincidunt vel sapien at, ornare condimentum justo. Ut ultricies quis magna a porta. Curabitur lacinia, velit tincidunt vestibulum consectetur, augue ante efficitur ligula, eget interdum augue lacus non mi. Fusce finibus vulputate orci, vel accumsan arcu aliquam sit amet. Suspendisse congue, mi nec vulputate consequat, dolor tortor sagittis lorem, imperdiet tempus turpis purus quis libero.</p>
	</div>
	<div class="modal"></div>
</body>
</html>