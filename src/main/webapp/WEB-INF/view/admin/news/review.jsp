<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <script type="text/javascript">


</script>
 <h1>评论(${ReviewsNum})</h1>  
<c:forEach  items="${Reviews.list}" var="re">
	<div style="border-bottom-style: solid;margin-top: 20px;width:1500px;margin-left: 200px;height: 110px">
		<h4>${re.content}</h4>
		<h6 style="margin-left: 1000px">评论人:${re.user.username}</h6>
		<h6 style="margin-left: 1000px">评论时间:${re.created}</h6>
	</div>
	
</c:forEach>
	
<div style="margin-left: 700px;margin-top: 20px;height: 50px">
 <button type="button" class="btn btn-default" onclick="getReview(1)" id="on">首页</button>
 <button type="button" class="btn btn-default" onclick="getReview(${Reviews.prePage})" id="on">上一页</button>
 <button type="button" class="btn btn-default" onclick="getReview(${Reviews.nextPage})" id="on">下一页</button>
 <button type="button" class="btn btn-default" onclick="getReview(${Reviews.pages})" id="on">尾页</button>
 </div>

