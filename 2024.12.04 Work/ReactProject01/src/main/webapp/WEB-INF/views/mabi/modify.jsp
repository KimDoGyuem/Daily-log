<%@page import="com.project.mh.board.dto.GuestDto"%>
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
	<c:if test="${not empty read}">
		글번호: ${read.m_no}<br>
		<form action="${cp}/mabi/modify" method="post">
			<input type="hidden" name="m_no" value="${read.m_no}">
			<input type="hidden" name="m_category" value="${read.m_category}">
			글제목: <input name="m_title" value="${read.m_title}"><br>
			글내용: <textarea name="m_text">${read.m_text}</textarea><br>
			<input type="submit" value="수정">
		</form>
	</c:if>
	<c:if test="${empty read}">
		<p>게시글 정보가 없음</p>
	</c:if>
</body>
</html>