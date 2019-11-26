 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width,inital-scale=1,maximum-scale=1,user-scalable=no;" />
<title>Insert title here</title>
<link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
<title>Bootstrap 实例 - 简单的轮播（Carousel）插件</title>
<link rel="stylesheet" href="//cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="//cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="//cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="/resource/js/cms_utils.js"></script>
<style type="text/css">
	.container{
  width: 100%;
  height: 100%;
  display: flex;
  justify-content:center;
  background-color: #ffffff;
}
.blueBorder{
  width: 400px;
  height: 150px;
  border:2px solid rgba(63,174,174,1);
  border-radius: 20px;
  position: relative;
}
.blueBorder div{
  position: absolute;
}
.blueRadius{
  width: 12px;
  height: 12px;
  border-radius: 6px;
  background-color: rgba(63,174,174,1);
}
.blueRadius:first-child{
  top: -6px;
  left: 50px;
}
.blueRadius:nth-child(2){
  top: -6px;
  right: 50px;
}
.text{
  width: 260px;
  top: -10px;
  left: 62px;
  height: auto;
  text-align: center;
  background-color: #ffffff
}
	
</style>
<script type="text/javascript">
	
	function toCategory(cid) {
		var url="/home/Category/getCategoryByChannelId?channelId="+cid;
		$("#news").load(url);
		var url1="/home/Article/getArticleBychannelId?channelId="+cid;
		$("#newss").load(url1);
	}
	function getArticleBychannelIdAndByCategoryId(categoryId) {
		var url="/home/Article/getArticleBychannelIdAndByCategoryId?categoryId="+categoryId;
		$("#newss").load(url);
	}
	function toRegister() {
		location="/user/toRegister";
	}
	function toLogin() {
		location="/user/toLogin";
		
	}
	function toIndex() {
		location="/admin/hello";
	}
	function toExit() {
		location="/user/exit";
	}
	function toUserIndex() {
		location="/admin/UserHello";
	}
	function toContent(newsId) {
		window.open("/home/Article/getContent?articleId="+newsId)
	}
