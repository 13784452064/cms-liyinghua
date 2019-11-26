<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript" src="/resource/bootstrap/js/bootstrap.js"></script>

<!-- 模态框（Modal） -->
<div class="modal fade" id="articleDetailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width:1000px;height:1000px" >
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					审核文章
				</h4>
			</div>
			<div class="modal-body"  style="height:1000px;overflow-x:scroll;overflow-y:scroll">
				<h3 id="articleTitle"></h3>
				<br/>
				<div id="articleInfo"></div>
				<br/>
				<div id="articleContent"></div>
				
				
			</div>
			<div class="modal-footer">
				<input type="button" class="btn btn-default" data-dismiss="modal">关闭
				</input>
				<input type="button" value="通过" onclick="apply(1)" class="btn btn-primary">
			
				<input type="button" value="拒绝" onclick="apply(2)" class="btn btn-danger">
					
				<input type="button" value="热门" onclick="setHot(1)" class="btn btn-warning"/>
				
				<input type="button" value="非热门" onclick="setHot(0)" class="btn btn-info"/>
					
				
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
	

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
	      	<input type="button" onclick="toApply(${article.id})" value="审核" class="btn-info"/>
	      	<input type="button" onclick="delNews(${article.id})" value="删除"  class="btn-danger"/>
	      </td></tr>
   	</c:forEach>
  </tbody>
</table>
<ul class="pagination">
    <li><a href="javascript:goPage(1)">首页</a></li>
    <li><a href="javascript:goPage(${p.prePage})">上一页</a></li>
    <li><a href="javascript:goPage(${p.prePage})">下一页</a></li>
    <li><a href="javascript:goPage(${p.pages})">尾页</a></li>
</ul>

<script type="text/javascript">

	//全局变量 保存文章id
	var globalArticleId = 0;
	
	function goPage(fy){
		var url="/user/getUserNewsList?fy="+fy ;
		$("#content").load(url);
	}

	/**
	*  status 1 通过  2 拒绝
	*/
	function apply(status) {
		
		$.post("/home/Article/applyArticle",{id:globalArticleId,status:status},
				function(data){
				if(data.result==1){
					alert("该文章已不存在");
					
				}else if(data.result==2){
					alert("处理成功")
					$('#articleDetailModal').modal('hide');
				}else{
					alert("处理失败")
				}
		}
		,"json");
	}
	
	/**
	* 设置热门  status 1： 设置成热门  0 设置为非热门
	*/
	function setHot(status) {
		
		$.post("/home/Article/setHot",{id:globalArticleId,status:status},
				function(data){
				if(data==1){
					alert("文章不存在");

				}else if(data==2){
					alert("文章已是热门");
	
				}else if(data==3){
					alert("设置成功");
					$('#articleDetailModal').modal('hide');
				}else{
					alert("设置失败");
				}
		}
		,"json");
	}
	
	
	
	/**
	* 去审核文章  也就是弹出文章的详情页面
	*  以模态框的形式显示
	*/
	function toApply(articleId){
		$.post("/home/Article/getContent1",{articleId:articleId},function(data){
			if(data.result==1){
				globalArticleId=data.article.id;		
				$("#articleTitle").text(data.article.title);
				$("#articleContent").html(data.article.content);
				$("#articleInfo").text("作者：" + data.article.user.username + 
					" 频道：" + data.article.channel.name +
					" 分类：" + data.article.category.name);
				//alert('fff')
				$('#articleDetailModal').modal('show');
				//$("#content").load("/admin/articles?page=${pageInfo.pageNum}");
			}else{
				alert(data.errorMsg);
			}
		},"json")
		
	}

	function delArticle(articleId){
		$.post("/user/delNews",{articleId:articleId},function(data){
			if(data==1){
				alert("删除成功");
				$("#content").load("/admin/articles?page=${pageInfo.pageNum}");
			}else{
				alert(data.errorMsg);
			}
		},"json")
	}
	

		
</script>
