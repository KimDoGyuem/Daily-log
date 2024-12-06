<%@page import="java.util.ArrayList"%>
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
		<c:set var="m_no" value="${read.m_no}"></c:set>
		<c:set var="m_title" value="${read.m_title}"></c:set>
		<c:set var="m_id" value="${read.m_id}"></c:set>
		<c:set var="m_text" value="${read.m_text}"></c:set>
		<c:set var="m_category" value="${read.m_category}"></c:set>
		<c:set var="m_hits" value="${read.m_hits}"></c:set>
	</c:if>
	
	<c:set var="log_id" value="${sessionScope.log != null ? sessionScope.log : '익명'}"></c:set>
	
	글번호: ${m_no}<br>
	글제목: ${m_title}<br>
	작성자: ${m_id}<br>
	글내용: ${m_text}<br>
	조회수: ${m_hits}<br>
	<hr>
	댓글<br>
	<c:choose>
		<c:when test="${empty reply}">
			댓글이 없습니다
		</c:when>
		<c:otherwise>
			<c:forEach var="i" items="${reply}">
				${i.m_reply_id}님의 댓글: ${i.m_reply_text}<br>
			</c:forEach>	
		</c:otherwise>
	</c:choose>

	<form action="${cp}/mabi/reply" method="post">
		<input type="hidden" name="m_reply_ori" value="${m_no}">
		<input type="hidden" name="m_reply_id" value="${log_id}">
		<input name="m_reply_text">
		<input type="submit" value="댓글쓰기">
	</form>
	<hr>
	
	<c:if test="${m_id eq log_id}">
	<a href="${cp}/mabi/del?m_no=${m_no}&category=${m_category}">글삭제</a>
	<a href="${cp}/mabi/modify?m_no=${m_no}">글수정</a>
	</c:if>
	<a href="${cp}/mabi/getList?category=${m_category}">글리스트</a>
	
</body>
</html>