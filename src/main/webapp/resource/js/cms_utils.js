//跳转页面
$(function(){
		$(".menu li").click(function(){
			var url  = $(this).attr("data");
			//alert(url);
			location.href=url;
		})
	})
	
function toContent(articleId){
	window.open("/home/Article/getContent?articleId="+articleId)
}