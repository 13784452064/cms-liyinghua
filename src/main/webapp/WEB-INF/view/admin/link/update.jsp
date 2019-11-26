<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib  uri="http://www.springframework.org/tags/form"  prefix="form"%>
<form:form modelAttribute="link" action="/link/update" method="post" >
				链接名<form:input path="name"/><form:errors path="name"></form:errors>&nbsp;&nbsp;&nbsp;
				链接地址<form:input path="url"/><form:errors path="url"></form:errors>&nbsp;&nbsp;&nbsp;
				<form:hidden path="id"/>
				<form:button>修改</form:button>
</form:form>