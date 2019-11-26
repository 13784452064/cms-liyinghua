<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		var id=${content.id}

		$("#review").load("/home/Article/getReview?id="+id);
	})
	function onNews(id) {
		id=id-1
		$.post(
			"minId",
			{},
			function(min) {
				if(id>=min){
					$("#content").load("/home/Article/onNews?id="+id);
					$("#review").load("/home/Article/getReview?id="+id);				
				}else{
					$("#on").remove();	
				}
				
				
			},
			"json"
		)
	}
	function putNews(id) {
		id=id+1
		$.post(
			"maxId",
			{},
			function(max) {
				if(id<=max){		
					$("#content").load("/home/Article/putNews?id="+id);
					$("#review").load("/home/Article/getReview?id="+id);
					
				}else{
					$("#on").remove();	
				}
			},
			"json"
		
		)
	}
	 
	
	function putOn(id) {
	
		if(id!=null){
			
			
			
		}else{
			alert("请先登录");
			$("#textarea").load("/user/toLogin1");
		}
	}
	
	function collect(uid,aid) {
	
		if(uid==null){
			alert("请先登录");
			$("#textarea").load("/user/toLogin1");
		}else{
			$.post(
					"/collect/addCollect",
					{userId:uid,articleId:aid},
					function(msg) {
						if(msg){
							alert("收藏成功")
						}else{
							alert("收藏失败")
						}
					},
					"json"
			)
		}
		
	}
</script>
<body>


	<div id="content">
		<h1>${content.title }</h1>
		
		<h3>频道:${content.channel.name}</h3>
		<h3>分类:${content.category.name}</h3>
		${content.content}
		<div class="btn-group">
			<button onclick="collect(${SESSION_USER_KEY.id==null?'null':SESSION_USER_KEY.id},${content.id})">收藏</button>
		    <button type="button" class="btn btn-default" onclick="onNews(${content.id})" id="on">上一篇</button>
		    <button type="button" class="btn btn-default" onclick="putNews(${content.id})" id="put">下一篇</button>
		</div>
	</div>
	
	<div id="review">

	</div>
	
	<div id="textarea">
		<h1 style="margin-left: 500px">评论</h1>
		<textarea rows="10px" cols="100px" style="margin-left: 600px;"></textarea>			
		<button onclick="putOn(${SESSION_USER_KEY.id})">提交</button>
		
	</div>
</body>

</html>