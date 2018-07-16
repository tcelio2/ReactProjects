package com.ibm.att.spa01.util;

import java.util.List;

import com.ibm.att.spa01.bean.DashboardBean;
import com.ibm.att.spa01.bean.UserBean;

public class CreateHtml {

    
    public CreateHtml(){
	
    }
    
    
    public String createHtmlForUser(UserBean userBean, String row){
	
	StringBuilder fullHtml = new StringBuilder();
	
	fullHtml.append("<tr id="+userBean.getId()+" class="+row+" role='row'>"
		+"<td class='sorting_1'>"+userBean.getUserName()+"</td>"
		+"<td><input id='row-4-age' name='row-4-age' value='"+userBean.getEmail()+"' type='text' disabled ></td>"
		+"<td><input id='row-4-position' name='row-4-position' value='"+userBean.getUserName()+"' type='text' disabled ></td>"
		+"<td><select size='1' id='row-4-office' name='row-4-office' disabled >");
    
    	if(userBean.getRole().matches("MANAGER")){
    	    fullHtml.append("<option value='"+userBean.getRole()+"' selected='selected'>"+userBean.getRole()+"</option>");
    	}else{
    	    fullHtml.append("<option value='MANAGER' >MANAGER</option>");
    	}
    
    	if(userBean.getRole().matches("TEAM LEADER")){
    	    fullHtml.append("<option value='"+userBean.getRole()+"' selected='selected'>"+userBean.getRole()+"</option>");
    	}else{
    	    fullHtml.append("<option value='TEAM LEADER' >TEAM LEADER</option>");
    	}
    	if(userBean.getRole().matches("DEVELOPER")){
    	    fullHtml.append("<option value='"+userBean.getRole()+"' selected='selected'>"+userBean.getRole()+"</option>");
    	}else{
    	    fullHtml.append("<option value='DEVELOPER' >DEVELOPER</option>");
    	}
    	if(userBean.getRole().matches("ADMIN")){
    	    fullHtml.append("<option value='"+userBean.getRole()+"' selected='selected'>"+userBean.getRole()+"</option>");
    	}else{
    	    fullHtml.append("<option value='ADMIN' >ADMIN</option>");
    	}
    	
    	fullHtml.append("</select></td>"
		+"<td><a href='#' class='admin_save edit_admin' id="+userBean.getId()+">edit</a> <a href='#' id="+userBean.getId()+" class='admin_update'>update</a>"
			+ "<a href='#' id="+userBean.getId()+" class='admin_delete delete'>x</a></td>"
		+"</tr>");
	
	return fullHtml.toString();
	
    }
    
    public static String getFildSetAndTabs(int num){
	
	String num2Str = "";
	
	//if(num != 0){
	     num2Str = String.valueOf(num);
	//}
	
	 
	
	String value = "<ul class='tabs"+num2Str+"'><li class='tab-link"+num2Str+" current project_tab' data-tab='tab-"+num2Str+"1'>Project</li><li class='tab-link"+num2Str+" overview_tab' data-tab='tab-"+num2Str+"2'>Overview</li><li class='tab-link"+num2Str+" detail requirement_tab' data-tab='tab-"+num2Str+"3'>Requirement</li><li class='tab-link"+num2Str+" detail design_tab' data-tab='tab-"+num2Str+"4'>Design</li><li class='tab-link"+num2Str+" detail development_tab' data-tab='tab-"+num2Str+"5'>Development</li></ul>";
	
	return value;
	
    }
    
