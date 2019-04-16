<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    

<!DOCTYPE html>
<html>

	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../css/screen_list.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table class="screen_ls" align="center" width="600" border="1" style="border-collapse : collapse">

				<c:forEach var="p" items="${ list }">
					<tr><td>상영 시간 : <a href="screen_view.korea?s_idx=${ p.s_idx }">${ p.s_time }</a></td></tr>
					<tr><td class="date">상영 날짜 : ${ p.s_date }</td></tr>	
					<tr><td class="aud">상영관 : ${ p.auditorium }</td></tr>
					
					<tr><td></td></tr>
									
				</c:forEach>
				<tr><a href="movie_list.korea?category=romance">돌아가기</a></tr>
	
	</table>
</body>
</html>