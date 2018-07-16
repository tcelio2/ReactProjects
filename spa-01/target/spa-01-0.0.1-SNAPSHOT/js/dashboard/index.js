$(document).ready(function() {

	
	/**    DELETE CLICK **/
	$(document).on("click", ".b_delete", function() {

		var id = $(this).attr("id");
		deletOnServer(id);
	
		return false;
	});

	function deletOnServer(id){
		
		$.ajax({
			url:"dashboard",
			type:"POST",
			data:{
				value:"DELETE",
				projectId: id		
			},
			success:function(response){
				
				 $(".modal").hide();
				 $(".modal-loader").hide();
				 if(response=="DELETED"){
					 $( "#dashboard tbody tr" ).each(function( index ) {
						 var $tds = $(this).find('td');
						 if($tds.length != 0) {
						 var $currText = $tds.eq(0).text();
						 if($currText == id){
							 $tds.parent("tr").fadeOut();
						 	}					 
						 }
					 });
				}else{
					alert("Fail delete Deliverable!!!");
				}
			}
		})		
	}
	
	

	
	
	
	/**    EDIT CLICK **/
	$(document).on("click", ".b_edit", function() {

		var values = {};
		
		values.application = $(this).parent("td").parent("tr").children(".d_application").html();
		values.projectId = $(this).parent("td").parent("tr").children(".d_projectid").html();
		values.projectName = $(this).parent("td").parent("tr").children(".d_projectname").html();						
		values.projectState = $(this).parent("td").parent("tr").children(".d_projectstate").html();
		values.sdlc = $(this).parent("td").parent("tr").children(".d_sdlc").html();
		values.projectStatus = $(this).parent("td").parent("tr").children(".d_projectstatus").html();
		values.issue = $(this).parent("td").parent("tr").children(".d_issue").html();
		values.comments = $(this).parent("td").parent("tr").children(".d_comments").html();
		values.jeopardyList = $(this).parent("td").parent("tr").children(".d_jeopardylist").html();						
		values.piFtps = $(this).parent("td").parent("tr").children(".d_piftps").html();
		values.piFtpsCurrentMonth = $(this).parent("td").parent("tr").children(".d_piftpscurrentmonth").html();
		values.piFtpsNextMonth = $(this).parent("td").parent("tr").children(".d_piftpsnextmonth").html();	
		values.piCrs = $(this).parent("td").parent("tr").children(".d_picrs").html();
		values.piSe = $(this).parent("td").parent("tr").children(".d_pise").html();
		values.piIbmPm = $(this).parent("td").parent("tr").children(".d_piibmpm").html();						
		values.piApm = $(this).parent("td").parent("tr").children(".d_piapm").html();
		values.scRelease = $(this).parent("td").parent("tr").children(".d_screlease").html();	
		values.iType = $(this).parent("td").parent("tr").children(".d_itype").html();
		
		values.scTestingTarget = $(this).attr("scTestingTarget");
		values.scSprint = $(this).attr("scSprint");
		values.scSchedule = $(this).attr("scSchedule");	
		values.iTube = $(this).attr("iTube");
		values.iBc = $(this).attr("iBc");
		values.iInv = $(this).attr("iInv");
		values.iPi = $(this).attr("iInv");
		
		 $(".modal").show();
		 $(".modal-loader").show();
		 $(".modal-box").show();

		makeEdit(values);
		
		return false;
	});
	
	function makeEdit(values){
		
		var fieldSet = '<fieldset><legend>Dashboard Overview -- Edit</legend>'
			+ '<p><label>Application:</label> <input type="text" class="d_application_edit" value="'+values.application+'" readonly /></p>'
			+ '<p><label>Project ID:</label> <input type="text" class="d_projectid_edit" value="'+values.projectId+'" readonly /></p>'					
			+ '<p><label>Project Name:</label> <input type="text" class="d_projectname_edit" value="'+values.projectName+'" /></p>'
			+ '<p><label>State:</label> <input type="text" class="d_projectstate_edit" value="'+values.projectState+'" /></p>'
			+ '<p><label>SLDC:</label> <input type="text"  class="d_sdlc_edit" value="'+values.sdlc+'" /></p>'
			+ '<p><label>Status:</label> <input type="text"  class="d_projectstatus_edit" value="'+values.projectStatus+'" /></p>'
			+ '<p><label>Issue:</label> <input type="text" class="d_issue_edit" value="'+values.issue+'" /></p>'
			+ '<p><label>Comments:</label> <input type="text" class="d_comments_edit" value="'+values.comments+'" /></p>'					
			+ '<p><label>Jeopardy List:</label> <input type="text" class="d_jeopardylist_edit" value="'+values.jeopardyList+'" /></p>'					
			+ '<p><label>FTPs:</label> <input type="text" class="d_piftps_edit" value="'+values.piFtps+'" /></p>'
			+ '<p><label>FTPs - Current Month:</label> <input type="text" class="d_piftpscurrentmonth_edit" value="'+values.piFtpsCurrentMonth+'" /></p>'
			+ '<p><label>FTPs - Next Month:</label> <input type="text" class="d_piftpsnextmonth_edit" value="'+values.piFtpsNextMonth+'" /></p>'					
			+ '<p><label>CRs:</label> <input type="text" class="d_picrs_edit" value="'+values.piCrs+'" /></p>'
			+ '<p><label>SE:</label> <input type="text" class="d_pise_edit" value="'+values.piSe+'" /></p>'
			+ '<p><label>Ibm PM:</label> <input type="text" class="d_piibmpm_edit" value="'+values.piIbmPm+'" /></p>'
			+ '<p><label>APM:</label> <input type="text" class="d_piapm_edit" value="'+values.piApm+'" /></p>'					
			+ '<p><label>Release:</label> <input type="text" class="d_screlease_edit" value="'+values.scRelease+'" /></p>'					
			+ '<p><label>Testing Target:</label> <input type="text" class="d_sctestingtarget_edit" value="'+values.scTestingTarget+'" /></p>'
			+ '<p><label>Sprint:</label> <input type="text" class="d_scsprint_edit" value="'+values.scSprint+'" /></p>'
			+ '<p><label>Schedule:</label> <input type="text" class="d_scschedule_edit" value="'+values.scSchedule+'" /></p>'					
			+ '<p><label>Type:</label> <input type="text" class="d_itype_edit" value="'+values.iType+'" /></p>'
			+ '<p><label>Tube:</label> <input type="text" class="d_itube_edit" value="'+values.iTube+'" /></p>'
			+ '<p><label>BC:</label> <input type="text" class="d_ibc_edit" value="'+values.iBc+'" /></p>'
			+ '<p><label>Inv:</label> <input type="text" class="d_iinv_edit" value="'+values.iInv+'" /></p>'
			+ '<p><label>PI:</label> <input type="text" class="d_ipi_edit" value="'+values.iPi+'" /></p>'
			+ '<p><button type="button" value="b_view" id="'+values.projectId+'" class="b_submit_edit">Submit</button></p>'
			+ '</fieldset>';
		
		$(".modal-box").html('<span class="x">X</span>');
		$(".modal-box").append(fieldSet);
		
	}
	
	$(document).on("click", ".b_submit_edit", function() {
		
			var template = {};
			
			template.application = $(".d_application_edit").val();
			template.projectId = $(this).attr("id");
			
			template.projectName = $(".d_projectname_edit").val();
			template.projectState = $(".d_projectstate_edit").val();
			template.sdlc = $(".d_sdlc_edit").val();
			template.projectStatus = $(".d_projectstatus_edit").val();			
			template.issue = $(".d_issue_edit").val();			
			template.comments = $(".d_comments_edit").val();
			template.jeopardyList = $(".d_jeopardylist_edit").val();
			template.piFtps = $(".d_piftps_edit").val();
			template.piFtpsCurrentMonth = $(".d_piftpscurrentmonth_edit").val();
			template.piFtpsNextMonth = $(".d_piftpsnextmonth_edit").val();					
			template.piCrs = $(".d_picrs_edit").val();			
			template.piSe = $(".d_pise_edit").val();
			template.piIbmPm = $(".d_piibmpm_edit").val();
			template.piApm = $(".d_piapm_edit").val();
			template.scRelease = $(".d_screlease_edit").val();
			template.scTestingTarget = $(".d_sctestingtarget_edit").val();							
			template.scSprint = $(".d_scsprint_edit").val();			
			template.scSchedule = $(".d_scschedule_edit").val();
			template.iType = $(".d_itype_edit").val();
			template.iTube = $(".d_itube_edit").val();
			template.iBc = $(".d_ibc_edit").val();
			template.iInv = $(".d_iinv_edit").val();
			template.iPi = $(".d_ipi_edit").val();
	
			var d_projectName = $(".d_projectname_edit").val();
			var d_projectStatus = $(".d_projectstatus_edit").val();			
			
			if (!d_projectName || !d_projectStatus) {
				alert("Project Name and Status are empty!");
			} else {
				loader_update(template);
			}

			return false;
	});
	
	function loader_update(template_value) {
		updateDashboardAjax(template_value);		
		return false;
	}
	
	function updateDashboardAjax(template){
	
		$.ajax({
			url:"dashboard",
			type:"POST",
			data:{
				value:"UPDATE",
				application: template.application,
				projectId: template.projectId,
				projectName: template.projectName,
				projectState: template.projectState,
				sdlc: template.sdlc,
				projectStatus: template.projectStatus,			
				issue: template.issue,
				comments: template.comments,
				jeopardyList: template.jeopardyList,
				piFtps: template.piFtps,
				piFtpsCurrentMonth: template.piFtpsCurrentMonth,
				piFtpsNextMonth: template.piFtpsNextMonth,
				piCrs: template.piCrs,
				piSe: template.piSe,
				piIbmPm: template.piIbmPm,
				piApm: template.piApm,
				scRelease: template.scRelease,
				scTestingTarget: template.scTestingTarget,
				scSprint: template.scSprint,				
				scSchedule: template.scSchedule,
				iType: template.iType,
				iTube: template.iTube,
				iBc: template.iBc,
				iInv: template.iInv,
				iPi: template.iPi
				
			},
			success:function(response){
				
				 if(response=="UPDATED"){
					 var num = 0;
					 $( "#dashboard tbody tr" ).each(function( index ) {
						 num += 1;
						 var $tds = $(this).find('td');
						 if($tds.length != 0) {
						 var $currText = $tds.eq(1).text();
						 
						 if($currText == template.projectId){
							 
						     $(".modal").hide();
							 $(".modal-loader").hide();
							 $(".modal-box").hide();
								 
							  var new_line = '<tr>'
								  +'<td class="d_application">'+template.application+'</td>'
								  +'<td class="d_projectid">'+template.projectId+'</td>'
								  +'<td class="d_projectname">'+template.projectName+'</td>'
								  +'<td class="d_projectstate">'+template.projectState+'</td>'
								  +'<td class="d_sdlc">'+template.sdlc+'</td>'
								  +'<td class="d_projectstatus">'+template.projectStatus+'</td>'								  
								  +'<td class="d_issue">'+template.issue+'</td>'
								  +'<td class="d_comments">'+template.comments+'</td>'
								  +'<td class="d_jeopardylist">'+template.jeopardyList+'</td>'								  
								  +'<td class="d_piftps">'+template.piFtps+'</td>'
								  +'<td class="d_piftpscurrentmonth">'+template.piFtpsCurrentMonth+'</td>'
								  +'<td class="d_piftpsnextmonth">'+template.piFtpsNextMonth+'</td>'	
								  +'<td class="d_picrs">'+template.piCrs+'</td>'
								  +'<td class="d_pise">'+template.piSe+'</td>'
								  +'<td class="d_piibmpm">'+template.piIbmPm+'</td>'								  
								  +'<td class="d_piapm">'+template.piApm+'</td>'
								  +'<td class="d_screlease">'+template.scRelease+'</td>'
								  +'<td class="d_itype">'+template.iType+'</td>'							  
								  +'<td>'
								  +'<button type="button" class="b_delete" id="'+template.projectId+'">Delete</button>'							  
								  +'<button type="button" scTestingTarget="'+template.scTestingTarget+'" scSprint="'+template.scSprint+'" scSchedule="'+template.scSchedule+'" iTube="'+template.iTube+'" iBc="'+template.iBc+'" iInv="'+template.iInv+'" iPi="'+template.iPi+'" class="b_edit" value="b_edit" id="'+template.id+'">Edit</button>'
								  +'<button type="button" scTestingTarget="'+template.scTestingTarget+'" scSprint="'+template.scSprint+'" scSchedule="'+template.scSchedule+'" iTube="'+template.iTube+'" iBc="'+template.iBc+'" iInv="'+template.iInv+'" iPi="'+template.iPi+'" class="b_view" value="b_view" id="'+template.projectId+'">View</button>'							  
								  +'</td>'
								  +'</tr>'

								  $tds.parent("tr").replaceWith(new_line);
						 	}
						 }
					 });
				}else{
					alert("Fail update Dashboard!!!");
				}				
			}
		})
			return false;
	}

			
		
	/*$('ul.tabs li').click(function(){
		
	})*/
	/**    VIEW CLICK **/
	$(document).on("click", ".b_view", function() {
						
//		var values = {};
//						
//		values.application = $(this).parent("td").parent("tr").children(".d_application").html();
//		values.projectId = $(this).parent("td").parent("tr").children(".d_projectid").html();
//		values.projectName = $(this).parent("td").parent("tr").children(".d_projectname").html();						
//		values.projectState = $(this).parent("td").parent("tr").children(".d_projectstate").html();
//		values.sdlc = $(this).parent("td").parent("tr").children(".d_sdlc").html();
//		values.projectStatus = $(this).parent("td").parent("tr").children(".d_projectstatus").html();
//		values.issue = $(this).parent("td").parent("tr").children(".d_issue").html();
//		values.comments = $(this).parent("td").parent("tr").children(".d_comments").html();
//		values.jeopardyList = $(this).parent("td").parent("tr").children(".d_jeopardylist").html();						
//		values.piFtps = $(this).parent("td").parent("tr").children(".d_piftps").html();
//		values.piFtpsCurrentMonth = $(this).parent("td").parent("tr").children(".d_piftpscurrentmonth").html();
//		values.piFtpsNextMonth = $(this).parent("td").parent("tr").children(".d_piftpsnextmonth").html();	
//		values.piCrs = $(this).parent("td").parent("tr").children(".d_picrs").html();
//		values.piSe = $(this).parent("td").parent("tr").children(".d_pise").html();
//		values.piIbmPm = $(this).parent("td").parent("tr").children(".d_piibmpm").html();						
//		values.piApm = $(this).parent("td").parent("tr").children(".d_piapm").html();
//		values.scRelease = $(this).parent("td").parent("tr").children(".d_screlease").html();	
//		values.iType = $(this).parent("td").parent("tr").children(".d_itype").html();
//		
//		values.scTestingTarget = $(this).attr("scTestingTarget");
//		values.scSprint = $(this).attr("scSprint");
//		values.scSchedule = $(this).attr("scSchedule");	
//		values.iTube = $(this).attr("iTube");
//		values.iBc = $(this).attr("iBc");
//		values.iInv = $(this).attr("iInv");
//		values.iPi = $(this).attr("iInv");
//		
//				
//		$(".modal").show();
//		$(".modal-box").show();						
//						
//		makeView(values);
				
	//	$(".tab-container").show();
		//alert("adsf");
		
		$(".dashboard-box .container").empty();
		$(".modal").show();
		$(".dashboard-box").show();
		
		var html = 
			"<ul class='tabs'>"
			+"<li class='tab-link current' data-tab='tab-1'>Status</li>"
			+"<li class='tab-link' data-tab='tab-2'>project Info</li>"
			+"<li class='tab-link' data-tab='tab-3'>Schedule</li>"
			+"<li class='tab-link' data-tab='tab-4'>Impact</li>"
			+"<li class='tab-link' data-tab='tab-5'>Requirement</li>"
			+"<li class='tab-link' data-tab='tab-6'>Design</li>"
			+"<li class='tab-link' data-tab='tab-7'>Development</li>"
			+"</ul>"
			+"<div id='tab-1' class='tab-content current'>"
			+"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +"laboris nisi ut aliquip ex ea commodo consequat."
			+"</div>"
			+"<div id='tab-2' class='tab-content'>"
			+"Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt" +"mollit anim id est laborum."
			+"</div>"
			+"<div id='tab-3' class='tab-content'>"
			+"Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu" +"fugiat nulla pariatur."
			+"</div>"
			+"<div id='tab-4' class='tab-content'>"
			+"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
			+"</div>"
			+"<div id='tab-5' class='tab-content'>"
			+"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +"laboris nisi ut aliquip ex ea commodo consequat."
			+"</div>"
			+"<div id='tab-6' class='tab-content'>"
			+"Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt" +"mollit anim id est laborum."
			+"</div>"
			+"<div id='tab-7' class='tab-content'>"
			+"Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
			+"</div>"

		$(".dashboard-box .container").append(html);
		$(".dashboard-box .container div#tabs").tabs("refresh");
		
		return false;			
	});
				
	
	
	
	
	
	
	
	function makeView(values){
						
		var fieldSet = '<fieldset><legend>Dashboard Overview -- Read Only</legend>'
						+ '<p><label>Application:</label> <input type="text" class="d_application" value="'+values.application+'" readonly /></p>'
						+ '<p><label>Project ID:</label> <input type="text" class="d_projectid" value="'+values.projectId+'" readonly /></p>'					
						+ '<p><label>Project Name:</label> <input type="text" class="d_projectname" value="'+values.projectName+'" readonly /></p>'
						+ '<p><label>State:</label> <input type="text" class="d_state" value="'+values.projectState+'" readonly /></p>'
						+ '<p><label>SLDC:</label> <input type="text"  class="d_sdlc" value="'+values.sdlc+'" readonly /></p>'
						+ '<p><label>Status:</label> <input type="text"  class="d_status" value="'+values.projectStatus+'" readonly /></p>'
						+ '<p><label>Issue:</label> <input type="text" class="d_issue" value="'+values.issue+'" readonly /></p>'
						+ '<p><label>Comments:</label> <input type="text" class="d_comments" value="'+values.comments+'" readonly /></p>'					
						+ '<p><label>Jeopardy List:</label> <input type="text" class="d_jeopardylist" value="'+values.jeopardyList+'" readonly /></p>'					
						+ '<p><label>FTPs:</label> <input type="text" class="d_piftps" value="'+values.piFtps+'" readonly /></p>'
						+ '<p><label>FTPs - Current Month:</label> <input type="text" class="d_piftpscurrentmonth" value="'+values.piFtpsCurrentMonth+'" readonly /></p>'
						+ '<p><label>FTPs - Next Month:</label> <input type="text" class="d_piftpsnextmonth" value="'+values.piFtpsNextMonth+'" readonly /></p>'					
						+ '<p><label>CRs:</label> <input type="text" class="d_picrs" value="'+values.piCrs+'" readonly /></p>'
						+ '<p><label>SE:</label> <input type="text" class="d_pise" value="'+values.piSe+'" readonly /></p>'
						+ '<p><label>Ibm PM:</label> <input type="text" class="d_piibmpm" value="'+values.piIbmPm+'" readonly /></p>'
						+ '<p><label>APM:</label> <input type="text" class="d_piapm" value="'+values.piApm+'" readonly /></p>'					
						+ '<p><label>Release:</label> <input type="text" class="d_screlease" value="'+values.scRelease+'" readonly /></p>'					
						+ '<p><label>Testing Target:</label> <input type="text" class="d_sctestingtarget" value="'+values.scTestingTarget+'" readonly /></p>'
						+ '<p><label>Sprint:</label> <input type="text" class="d_cssprint" value="'+values.scSprint+'" readonly /></p>'
						+ '<p><label>Schedule:</label> <input type="text" class="d_scschedule" value="'+values.scSchedule+'" readonly /></p>'					
						+ '<p><label>Type:</label> <input type="text" class="d_itype" value="'+values.iType+'" readonly /></p>'
						+ '<p><label>Tube:</label> <input type="text" class="d_itube" value="'+values.iTube+'" readonly /></p>'
						+ '<p><label>BC:</label> <input type="text" class="d_ibc" value="'+values.iBc+'" readonly /></p>'
						+ '<p><label>Inv:</label> <input type="text" class="d_iinv" value="'+values.iInv+'" readonly /></p>'
						+ '<p><label>PI:</label> <input type="text" class="d_ipi" value="'+values.iPi+'" readonly /></p>'
						+ '</fieldset>';
											
						$(".modal-box").html('<span class="x">X</span>');
						$(".modal-box").append(fieldSet);
						
	}
		$(document).on("click", ".x", function() {
			$(".modal").hide();
			$(".dashboard-box").hide();
			$(".modal-box-filter").hide();
			$(".modal-box").hide();
			$(".modal-loader").hide();
			$(".pop-up-edit").hide();
			$(".content").css({"position":"relative"});
		});
					

		function AddLoader(deliverable_id){
			
			$(".modal").show();
			$(".modal-loader").show();
			
			return false;
		}
		
		
		$(".a_role").change(function(){
			
			AddLoader();
			 setTimeout(function(){
				 //getAllDelivebrablesForUser(deliverable_id);
				 alert("dsaf");
			 }, 2000);
			
		});
		
		
		//0 - methodology 1 - PM
		$(".filter_btn").click(function(){
			
			$(".modal").show();
			$(".modal-box-filter").show();
			$(".content").css({"position":"fixed"});
			
			
			return false;
			
		});
		
		
		
		
		
		

		
		
		 
		$(document).on("change", ".dropdown_filter_manager", function(){
			
			
			//alert("dasf");
			var choose_value = $(".dropdown_filter_manager option:selected").attr("id");//text();
			if(choose_value !== "0"){
				$(".dropdown_filter_group").prop('disabled','disabled');
			}else{
				 //event.preventDefault();
				   $(".dropdown_filter_group").prop('disabled', false); // Element(s) are now enabled.	
			}
			
			return false;
		});
		
		//0 - methodology 1 - PM
		$("#go_btn").click(function(){
			
			$(".modal-box-filter").hide();
			$(".modal-loader").show();
			
			var filter_type = "";
			var dashboard_filter = $(".dropdown_filter_group option:selected").attr("id");
			var dropdown_filter_manager = $(".dropdown_filter_manager option:selected").attr("id");
			
			//alert("dd"+dropdown_filter_manager);
			
			if(dropdown_filter_manager != "0"){
			
				window.location.replace("dashboardFilter?pm="+dropdown_filter_manager+"&filter=''");
				
			}
			if(dropdown_filter_manager == "0"){
				
					//alert("->"+dashboard_filter);
					if(dashboard_filter == "0"){
						//filter_type = "METHODOLOGY_FILTER";
						window.location.replace("dashboardFilter?filter=methodology&pm=''");
					}
					
					if(dashboard_filter == "1"){
						//filter_type = "PM_FILTER";
						window.location.replace("dashboardFilter?filter=pm&pm=''");
					}
				
			}
			
			return false;
			
		});
		
		
		
		function send_filter(filter_type_){
			//$.get( "dashboardFilter?ok=132", { name:"Donald", town:"Ducktown" });
			window.location.replace("dashboardFilter?filter=pm&pm=''");
			return false;
		}
		
		
		
		
		
		$(".filter_tabs").click(function(){
			
			$(".modal-loader").show();
			$(".modal").show();
			
			
			$.ajax({
				url:"dashboard",
				type:"POST",
				data:{
					value:"TAB"
					
					
					
				},
				success:function(response){
					$(".dinamic-ajax").append(response);
					$(".modal-loader").hide();
					$(".modal").hide();
								
				}
			})
		
			
		});
		
		//design mouseover and click table
		$(document).on("mouseover", ".design_details", function(e){
			
			var id = $(this).attr("id");
			var position = $(this).position();

			if(id != ""){
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").show();
				var width_ =  $(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").width();
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").show();
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").css({"top":position.top - 140});
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").css({"marginLeft":- width_/2});
				
				//colors
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_tube").css("background-color","#77f077");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_bc").css("background-color","rgb(183, 183, 255) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_inv").css("background-color","pink");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ia_ia").css("background-color","#fed07d");
				
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_tube").css("background-color","rgb(179, 255, 238) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_bc").css("background-color","rgb(198, 198, 198) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_inv").css("background-color","rgb(254, 173, 166) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_cw_pi").css("background-color","rgb(177, 255, 186) none repeat scroll 0% 0%");
				
			}   
		});
		$(document).on("mouseout", ".design_details", function(e){
	
			var mode = $(this).parent(".rTableCell").attr("mode");//parent(".rTableRow").find(".pop-up-info").attr("mode");
			
			if(mode != "show"){
				var position = $(this).position();
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").fadeOut(1000);
				
				
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_tube").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_bc").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_inv").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ia_ia").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_tube").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_bc").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_inv").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_cw_pi").css("background-color","#fffed7");
			}
			
			
			
		});

		
		$(document).on("click",".design_details", function(e){
			
			var id = $(this).attr("id");
			var position = $(this).position();
			var mode = $(this).parent(".rTableCell").attr("mode");
			if(id != "" && mode != "show"){
				
				$(this).parent(".rTableCell").attr("mode","show");
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").show();
				
				var width_ =  $(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").width();
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").show();
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").css({"top":position.top - 140});
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").css({"marginLeft":- width_/2});
				//colors
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_tube").css("background-color","#77f077");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_bc").css("background-color","rgb(183, 183, 255) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_inv").css("background-color","pink");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ia_ia").css("background-color","#fed07d");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_tube").css("background-color","rgb(179, 255, 238) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_bc").css("background-color","rgb(198, 198, 198) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_inv").css("background-color","rgb(254, 173, 166) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_cw_pi").css("background-color","rgb(177, 255, 186) none repeat scroll 0% 0%");
				
			}  
			if(id != "" && mode == "show"){
				
				$(this).parent(".rTableCell").attr("mode","");
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").fadeOut(1000);
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_tube").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_bc").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_inv").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ia_ia").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_tube").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_bc").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_inv").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_cw_pi").css("background-color","#fffed7");
				
			}
			
			
			 e.preventDefault();
			
		});
		//end of click and mouseover design
		
		//development mouseover and click table
		$(document).on("mouseover", ".development_details", function(e){
			
			var id = $(this).attr("id");
			var position = $(this).position();
			
			if(id != ""){
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").show();
				var width_ =  $(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").width();
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").show();
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").css({"top":position.top - 140});
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").css({"marginLeft":- width_/2});
				
				//colors
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_utd_tube").css("background-color","#77f077");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_utd_bc").css("background-color","rgb(255, 254, 183)");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_utd_inv").css("background-color","pink");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_std_stsr").css("background-color","rgb(255, 216, 143)");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_std_testdata").css("background-color","rgb(148, 255, 225)");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_tap_pi").css("background-color","rgb(228, 227, 227)");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_code_tube").css("background-color","rgb(249, 210, 255)");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_code_bc").css("background-color","rgb(251, 168, 200)");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_code_inv").css("background-color","rgb(158, 224, 251)");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_ut_tube").css("background-color","rgb(177, 177, 177)");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_ut_bc").css("background-color","rgb(249, 242, 111)");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_ut_inv").css("background-color","rgb(249, 209, 255)");
				
				
			}   
		});
		$(document).on("mouseout", ".development_details", function(e){
	
			var mode = $(this).parent(".rTableCell").attr("mode");//parent(".rTableRow").find(".pop-up-info").attr("mode");
			
			if(mode != "show"){
				var position = $(this).position();
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").fadeOut(1000);
				//colors
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_utd_tube").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_utd_bc").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_utd_inv").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_std_stsr").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_std_testdata").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_tap_pi").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_code_tube").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_code_bc").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_code_inv").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_ut_tube").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_ut_bc").css("background-color","#d2d2ff");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#dev_ut_inv").css("background-color","#d2d2ff");
			}
			
			
			
		});

		
		$(document).on("click",".development_details", function(e){
			
			var id = $(this).attr("id");
			var position = $(this).position();
			var mode = $(this).parent(".rTableCell").attr("mode");
			if(id != "" && mode != "show"){
				
				$(this).parent(".rTableCell").attr("mode","show");
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").show();
				
				var width_ =  $(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").width();
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").show();
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").css({"top":position.top - 140});
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").css({"marginLeft":- width_/2});
				//colors
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_tube").css("background-color","#77f077");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_bc").css("background-color","rgb(183, 183, 255) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_inv").css("background-color","pink");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ia_ia").css("background-color","#fed07d");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_tube").css("background-color","rgb(179, 255, 238) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_bc").css("background-color","rgb(198, 198, 198) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_inv").css("background-color","rgb(254, 173, 166) none repeat scroll 0% 0%");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_cw_pi").css("background-color","rgb(177, 255, 186) none repeat scroll 0% 0%");
				
			}  
			if(id != "" && mode == "show"){
				
				$(this).parent(".rTableCell").attr("mode","");
				$(this).parent(".rTableCell").parent(".rTableRow").find(".pop-up-info").fadeOut(1000);
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_tube").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_bc").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_hld_inv").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ia_ia").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_tube").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_bc").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_ad_inv").css("background-color","#fffed7");
				$(this).parent(".rTableCell").parent(".rTableRow").find("#des_cw_pi").css("background-color","#fffed7");
				
			}
			
			
			 e.preventDefault();
			
		});
		//end of click and mouseover development
		
		
		
		$(document).on("click", "#update_btn", function(e){
			
			$(".pop-up-edit").fadeOut(1000);
			var fieldset = $(".pop-up-edit").attr("fieldset");
			var id_row = $(".pop-up-edit").attr("id");
			var table_column = $(".pop-up-edit input").attr("id");
			var input_value = $(".input_edit").val();
			var tab = $(".pop-up-edit").attr("tab");
			var bgColor = $(".pop-up-edit").attr("bgColor");
			var tab_especial = $(".pop-up-edit").attr("tab_especial");
			
			$.ajax({
				url:"dashboard",
				type:"POST",
				data:{
					value:"UPDATE_ROW",
					input_value_update:input_value,
					id_row_table:id_row,
					table_column:table_column
					
				},
				success:function(response){
					
					if(response == "UPDATED"){
							if(tab_especial == ""){
								$("."+fieldset).find('#'+tab).find(".rTable2 .rTableRow").each(function(){
										var id = $(this).attr("id");
										if(id == id_row){
											$(this).find('#'+table_column).html(input_value).animate({backgroundColor: '#FFFF00'}, 'slow').animate({backgroundColor: bgColor}, 2000);
										}
									})
							}
							if(tab_especial != ""){
								$("."+fieldset).find('#'+tab).find(".rTable2 .rTableRow").each(function(){
									var id = $(this).attr("id");
									if(id == id_row){
										$(this).find(".pop-up-info").find(".rTableRow").find('#'+table_column).html(input_value).animate({backgroundColor: '#FFFF00'}, 'slow').animate({backgroundColor: bgColor}, 2000);
									}
								})
							}
					}
					$(".modal-loader").hide();
					$(".modal").hide();
								
				}
			})
			
			 e.preventDefault();
			
		});
		
		
		
		$(".rTableCell+.edit_").click(function(e){
			
			var fieldset = $(this).closest("fieldset").attr("class");
			var id_row = $(this).parent(".rTableRow").attr("id");//text();
			var position = $(this).position();
			var column_table = $(this).attr("id");
			var tab = $(this).parent(".rTableRow").parent(".rTable2").parent().attr("id");
			var bgColor = $(this).css("background-color");
			
			$(".modal").show();
			var c = $(this).html();
			
			$(".pop-up-edit").attr("fieldset", fieldset);
			$(".pop-up-edit").attr("id", id_row);
			$(".pop-up-edit").css({"top":position.top});
			$(".pop-up-edit input").val("");
			$(".pop-up-edit input").val(c);
			$(".pop-up-edit input").attr("id",column_table);
			$(".pop-up-edit").attr("tab", tab);
			$(".pop-up-edit").attr("bgColor", bgColor);
			$(".pop-up-edit").show();
			
			 e.preventDefault();
		});
		$(".rTableCellInfo+.edit_").click(function(e){
			
			var fieldset = $(this).closest("fieldset").attr("class");
			var id_row = $(this).parent(".rTableRow").attr("id");//text();
			var position = $(this).position();
			var column_table = $(this).attr("id");
			var tab = $(this).parent(".rTableRow").parent(".pop-up-info").parent(".rTableRow").parent(".rTable2").parent().attr("id");
			var bgColor = $(this).css("background-color");
			var tab_especial =  $(this).parent(".rTableRow").attr("tab_especial");
			$(".modal").show();
			var c = $(this).html();
			$(".pop-up-edit").attr("fieldset", fieldset);
			$(".pop-up-edit").attr("id", id_row);
			$(".pop-up-edit").css({"top":position.top});
			$(".pop-up-edit input").val("");
			$(".pop-up-edit input").val(c);
			$(".pop-up-edit input").attr("id",column_table);
			$(".pop-up-edit").attr("tab", tab);
			$(".pop-up-edit").attr("bgColor", bgColor);
			$(".pop-up-edit").attr("tab_especial", tab_especial);
			$(".pop-up-edit").show();
			
			 e.preventDefault();
		});
		
});
