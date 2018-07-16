$(document).ready(function(){
	
	
	$(".i_forget").click(function(){
		
		$(".val_password").val("");
		$(".val_name").val("");
		
	});
	
	$(".i_login").click(function(){
		var u_name = $(".val_name").val();
		var u_password = $(".val_password").val();
		
		if (!u_name || !u_password) {
			alert("vazio!!");
		} else {
			login(u_name, u_password);
			//alert("daaa");
			var url = "login";    
			$(location).attr('href',url);
			return false;
		}
		return false;
	});
	
	
//	function login(u_name, u_password){
//			
//			$.ajax({
//				url:"login",
//				type:"POST",
//				data:{
//					login: u_name,
//					password: u_password
//					
//				},
//				success:function(response){
//
//					// $(".modal-box").fadeIn();
//					
//					 $(".modal").hide();
//					 $(".modal-loader").hide();
//					
//					 if(response=="TRUE"){
//						//$(".modal-box .a_users").html(response);
//						// setValues(template);
//						// alert("New Deliverable Inserted!!");
//						
//						 
//						 
//					}else{
//						alert("Fail insert Deliverable!!!");
//						//$(".modal-box .a_users").html("nothing coming");
//					}
//				}
//			})
//
//		}
		
		
	
	
	
	
});