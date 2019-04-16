<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="check_login.jsp" %>

<!DOCTYPE html>
<html>

<link rel="stylesheet" type="text/css" href="../css/movie_main.css">
<link rel="stylesheet" type="text/css" href="../css/reset.css">

	<head>
		<meta charset="UTF-8">
		<title>메인 페이지(영화 목록)</title>
		
		<script>
			function regi() {
				location.href = "movie_insert.korea";
			}
		</script>
	</head>
	
	<body>
		<jsp:include page="index.jsp"/>		
		<div class="log">
			<c:if test="${empty sessionScope.user.name }">
				<input class="btn" type="button" onclick="location.href='member_login.jsp'" value="로그인">
			</c:if>
			<c:if test="${!empty sessionScope.user.name }">
				<input class="btn" type="button" onclick="location.href='logout.korea'" value="로그아웃">
				<input class="btn" type="button" onclick="location.href='reservation_list.korea'" value="예매확인">
			</c:if>
		</div>
	</body>
</html>