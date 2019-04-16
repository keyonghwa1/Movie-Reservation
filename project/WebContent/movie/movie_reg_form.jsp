<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script>
		function checkdata( f ){
			var category = f.category.value;
			
			f.submit();
		}
		
		</script>
		
	</head>
	<body>
		<jsp:include page="movie_main.jsp"/>
		
		<form name="f" method="post" action="movie_insert_result.korea" enctype="multipart/form-data">
			
			<table align="center" width="600" border="1" style="border-collapse : collapse">
				<tr>
					<td>영화 카테고리</td>
					<td colspan="4" align="center">
						<select name="category"> <!-- 파라미터명 -->
							<option>카테고리 선택</option>
							<option value="romance">로맨스</option>
							<option value="action">액션</option>
							<option value="comedy">코미디</option>
						</select>
					 </td>
				</tr>	
				
				<tr>
					<td>영화제목</td>
					<td colspan="4" align="center"><input name="m_title"></td>
				</tr>

				<tr>
					<td>영화감독</td>
					<td colspan="4" align="center"><input name="m_dir"></td>
				</tr>
						
				<tr>
					<td>영화가격</td>
					<td colspan="4" align="center"><input name="m_price"></td>
				</tr>
				
				<tr>
					<td>이미지</td>
					<td colspan="4" align="center"><input type="file" name="m_img" ></td>
				</tr>
				
				<tr>
					<td colspan="5" align="center"></td>
					<td><input type="button" value="영화등록" onclick="checkdata(this.form)">
						<input type="reset" value="초기화">
					</td>
				</tr>
				
				
						
			</table>
			
			</form>
			
	
		
	</body>
</html>