<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
		function getReview(fy) {
			var id=${content.id}
			$("#review").load("/home/Article/getReview?id="+id+"&fy="+fy);
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
<div id="content">
		<h1>${content.title }</h1>
		<h3>频道:${content.channel.name}</h3>
		<h3>分类:${content.category.name}</h3>
		${content.content}
		
		<div class="btn-group">
			<button onclick="collect(${SESSION_USER_KEY.id==null?'null':SESSION_USER_KEY.id},${content.id})">收藏</button>
		    <button type="button" class="btn btn-default" onclick="onNews(${content.id})">上一篇</button>
		    <button type="button" class="btn btn-default" onclick="putNews(${content.id})">下一篇</button>
		</div>
</div>