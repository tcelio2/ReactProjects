<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png" href="img/suitcase.png">
<title>SPA - Spreadsheet Process Automation</title>

<link rel="stylesheet" href="css/style.css" type="text/css" media="all">

<script type="text/javascript" src="js/lib/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="js/admin/index.js"></script>
</head>
<body>

	<div class="main">

		<div class="header">
			<%@ include file="includes/user.jsp"%>
		</div>

		<div class="menu">
			<h2>Page Title</h2>
			<%@ include file="includes/menu.jsp"%>
		</div>

		<div class="content">
			<h3>Content Title 1</h3>

			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
				eleifend eget leo ut scelerisque. Vestibulum ante ipsum primis in
				faucibus orci luctus et ultrices posuere cubilia Curae; Mauris sit
				amet massa sed augue egestas consequat. Vestibulum ultrices volutpat
				bibendum. Vestibulum molestie, felis vitae aliquam eleifend, dui
				ante vestibulum risus, eget convallis leo sapien eu nulla. Sed
				interdum nulla nisl, vel imperdiet nisl vehicula ullamcorper.
				Vivamus auctor metus sit amet mattis lacinia. Vivamus tempus euismod
				risus in tincidunt. Pellentesque dignissim urna ac ligula hendrerit,
				sed elementum tortor laoreet. Nam suscipit lorem in iaculis maximus.
				Aenean sagittis auctor risus, sed placerat dolor lobortis eget.
				Vivamus nisl nunc, tincidunt vel sapien at, ornare condimentum
				justo. Ut ultricies quis magna a porta. Curabitur lacinia, velit
				tincidunt vestibulum consectetur, augue ante efficitur ligula, eget
				interdum augue lacus non mi. Fusce finibus vulputate orci, vel
				accumsan arcu aliquam sit amet. Suspendisse congue, mi nec vulputate
				consequat, dolor tortor sagittis lorem, imperdiet tempus turpis
				purus quis libero.</p>

			<br>

			<h3>Content Title 2</h3>

			<h4>Subtitle Example</h4>

			<p>Aliquam posuere egestas mauris eget bibendum. Sed elementum id
				justo malesuada ornare. Integer venenatis arcu eget lacus rhoncus,
				nec porttitor tortor egestas. Ut vitae bibendum quam. Vivamus
				lobortis bibendum vestibulum. Nulla lorem est, venenatis eget diam
				sed, dapibus pulvinar dolor. Integer molestie posuere mi. Vivamus
				blandit varius volutpat. Mauris volutpat est ut mauris consectetur,
				vitae lobortis metus pretium. Donec id mi sit amet tellus fermentum
				eleifend ut sed quam. Integer suscipit, ante finibus aliquam
				sollicitudin, metus quam tempor purus, eu vestibulum nunc risus in
				elit. Ut porta mi finibus pellentesque pharetra. Aliquam malesuada
				malesuada fermentum.</p>
			<p>Mauris bibendum cursus odio, nec luctus orci aliquam in.
				Quisque enim lorem, blandit eleifend pretium a, pulvinar in lectus.
				Maecenas elementum, arcu at placerat imperdiet, lorem nulla
				hendrerit arcu, maximus vehicula lectus felis eget diam. Nam finibus
				leo lobortis mollis interdum. Ut ipsum libero, eleifend eu enim
				vitae, lacinia laoreet felis. Nunc rutrum dui vel eros consectetur
				ultrices. Integer id faucibus ipsum, eu viverra magna. Etiam aliquet
				urna id aliquam lobortis. Pellentesque tellus enim, commodo et mi a,
				elementum molestie massa. Aenean nec mollis quam. Sed laoreet velit
				diam, ut laoreet neque imperdiet vel. In id enim sed urna
				sollicitudin pharetra eu finibus ipsum.</p>

			<br>

			<fieldset class="form">
				<legend>Form Example</legend>

				<p>
					<label>Name:</label> <input type="text">
				</p>
				<p>
					<label>Email:</label> <input type="text">
				</p>
				<p>
					<label>Username:</label> <input type="text">
				</p>
				<p>
					<label>Password:</label> <input type="password">
				</p>
				<p>
					<button type="button" class="list" value="">List all users</button>
					<button type="button" value="">Submit</button>
				</p>
			</fieldset>

			<br>

			<fieldset>
				<legend>Table Example</legend>

				<table>
					<thead>
						<tr>
							<th>Column 1</th>
							<th>Column 2</th>
							<th>Column 3</th>
							<th>Column 4</th>
							<th>Column 5</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<td>Column 1</td>
							<td>Column 2</td>
							<td>Column 3</td>
							<td>Column 4</td>
							<td>Column 5</td>
						</tr>
					</tfoot>

					<tbody>
						<tr>
							<td>Column 1</td>
							<td>Column 2</td>
							<td>Column 3</td>
							<td>Column 4</td>
							<td>Column 5</td>
						</tr>
						<tr>
							<td>Column 1</td>
							<td>Column 2</td>
							<td>Column 3</td>
							<td>Column 4</td>
							<td>Column 5</td>
						</tr>
						<tr>
							<td>Column 1</td>
							<td>Column 2</td>
							<td>Column 3</td>
							<td>Column 4</td>
							<td>Column 5</td>
						</tr>
						<tr>
							<td>Column 1</td>
							<td>Column 2</td>
							<td>Column 3</td>
							<td>Column 4</td>
							<td>Column 5</td>
						</tr>
						<tr>
							<td>Column 1</td>
							<td>Column 2</td>
							<td>Column 3</td>
							<td>Column 4</td>
							<td>Column 5</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
			
			
			<fieldset>
				<legend>Table Example</legend>
		
		<h2>Phone numbers</h2>
				 <div class="rTable">
				 <div class="rTableRow">
				 <div class="rTableHead"><strong>Application</strong></div>
				 <div class="rTableHead"><span style="font-weight: bold;">Project ID</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">Project Name</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">State</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">SDLC</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">Status</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">Issue</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">Comments</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">Jeopardy List</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">FTPs</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">FTPs - Current Month</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">FTPs - Next Month</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">CRs</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">SE</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">IBM PM</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">APM</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">Release</span></div>
				 <div class="rTableHead"><span style="font-weight: bold;">Type</span></div>
				 <div class="rTableHead">&nbsp;</div>
				 </div>
				 <div class="rTableRow">
				 <div class="rTableCell">John</div>
				 <div class="rTableCell"><a href="tel:0123456785">0123 456 785</a></div>
				 <div class="rTableCell"><img src="images/check.gif" alt="checked" /></div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">button aqui!!!</div>
				 
				 </div>
				 <div class="rTableRow">
				 <div class="rTableCell">Cassie</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">bbb</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell">John</div>
				 <div class="rTableCell"><a href="tel:9876532432">9876 532 432</a></div>
				 <div class="rTableCell"><img src="images/check.gif" alt="checked" /></div>
				 <div class="rTableCell">button aqui!!!</div>
				 </div>
				</div>
		
		
		</fieldset>

		</div>
		
		
		
			
		
		
		
		<!-- FOOTER -->

		<%@ include file="includes/footer.jsp"%>
	</div>


















	<!-- MODALS -->
	<div class="modal-box">
		<span class="x">X</span>
		<h2>SPA Users</h2>
		<ul>
			<li>Thiago</li>
			<li>Roger Waters</li>
			<li>David Gilmour</li>
			<li>Richard Wright</li>
			<li>Nick Mason</li>
		</ul>
	</div>
	
	<div class="modal"></div>

</body>
</html>