    public static String getTabOne(int num){
	
	String num2Str = "";
	
	//if(num != 0){
	     num2Str = String.valueOf(num);
	//}
	
	String value = "<div id='tab-"+num2Str+"1' class='tab-content"+num2Str+" current'>"
							+"<div class='rTable2'>"
							    +"<div class='rTableHead'></div>"
								+"<div class='rTableHead' style='width:130px'>UB Project Tracking</div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'>Project Status</div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'>Project Info</div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'></div>"
								+"<div class='rTableHead'></div>"
						+"<div class='rTableRow'>"
								+"<div class='rTableCellFirst ub_project_tracking_row'><span style='font-weight: bold;'>Application</span></div>"
								+"<div class='rTableCellFirst ub_project_tracking_row'><span style='font-weight: bold;'>Project ID</span></div>"
	  							+"<div class='rTableCellFirst ub_project_tracking_row medium'><span style='font-weight: bold;'>Project Name</span></div>"
							 	+"<div class='rTableCellFirst project_status_row'><span style='font-weight: bold;'>State</span></div>"
								+"<div class='rTableCellFirst project_status_row'><span style='font-weight: bold;'>SDLC</span></div>"
								+"<div class='rTableCellFirst project_status_row'><span style='font-weight: bold;'>Status</span></div>"					
								+"<div class='rTableCellFirst project_status_row'><span style='font-weight: bold;'>Issue</span></div>"
								+"<div class='rTableCellFirst project_status_row'><span style='font-weight: bold;'>Comments</span></div>"
								+"<div class='rTableCellFirst project_status_row'><span style='font-weight: bold;'>Jeopardy List</span></div>"
 								+"<div class='rTableCellFirst project_info_row'><span style='font-weight: bold;'>ftp's</span></div>"
								+"<div class='rTableCellFirst project_info_row'><span style='font-weight: bold;' title='FTPs-Current Month'>ftp's CM</span></div>"
								+"<div class='rTableCellFirst project_info_row'><span style='font-weight: bold;'  title='FTPs-Next Month'>ftp's NM</span></div>"
								+"<div class='rTableCellFirst project_info_row'><span style='font-weight: bold;'>CRs</span></div>"
								+"<div class='rTableCellFirst project_info_row'><span style='font-weight: bold;'>SE</span></div>"				
								+"<div class='rTableCellFirst project_info_row'><span style='font-weight: bold;'>IBM PM</span></div>"
								+"<div class='rTableCellFirst project_info_row'><span style='font-weight: bold;'>APM</span></div>"
						+"</div>";
	return value;
    }
    
    public static String getTabTwo(int num){
	
	String num2Str = "";
//	String num2Str_ = "";
//	boolean isDoubleDigit = (num > 9 && num < 100) || (num < -9 && num > -100);
//	if(isDoubleDigit){
	     num2Str = String.valueOf(num);
	//}
	
	String value = "<div id='tab-"+num2Str+"2' class='tab-content"+num2Str+"'>"
							+"<div class='rTable2'>"
							     		+"<div class='rTableHead'></div>"
										+"<div class='rTableHead' style='width:130px'>UB Project Tracking</div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'>Schedule</div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'>Impact</div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'>Requirement</div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'>Design</div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'>Development</div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'></div>"
										+"<div class='rTableHead'></div>"
							+"<div class='rTableRow'>"
		  	 						 +"<div class='rTableCellFirst ub_project_tracking_row'><span style='font-weight: bold;'>Application</span></div>"
									 +"<div class='rTableCellFirst ub_project_tracking_row'><span style='font-weight: bold;'>Project ID</span></div>"
									 +"<div class='rTableCellFirst ub_project_tracking_row medium'><span style='font-weight: bold;'>Project Name</span></div>"
								 	 +"<div class='rTableCellFirst release_row'><span style='font-weight: bold;'>Release</span></div>"
								 	 +"<div class='rTableCellFirst release_row'><span style='font-weight: bold;'>Testing Target</span></div>"
								 	 +"<div class='rTableCellFirst release_row'><span style='font-weight: bold;'>Sprint</span></div>"
								 	 +"<div class='rTableCellFirst release_row'><span style='font-weight: bold;'>Schedule</span></div>"
									 +"<div class='rTableCellFirst impact_row'><span style='font-weight: bold;'>Type</span></div>"
									 +"<div class='rTableCellFirst impact_row'><span style='font-weight: bold;'>TUBE</span></div>"
									 +"<div class='rTableCellFirst impact_row'><span style='font-weight: bold;'>BC</span></div>"
									 +"<div class='rTableCellFirst impact_row'><span style='font-weight: bold;'>INV</span></div>"
									 +"<div class='rTableCellFirst impact_row'><span style='font-weight: bold;'>PI</span></div>"
									 +"<div class='rTableCellFirst requirement_row'><span style='font-weight: bold;'>SRS</span></div>"
									 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>HLD</span></div>"
									 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>IA</span></div>"
									 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>AD</span></div>"
									 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>CW</span></div>"
									 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>Unit Test Docs</span></div>"
									 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>System Test Docs</span></div>"
									 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>TAP</span></div>"
									 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>CODE</span></div>"
									 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>UT</span></div>"
							+"</div>";
	return value;
    }
    
