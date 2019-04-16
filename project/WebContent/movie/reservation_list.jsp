<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

	<link rel="stylesheet" type="text/css" href="../css/reservation_list.css"/>
	<link rel="stylesheet" type="text/css" href="../css/reset.css"/>
	<head>

		<meta charset="UTF-8">
		<title>예매 확인</title>
		<script src="../js/httpRequest.js"></script>
		<script>
		function del(idx) {
			if(confirm("예매를 취소하시겠습니까?")==false){
				return;
			}
			
			//ajax를 통해 삭제 처리
			var url = "reservation_delete.korea";
			var param = "r_idx="+idx;
			
			//삭제를 GET으로 하면 
			sendRequest(url,param,resultFn,"POST");
			
			
		}
		
		function resultFn() {
			if( xhr.readyState == 4 && xhr.status == 200 ){
				var data = xhr.responseText;
				var json = eval( data );
				
				location.href="reservation_list.korea";
				
			}
		}
	</script>
	</head>
	<body>
		<input type="button" class="btn" value="영화 목록으로 가기" onclick="location.href='movie_list.korea'">
		<div class="res">
		<table class="reserve_ls" align="center" width="600" border="1" style="border-collapse : collapse">
		<thead>
		<tr>
			<th>예매번호</th>
			<th colspan="2">영화 제목</th>
			<th>상영관</th>
			<th>상영 날짜</th>
			<th>상영 시간</th>
			<th>예약 좌석</th>
			<th>예매 일시</th>
			<th>가격</th>
			<th>예매 취소</th>
		</tr>
		</thead>
		
		<tbody>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${ vo.r_idx }</td>
				<td><a href="movie_view?m_idx=${ vo.m_idx } ">${ vo.m_title }</a></td>
				<td><img src="../images/${ vo.m_img}" width="100" height="90"></td>
				<td>${ vo.auditorium }</td>
				<td>${ vo.s_date }</td>
				<td>${ vo.s_time }</td>
				<td>${ vo.r_seat}</td>
				<td>${ vo.r_time }</td>
				<td>${ vo.m_price }</td>
				<td>
					<input type="button" value ="삭제" onclick="del('${vo.r_idx}');">
				</td>
			</tr>
		</c:forEach>
		
		<c:if test="${empty list }">
			<tr>
				<td colspan ="10" align="center">
					예매 정보가 없습니다
				</td>
			</tr>
		</c:if>
		</tbody>
	</table>
	</div>
	</body>
</html>