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

<h1>자유게시판</h1>
<h2>글목록</h2>
<table>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
	</tr>
	<c:set var="list" value="${blp.posts}"></c:set>
	<c:forEach var="i" items="${list}">
	<tr>
		<td>${i.m_no }</td>
		<td><a href="${cp}/mabi/read?m_no=${i.m_no}">${i.m_title}</a></td>
		<td>${i.m_id }</td>
	</tr>
	</c:forEach>
</table>

<c:if test="${blp.hasPrev }">
	<a href="${cp}/mabi/getList?category=${blp.category}&word=${blp.word}&currentPage=${blp.prevPage}">이전</a>
</c:if>

<c:forEach var="i" begin="${blp.blockStartNo}" end="${blp.blockEndNo}">
	<a href="${cp}/mabi/getList?category=${blp.category}&word=${blp.word}&currentPage=${i}">${i}</a>
</c:forEach>

<c:if test="${blp.hasNext}">
	<a href="${cp}/mabi/getList?category=${blp.category}&word=${blp.word}&currentPage=${blp.nextPage}">다음</a>
</c:if>

<br>

<form action="${cp}/mabi/getList" method="get">
	<input type="hidden" name="category" value="${blp.category}">
	<input name="word" placeholder="검색어 입력">
	<input type="submit" value="검색">
</form>


<a href="${cp}/mabi/write?category=${blp.category}">글쓰기</a><br>
<a href="${cp}/">홈으로</a>

</body>
</html>