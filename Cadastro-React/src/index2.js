$(document).ready(function(){


//Elementos criados afim de que haja responsividade!!
var g = $('.content-left').width();
$('.content-left').css({"width":g - 180});
$('.content-left').css({"left":180});



	$('.content-right .component-customer-detail').hide();
	
    $(".form-input-one-title").click(function(){

		//	$(this).parent("div").find(".form-input-one-left").hide();
		//	$(this).parent("div").find(".form-input-one-right").hide();
		//	$(this).parent("div").attr("hide","true");

	});

	$(".head").click(function(){
		
			var width = $(".menu").width();
			var content_left = $(".content-left").width();

			if(width < 10){
			
				$(".menu").animate({width:"180"}, 500);
				$(".menu").show();
				content_left = content_left - 180;
				$(".content_left").animate({width: content_left}, 500);
				$('.content-left').css({"width":g - 180});
				$('.content-left').css({"left":180});
			}else{
			
				content_left = content_left - 5;
				$(".menu").animate({width:"5"}, 500);
				$(".content_left").animate({width: content_left}, 500);
				$(".content_left").animate({marginLeft: 180}, 500);
				$(".menu").hide();
				$('.content-left').css({"width":g});
				$('.content-left').css({"left":0});
			}
		
	});
	
	$('tr').click(function(){

				$("tbody tr").css({"background":"#f2f2f2"});
				$(this).css({"background":"#ddd"});
				$('.content-right .component-customer-detail').hide();
				$('.content-right').append("<div class='loader'><img src='img/loader2.gif'</div>");
	
				setTimeout(function(){
							$('.content-right .loader').remove();
							$('.content-right .component-customer-detail').show();
						}, 3000);
		

	});

	$(".form-input-one .clear").click(function(){

				$(".form-input-one .form-input-stand-input").attr("value", "");


	});
});
