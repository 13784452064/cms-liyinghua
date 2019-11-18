<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
	<script type="text/javascript" src="/resource/js/cms_utils.js">
		
	</script>
	<c:forEach items="${Articles}" var="news">
		<div style="background-color: white;">
			<img alt="找找" src="/pic/${news.picture}" style="width: 100px;height: 100px;float: left">
			<h3 style="width: 100%;float left"><a href="javascript:toContent(${news.id })">${news.title}</a></h3><br>
			<h5 style="width: 100%;">频道:${news.channel.name}</h3>
			<h5 style="width: 100%;">分类:${news.category.name}</h3>
			<h5 style="width: 100%;margin-left: 500px">作者:${news.user.username}</h3><br>
		</div>
	</c:forEach>	
