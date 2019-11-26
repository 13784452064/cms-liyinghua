<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<!-- <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<!-- <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script> -->
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="/resource/kindeditor/kindeditor-all.js"></script>

<title>Insert title here</title>

</head>
<script type="text/javascript">

	function showFuction(url) {
		$("#content").load(url);
	}
	function getUserNewsList(fy) {
		if(fy==null){
			var url='/user/getUserNewsList'
		}else{
			var url='/user/getUserNewsList?fy='+fy
		}
		$("#content").load(url);
	}
	function delNews(ArticleId) {
		$.post(
			"/home/Article/delNews",
			{"articleId":ArticleId},
			function(msg) {
				if(msg!=1){
					alert("删除失败,文章异常");
				}else{
					alert("删除成功");
					var url='/user/getUserNewsList?fy='+1;
					$("#content").load(url);
				}
			},
			"json"
		)
	}
	function postArticle(url){
		$("#content").load(url);
	}
	function toLink(url) {
		$("#content").load(url);
	}
</script>
<body>
<!--整个盒子用来包括所有小盒子  -->
<div class="container-fluid" style="height: 900px">
<!-- 导航头 -->
	<div class="row-fluid" style="height: 100px">
		<div class="span12" style="height:50px;background:  black;">
			<h1 class="text-left" style="color: white;">
				每日一报
			</h1>
			
		</div>
	</div>
	<!-- 包含导航列表 和 内容栏 -->
	<div class="row-fluid">
		<div class="col-md-1"></div>
		<!-- 导航列表 -->
		<div class="col-md-2" style="border-right: solid;height: 600px">
			<ul class="nav nav-list">
				<li class="active">
					<a href="/user/home">查看首页</a>
				</li>
				<li class="nav-header">
					用户
				</li>
				<li>
					<a href="javascript:showFuction('userlist')">用户列表</a>
				</li>
				<li class="active">
					<a href="#">用户设置</a>
				</li>
				<li>
					<a href="#">个人信息</a>
				</li>
				<li>
					<a href="#">退出</a>
				</li>
				<li class="nav-header">
					文章列表
				</li>
				<li>
					<a href="#">测试 </a>
				</li>
				<li>
					<a href="javascript:postArticle('/home/Article/toPostArticle?n=1')">发布文章 </a>
					<a href="javascript:getUserNewsList()">用户文章 </a>
				</li>
				<li>投票管理
					<ul class="nav nav-list">
						<li>
						<a href="#">投票列表</a>
						</li>
						<li>
						<a href="#">新建投票</a>
						</li>
					</ul>
					
					
				</li>
				<li class="divider">
				</li>
				<li>
					<a href="javascript:toLink('/link/toLink')">友情连接管理</a>
				</li>
			</ul>
		</div>
		<!-- 内容栏 -->
		<div class="col-md-9">
			<div class="hero-unit" id="content">
				<div id="kindEditor" style="display: none">
				   <!-- 引入kindEditor的样式 -->
				  <jsp:include page="/resource/kindeditor/jsp/demo.jsp"></jsp:include>
              </div>
			</div>
		</div>
	</div>
	
</div>
<!-- 因为排版问题所以盒子在外面 -->
<div class="row-fluid">
	<!-- 底栏 -->
		<div class="span12" style="height:50px;background:  black;"><h5 class="text-right" style="color: white;">CMS-小实训一</h5></div>
</div>
</body>
</html>