    public static String getTabThree(int num){
	
	String num2Str = "";
	
	//if(num != 0){
	     num2Str = String.valueOf(num);
	//}
	
	
	String value = "<div id='tab-"+num2Str+"3' class='tab-content"+num2Str+"'>"
						+"<div class='rTable2'>"
									        +"<div class='rTableHead'></div>"
											+"<div class='rTableHead' style='width:130px'>UB Project Tracking</div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'>Requirement</div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
									 +"<div class='rTableRow'>"
		     								 +"<div class='rTableCellFirst ub_project_tracking_row'><span style='font-weight: bold;'>Application</span></div>"
											 +"<div class='rTableCellFirst ub_project_tracking_row'><span style='font-weight: bold;'>Project ID</span></div>"
											 +"<div class='rTableCellFirst ub_project_tracking_row medium'><span style='font-weight: bold;'>Project Name</span></div>"
										 	 +"<div class='rTableCellFirst requirement_row cc'><span style='font-weight: bold;'>SRS</span></div>"
											 +"<div class='rTableCellFirst requirement_row cc'><span style='font-weight: bold;'>Status</span></div>"
											 +"<div class='rTableCellFirst requirement_row cc'><span style='font-weight: bold;'>Baseline Date</span></div>"					
											 +"<div class='rTableCellFirst requirement_row cc'><span style='font-weight: bold;'>Due Date</span></div>"
											 +"<div class='rTableCellFirst requirement_row cc'><span style='font-weight: bold;'>Planned %</span></div>"
									+"</div>";
	return value;
    }
    
    public static String getTabFour(int num){
	String num2Str = "";
	
	//if(num != 0){
	     num2Str = String.valueOf(num);
	//}
	String value = "<div id='tab-"+num2Str+"4' class='tab-content"+num2Str+"'>"
						+"<div class='rTable2'>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'  style='width:130px'>UB Project Tracking</div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'>Design</div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
											+"<div class='rTableHead'></div>"
									 +"<div class='rTableRow'>"
									      	 +"<div class='rTableCellFirst ub_project_tracking_row'><span style='font-weight: bold;'>Application</span></div>"
											 +"<div class='rTableCellFirst ub_project_tracking_row'><span style='font-weight: bold;'>Project ID</span></div>"
											 +"<div class='rTableCellFirst ub_project_tracking_row medium'><span style='font-weight: bold;'>Project Name</span></div>"
										 	 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>HLD</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>tube</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>bc</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>inv</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>pi</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>IA</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>ia</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>AD</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>tube</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>bc</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>inv</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>CW</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>pi</span></div>"
											 +"<div class='rTableCellFirst design_row'><span style='font-weight: bold;'>DETAIL</span></div>"		
									+"</div>";
	return value;
    }
    
