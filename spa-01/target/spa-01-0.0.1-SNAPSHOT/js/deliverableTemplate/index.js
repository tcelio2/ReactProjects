$(document).ready(function() {

					var d_name = "";
					var d_description = "";

					$(".b_submit").click(function() {

						var template = {};
						
						template.title = $(".d_name").val();
						template.description = $(".d_description").val();
						
						if($(".d_hld").prop('checked')) {
							template.hld = "S";
						} else {
							template.hld = "N";
						}
						
						if($(".d_ia").prop('checked')) {
							template.ia = "S";
						} else {
							template.ia = "N";
						}
						
						if($(".d_ad").prop('checked')) {
							template.ad = "S";
						} else {
							template.ad = "N";
						}
						
						if($(".d_cw").prop('checked')) {
							template.cw = "S";
						} else {
							template.cw = "N";
						}
										
						var d_name = $(".d_name").val();
						var d_description = $(".d_description").val();

						if (!d_name || !d_description) {
							alert("vazio!!");
						} else {
							loader(template);
						}
						
						
						return false;

					});

					function visualizar(c){
						
						alert(c.id+"---"+c.nome);
					}
					
					
					function loader(template) {
						$(".modal").show();
						$(".modal-loader").show();
						 setTimeout(function(){
							 insertDeliverableAjax(template);
							}, 2000);
						
						return false;
					}

					
					function insertDeliverableAjax(template){
						
						$.ajax({
							url:"deliverable",
							type:"POST",
							data:{
								value:"INSERT",
								title: template.title,
								description: template.description,
								hld: template.hld,
								ia: template.ia,
								ad: template.ad,
								cw:template.cw
							},
							success:function(response){
									//alert("=>"+response);
								// $(".modal-box").fadeIn();
								
								 $(".modal").hide();
								 $(".modal-loader").hide();
								// alert(response);
								 if(response != "0"){
									//$(".modal-box .a_users").html(response);
									 
									 
										 setValues(template, response);
									
									 //alert("New Deliverable Inserted!!"+response);
									return false;
								}else{
									alert("Fail insert Deliverable!!!");
									//$(".modal-box .a_users").html("nothing coming");
								}
							}
						})
							return false;
					}
					
//					function hideModal(d_name, d_description) {
//
//						setTimeout(function() {
//
//							$(".modal").hide();
//							$(".modal-loader").hide();
//							setValues(d_name, d_description);
//						}, 3000);
//
//						return false;
//					}

					function setValues(template, response) {
						
						$(".rTable").append("<div class='rTableRow' id='"+response+"'>"
								+"<div class='rTableCell d_id' id='id'>"+response+"</div>"
								+"<div class='rTableCell Edit d_title' id='title' style='text-align: left;'>"+template.title+"</div>"
								+"<div class='rTableCell Edit d_descriptione' id='description' style='text-align: left;'>"+template.description+"</div>"
								+"<div class='rTableCell Edit d_hld' id='hld'>"+template.hld+"</div>"
								+"<div class='rTableCell Edit d_ia' id='ia'>"+template.ia+"</div>"
								+"<div class='rTableCell Edit d_ad' id='ad'>"+template.ad+"</div>"
								+"<div class='rTableCell Edit d_cw' id='cw'>"+template.cw+"</div>"
	
								+"<div class='rTableCell'>"
								+" <a class='b_delete' id='"+response+"'><img alt='' src='img/paper-bin.png'></a>"
								+"</div>"
								+"</div>"
						
						);
						$(".rTable:last-child").hide().fadeIn(1000);
												
						$(".d_name").val("");
						$(".d_description").val("");
						$(".d_hld").prop("checked", false);
						$(".d_ia").prop("checked", false);						
						$(".d_ad").prop("checked", false);						
						$(".d_cw").prop("checked", false);
						
						return false;
					}

					
					/**    DELETE CLICK **/
					$(document).on("click", ".b_delete", function() {

						
						var id = $(this).attr("id");
					    var answer = confirm("Are you sure to remove this item?");
					     
					     if (answer == true) {
					    	 deletOnServer(id);
					     }
						
					     return false;
					});

					function deletOnServer(id){
						
						
						$.ajax({
							url:"deliverable",
							type:"POST",
							data:{
								value:"DELETE",
								id: id
							
							},
							success:function(response){
								
								 $(".modal").hide();
								 $(".modal-loader").hide();
								 if(response=="DELETED"){
									
									 //$(this).parent("td").parent("tr").fadeOut();//.remove();
									 $( ".form .rTable .rTableRow" ).each(function( index ) {
										 
										 //alert("v"+ $(this).attr("id"));
										 var tds = $(this).attr("id");//.find('.rTableRow');
										 //if(tds.length != 0) {
										 //var $currText = $tds.eq(0).text();
										 if(tds == id){
											 $(this).fadeOut(1000);
										 	}
										 
										 //}
									 });
									 								
								}else{
									alert("Fail delete Deliverable!!!");
									//$(".modal-box .a_users").html("nothing coming");
								}
							}
						})
						
						
					}
					
					/**    EDIT CLICK **/
					$(document).on("click", ".b_edit", function() {

						var values = {};
						values.hld = $(this).attr("hld");
						values.ia  = $(this).attr("ia");
						values.ad  = $(this).attr("ad");
						values.cw  = $(this).attr("cw");
						values.id = $(this).parent("td").parent("tr").children(".d_id").html();
						values.title = $(this).parent("td").parent("tr").children(".d_title").html();
						values.description = $(this).parent("td").parent("tr").children(".d_description").html();
						
						
						 $(".modal").show();
						 $(".modal-loader").show();
						 $(".modal-box").show();
						//var id = $(this).attr("id");
						//deletOnServer(id);
					//alert("eee")
						makeEdit(values);
						
						return false;
					});
					
					function makeEdit(values){
						
						var r_hld = "";
						var r_ia  = "";
						var r_ad  = "";
						var r_cw  = "";
						
						if(values.hld == "S"){
							r_hld = "checked";
						}
						if(values.ia == "S"){
							r_ia = "checked";
						}
						if(values.ad == "S"){
							r_ad = "checked";
						}
						if(values.cw == "S"){
							r_cw = "checked";
						}
						
						var fieldSet = '<fieldset><legend>Deliverable Template - Edit</legend>'
						+ '<p><label>Title:</label> <input type="text" class="d_name_edit" value="'+values.title+'"  /></p>'
						+ '<p><label>Description:</label> <input type="text" class="d_description_edit" value="'+values.description+'" /></p>'				
						+ '<p><label>Type:</label>' 
							+ '<input type="checkbox" name="" class="d_hld_edit" value="HLD" '+r_hld+' /> HLD ' 
							+ '<input type="checkbox" name="" class="d_ia_edit"  value="IA" ' +r_ia+' /> IA '
							+ '<input type="checkbox" name="" class="d_ad_edit"  value="AD" ' +r_ad+' /> AD '
							+ '<input type="checkbox" name="" class="d_cw_edit"  value="CW" ' +r_cw+' /> CW '
						+ '</p>'
						+ '<p><button type="button" value="b_view" id="'+values.id+'" class="b_submit_edit">Submit</button></p>'
						+ '</fieldset>';
						
						$(".modal-box").html('<span class="x">X</span>');
						$(".modal-box").append(fieldSet);
						
					}
					
					$(document).on("click", ".b_submit_edit", function() {

							var template = {};
							
							template.title = $(".d_name_edit").val();
							template.description = $(".d_description_edit").val();
							template.id = $(this).attr("id");
							
							if($(".d_hld_edit").prop('checked')) {
								template.hld = "S";
							} else {
								template.hld = "N";
							}
							
							if($(".d_ia_edit").prop('checked')) {
								template.ia = "S";
							} else {
								template.ia = "N";
							}
							
							if($(".d_ad_edit").prop('checked')) {
								template.ad = "S";
							} else {
								template.ad = "N";
							}
							
							if($(".d_cw_edit").prop('checked')) {
								template.cw = "S";
							} else {
								template.cw = "N";
							}
											
							var d_name = $(".d_name_edit").val();
							var d_description = $(".d_description_edit").val();

							if (!d_name || !d_description) {
								alert("Title and Description are required!");
							} else {
								loader_update(template);
							}
							
							
							return false;
							
					});
					
					function loader_update(template_value) {
						updateDeliverableAjax(template_value);
						return false;
					}
									
					function updateDeliverableAjax(template){
	
						$.ajax({
							url:"deliverable",
							type:"POST",
							data:{
								value:"UPDATE",
								title: template.title,
								description: template.description,
								hld: template.hld,
								ia: template.ia,
								ad: template.ad,
								cw:template.cw,
								id:template.id
							},
							success:function(response){
							
								 if(response=="UPDATED"){
									 var num = 0;
									 $( "#deliverableTable tbody tr" ).each(function( index ) {
										 num += 1;
										 var $tds = $(this).find('td');
										 if($tds.length != 0) {
										 var $currText = $tds.eq(0).text();
										 if($currText == template.id){
											
											     $(".modal").hide();
												 $(".modal-loader").hide();
												 $(".modal-box").hide();
												 
											  var new_line = '<tr>'
												  +'<td class="d_id">'+template.id+'</td>'
												  +'<td class="d_title">'+template.title+'</td>'
												  +'<td class="d_description">'+template.description+'</td>'
												  +'<td class="d_hld">'+template.hld+'</td>'
												  +'<td class="d_hld">'+template.ia+'</td>'
												  +'<td class="d_hld">'+template.ad+'</td>'
												  +'<td class="d_hld">'+template.cw+'</td>'
												  +'<td>'
												  +'<button type="button" class="b_delete" id="'+template.id+'">Delete</button>'
												  +'<button type="button" hld="'+template.hld+'" ia="'+template.ia+'" ad="'+template.ad+'" cw="'+template.cw+'" class="b_edit" value="b_edit" id="'+template.id+'">Edit</button>'
												  +'<button type="button" hld="'+template.hld+'" ia="'+template.ia+'" ad="'+template.ad+'" cw="'+template.cw+'" class="b_view" value="b_view" id="'+template.id+'">View</button>'
												  +'</td>'
												  +'</tr>'
												  
												  
												  $tds.parent("tr").replaceWith(new_line);//.fadeIn(1000);
												  //$( "table tr:nth-child("+num+")" ).css("background-color", "blue");
												 // $(".form").animate("background-color", "blue");
												 // takeOffColor(num);
												  										      
											  //$( "table tr:nth-child("+num+")" ).animate({backgroundColor:"red"},'slow');
											   
										 	}									 
										 }
									 });
				 
									
								}else{
									alert("Fail update Deliverable!!!");
									//$(".modal-box .a_users").html("nothing coming");
								}
								
							}
						})
							return false;
					}


			/*		function takeOffColor(num_){
						
						
						$( "#deliverableTable tbody tr" ).each(function( index ) {
							
							 var $tds = $(this).find('td');
							 var $currText = $tds.eq(0).text();
							 
							 if($tds.length != 0) {
								 
								 if($currText == num_){
									 
									 setTimeout(function(){
										  $( "#deliverableTable tr:nth-child("+num_+")" ).css("background-color", "red");
									  },1000); 
								 }			 
							 }
						});
					}*/
					
					
					/**    VIEW CLICK **/
					$(document).on("click", ".b_view", function() {
						
						var values = {};
						
						values.hld = $(this).attr("hld");
						values.ia  = $(this).attr("ia");
						values.ad  = $(this).attr("ad");
						values.cw  = $(this).attr("cw");
						values.id = $(this).attr("d_id");
						values.title = $(this).parent("td").parent("tr").children(".d_title").html();
						values.description = $(this).parent("td").parent("tr").children(".d_description").html();
						
						$(".modal").show();
						$(".modal-box").show();
						
						
						makeView(values);
					
						return false;
					});
					
					function makeView(values){
						
						var r_hld = "";
						var r_ia  = "";
						var r_ad  = "";
						var r_cw  = "";
						
						if(values.hld == "S"){
							r_hld = "checked";
						}
						if(values.ia == "S"){
							r_ia = "checked";
						}
						if(values.ad == "S"){
							r_ad = "checked";
						}
						if(values.cw == "S"){
							r_cw = "checked";
						}
						
						var fieldSet = '<fieldset><legend>Deliverable Template -- Read Only</legend>'
						+ '<p><label>Title:</label> <input type="text" class="d_name" value="'+values.title+'" readonly /></p>'
						+ '<p><label>Description:</label> <input type="text" class="d_description" value="'+values.description+'" readonly /></p>'						
						+ '<p><label>Type:</label>' 
							+ '<input type="checkbox" name="" class="d_hld" value="HLD" '+r_hld+' onkeydown="return false;" /> HLD ' 
							+ '<input type="checkbox" name="" class="d_ia"  value="IA" ' +r_ia+' onclick="return false;" onkeydown="return false;" /> IA '
							+ '<input type="checkbox" name="" class="d_ad"  value="AD" ' +r_ad+' onclick="return false;" onkeydown="return false;" /> AD '
							+ '<input type="checkbox" name="" class="d_cw"  value="CW" ' +r_cw+' onclick="return false;" onkeydown="return false;" /> CW '
						+ '</p>'						
						+ '</fieldset>';
						
						$(".modal-box").html('<span class="x">X</span>');
						$(".modal-box").append(fieldSet);
						
					}
					
					$(document).on("click", "#update_btn", function(e){
						
						$(".pop-up-edit").hide();
						
						
						var id_row = $(".pop-up-edit").attr("id");
						var table_column = $(".pop-up-edit input").attr("id");
						var input_value = $(".input_edit").val();
						var tab = $(".pop-up-edit").attr("tab");
						var bgColor = $(".pop-up-edit").attr("bgColor");
						
						$.ajax({
							url:"deliverable",
							type:"POST",
							data:{
								value:"UPDATE_ROW",
								input_value_update:input_value,
								id_row_table:id_row,
								table_column:table_column
								
							},
							success:function(response){
								
								if(response == "UPDATED"){
									
									$(".rTable .rTableRow").each(function() {
										
										var id = $(this).attr("id");
										if(id == id_row){
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
						var position = $(this).position();
						var column_table = $(this).attr("id");
						var bgColor = $(this).css("background-color");

						$(".modal").show();
						var c = $(this).html();

						$(".pop-up-edit").attr("id", id_row);
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