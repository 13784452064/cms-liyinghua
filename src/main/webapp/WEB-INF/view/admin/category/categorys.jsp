<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="width:55% ;margin-left:20%;height:40px;border-bottom: solid;" >
	<c:forEach items="${Categorys}" var="c">
		<h4 style="float: left;margin-left: 5%">
		<a href="javascript:getArticleBychannelIdAndByCategoryId(${c.id},)">${c.name }</a>
		</h4>
	</c:forEach>
</div>	
<div style="width: 100% ;" id="categoryNews">
	
</div>

