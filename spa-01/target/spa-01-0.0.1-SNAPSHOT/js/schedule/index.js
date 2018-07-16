$(document).ready(function() {
	
	$(document).on("focus", ".start_date", function() {
		$(this).datepicker();
		return false;
	});
	$(document).on("focus", ".end_date", function() {
		$(this).datepicker();
		return false;
	});

	
	$(".deliverables").change(function(){
		
		var deliverable_id = $(this).children(":selected").attr("id");
		AddLoader(deliverable_id);
		
	});
	
	function AddLoader(deliverable_id){
		
		$(".modal").show();
		$(".modal-loader").show();
		 setTimeout(function(){
			 getAllDelivebrablesForUser(deliverable_id);
			}, 2000);
		
		
		return false;
	}

	function AddLoaderSchedule(myarray, table_scheduled){
		
		$(".modal").show();
		$(".modal-loader").show();
		 setTimeout(function(){
			 send(myarray, table_scheduled);
			}, 2000);
		
		
		return false;
	}
	
	
	function takeOffLoader(){
		
		$(".modal").hide();
		$(".modal-loader").hide();
		
		//getAllDelivebrablesForUser();
		
		return false;
	}
	
	
	function getAllDelivebrablesForUser(deliverable_id){
		
		
		$.ajax({
				url:"schedule",
				type:"POST",
				data:{
					userid:"8",
					deliverable:deliverable_id
					
				},
				success:function(response){
		
					takeOffLoader();
					
					$(".table_deliverable tbody").empty().html(response).hide().fadeIn(1000);
					
				}

		})

		
		return false;
	}
	
	/**	DELETE CLICK **/
	$(document).on ("click", ".b_delete", function() {
		
		var id = $(this).attr("id");
		var answer = confirm("Are you sure to remove this schedule?\n");
		
		if (answer == true){
			deleteItem(id)
		}
		
		return false;		
		
	});

	
	
	function deleteItem(id){
		
		
		$.ajax({
			url:"deliverableuser",
			type:"POST",
			data:{
				value:"DELETE",
				id: id
			
			},
			success:function(response){
				
				 $(".modal").hide();
				 $(".modal-loader").hide();
				 if(response == "DELETED"){
					
					 $(".rTable .rTableRow").each(function() {

						 var id_row = $(this).attr("id");
							if(id == id_row){
								$(this).fadeOut(1000).remove();
							}
					 });				 			
				}else{
					alert("Fail delete Schedule!!!");
				}
			}
		})

	}
	

	$(document).on ("click", ".submit_schedule", function() {	

		
/*		var schedule_id = $(".table_deliverable tbody tr").attr("id");*/

		var schedule = {};
		
		var dashboard_id =  $('#project_id_schedule').find(":selected").attr("id");
		var deliverable_id =  $('.deliverables').find(":selected").attr("id");
		var project_name = $('#project_id_schedule').find(":selected").val();
		var project_id = $('#project_id_schedule').find(":selected").attr("class");
		var deliverable_title =  $('.deliverables').find(":selected").val();
		
		schedule.project_name = project_name;
		schedule.project_id = project_id;
		schedule.deliverable_title = deliverable_title;
		
		schedule.dashboard_id = dashboard_id;
		schedule.deliverable_id = deliverable_id;
		
		//hld
		var hld_start_date = $(".hld_start_date").val();
		var hld_end_date = $(".hld_end_date").val();
		var hld_comment= $(".hld_comment").val();
		//ia	
		var ia_start_date = $(".ia_start_date").val();
		var ia_end_date = $(".ia_end_date").val();
		var ia_comment = $(".ia_comment").val();
		//ad			
		var ad_start_date = $(".ad_start_date").val();
		var ad_end_date = $(".ad_end_date").val();
		var ad_comment = $(".ad_comment").val();
		//cw					
		var cw_start_date = $(".cw_start_date").val();
		var cw_end_date = $(".cw_end_date").val();
		var cw_comment = $(".cw_comment").val();
		
		if(hld_start_date != null){
			schedule.hld_start_date = hld_start_date;
		}else{
			schedule.hld_start_date = "EMPTY";
		}
		if(hld_end_date != null){
			schedule.hld_end_date = hld_end_date;
		}else{
			schedule.hld_end_date = "EMPTY";			
		}
		if(ia_start_date != null){
			schedule.ia_start_date = ia_start_date;			
		}else{
			schedule.ia_start_date = "EMPTY";
		}
		if(ia_end_date != null){
			schedule.ia_end_date = ia_end_date;
		}else{
			schedule.ia_end_date = "EMPTY";
			
		}
		if(ad_start_date != null){
			schedule.ad_start_date = ad_start_date;
		}else{
			schedule.ad_start_date = "EMPTY";
			
		}
		if(ad_end_date != null){
			schedule.ad_end_date = ad_end_date;
		}else{
			schedule.ad_end_date = "EMPTY";
			
		}
		if(cw_start_date != null){
			schedule.cw_start_date = cw_start_date;
		}else{
			schedule.cw_start_date = "EMPTY";
			
		}
		if(cw_end_date != null){
			schedule.cw_end_date = cw_end_date;
		}else{
			schedule.cw_end_date = "EMPTY";
			
		}
		if(hld_comment != null){
			schedule.hld_comment = hld_comment;
		}else{
			schedule.hld_comment = "EMPTY";
			
		}
		if(ia_comment != null){
			schedule.ia_comment = ia_comment;
		}else{
			schedule.ia_comment = "EMPTY";
			
		}
		if(ad_comment != null){
			schedule.ad_comment = ad_comment;
		}else{
			schedule.ad_comment = "EMPTY";
			
		}
		if(cw_comment != null){
			schedule.cw_comment = cw_comment;
		}else{
			schedule.cw_comment = "EMPTY";
			
		}
		if(hld_comment != null){
			schedule.hld_comment = hld_comment;
		}else{
			schedule.hld_comment = "EMPTY";
			
		}
		if(ia_comment != null){
			schedule.ia_comment = ia_comment;
		}else{
			schedule.ia_comment = "EMPTY";
			
		}
		if(ad_comment != null){
			schedule.ad_comment = ad_comment;
		}else{
			schedule.ad_comment = "EMPTY";
			
		}
		if(cw_comment != null){
			schedule.cw_comment =cw_comment;
		}else{
			schedule.cw_comment = "EMPTY";
			
		}
			
		
			if ( $(".table_deliverable tbody").children().length == 0 ) {
				alert("First, choose one project ID and one deliverable!");
			}else{	
				 				 //AddLoaderSchedule(myarray, table_scheduled);
				// send(myarray, table_scheduled);
				 
				 $(".modal").show();
					$(".modal-loader").show();
					 setTimeout(function(){
						 sendAjax(schedule);
						}, 2000);
				 
				 
				// myJSON = JSON.stringify(myarray);
				// alert(myJSON);
				 return false;
			}
			
			
			
			function sendAjax(schedule){
				$.ajax({
					url:"deliverableuser",
					type:"POST",
					//dataType: "JSON",
					data:{ 
						value:"INSERT",
						//schedule: JSON.stringify(myarray)
						 dashboard_id:schedule.dashboard_id,
						 deliverable_id :schedule.deliverable_id,
						 deliverable_title: schedule.deliverable_title,
						 project_name:schedule.project_name,
						 project_id: schedule.project_id,
						//hld
						 hld_start_date :schedule.hld_start_date,
						 hld_end_date:schedule.hld_end_date,
						 hld_comment:schedule.hld_comment,
						//ia	
						 ia_start_date:schedule.ia_start_date,
						 ia_end_date:schedule.ia_end_date,
						 ia_comment:schedule.ia_comment,
						//ad			
						 ad_start_date:schedule.ad_start_date,
						 ad_end_date:schedule.ad_end_date,
						 ad_comment:schedule.ad_comment,
						//cw					
						 cw_start_date:schedule.cw_start_date,
						 cw_end_date:schedule.cw_end_date,
						 cw_comment:schedule.cw_comment
			
					},
					beforeSend: function(){
						
						
					},
				    success:function(response){
						
				    			
						takeOffLoader();
						var table_scheduled = "";
						if(response != "FAIL"){
							
							var schedule_id = response;
							
							$(".table_deliverable tbody tr").each(function( index ) {
								

								 var id_deliverable_type = $(this).text();  //hld ia ad cw
								 var start_date = $(this).children("td").find(".start_date").val();
								 var end_date = $(this).children("td").find(".end_date").val();
								 var comment = $(this).children("td").find(".comment").val();

				    			table_scheduled += "<div id='"+schedule_id+"' class='rTableRow'>" +
														"<div id='projectid' class='rTableCell d_project_id' style='text-align: left;'>"+project_id+"</div>" +
														"<div id='projectname' class='rTableCell d_project_name' style='text-align: left;'>"+project_name+"</div>" +
														"<div id='deliverable' class='rTableCell d_methodology' style='text-align: left;'>"+deliverable_title+"</div>" +
														"<div id='type' class='rTableCell d_deliverable'>"+id_deliverable_type+"</div>" +
														"<div id='startdate' class='rTableCell Edit d_start_date'>"+start_date+"</div>" +
														"<div id='enddate' class='rTableCell Edit d_end_date'>"+end_date+"</div>" +
														"<div id='comment' class='rTableCell Edit d_comments' style='text-align: left;'>"+comment+"</div>" +
														
														"<a class='b_delete rTableCell' id='"+dashboard_id+"'><img alt='' src='img/paper-bin.png'></a>" +
														
												  "</div>"
									    
								 })

						}
						
						
				/*		$(".schedule_submited tbody").empty().html(table_scheduled).hide().fadeIn(1000);*/
						$(".rTable").append(table_scheduled); //.hide().fadeIn(1000);
						$(".table_deliverable tbody").fadeOut(1000);
						
						$("#project_id_schedule").val("");
						$(".deliverables").val("");
						
					}
					
				});
			}
	});
	
	
/*	
	
	*//**    VIEW CLICK **//*
	$(document).on("click", ".b_view", function() {
		
		var values = {};
		
		values.id = $(this).parent("td").parent("tr").children(".d_project_id").html();		
		values.deliverable = $(this).parent("td").parent("tr").children(".d_methodology").html();
		values.type = $(this).parent("td").parent("tr").children(".d_deliverable").html();		
		values.startdate = $(this).parent("td").parent("tr").children(".d_start_date").html();
		values.enddate = $(this).parent("td").parent("tr").children(".d_end_date").html();
		values.comment = $(this).parent("td").parent("tr").children(".d_comments").html();
		
		$(".modal").show();
		$(".modal-box").show();
		
		
		makeView(values);
	
		return false;
	});
	
	function makeView(values){
		
		
		var fieldSet = '<fieldset><legend>Schedule Template -- Read Only</legend>'
		+ '<p><label>Project ID:</label> <input type="text" class="d_name" value="'+values.id+'" readonly /></p>'
		+ '<p><label>Deliverable:</label> <input type="text" class="d_description" value="'+values.deliverable+'" readonly /></p>'	
		+ '<p><label>Type:</label> <input type="text" class="d_type" value="'+values.type+'" readonly /></p>'	
		+ '<p><label>Start Date:</label> <input type="text" class="d_start_date" value="'+values.startdate+'" /></p>'	
		+ '<p><label>End Date:</label> <input type="text" class="d_end_date" value="'+values.enddate+'" /></p>'	
		+ '<p><label>Comment:</label> <input type="text" class="d_comments" value="'+values.comment+'" /></p>'	
		+ '</fieldset>';
		
		$(".modal-box").html('<span class="x">X</span>');
		$(".modal-box").append(fieldSet);
		
	}
	*/
	
	$(document).on("click", ".x", function() {
		$(".modal").hide();
		$(".modal-box").hide();
		 $(".modal-loader").hide();
	});

	
	$(document).on("click", "#update_btn", function(e){
		
		$(".pop-up-edit").hide();
		
		var id_row = $(".pop-up-edit").attr("id");	
		var deliverable_row = $(".pop-up-edit").attr("deliverable");
		var type_row = $(".pop-up-edit").attr("typedel");
		var table_column = $(".pop-up-edit input").attr("id");
		var input_value = $(".input_edit").val();
		var tab = $(".pop-up-edit").attr("tab");
		var bgColor = $(".pop-up-edit").attr("bgColor");
		
		$.ajax({
			url:"deliverableuser",
			type:"POST",
			data:{
				value:"UPDATE_ROW",
				input_value_update:input_value,
				id_row_table:id_row,
				deliverable_row_table:deliverable_row,
				type_row_table:type_row,
				table_column:table_column
				
			},
			success:function(response){
				
				if(response == "UPDATED"){
					
					$(".rTable .rTableRow").each(function() {
						
						var id = $(this).attr("id");			
						var deliverable = $(this).find("#deliverable").html();
						var type = $(this).find("#type").html();
						
						if(id == id_row && deliverable == deliverable_row && type == type_row){
							$(this).find('#'+table_column).html(input_value).animate({backgroundColor: '#FFFF00'}, 'slow').animate({backgroundColor: bgColor}, 2000);
						}
						
					})

				}
				$(".modal-loader").hide();
				$(".modal").hide();
							
			}
		})
		
		 e.preventDefault();
		
	});
	
	
	$(document).on("click", ".x", function() {
		$(".modal").hide();
		$(".dashboard-box").hide();
		$(".modal-box-filter").hide();
		$(".modal-box").hide();
		$(".modal-loader").hide();
		$(".pop-up-edit").hide();
		$(".content").css({"position":"relative"});
	});
	
				
	$(".rTableCell+.Edit").click(function(e){

		var id_row = $(this).parent(".rTableRow").attr("id");
		var deliverable_row = $(this).parent(".rTableRow").find("#deliverable").html();
		var type_row = $(this).parent(".rTableRow").find("#type").html();
		var position = $(this).position();
		var column_table = $(this).attr("id");
		var bgColor = $(this).css("background-color");

		$(".modal").show();
		var c = $(this).html();

		$(".pop-up-edit").attr("id", id_row);
		$(".pop-up-edit").attr("deliverable", deliverable_row);
		$(".pop-up-edit").attr("typedel", type_row);
		$(".pop-up-edit").css({"top":position.top});
		$(".pop-up-edit input").val("");
		$(".pop-up-edit input").val(c);
		$(".pop-up-edit input").attr("id",column_table);
		$(".pop-up-edit").attr("bgColor", bgColor);
		$(".pop-up-edit").show();
		
		//alert(c+"-");
		 e.preventDefault();
	});
	
	
	
	
	
	
});