</script>
</head>
<body	background="/resource/images/光速运营唯一QQ2415813907图片0322.jpg">
<div>
	<div class="container">
	<divstyle="height: 75px">
		<div class="span12" >
			<nav class="navbar navbar-default" role="navigation"  style="width: 1700px">
			    <div class="container-fluid" style="width: 100%;height: 75px">
				<div class="navbar-header" style="float: left;height: 75px;">
					<img alt="等下我找找" src="/resource/images/怡心.png" style="height: 75px;width: 75px">
				 </div>
				<div style="float: left;margin-left: 40%">
					<form class="navbar-form navbar-left" role="search">
						 <div class="form-group">
							<input type="text" class="form-control" placeholder="Search"  >           
						</div>
						<button type="submit" class="btn btn-default">提交</button>
					</form>	    				      
				</div>
				<div>
					    <c:if test="${mess!=1}">     
				             <input type="button" class="btn btn-default" id="toLogin" onclick="toLogin()" style="margin-top: 5px;float: right;"  value="员工入口" >
				        </c:if> 
				        <c:if test="${mess==1}">
				        			<img alt="找找" src="/resource/images/3.png" style="width: 75px;height:75px;float: right">
				        	<h3 style="margin-top: 10px;float: right;">${SESSION_USER_KEY.username}</h3>
				        </c:if>
				        <c:if test="${add==1}">
				       		<button type="button" class="btn btn-default" onclick="toIndex()" style="margin-left: 300px;margin-top: 30px">个人中心</button>
    						<button type="button" class="btn btn-default" onclick="toExit()" style="margin-top: 30px">退出</button>
				        	
							
				       </c:if>
				       <c:if test="${add!=1 && add!=null}">
				        	<button type="button" class="btn btn-default" onclick="toUserIndex()" style="margin-left: 300px;margin-top: 30px">个人中心</button>
    						<button type="button" class="btn btn-default" onclick="toExit()" style="margin-top: 30px">退出</button>
    						
				      </c:if>	 
				</div>
				</div>
			</nav>
		</div>
	</div>
		

		<div class="span2"  style="margin-top: 20px;width: 13% ;float: left;margin-left: 100px" >
			<div style="width:100%;" >
			<div class="list-group"  >
			    <a href="#" class="list-group-item active">
			        <h4 class="list-group-item-heading">
			         		国际
			        </h4>
			    </a>
			    <c:forEach items="${list }" var="channel">
			    <a href="javascript:toCategory(${channel.id })" class="list-group-item" >
			        <h4 class="list-group-item-heading" >
			            	${channel.name }
			        </h4>
			        <p class="list-group-item-text">
			          		  您将通过网页进行免费域名注册。
			        </p>
			    </a>
			  	</c:forEach>
			</div>
		</div>	
	</div>
		<div class="span7">
			<div style="width: 98%;margin-left: 20px">
				<div id="news"></div>
				<div  style="width:55%; float: left;" id="newss" >
				
				
				<div id="myCarousel" class="carousel slide">
					<!-- 轮播（Carousel）指标 -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>   
					<!-- 轮播（Carousel）项目 -->
					<div class="carousel-inner">
						<div class="item active">
							<img src="/resource/images/1 (6).jpg" alt="First slide" style="height: 700px;width:100%;">
						</div>
						<div class="item">
							<img src="/resource/images/1b90e4dc219f41dd70f7b9c14fcb4f0a.jpg" alt="Second slide" style="height: 700px;width:100%;">
						</div>
						<div class="item">
							<img src="/resource/images/2ce40ddeb1963526bbaf85273c1cf6c4.jpg" alt="Third slide" style="height: 700px;width:100%;">
						</div>
					</div>
					<!-- 轮播（Carousel）导航 -->
					<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div> 
				<c:forEach items="${hotNews}" var="news">
				<div>
					<img alt="找找" src="/pic/${news.picture}" style="width: 100px;height: 100px;float: left">
					<h3 style="width: 100%;float left"><a href="javascript:toContent(${news.id })">${news.title}</a></h3><br>
					<h5 style="width: 100%;">频道:${news.channel.name}</h3>
					<h5 style="width: 100%;">分类:${news.category.name}</h3>
					<h5 style="width: 100%;margin-left: 500px">作者:${news.user.username}</h3><br>
				</div>
				</c:forEach>
			</div>
			</div>
		
		</div>
		<div class="span3">
		<div style=" width:26%;float: right;">
			<div class="container" style="width: 95%;margin-right: 60px">
		      <div class="blueBorder">
		         <div class="blueRadius">
					
		         </div>
		          <div class="blueRadius">
		          
		         </div>
		         <div class="text" style="margin-left: 5px">
		         		<h3>公告</h3>
		         </div>
		      </div>
		    </div>	
		    <c:if test="${yz==null or yz==true}">
			
			<div style="FONT-SIZE: 26pt; FILTER: wave(add=0,lightstrength=50,strength=3,freq=2,phrase=10); 
					WIDTH: 100%; COLOR: pink; LINE-HEIGHT: 100%; FONT-FAMILY: 华文行楷;margin-left: 40% ">
					<h1><strong>怡语</strong></h1>				
			</div>
			<p style="font-style:red;margin-left: 35%">${ErrorMessage}</p>
			<p style="font-style:red;margin-left: 35%">${message}</p>
			<div style="padding: 50xp 100px 10px;width: 100%">
			    <form class="bs-example bs-example-form" role="form" action="/user/userLogin">
			        <div class="input-group" style="width: 50%;margin-left: 25%">
			            <span class="input-group-addon">用户名</span>
			            <input type="text" class="form-control" placeholder="请输入用户名" name="username" >
			            <!-- 用户判断 -->
			            <input type="hidden" name="n" value="1">
			           
			        </div>
			        <br>
			       <div class="input-group" style="width: 50%;margin-left: 25%">
			            <span class="input-group-addon">密&nbsp;&nbsp;&nbsp;码</span>
			            <input type="text" class="form-control" placeholder="请输入密码" name="password">
			        </div>
			        <div>
			        	<input type="submit" class="btn btn-success" style="margin-top: 10px;margin-left: 30%" value="登录">
			        	<input type="button" class="btn btn-info" style="margin-top: 10px;margin-left: 10%;" value="注册" onclick="toRegister()">
			        </div>
			        
			    </form>

			</div>
			</c:if>
			<div  style="width: 50%;margin-left: 50px;margin-top: 10%">
			<div class="panel panel-primary" >
			    <div class="panel-heading">
			        <h3 class="panel-title">图片文章</h3>
			    </div>
			    <div class="panel-body">
						<c:forEach items="${imgArticles}" var="article" varStatus="index"> 
							<a href="javascript:showArticle(${article.id})">${index.index}. ${article.title}</a>
							<br/>
						</c:forEach>
				</div>		    
			</div>
		<div class="panel panel-success">
		    <div class="panel-heading">
		        <h3 class="panel-title">面板标题</h3>
		    </div>
		    <div class="panel-body">
		        这是一个基本的面板
		    </div>
		</div>
		<div class="panel panel-info">
		    <div class="panel-heading">
		        <h3 class="panel-title">面板标题</h3>
		    </div>
		    <div class="panel-body">
		        这是一个基本的面板
		    </div>
		</div>
		<div class="panel panel-warning">
		    <div class="panel-heading">
		        <h3 class="panel-title">面板标题</h3>
		    </div>
		    <div class="panel-body">
		        这是一个基本的面板
		    </div>
		</div>
		<div class="panel panel-danger">
		    <div class="panel-heading">
		        <h3 class="panel-title">面板标题</h3>
		    </div>
		    <div class="panel-body">
		        这是一个基本的面板
		    </div>
		</div>			
		</div>
		</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
		</div>
	</div>
</div>
<script type="text/javascript" src="/resource/js/cms_index.js"></script>
<script type="text/javascript">




</script>
</body>
</html>