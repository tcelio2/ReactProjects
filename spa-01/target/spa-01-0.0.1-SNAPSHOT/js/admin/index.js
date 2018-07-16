$(document).ready(function(){

	
	
		$(document).on("click", ".change_manager", function(e){
		
		var dashboard_id = $(this).attr("id");
		var project_id = $(this).attr("project_id");
		var project_name = $(this).attr("project_name");
		//alert(project_id+"asfd"+project_name);
		
		$(".modal-box3").css("z-index","0");
		$(".modal-box4").attr("dashboard_id", dashboard_id);
		$(".modal-box4").attr("project_name", project_name);
		$(".modal-box4").attr("project_id", project_id);
		$(".modal-box4").fadeIn(1000);
	});
	
	
	$(document).on("change", ".manager_select", function(e){
		
		var values = {};
		var id_user = $(this).find("option:selected").attr("class");
		var name = $(this).find("option:selected").attr("name");
		var last_name = $(this).find("option:selected").attr("last_name");
		var project_id = $(this).parent(".modal-box4").attr("project_id");
		var project_name = $(this).parent(".modal-box4").attr("project_name");
		var dashboard_id = $(this).parent(".modal-box4").attr("dashboard_id");
		
		values.id_user = id_user;
		values.name = name;
		values.last_name = last_name;
		values.project_id = project_id;
		values.project_name = project_name;
		values.dashboard_id = dashboard_id;
		
		//alert("asdf: "+id_user+"-"+name+"- "+last_name+"-"+project_id);
		$(".modal-box4").hide();
		$(".modal-loader").show();
		//$(".modal-box3").css("z-index","999");
		 
		
		 setTimeout(function(){
			 update_project_manager(values);
			}, 2000);
		
		 
		 
		
	});
	
	function update_project_manager(values){
	
//alert("aqui: "+ values.id_user);
		$.ajax({
			url:"admin",
			type:"POST",
			data:{
				value:"UPDATE_PROJECT_TABLE",
				user_id:values.id_user,
				//project_id:values.project_id,
				id: values.dashboard_id,
			},
			success:function(response){
				
				if(response=="UPDATED"){
					
					var code = "<tr id="+values.dashboard_id+">" +
								"<td id='"+values.project_id+"' class='"+values.project_id+"' table='project_id'>"+values.project_id+"" +
								"</td><td id='"+values.project_name+"' class='"+values.project_name+"' table='project_name'>"+values.project_name+"" +
								"</td><td id='"+values.name+"' class='"+values.name+"' table='name'>"+values.name+"" +
								"</td><td id='"+values.last_name+"' class='"+values.last_name+"' table='last_name'>"+values.last_name+"</td>" +
								"<td><input project_name='"+values.project_name+"' project_id='"+values.project_id+"' user_id='"+values.id_user+"' id='"+values.dashboard_id+"' class='change_manager' value='Change' type='submit' /></td>"
							"</tr>"
					
					 $(".modal-box3 table tbody tr").each(function(){
						 var id_dashboard = $(this).attr("id");
						 if(id_dashboard == values.dashboard_id){
								 $(this).replaceWith(code).hide().fadeIn(2000);
									$(".modal-loader").hide();
									$(".modal-box3").css("z-index","999");
									$(this).animate({backgroundColor: '#FFFF00'}, 'slow');
						 }
					 });
					
				}else{
					alert("Fail!!!");
				
				}
			}
		})
		
		return false;
		
		
		
		
		
	}
	
	
	//manager_select
	
	
	$(".display_projects_managers").click(function(){
		
		$(".modal").show();
		 $(".modal-loader").show();
		
		 setTimeout(function(){
			 $(".modal-loader").hide();
			 $(".modal-box3").show();	 
			}, 2000);
		
		return false;
		
	});
	
	
	
	
	 $(".delete_project").click(function(){
			
		 var id_deleted = $(this).attr("id");
		
		 
		 $("body").append("<div class='confirmation'><span class='x2'>X</span><h2>Are you sure?</h2><input class='confirmation_project' id="+id_deleted+" type='button' value='yes'></div>");
		 
		 
	 });
	 
	 $(document).on("click", ".confirmation_project", function(){
		
		 var id_deleted = $(this).attr("id");
		 $(".modal-box").css("z-index","000");
		 $(".modal-box2").css("z-index","000");
		 $(".modal-loader").show();
		 $(".confirmation").hide();
		 setTimeout(function(){
			 delete_project_(id_deleted);
			}, 1000);
		 
		 // alert("adsf");
		 
	 });
	 
		function delete_project_(id){
				
				$.ajax({
					url:"admin",
					type:"POST",
					data:{
						value:"DELETE_PROJECT",
						id:id
					},
					success:function(response){
						
						$(".modal").hide();
						 $(".modal-loader").hide();
						 $(".modal-box2").css("z-index","999");
						
						 if(response=="DELETED"){
							 //alert("sucesso!");
							 $(".modal-box2 table tbody tr").each(function(){
								 var id_project = $(this).attr("id");
							
								 if(id_project == id){
							
									 $(this).fadeOut(1000);
								 }
							 });
						}else{
							alert("Fail!!!");
						}
					}
				})
				
				return false;
		}
	
	$(".a_delete_project").click(function(){
		
		//	alert("sadf");
		loaderProjects();
			return false;
		});
	
	
	
	
	
	
	function loaderProjects() {
		$(".modal").show();
		$(".modal-loader").show();
		 setTimeout(function(){
			 $(".modal-box2").show();
			 $(".modal-loader").hide();
			 
			}, 2000);
		
		
		selectByAjax();
		return false;
	}
	
	
	
	
	
	
	
	
	
	$(".a_create_project").click(function(){
		
		
		var a_project_name =  $(".a_project_name").val();
		var a_project_id = $(".a_project_id").val();
		var a_methodology =  $(".a_methodology option:selected").text();
		var a_methodology_id =  $(".a_methodology option:selected").val();
	
		
		//alert(a_project_name +"d"+ a_project_id +"d"+ a_methodology +"d"+ a_methodology_id);
		
		if (!a_project_name || !a_project_id) {
			alert("Empty!!!");
		} else {
			insertProject(a_project_name, a_project_id, a_methodology, a_methodology_id);
		}
		
		
		
	});
	
	function insertProject(a_project_name, a_project_id, a_methodology, a_methodology_id) {
		$(".modal").show();
		$(".modal-loader").show();
		 setTimeout(function(){
			 insertProjectByAjax(a_project_name, a_project_id, a_methodology, a_methodology_id);
			}, 2000);
		
		return false;
	}
	
	function insertProjectByAjax(a_project_name, a_project_id, a_methodology, a_methodology_id){
		$.ajax({
			url:"admin",
			type:"POST",
			data:{
				value:"CREATE_PROJECT",
				project_name: a_project_name,
				project_id: a_project_id,
				methodology: a_methodology,
				methodology_id: a_methodology_id,
			},
			success:function(response){
				
//				$(".modal").hide();
				 $(".modal-loader").hide();
				
				 if(response=="CREATED"){
					   $(".a_project_name").val("");
					   $(".a_project_id").val("");
					  
					
					$(".pop-up-edit-confirmation3").show();
					 
				}else{
					alert("Fail!!!");
				
				}
			}
		})

	}
	
		    $('#example').DataTable( {
		        columnDefs: [ {
		            targets: [ 0 ],
		            orderData: [ 0, 1 ]
		        }, {
		            targets: [ 1 ],
		            orderData: [ 1, 0 ]
		        }, {
		            targets: [ 4 ],
		            orderData: [ 4, 0 ]
		        } ]
		    } );
		//} );
	  
	 $(".delete_").click(function(){
		
		 var id_deleted = $(this).attr("id");
		
		 
		 $("body").append("<div class='confirmation'><span class='x2'>X</span><h2>Are you sure?</h2><input class='confirmation_ok' id="+id_deleted+" type='button' value='yes'></div>");
		 
		 
	 });
	 
	 $(document).on("click", ".confirmation_ok", function(){
		
		 var id_deleted = $(this).attr("id");
		 $(".modal-box").css("z-index","000");
		 $(".modal-box2").css("z-index","000");
		 $(".modal-loader").show();
		 $(".confirmation").hide();
		 setTimeout(function(){
			 delete_user(id_deleted);
			}, 1000);
		 
		 // alert("adsf");
		 
	 });
	 
	 
		    
		    
		    
	/*    $('button').click( function() {
	        var data = table.$('input, select').serialize();
	        return false;
	    } );
	*/
	$(".list").click(function(){
		
	//	alert("sadf");
		loader();
		return false;
	});
	$(".a_insert").click(function(){
		
		
		
		
		var a_name =  $(".a_name").val();
		var a_last_name = $(".a_last_name").val();
		var a_user_name = $(".a_user_name").val();
		var a_email = $(".a_email").val();
		var a_role =  $(".a_role option:selected").text();
		var a_role_id =  $(".a_role option:selected").val();
	
		
		//alert(a_role_id);
		
		if (!a_name || !a_email || !a_role || !a_role_id || !a_last_name || !a_user_name) {
			alert("Empty!!!");
		} else {
			loaderInsert(a_name, a_email, a_role, a_role_id, a_last_name, a_user_name);
		}

	});
	
	
	function loader() {
		$(".modal").show();
		$(".modal-loader").show();
		 setTimeout(function(){
			 $(".modal-box").show();
			 $(".modal-loader").hide();
			 
			}, 2000);
		
		
		selectByAjax();
		return false;
	}
	
	function selectByAjax(){
		
		$.ajax({
			url:"AdminServlet",
			type:"POST",
			data:{
				value:"SELECT"
			},
			success:function(response){
				//alert(response+"as");
				 $(".modal-box").fadeIn();
				 $(".modal-loader").hide();
				 if(response!=""){
					$(".modal-box .dataTable tbody").html(response);
					
				}else{
					$(".modal-box .a_users").html("nothing coming");
				}
			}
		})

	}
	
	function loaderInsert(a_name, a_email, a_role, a_role_id, a_last_name, a_user_name) {
		$(".modal").show();
		$(".modal-loader").show();
		 setTimeout(function(){
			 insertByAjax(a_name, a_email, a_role, a_role_id, a_last_name, a_user_name);
			}, 2000);
		
		return false;
	}
	
	
function insertByAjax(a_name, a_email, a_role, role_id, a_last_name, a_user_name){
	
	
	
		$.ajax({
			url:"admin",
			type:"POST",
			data:{
				value:"INSERT",
				name: a_name,
				email: a_email,
				role: a_role,
				role_id: role_id,
				last_name:a_last_name,
				user_name:a_user_name
			},
			success:function(response){
				
				$(".modal").hide();
				 $(".modal-loader").hide();
				
				 if(response=="INSERTED"){
					   $(".a_name").val("");
					   $(".a_last_name").val("");
					   $(".a_user_name").val("");
					   $(".a_email").val("");
					
					$(".pop-up-edit-confirmation").show();
					 
				}else{
					alert("Fail!!!");
				
				}
			}
		})

	}
	$(".x").click(function(){
		
		
		$(".modal").hide();
		$(".modal-box").hide();
		$(".modal-box2").hide();
		$(".modal-box4").hide();
		$(".pop-up-edit-confirmation").hide();
		$(".pop-up-edit-confirmation2").hide();
		$(".pop-up-edit-confirmation3").hide();
		location.reload();
		
	});

	$(document).on("click",".x2", function(){
		$(".confirmation").hide();
	});

	
	$(document).on("click",".x3", function(){
		$(".pop-up-edit").hide();
	});

	
	$(document).on("click",".x4", function(){
		$(".modal-box4").hide();
		$(".modal-box3").css("z-index","999");
		//$(".modal").hide();
	});
	
	
	$(document).on("click", ".edit_admin", function() {

		var tr_father = $(this).parent("td").parent("tr");
		
		tr_father.find('td input:text,td select').each(function() {			
			textVal = this.value;
			$(this).prop( "disabled", false );
		}); 
		
	});
	
	
	//$(document).on("click", ".admin_delete", function() {
		
		function delete_user(id){
			
		
		
	//	$(this).replaceWith("<img id='loader_admin' src='img/loader2.gif'/>");
	//	var id = $(this).attr("id");
		
		$.ajax({
			url:"admin",
			type:"POST",
			data:{
				value:"DELETE",
				id:id
			},
			success:function(response){
				
				//$(".modal").hide();
				 $(".modal-loader").hide();
				 $(".modal-box").css("z-index","999");
				
				 if(response=="DELETED"){
					 
					 $("#example_wrapper table tbody tr").each(function(){
						
						 var id_user = $(this).attr("id");
					
						 if(id_user == id){
					
							 $(this).fadeOut(1000);
						 }
						 
					 });
				
					 
					 
				}else{
					alert("Fail!!!");
					
				}
			}
		})
		
		return false;
}
	//});
	
	
	
	
$(document).on("click", ".admin_update", function() {
		alert(":asdf");
	var userObject = {};
	var tr_father = $(this).parent("td").parent("tr");
	userObject.email = "";
	userObject.role ="";
//	userObject.role_id ="";
	userObject.name ="";
	
	
	tr_father.find('td').each(function() {			
		textVal = this.value;
		var t = $(this).attr("class");
		if(t == "email"){
			userObject.email = $(this).find('input').val();
		}
		if(t == "role"){
			userObject.role = $(this).find('option:selected').val();
			userObject.role = $(this).find('option:selected').val();
		}
		if(t == "name"){
			userObject.name = $(this).text();
		}
	}); 
		userObject.id = $(this).attr("id");
		userObject.row_type = $(this).parent("td").parent("tr").attr("class");

		$(this).replaceWith("<img id='loader_admin' style='margin-left: 20px;margin-right: 30px' src='img/loader2.gif'/>");
		
		
		 setTimeout(function(){
			 updateUser(userObject);
			}, 2000);
		
});


function updateUser(object){
	
	
	
		$.ajax({
			url:"AdminServlet",
			dataType: 'json',
			type:"POST",
			data:{
				value:"UPDATE",
				row_type:object.row_type,
				id:object.id,
				nome: object.name,
				email: object.email,
				role: object.role
			},
			success:function(response){
				if(response.resultado=="UPDATED"){
					 $("#example_wrapper table tbody tr").each(function(){
						 var id_user = $(this).attr("id");
						 if(id_user == object.id){
								 $(this).replaceWith(response.htmlResult).hide().fadeIn(2000);
								 alert("Updated Successfully!");
						 }
					 });
					
				}else{
					alert("Fail!!!");
				
				}
			}
		})
		
		return false;
		
	};
	

	
	$(".edit_").click(function(e){
		
		var id_row = $(this).attr("id");//text();
		var position = $(this).position();
		var column_table = $(this).attr("table");
		//$(".pop-up-edit").show();
		
		var c = $(this).html();
		
		//alert($(".pop-up-edit input").val());
		$(".pop-up-edit").css("z-index","9999");
		$(".pop-up-edit").attr("id", id_row);
		$(".pop-up-edit").css({"top":position.top});
		$(".pop-up-edit input").val("");
		$(".pop-up-edit input").val(c);
		$(".pop-up-edit").attr("table",column_table);
		//$(".pop-up-edit").attr("tab", tab);
		//$(".pop-up-edit").attr("bgColor", bgColor);
		$(".pop-up-edit").show();
		
		//alert(c+"-");
		 e.preventDefault();
	});

	$(document).on("click", "#update_btn", function(e){
		
		$(".pop-up-edit").fadeOut(1000);
		//var fieldset = $(".pop-up-edit").attr("fieldset");
		var id_row = $(".pop-up-edit").attr("id");
		var table_column = $(".pop-up-edit").attr("table");
		var input_value = $(".input_edit").val();
		//var tab = $(".pop-up-edit").attr("tab");
		//var bgColor = $(".pop-up-edit").attr("bgColor");
		//var tab_especial = $(".pop-up-edit").attr("tab_especial");
		
		$.ajax({
			url:"admin",
			type:"POST",
			data:{
				value:"UPDATE",
				content:input_value,
				id:id_row,
				table:table_column
				
			},
			success:function(response){
				
				if(response == "UPDATED"){
					
					$(".pop-up-edit-confirmation2").show();
					$(".modal").hide();
					$(".modal-box").fadeOut(1000);
					
					 setTimeout(function(){
						 location.reload();
						}, 2000);
					
					//location.reload();
						//alert("confirmado!!!");
					
					
				}
				//$(".modal-loader").hide();
				//$(".modal-box").hide();
							
			}
		})
		
		 e.preventDefault();
		
	});	
	
});