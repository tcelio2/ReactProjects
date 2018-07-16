$(document).ready(function(){
	
	
	
	$(".list").click(function(){
		
		
		loader();
		
	});
	
	function loader() {
		$(".modal").show();
		$(".modal-loader").show();

		requestAjax();

		return false;
	}
	
	function requestAjax(){
		
		$.ajax({
			url:"AdminServlet",
			type:"POST",
			data:{
				ok:"US"
			},
			success:function(response){
				//alert(response.txt());
				$(".a_users").empty();
				 $.each(response, function(i, field){
			            $(".modal-box .a_users").append("<h4><span>"+field +"</span></h4>");
			            //alert(field+"-->");
				 });
				 $(".modal-box").fadeIn();
				// $(".modal").hide();
				 $(".modal-loader").hide();
				
				 if(response!=""){
					$(".modal-box a_users").html(response);
				}else{
					$(".modal-box a_users").html("nothing coming");
				}
			}
		})
		
		
	}
	
	
	
	$(".x").click(function(){
		
		
		$(".modal").hide();
		$(".modal-box").hide();
		
		
	});
	
	//alert("manager page");
	
	
	
});