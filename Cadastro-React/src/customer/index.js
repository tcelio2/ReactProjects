window.$(document).ready(function(){


//Elementos criados afim de que haja responsividade!!
var g = window.$('.content-left').width();
window.$('.content-left').css({"width":g - 180});
window.$('.content-left').css({"left":180});






	window.$('.content-right .component-customer-detail').hide();
	
    window.$(".form-input-one-title").click(function(){

		//	window.$(this).parent("div").find(".form-input-one-left").hide();
		//	window.$(this).parent("div").find(".form-input-one-right").hide();
		//	window.$(this).parent("div").attr("hide","true");

	});

	window.$(".head").click(function(){
		
			var width = window.$(".menu").width();
			var content_left = window.$(".content-left").width();

			if(width < 10){
			
				window.$(".menu").animate({width:"180"}, 500);
				window.$(".menu").show();
				content_left = content_left - 180;
				window.$(".content_left").animate({width: content_left}, 500);
				window.$('.content-left').css({"width":g - 180});
				window.$('.content-left').css({"left":180});
			}else{
			
				content_left = content_left - 5;
				window.$(".menu").animate({width:"5"}, 500);
				window.$(".content_left").animate({width: content_left}, 500);
				window.$(".content_left").animate({marginLeft: 180}, 500);
				window.$(".menu").hide();
				window.$('.content-left').css({"width":g});
				window.$('.content-left').css({"left":0});
			}
		
	});
	
	window.$('tr').click(function(){

				window.$("tbody tr").css({"background":"#f2f2f2"});
				window.$(this).css({"background":"#ddd"});
				window.$('.content-right .component-customer-detail').hide();
				window.$('.content-right .loader').show();
				
	
				setTimeout(function(){
							window.$('.content-right .loader').hide();
							window.$('.content-right .component-customer-detail').hide().fadeIn(1000);//show();
						}, 3000);
		

	});

	window.$(".form-input-one .clear").click(function(){

				window.$(".form-input-one .form-input-stand-input").attr("value", "");


	});

	// window.$(window).resize(function(){
	// 		var width = window.$(".menu").width();
	// 		var content_left  = window.$(".content-left").width();
	// 		var content_right = window.$(".content-right").width();
			
	// 			//content_left = content_left - 5;
	// 			window.$(".menu").animate({width:"5"}, 500);
	// 			//window.$(".content_left").animate({width: content_left}, 500);
	// 			//window.$(".content_left").animate({marginLeft: 180}, 500);
	// 			window.$(".menu").hide();
	// 			window.$('.content-left').css({"width":'60%'});
	// 			window.$('.content-left').css({"left":0});

	// 			if(content_right <= 420){
	// 				window.$('.content-right').hide();

	// 			}else{
	// 				window.$('.content-right').show();
	// 			}

	// });

});