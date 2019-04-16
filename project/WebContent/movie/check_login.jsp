<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	
	<body>
		<!-- 세션 영역에 name이 없으면 if문 안에서 페이지가 이동된다. 있으면 아무 효과 없음 -->
		<c:if test="${ empty sessionScope.user.name }">
			비회원 님 환영합니다
		</c:if>
		
		<c:if test="${ !empty sessionScope.user.name }">
			${sessionScope.user.name}님 환영합니다
		</c:if>
	</body>
</html>