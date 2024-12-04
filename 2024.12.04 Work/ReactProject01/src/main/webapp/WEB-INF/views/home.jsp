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
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	리엑트 api 테스트<br>
	<a href="${cp }/card/gacha">가챠 확인</a>
	<a href="${cp }/card/getMyCards">보유 목록 확인</a>
</body>
</html>
