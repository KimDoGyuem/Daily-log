<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${cp}/resources/common.css?ver=<%= System.currentTimeMillis() %>">
</head>
<body>

	<c:set var="category" value="${category}"></c:set>
	<c:set var="id" value="${sessionScope.log != null ? sessionScope.log : '익명'}"></c:set>
	<form action="${cp}/mabi/write" method="post">
		<input name="m_title" placeholder="제목을 입력하세요"><br>
		<textarea rows="5" name="m_text" placeholder="내용을 입력하세요"></textarea><br>
		<input type="hidden" name="m_id" value="${id}">
		<input type="hidden" name="m_category" value="${category}">
		<input type="submit" value="글쓰기">
	</form>

</body>
</html>