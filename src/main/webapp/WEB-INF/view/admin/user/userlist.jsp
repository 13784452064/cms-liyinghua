<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<link href="/resource/bootstrap/css/bootstrap.css" rel="stylesheet">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>

<script type="text/javascript">
/**
 * 分页
 */
	function fy(fy) {
			var url="userlist?fy="+fy+"&mohu=${mohu}";
			$("#content").load(url);
	}
/**
 * 修改状态
 */
 	function updLocked(id,locked) {
	
	if (confirm("是否改变状态?")) {
		$.post(
				"updLocked",
				{id:id,locked:locked},
				function(sm) {
					if(sm.wrongNumber==0){
						alert(sm.hint);
						$("#content").load("userlist");
					}else{
						alert(sm.hint);
					}
				},
				"json"	
		)	
	}
		
	}
	/* 模糊查询 */
	function search() {
		var mohu=$("#mohu").val();
		
		$("#content").load("userlist?mohu="+mohu);
	}
</script>

<div class="container-fluid">
	<div >
	<!-- 并不是用表单标签就一定要用表单标签 -->
    <form class="bs-example bs-example-form" role="form">
        <div class="input-group input-group-lg">
            <span class="input-group-addon">用户名查询</span>
            <input id="mohu" type="text" class="form-control" placeholder="请输入用户名" style="width: 200px" name="mohu" value="${mohu}" >
            <input type="button" class="btn btn-default" style="height: 45px" value="搜索" onclick="search()">
        </div>
    </form>  
</div>
	<div style="height:500px;width: 1000px;margin-left: 100px;margin-top: 20px" >
	<!-- 用户列表 -->
		<table class="table table-striped" style="font-size: 25px;font-family: courier">
  		<thead>
	 		<tr>
			    <th>用户id</th>
			    <th>用户名</th>
			    <th>生日</th>
			    <th>性别</th>
			    <th>状态</th>
			    <th>注册时间</th>
			    <th>级别</th>
			    <th>操作</th>
			</tr>
  		</thead>
		  <tbody>
		  <c:forEach items="${info.list}" var="user">
		  <tr>
		  	
		  </tr>
		    <tr class="active">
		        <td>${user.id }</td>
			    <td>${user.username }</td>
			    <td><fmt:formatDate value="${user.birthday }" pattern="YYYY年MM月dd日"/></td>
			    <td>${user.gender!=0?"男":"女" }</td>
			    <td>${user.locked!=0?"禁用":"正常" }</td>
			    <td><fmt:formatDate value="${user.createTime }" pattern="YYYY年MM月dd日"/></td>
			    <td>${user.role==0?"普通用户":"管理员"}</td>
			    <td>
			    <c:if test="${user.locked==0?"true":""}">
			    <input type="button" onclick="updLocked(${user.id },${user.locked})" value="禁用">
			    </c:if>
			    <c:if test="${user.locked==1?"true":""}">
			    <input type="button" onclick="updLocked(${user.id },${user.locked})" value="解禁">
			    </c:if>
			     </td>
		    </tr>
		    </c:forEach>
		  </tbody>
	</table>
	<nav aria-label="Page navigation">
<!-- 有空看一下 分页 不是很明白  -->	
  <ul class="pagination">
    <li>
      <a href="javascript:fy(${info.prePage})" aria-label="Previous"> &laquo;</a>
    </li>
   	<c:forEach begin="${info.pageNum-2 > 1 ? info.pageNum-2:1}" end="${info.pageNum+2 > info.pages ? info.pages:info.pageNum+2}" varStatus="index">    		
    	<c:if test="${info.pageNum!=index.index}">
    		<li><a href="javascript:goPage(${index.index})">${index.index}</a></li>
    	</c:if>
    	<c:if test="${info.pageNum==index.index}">
    		<li><a href="javascript:void"><strong> ${index.index} </strong> </a></li>
    	</c:if>
    	
    </c:forEach>
    <li>
      <a href="javascript:fy(${info.nextPage})" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>	
	</div>
</div>