<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
        .hide{
            display: none;
        }
        .c1{
            position: fixed;
            top:0;
            bottom: 0;
            left:0;
            right: 0;
            background: rgba(0,0,0,.5);
            z-index: 2;
        }
        .c2{
            background-color: white;
            position: fixed;
            width: 400px;
            height: 300px;
            top:50%;
            left: 50%;
            z-index: 3;
            margin-top: -150px;
            margin-left: -200px;
        }
		#modal p {
			margin-left:80px;
		}
    </style>
</head>
<body>
<div>
    <table>
        <tr>   
            <td><input type="button" value="登录" onclick="Show();" style="margin-left: 900px"></td>
        </tr>
    </table>
</div>
<div id="shade" class="c1 hide"></div>
<form action="/user/userLogin">
<div id="modal" class="c2 hide">
    <p>用户：<input type="text" name="username" /></p>
    <input type="hidden" name="n" value="1"/>
    <p>密码：<input type="password" name="password"  /></p>
<p>
    <input type="submit" value="确定" onclick="login()">
    <input type="button" value="取消" onclick="Hide()">
</p>
   </div>
 </form>
<script>
    function Show(){
        document.getElementById('shade').classList.remove('hide');
        document.getElementById('modal').classList.remove('hide');
    }
     function Hide(){
        document.getElementById('shade').classList.add('hide');
        document.getElementById('modal').classList.add('hide');
    }
 
</script>
