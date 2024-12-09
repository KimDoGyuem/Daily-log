<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cp" value="${pageContext.request.contextPath }" />
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="${cp}/resources/common.css?ver=<%= System.currentTimeMillis() %>">
</head>
<body>
<!-- 	<h1>Hello world!</h1> -->
<%-- 	<P>The time on the server is ${serverTime}.</P> --%>
	<a href="${cp }/mabi/board">마영전 게시판</a>
</body>
</html>
