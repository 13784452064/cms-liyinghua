<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="/resource/moban/bootstrap.min.css">

<!-- Loding font -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:300,700" rel="stylesheet">

<!-- Custom Styles -->
<link rel="stylesheet" type="text/css" href="/resource/moban/styles.css">
</head>
<script type="text/javascript">
	function toRegister() {
		location="/user/toRegister?n=1";
	}
</script>
<body>
	<!-- Backgrounds -->

<div id="login-bg" class="container-fluid">

  <div class="bg-img"></div>
  <div class="bg-color"></div>
</div>

<!-- End Backgrounds -->

<div class="container" id="login">
	<div class="row justify-content-center">
	<div class="col-lg-8">
	  <div class="login">

		<h1>Login</h1>
		
		
		<!-- Loging form -->
			  <form action="/user/userLogin">
			  <h3><font color="red">${mseeage}</font></h3>
				<div class="form-group">
				  <input type="test" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="用户名" name="username">  
				</div>
				<div class="form-group">
				  <input type="password" class="form-control" id="exampleInputPassword1" placeholder="密码" name="password">
				  
				</div>

				  <div class="form-check">

				  <label class="switch">
				  <input type="checkbox">
				  <span class="slider round"></span>
				</label>
				  <label class="form-check-label" for="exampleCheck1">Remember me</label>
				  
				  <label class="forgot-password"><a href="javascript:toRegister()">注册<a></label>

				</div>
			  
				<br>
				<button type="submit" class="btn btn-lg btn-block btn-success">Sign in</button>
			  </form>
		 <!-- End Loging form -->

	  </div>
	</div>
	</div>
</div>
</body>
</html>