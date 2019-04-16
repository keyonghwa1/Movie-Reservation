<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function reserve(idx){
		
		param = "?m_idx=" + idx;
		location.href="timetable.korea"+param;
		
		idx.submit();
		
	}
</script>


</head>
<body>
	<jsp:include page="movie_main.jsp"/>
	
	<table align="center" width="600" border="1" style="border-collapse : collapse">
		<tr>
			<td rowspan="5" align="center"><img src="../images/${vo.m_img }"></td>
			<td colspan="2">영화 제목: ${ vo.m_title }</td>
		</tr>
		<tr>
			<td colspan="2">영화 장르 : ${ vo.category}</td>
		</tr>
		
		<tr>
			<td colspan="2">영화 감독 : ${vo.m_dir }</td>
		</tr>
		
		<tr>
			<td colspan="2">영화 가격 : ${ vo.m_price }</td>
		</tr>
		
		<tr>
			<td><input type="button" value="예매하기" onclick="reserve('${ vo.m_idx }');"/></td>
		</tr>
		
	</table>
</body>
</html>