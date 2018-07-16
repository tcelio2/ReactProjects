$(document).ready(function(){
	
	
	
	$(document).on("click", ".scroll ul.tabs li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");

		$('.scroll ul.tabs li').removeClass('current');
		$('.scroll .tab-content').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll .cc").hide().fadeIn(1000);
		$(this).parent(".tabs0").parent(".scroll0").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-04"){
		
			$(this).parent(".tabs0").parent(".scroll0").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});
	
	$(document).on("click", ".scroll0 ul.tabs0 li", function(){
		var tab_id = $(this).attr('data-tab');
		
		var color = $(this).css("background-color");

		$('.scroll0 ul.tabs0 li').removeClass('current');
		$('.scroll0 .tab-content0').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(this).parent(".tabs0").parent(".scroll0").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-04"){
		
			$(this).parent(".tabs0").parent(".scroll0").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		//$(this).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		$(".scroll0 .cc").hide().fadeIn(1000);
		
		return false;
	});

	$(document).on("click", ".scroll1 ul.tabs1 li", function(){
		var tab_id = $(this).attr('data-tab');
		
		var color = $(this).css("background-color");
	//	$(".rTableHead").animate({backgroundColor: color}, 1000);

		$('.scroll1 ul.tabs1 li').removeClass('current');
		$('.scroll1 .tab-content1').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(this).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		$(".scroll1 .cc").hide().fadeIn(1000);
		$(this).parent(".tabs1").parent(".scroll1").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-14"){
		
			$(this).parent(".tabs1").parent(".scroll1").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});
	
	
	$(document).on("click", ".scroll2 ul.tabs2 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
	//	$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll2 ul.tabs2 li').removeClass('current');
		$('.scroll2 .tab-content2').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(this).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		$(".scroll2 .cc").hide().fadeIn(1000);
		
	   $(this).parent(".tabs2").parent(".scroll2").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-24"){
		
			$(this).parent(".tabs2").parent(".scroll2").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});
	
	$(document).on("click", ".scroll3 ul.tabs3 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		//$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll3 ul.tabs3 li').removeClass('current');
		$('.scroll3 .tab-content3').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(this).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		$(".scroll3 .cc").hide().fadeIn(1000);
		$(this).parent(".tabs3").parent(".scroll3").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-34"){
		
			$(this).parent(".tabs3").parent(".scroll3").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});


	$(document).on("click", ".scroll4 ul.tabs4 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll4 ul.tabs4 li').removeClass('current');
		$('.scroll4 .tab-content4').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll4 .cc").hide().fadeIn(1000);
	    $(this).parent(".tabs4").parent(".scroll4").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-44"){
		
			$(this).parent(".tabs4").parent(".scroll4").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	$(document).on("click", ".scroll5 ul.tabs5 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll5 ul.tabs5 li').removeClass('current');
		$('.scroll5 .tab-content5').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll5 .cc").hide().fadeIn(1000);
		$(this).parent(".tabs5").parent(".scroll5").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-54"){
		
			$(this).parent(".tabs5").parent(".scroll5").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	$(document).on("click", ".scroll6 ul.tabs6 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll6 ul.tabs6 li').removeClass('current');
		$('.scroll6 .tab-content6').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll6 .cc").hide().fadeIn(1000);
		$(this).parent(".tabs6").parent(".scroll6").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-64"){
		
			$(this).parent(".tabs6").parent(".scroll6").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	$(document).on("click", ".scroll7 ul.tabs7 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll7 ul.tabs7 li').removeClass('current');
		$('.scroll7 .tab-content7').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll7 .cc").hide().fadeIn(1000);
		
		$(this).parent(".tabs7").parent(".scroll7").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-74"){
		
			$(this).parent(".tabs7").parent(".scroll7").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		return false;
	});

	$(document).on("click", ".scroll8 ul.tabs8 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll8 ul.tabs8 li').removeClass('current');
		$('.scroll8 .tab-content8').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll8 .cc").hide().fadeIn(1000);
		
	   $(this).parent(".tabs8").parent(".scroll8").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-84"){
		
			$(this).parent(".tabs8").parent(".scroll8").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	$(document).on("click", ".scroll9 ul.tabs9 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll9 ul.tabs9 li').removeClass('current');
		$('.scroll9 .tab-content9').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll9 .cc").hide().fadeIn(1000);
		$(this).parent(".tabs9").parent(".scroll9").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-94"){
		
			$(this).parent(".tabs9").parent(".scroll9").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	$(document).on("click", ".scroll10 ul.tabs10 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll10 ul.tabs10 li').removeClass('current');
		$('.scroll10 .tab-content10').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll10 .cc").hide().fadeIn(1000);
		$(this).parent(".tabs10").parent(".scroll10").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-104"){
		
			$(this).parent(".tabs10").parent(".scroll10").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	$(document).on("click", ".scroll11 ul.tabs11 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll11 ul.tabs11 li').removeClass('current');
		$('.scroll11 .tab-content11').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll6 .cc").hide().fadeIn(1000);
	    $(this).parent(".tabs11").parent(".scroll11").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-114"){
		
			$(this).parent(".tabs11").parent(".scroll11").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	$(document).on("click", ".scroll12 ul.tabs12 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll12 ul.tabs12 li').removeClass('current');
		$('.scroll12 .tab-content12').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll12 .cc").hide().fadeIn(1000);
		$(this).parent(".tabs12").parent(".scroll12").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-124"){
		
			$(this).parent(".tabs12").parent(".scroll12").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	$(document).on("click", ".scroll13 ul.tabs13 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll13 ul.tabs13 li').removeClass('current');
		$('.scroll13 .tab-content13').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll13 .cc").hide().fadeIn(1000);
		
	    $(this).parent(".tabs13").parent(".scroll13").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-134"){
		
			$(this).parent(".tabs13").parent(".scroll13").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	$(document).on("click", ".scroll14 ul.tabs14 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll14 ul.tabs14 li').removeClass('current');
		$('.scroll14 .tab-content14').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll14 .cc").hide().fadeIn(1000);
		
	     $(this).parent(".tabs14").parent(".scroll14").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-144"){
		
			$(this).parent(".tabs14").parent(".scroll14").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	$(document).on("click", ".scroll15 ul.tabs15 li", function(){
		var tab_id = $(this).attr('data-tab');

		var color = $(this).css("background-color");
		$(".rTableHead").animate({backgroundColor: color}, 1000);
		
		$('.scroll15 ul.tabs15 li').removeClass('current');
		$('.scroll15 .tab-content15').removeClass('current');

		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		$(".scroll15 .cc").hide().fadeIn(1000);
		
		$(this).parent(".tabs15").parent(".scroll15").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({backgroundColor: color}, 1000);
		
		if(tab_id == "tab-154"){
		
			$(this).parent(".tabs15").parent(".scroll15").find("#"+tab_id).find(".rTable2").find(".rTableHead").animate({color: "black"}, 1000);
		}
		
		return false;
	});

	
	
});