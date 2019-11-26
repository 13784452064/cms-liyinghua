<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
   <%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>

    
<!DOCTYPE html>
<link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript">
		function fy(userId,fy) {
			var url='/collect/getUserCollect?id='+userId+'&fy='+fy;
			$("#content").load(url);
		}
		function del(id,userId) {
			$.post(
					"/collect/del",
					{id:id},
					function(msg) {
						if(msg>0){
							alert("取消成功")
							var url='/collect/getUserCollect?id='+userId;
							$("#content").load(url)
						}else{
							alert('取消失败');
						}
					},
					"json"
			)
			
		}
</script>
<div style="height:500px;width: 1000px;margin-left: 100px;margin-top: 20px" >
				<table class="table table-striped" style="font-size: 25px;font-family: courier">
		  		<thead>
			 		<tr>
					    <th>收藏编号</th>
					    <th>文章名</th>
					    <th>收藏时间</th>
					    <th>操作</th>
					</tr>
		  		</thead>
				  <tbody>
				  <c:forEach items="${p.list}" var="collect">
				    <tr class="active">
				        <td>${collect.id}</td>
					    <td>${collect.article.title}</td>
					    <td>${collect.collectTime}</td>
					    <td><button onclick="del(${collect.id},${SESSION_USER_KEY.id})">删除</button></td>				    	
				    </tr>
				    </c:forEach>
				    
				  </tbody>
			</table>
			<nav aria-label="Page navigation">
		<!-- 有空看一下 分页 不是很明白  -->
		<div id="upd"></div>	
		  <ul class="pagination">
		    <li>
		      <a href="javascript:fy(${SESSION_USER_KEY.id},1)" aria-label="Previous">首页</a>
		    </li>
			<li>
		      <a href="javascript:fy(${SESSION_USER_KEY.id},${p.prePage})" aria-label="Previous">上一页</a>
		    </li>
		    <li>
		      <a href="javascript:fy(${SESSION_USER_KEY.id},${p.nextPage})" aria-label="Previous">下一页</a>
		    </li>
			<li>
		      <a href="javascript:fy(${SESSION_USER_KEY.id},${p.pages})" aria-label="Previous">尾页</a>
		    </li>
		  </ul>
		</nav>	
	</div>