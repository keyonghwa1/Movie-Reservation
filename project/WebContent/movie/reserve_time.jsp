<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%
DecimalFormat df = new DecimalFormat("00");
Calendar currentCalendar = Calendar.getInstance();

//현재 날짜 구하기
String strMonth = df.format(currentCalendar.get(Calendar.MONTH) + 1);
String strDay = df.format(currentCalendar.get(Calendar.DATE));
String strDate = strMonth + strDay;

// 다음날
currentCalendar.add(currentCalendar.DATE, +1);
String strMonth1 = df.format(currentCalendar.get(Calendar.MONTH) + 1);
String strDay1 = df.format(currentCalendar.get(Calendar.DATE));
String strDate1 = strMonth1 + strDay1;

// 다 다음날
currentCalendar.add(currentCalendar.DATE, +1);
String strMonth2 = df.format(currentCalendar.get(Calendar.MONTH) + 1);
String strDay2 = df.format(currentCalendar.get(Calendar.DATE));
String strDate2 = strMonth2 + strDay2;

request.setAttribute("date1", strDate);
request.setAttribute("date2", strDate1);
request.setAttribute("date3", strDate2);

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table align="center" width="600" border="1" style="border-collapse : collapse">
			<c:forEach var="p" items="${ list }">
			
				<c:choose>
					<c:when test="${ p.s_date eq date1}">
						<tr>
							<td><a href="reservation_seat_check.korea?s_idx=${p.s_idx }">오늘날짜:${ p.s_time }</a></td>
						</tr>
					</c:when>
					
					<c:when test="${ p.s_date eq date2}">
						<tr>
							<td><a href="reservation_seat_check.korea?s_idx=${p.s_idx }">다음날:${ p.s_time }</a></td>
						</tr>
					</c:when>
					
					<c:when test="${ p.s_date eq date3}">
						<tr>
							<td><a href="reservation_seat_check.korea?s_idx=${p.s_idx }">다다음날:${ p.s_time }</a></td> <!-- reservation_seat_check.korea 로 수정해야함 -->
						</tr>
					</c:when>
					
				</c:choose>
			
			</c:forEach>
		</table>
	</body>
</html>