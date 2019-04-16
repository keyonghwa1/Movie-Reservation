<!-- 다른 페이지들에서 include 할 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<link rel="stylesheet"  href="../css/index.css">
	<link rel="stylesheet"  href="../css/reset.css">
		
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			div{text-align:center;}
			a{text-decoration: none;}
			a:hover{color:red;}
		</style>
	</head>
	<body>
		<hr width="600" noshade color="navy">
			<div>
				<a href="movie_list.korea?category=romance">로맨스</a>
				<a href="movie_list.korea?category=action">액션</a>
				<a href="movie_list.korea?category=comedy">코미디</a>
			</div>
		<hr width="600" noshade color="navy">
	</body>
</html>