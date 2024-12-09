<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link rel="stylesheet"
	href="${cp}/resources/common.css?ver=<%= System.currentTimeMillis() %>">
</head>
<body>
	<div id="reg_box">
		<form action="${cp}/mabi/reg" method="post">
			<input name="id" placeholder="아이디 입력"><br>
			<input type="password" name="pw" placeholder="비번 입력"><br>
			<button type="submit">회원가입</button>
		</form>
	</div>
	
	<c:if test="${not empty error}">
		<script>
			alert("${error}");
		</script>
	</c:if>
	
</body>
</html>