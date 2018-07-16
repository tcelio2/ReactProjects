$(document).ready(function(){
	
	
	$(".update_password").click(function(){
		$(".modal").show();
		$("#first_value").val("");
		$("#second_value").val("");
		$("#at").hide();
		$(".pop-up-edit-configuration").fadeIn(1000);
	});
	
	$("#first_value").click(function(){
		$("#at").empty();
		$("#at").hide();
	});

	$("#second_value").click(function(){
		$("#at").empty();
		$("#at").hide();
	});
	
	$(document).on("click", ".x", function() {
		$(".modal").hide();
		$(".dashboard-box").hide();
		$(".modal-box-filter").hide();
		$(".modal-box").hide();
		$(".modal-loader").hide();
		$(".pop-up-edit-configuration").hide();
		$(".pop-up-edit-confirmation").hide();
		$(".content").css({"position":"relative"});
	});
	
	
	$("#update_btn").click(function(){
		
		var first = $("#first_value").val();
		var second = $("#second_value").val();
		
		if(!first || !second){
			
				$("#at").show();
				$("#at").empty();
				$("#at").append("Password cannot be empty!");
			
		}
		if(first != null &&  second != null){
			
			if(first != second){
				$("#at").show();
				$("#at").empty();
				$("#at").append("Password do not match! Try again!");
			}
			
			if(first == second){
				$("#at").show();
				$("#at").empty();
				 $(".pop-up-edit-configuration").hide();
				 $(".modal-loader").show();
				 setTimeout(function(){
					
					 sendChange(first); 
				 }, 2000);
				
				
			}
			
		}
		
		
		
		
	});
	
	function sendChange(password){
		
		
		
		$.ajax({
			url:"configuration",
			type:"POST",
			data:{
				password:password,
				
				
				
				
			},
			success:function(response){
				
				if(response == "SUCCESS"){
					$(".pop-up-edit-confirmation").show();
					$(".modal-loader").hide();
					
				}
				
				
			//	$(".dinamic-ajax").append(response);
				
							
			}
		})
		
		
		
		
		
		
		
		return false;
	}
	
	
});