$(function(){

	$(".menu").css("marginLeft","-351px")
	$(".sub").hide();
	
	$(".hamburger").click(function(){
	$(".menu").show();
		$(".menu").animate({marginLeft:"0"},100);
		$(".hamburger").hide();
		$(".cross").show();
	});
		
	$(".menu>ul>li>a").click(function(){
		if($(this).next().is(":visible"))
		{	
			$(this).next().stop().slideUp(300);
		}else{
			$(".sub").stop().slideUp(500);
			$(this).next().stop().slideDown(500);
		};
	});
	
	$(".cross").click(function(){
		$(".menu").animate({marginLeft:"-351px"},100);
		$(".cross").hide();
		$(".hamburger").show();
	});
});