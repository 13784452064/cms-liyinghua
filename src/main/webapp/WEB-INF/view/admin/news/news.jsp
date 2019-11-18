<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index3.css"/>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</head>
<body>
	<div>
		<h1>${content.title }</h1>
		<h3>频道:${news.channel.name}</h3>
		<h3>分类:${news.category.name}</h3>
		${content.content}<br>
		
	</div>
</body>
</html>