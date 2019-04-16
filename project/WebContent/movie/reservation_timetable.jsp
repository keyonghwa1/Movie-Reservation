<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
DecimalFormat df = new DecimalFormat("00");
Calendar currentCalendar = Calendar.getInstance();

//현재 날짜 구하기
String strMonth = df.format(currentCalendar.get(Calendar.MONTH) + 1);
String strDay = df.format(currentCalendar.get(Calendar.DATE));
String strDate = strMonth + strDay;
int todayDate = Integer.parseInt(strDate);

request.setAttribute("date1", todayDate);
%>

<!DOCTYPE html>
<html>
	<link rel="stylesheet" href="../css/timetable.css"/>
	<head>
		<meta charset="UTF-8">
		<title>예매시간표(예매하기 누르면 나오는 페이지)</title>
		
		<script src="../js/httpRequest.js"></script>
		<script type="text/javascript"></script>
	</head>
	
	<body>
		<input class="btncom" type="button" value="영화 목록으로 가기" onclick="location.href='movie_list.korea'">
		<div class="rt">
		<table class="r_t"align="center" width="600" border="1" style="border-collapse : collapse">
			<thead>	<tr>
				<th>날짜</th>
				<th>시간</th>
				<th>상영관</th>
				<th>예매</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${ vo.s_date }</td>
					<td>${ vo.s_time }</td>
					<td>${ vo.auditorium }</td>
					<td>
						<c:if test="${ vo.s_date < date1 }">
							<input class="btncom" type="button" value ="예매불가" disabled="disabled">
						</c:if>
						<c:if test="${ vo.s_date >= date1 }">
							<input class="btncom" type="button" value ="예매" onclick="location.href='reservation_seat_check.korea?s_idx=${ vo.s_idx }'">
						</c:if>
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