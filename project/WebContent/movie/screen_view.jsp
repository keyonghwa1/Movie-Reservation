<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	
		<link rel="stylesheet" type="text/css" href="../css/screen_reg_form.css">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="movie_main.jsp"/>	
	<div class="position">
		<table class="view" align="center" width="600"  style="border-collapse : collapse">
	    	<tr>
				<td>시간 : ${ vo.s_time}</td>
			</tr>
			<tr>
				<td>상영관 : ${ vo.auditorium }</td>
			</tr>
			<tr>
				<td>날짜 : ${ vo.s_date }</td>
			</tr>
		</table>
			<input class="btncom" type="button" value="돌아가기" onclick="location.href='movie_list.korea?category=romance'">
		</div>
	</div>	
		
	
	</body>
</html>