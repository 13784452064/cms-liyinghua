<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<table class="table">
  <caption>我的文章</caption>
  <thead>
    <tr>
      <th>id</th>
      <th width="50%">标题</th>
      <th>频道</th>
      <th>分类</th>
      <th>作者</th>
      <th>发布日期</th>
      <th>状态</th>
      <th>热门</th>
      <th>操作</th>
      </tr>
  </thead>
  <tbody>
    <c:forEach items="${p.list}" var="article">
	    <tr>
	     <tr class="active">
	       <td>${article.id}</td>
	       <td>${article.title}</td>
	       <td>${article.channel.name}</td>
	       <td>${article.category.name}</td>
	       <td>${article.user.username}</td>
	       <td><fmt:formatDate value="${article.created}" pattern="yyyy-MM-dd"/></td>
	       <td>
	       <c:choose>
	       	<c:when test="${article.status==0}">
	       		待审核
	       	</c:when>
	       	<c:when test="${article.status==1}">
	       		审核通过
	       	</c:when>
	       	<c:when test="${article.status==2}">
	       		审核被拒
	       	</c:when>
	       	<c:otherwise>
	       		未知
	       	</c:otherwise>	
	       </c:choose>
	       </td>
	       <td>
	       <c:choose>
	       	<c:when test="${article.hot==0}">
	       		是
	       	</c:when>
	       	<c:when test="${article.hot==1}">
	       		否
	       	</c:when>
	       	<c:otherwise>
	       		未知
	       	</c:otherwise>	
	       </c:choose>
	       </td>
	      <td>
	      	<input type="button" onclick="toUpdNews(${article.id})" value="修改" class="btn-info"/>
	      	<input type="button" onclick="delNews(${article.id})" value="删除"  class="btn-danger"/>
	      </td></tr> 
	     </tr>
   	</c:forEach>
  </tbody>
</table>
<ul class="pagination">
    <li><a href="javascript:goPage(1)">首页</a></li>
    <li><a href="javascript:goPage(${p.prePage})">上一页</a></li>
    <li><a href="javascript:goPage(${p.nextPage})">下一页</a></li>
    <li><a href="javascript:goPage(${p.pages})">尾页</a></li>
</ul>

<script type="text/javascript">
	//全局变量 保存文章id
	var globalArticleId = 0;
	
	function goPage(fy){
		var url="/user/getUserNewsListByUserId?fy="+fy ;
		$("#content").load(url);
	}
	function delArticle(articleId){
		$.post("/user/delUserNews",{id:articleId},function(data){
			if(data.result==1){
				alert("删除成功");
				$("#content").load("/admin/articles?page=${pageInfo.pageNum}");
			}else{
				alert(data.errorMsg);
			}
		},"json")
	}
	function toUpdNews(articleId){
		var url="/home/Article/updArticle?id="+articleId;
		$("#content").load(url);
	}
</script>