    public static String getTabFive(int num){
	String num2Str = "";
	
	//if(num != 0){
	     num2Str = String.valueOf(num);
	//}
	
	String value = "<div id='tab-"+num2Str+"5' class='tab-content"+num2Str+"'>"
						+"<div class='rTable2'>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'  style='width:130px'>UB Project Tracking</div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'>Development</div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									+"<div class='rTableHead'></div>"
									 +"<div class='rTableRow'>"
				                             +"<div class='rTableCellFirst ub_project_tracking_row'><span style='font-weight: bold;'>Application</span></div>"
											 +"<div class='rTableCellFirst ub_project_tracking_row'><span style='font-weight: bold;'>Project ID</span></div>"
											 +"<div class='rTableCellFirst ub_project_tracking_row medium'><span style='font-weight: bold;'>Project Name</span></div>"
										 	 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;' title='Unit Test Docs'>UTD</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>tube</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>bc</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>inv</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'title='System Test Docs'>STD</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>strs</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>test data</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>TAP</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>pi</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>CODE</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>tube</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>bc</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>inv</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>UT</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>tube</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>bc</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>inv</span></div>"
											 +"<div class='rTableCellFirst development_row'><span style='font-weight: bold;'>DETAIL</span></div>"
		     						+"</div>";
		
		
	return value;	
    }
    
    
    public static String getPagination2(int elementsByPage, int actualPage, int totalProjectsByManager){
	
	StringBuilder vo = new StringBuilder();
	
	int elem = totalProjectsByManager / elementsByPage;
	
	String line = "";
	
	for(int i = 1; i <= elem; i++){
	    
	    if(i == 0){
		line = "<li class='paginate_button page-item '><a class='page-link' tabindex='"+i+"' data-dt-idx='"+i+"' aria-controls='example' href='#'>"+i+"</a></li>";
	    }else{
		line = "<li class='paginate_button page-item active'><a class='page-link' tabindex='0' data-dt-idx='"+i+"' aria-controls='example' href='#'>"+i+"</a></li>";
	    }
	    vo.append(line);
	}
	
	
	String value = "<div class='' style='float: right;' id='example_paginate'>"
						+"<ul class='pagination'>"
								+"<li id='example_previous' class='paginate_button page-item previous disabled'><a class='page-link' tabindex='0' data-dt-idx='0' aria-controls='example' href='#'>Previous</a></li>"
								/*+"<li class='paginate_button page-item active'><a class='page-link' tabindex='0' data-dt-idx='1' aria-controls='example' href='#'>1</a></li>"
								+"<li class='paginate_button page-item '><a class='page-link' tabindex='0' data-dt-idx='2' aria-controls='example' href='#'>2</a></li>"
								+"<li class='paginate_button page-item '><a class='page-link' tabindex='0' data-dt-idx='3' aria-controls='example' href='#'>3</a></li>"
								+"<li class='paginate_button page-item '><a class='page-link' tabindex='0' data-dt-idx='4' aria-controls='example' href='#'>4</a></li>"
								+"<li class='paginate_button page-item '><a class='page-link' tabindex='0' data-dt-idx='5' aria-controls='example' href='#'>5</a></li>"
								+"<li class='paginate_button page-item '><a class='page-link' tabindex='0' data-dt-idx='6' aria-controls='example' href='#'>6</a></li>"*/
								+vo.toString()
								+"<li id='example_next' class='paginate_button page-item next'><a class='page-link' tabindex='0' data-dt-idx='7' aria-controls='example' href='#'>Next</a></li>"
						+"</ul>"
					+"</div>";
	
	return value;
    }
    
public static String getPagination(){
	
	
	
	String value = "<div class='' style='float: right;' id='example_paginate'>"
						+"<ul class='pagination'>"
								+"<li id='example_previous' class='paginate_button page-item previous disabled'><a class='page-link' tabindex='0' data-dt-idx='0' aria-controls='example' href='#'>Previous</a></li>"
								+"<li class='paginate_button page-item active'><a class='page-link' tabindex='0' data-dt-idx='1' aria-controls='example' href='#'>1</a></li>"
								+"<li class='paginate_button page-item '><a class='page-link' tabindex='0' data-dt-idx='2' aria-controls='example' href='#'>2</a></li>"
								+"<li class='paginate_button page-item '><a class='page-link' tabindex='0' data-dt-idx='3' aria-controls='example' href='#'>3</a></li>"
								+"<li class='paginate_button page-item '><a class='page-link' tabindex='0' data-dt-idx='4' aria-controls='example' href='#'>4</a></li>"
								+"<li class='paginate_button page-item '><a class='page-link' tabindex='0' data-dt-idx='5' aria-controls='example' href='#'>5</a></li>"
								+"<li class='paginate_button page-item '><a class='page-link' tabindex='0' data-dt-idx='6' aria-controls='example' href='#'>6</a></li>"
								+"<li id='example_next' class='paginate_button page-item next'><a class='page-link' tabindex='0' data-dt-idx='7' aria-controls='example' href='#'>Next</a></li>"
						+"</ul>"
					+"</div>";
	
	return value;
    }
    
    public static String getFinalTab(){
	String value = "</div></div>";
	return value;
	
    }
    
    public static String getPaginationBig(){
	String page = "<nav>"
                      +"<ul class='pagination'>"
                        +"<li class='page-item disabled'><a class='page-link' href='#' aria-label='Previous'> <span aria-hidden='true'>&laquo;</span>"
                            +"<span class='sr-only'>Previous</span>"
                        +"</a></li>"
                        +"<li class='page-item active'><a class='page-link' href='#'>1<span class='sr-only'>(current)</span>"
                        +"</a></li>"
                        +"<li class='page-item'><a class='page-link' href='#'>2</a></li>"
                        +"<li class='page-item'><a class='page-link' href='#'>3</a></li>"
                        +"<li class='page-item'><a class='page-link' href='#'>4</a></li>"
                        +"<li class='page-item'><a class='page-link' href='#'>5</a></li>"
                        +"<li class='page-item'><a class='page-link' href='#' aria-label='Next'> <span aria-hidden='true'>&raquo;</span> <span class='sr-only'>Next</span>"
                        +"</a></li>"
                      +"</ul>"
                      +"</nav>";
		
		
		return page;
    }
    

    

    
}


