<%@page import="com.project.mh.board.dto.AccountDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마영전 게시판</title>
<link rel="stylesheet"
	href="${cp}/resources/common.css?ver=<%= System.currentTimeMillis() %>">
</head>
<body>
	<div id="main">
		<div id="category_box">
			<a href="${cp}/mabi/getList?category=자유">자유게시판</a><br>
			<a href="${cp}/mabi/getList?category=벨">벨 게시판</a>
		</div>
		<div id="center_box">
			<div id="hits_list_box">
				<p>인기글</p>
				<c:forEach var="i" items="${hitsList}">
					${i.m_category} 게시판 - <a href="${cp}/mabi/read?m_no=${i.m_no}">${i.m_title}</a> / ${i.m_id} / ${i.m_hits}hits! <br>
				</c:forEach>
			</div>
		</div>

		<div id="util_box">
			<div id="login_box">
				<c:choose>
					<c:when test="${not empty sessionScope.log}">
					환영합니다 ${sessionScope.log} 님
					<form action="${cp}/mabi/logOut" method="get">
							<button>로그아웃</button>
						</form>
					</c:when>
					<c:otherwise>
						<form action="${cp}/mabi/log" method="post">
							<input class="log_box" name="id" placeholder="아이디 입력"><br>
							<input class="log_box" type="password" name="pw" placeholder="비번 입력"><br>
							<button type="submit">로그인</button>
							<button type="button" onclick="location.href='${cp}/mabi/reg'">회원가입</button>
						</form>
					</c:otherwise>
				</c:choose>
				<c:if test="${not empty logError}">
					<script>
						alert("${logError}");
					</script>
				</c:if>
			</div>
			
			<div id="party_simul_box">
				<a href="http://localhost:3000?id=${sessionScope.log}&load=party">파티 시뮬레이터</a>
			</div>
			<div id="logcheck_shop_box">
				<a href="http://localhost:3000?id=${sessionScope.log}&load=shop">출석체크/포인트샵</a>
			</div>
			<div id="home_box">
				<a href="${cp}/">홈으로</a>
			</div>
		</div>
	</div>
</body>
</html>
