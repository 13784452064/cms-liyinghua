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
function fy(fy) {
	var url="/link/linkList?fy="+fy;
	$("#content").load(url);
}
function del(id) {
	location="/link/delLink?linkId="+id;
}
function updLink(id) {
	var url="/link/toUpdate?linkId="+id;
	$("#upd").load(url);
}
function toUrl(url) {
	window.open(url);
}
</script>
	<div style="margin-left: 100px">
		<form:form modelAttribute="link" action="/link/addLink" method="post" >
				链接名<form:input path="name"/><form:errors path="name"></form:errors>&nbsp;&nbsp;&nbsp;
				链接地址<form:input path="url"/><form:errors path="url"></form:errors>&nbsp;&nbsp;&nbsp;
				<form:button>添加</form:button>
		</form:form>
	</div>	
	<div style="height:500px;width: 1000px;margin-left: 100px;margin-top: 20px" >
				<table class="table table-striped" style="font-size: 25px;font-family: courier">
		  		<thead>
			 		<tr>
					    <th>id</th>
					    <th>链接名</th>
					    <th>链接地址</th>
					    <th>链接添加时间</th>
					    <th>操作</th>
					</tr>
		  		</thead>
				  <tbody>
				  <c:forEach items="${LinkInfo.list}" var="link">
				    <tr class="active">
				        <td>${link.id}</td>
					    <td><a href="javascript:toUrl('${link.url}')">${link.name}</a></td>
					    <td>${link.url}</td>
					    <td><fmt:formatDate value="${link.created}" pattern="YYYY年MM月dd日"/></td>
					    <td><button onclick="updLink(${link.id})">修改</button><button onclick="del(${link.id})">删除</button></td>
				    	
				    </tr>
				    </c:forEach>
				    
				  </tbody>
			</table>
			<nav aria-label="Page navigation">
		<!-- 有空看一下 分页 不是很明白  -->
		<div id="upd"></div>	
		  <ul class="pagination">
		    <li>
		      <a href="javascript:fy(1)" aria-label="Previous">首页</a>
		    </li>
			<li>
		      <a href="javascript:fy(${LinkInfo.prePage})" aria-label="Previous">上一页</a>
		    </li>
		    <li>
		      <a href="javascript:fy(${LinkInfo.nextPage})" aria-label="Previous">下一页</a>
		    </li>
			<li>
		      <a href="javascript:fy(${LinkInfo.pages})" aria-label="Previous">尾页</a>
		    </li>
		  </ul>
		</nav>	
	</div>
