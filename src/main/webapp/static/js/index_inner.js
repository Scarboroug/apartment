$(".nav").on("click","li",function(){
	$(this).siblings().removeClass("current");
	$(this).addClass("current");
	//console.log($('iframe[name=iframe1]'))
	$('iframe[name=iframe1]').attr('src', $(this).find("a").attr('href'));
});


$(window).resize(function(e) {
    $("#bd").height($(window).height() - 6);
	$(".wrap").height($("#bd").height()-6);
	$(".nav").css("minHeight", $(".sidebar").height() - $(".sidebar-header").height()-1);
	$("#iframe").height($(window).height() - 35);
}).resize();

$(".nav>li").css({"borderColor":"#dbe9f1"});
$(".nav>.current").prev().css({"borderColor":"#7ac47f"});
$(".nav").on("click","li",function(e){
	var aurl = $(this).find("a").attr("data-src");
	$("#iframe").attr("src",aurl);
	$(".nav>li").css({"borderColor":"#dbe9f1"});
	$(".nav>.current").prev().css({"borderColor":"#7ac47f"});
	return false;
});
