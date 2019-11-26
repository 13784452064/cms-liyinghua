<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Home</title>
<meta name="description" content=""/>

<!--Google font-->
<link href="https://fonts.googleapis.com/css?family=K2D:300,400,500,700,800" rel="stylesheet">

<!-- Bootstrap CSS / Color Scheme -->
<link rel="stylesheet" href="/resource/moban1/css/bootstrap.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		var m=${param.n};
		if(m==1){
			$("#name").text("职员注册")
			$("#role").val("1");
		}
	})
</script>
<body>
		<!--navigation-->
		<section class="bh-white py-3">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12 text-center">
					<a href="index.html" class="heading-brand text-primary" id="name">Crew</a>
				</div>
			</div>
		</div>
		</section>
		
		<!--hero header-->
		<section class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-7 my-md-auto">
					<h1 class="text-center text-md-left">Hire the top freelancers in the world and enjoy their best
						work.</h1>
					<div class="row feature-grid">
						<div class="col-sm-6">
							<div class="media">
								<div class="icon-box">
									<div class="icon-box-inner">
										<span data-feather="unlock" width="28" height="28"></span>
									</div>
								</div>
								<div class="media-body">
									Access to premium freelancers
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="media">
								<div class="icon-box">
									<div class="icon-box-inner">
										<span data-feather="briefcase" width="28" height="28"></span>
									</div>
								</div>
								<div class="media-body">
									Work with specialized developers
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="media">
								<div class="icon-box">
									<div class="icon-box-inner">
										<span data-feather="gift" width="28" height="28"></span>
									</div>
								</div>
								<div class="media-body">
									Exclusive rewards and perks
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="media">
								<div class="icon-box">
									<div class="icon-box-inner">
										<span data-feather="users" width="28" height="28"></span>
									</div>
								</div>
								<div class="media-body">
									Manage remote software team
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-5 pl-md-5">
					<div class="card">
						<div class="card-body py-md-4">
							<h2>Get early access</h2>
							<p class="lead text-muted">We're in private beta.</p>
							<form action="register" >
								<div class="form-group">
								<h2>${message}</h2>
									<input type="text" class="form-control" name="username" placeholder="用户名">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="nickname" placeholder="昵称">
								</div>
								<div class="form-group">
									<input type="password" class="form-control" name="password" placeholder="密码">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="birthday" placeholder="生日">
									<input type="hidden" class="form-control" name="role" value="0" id="role">
								</div>
								
								<div class="form-group">
								<span style="margin-left: 7%;" >性别</span>
									<input type="radio"  name="gender" value="1" style="margin-left: 10%">男
									<input type="radio"  name="gender" value="0" style="margin-left: 10%">女
								</div>
								
								<div class="d-flex flex-row align-items-center justify-content-between">
									<a href="#">Need invite code?</a>
									<input class="btn btn-primary" value="注册" type="submit">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
		
		<!--footer-->
		<footer>
		<div class="container">
			<div class="row">
				<div class="col-12 text-center">
					<ul class="list-inline">
						<li class="list-inline-item"><a href="#">About</a></li>
						<li class="list-inline-item"><a href="#">Privacy</a></li>
						<li class="list-inline-item"><a href="#">Terms</a></li>
					</ul>
				</div>
			</div>

		</div>
		</footer>
		
		<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="/resource/moban1/js/jquery-3.2.1.min.js"></script>
		<script src="/resource/moban1/js/feather.min.js""></script>
		<script src="/resource/moban1/js/scripts.js""></script>
		</body>
</html>