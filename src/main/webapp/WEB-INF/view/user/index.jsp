<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="src/main/webapp/resource/bootstrap/js/bootstrap.js"></script>
<title>Insert title here</title>
</head>
<body>
<!--整个盒子用来包括所有小盒子  -->
<div class="container-fluid" style="height: 900px">
<!-- 导航头 -->
	<div class="row-fluid" style="height: 100px">
		<div class="span12" style="height:50px;background:  black;">
			<h1 class="text-left" style="color: white;">
				CMS-小实训一
			</h1>
		</div>
	</div>
	<!-- 包含导航列表 和 内容栏 -->
	<div class="row-fluid">
		<div class="col-md-1"></div>
		<!-- 导航列表 -->
		<div class="col-md-2" style="border-right: solid;height: 600px">
			<ul class="nav nav-list">
				<li class="nav-header">
					列表标题
				</li>
				<li class="active">
					<a href="#">首页</a>
				</li>
				<li>
					<a href="#">库</a>
				</li>
				<li>
					<a href="#">应用</a>
				</li>
				<li class="nav-header">
					功能列表
				</li>
				<li>
					<a href="#">资料</a>
				</li>
				<li>
					<a href="#">设置</a>
				</li>
				<li class="divider">
				</li>
				<li>
					<a href="#">帮助</a>
				</li>
			</ul>
		</div>
		<!-- 内容栏 -->
		<div class="col-md-9">
			<div class="hero-unit">
				<h1>
					Hello, world!
				</h1>
				<p>
					这是一个可视化布局模板, 你可以点击模板里的文字进行修改, 也可以通过点击弹出的编辑框进行富文本修改. 拖动区块能实现排序.
				</p>
				<p>
					<a class="btn btn-primary btn-large" href="#">参看更多 »</a>
				</p>
			</div>
		</div>
	</div>
	
</div>
<!-- 因为排版问题所以盒子在外面 -->
<div class="row-fluid">
	<!-- 底栏 -->
		<div class="span12" style="height:50px;background:  black;"></div>
</div>
</body>
</html>