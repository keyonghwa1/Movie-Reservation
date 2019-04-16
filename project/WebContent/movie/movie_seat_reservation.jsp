<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	String idx = request.getParameter("s_idx");
	if( idx == null ) {
		// 이전 페이지로 돌려보내거나 등등의 행위를 하자
		response.sendRedirect("movie_list.korea");
	}
	
	String seat = (String)request.getAttribute("already_seat");
	System.out.println("여긴 jsp : " + seat);
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>좌석 예약</title>
		
		<script type="text/javascript">
			var no_seat = "<%=seat%>";
			var arr_temp = no_seat.split(",");
			var arr_seat = new Array();
			var arr_cnt = 0;
			
			for( var i = 0; i < 20; i++ ) {
				if( (i+1) == arr_temp[arr_cnt] ) {
					arr_seat[i] = 0; // 이미 선택된 좌석
					arr_cnt++;
				}
				else {
					arr_seat[i] = 1; // 선택할 수 있는 좌석
				}
			}
			
			window.onload = function() {
				var values = document.getElementsByName("seat");
				for( var i=0; i < values.length; i++ ) {
					if( arr_seat[i] == 0 ){
						values[i].disabled = true;
					}
				}
			}
			
			function send(f){
				if(confirm("예약하시겠습니까?")==false){
					return;
				}
				
				f.s_idx.value = <%=idx%>;
				f.action = "reservation_insert.korea";
				f.submit();
				
				/* location.href = "insert_reservation.korea"
				
				var url = "insert_reservation.korea";
				var param = "seat="+values;
				
				sendRequest(url,param,resultFn,"POST"); */
				
			}
			
			function change() {
				// 선택된 seat checkbox 를 모두 골라서 문자열을 만든다!!
				
				var str = "선택된 좌석은 ";
				var values = document.getElementsByName("seat");

				var people = document.getElementById("p");
				var people_num = parseInt( people.options[people.selectedIndex].value );
				var count=0;
				
				var check = false;
				// 내가 체크한 것을 확인
				for( var i=0; i < values.length; i++ ) {
					
					if( values[i].checked == true ){
						if( check == true ) {
							str+=", ";	
						}
						
						str += (values[i].value);
						check = true;
						count++;
					}	
				}
				
				if(check == true) {   
					str+=" 입니다.";
				}
				else {
					str+="없습니다.";					
				}
				
				for( var i=0; i < values.length; i++ ) {
					if(people_num==count) {
						if( values[i].checked == false ){
							values[i].disabled = true;
						}
					}
					else {
						if( arr_seat[i] != 0 )
							values[i].disabled = false;
					}
					
				}
				
				document.getElementById("seat_disp").innerHTML = str;
			}
			
			
		</script>
		<link rel="stylesheet" href="../css/seat_reservation.css"/>
		<link rel="reset" href="../css/reset.css"/>
		
	</head>
	<body>
		
		<br>
		<div id="seat">
			<form>
			<div id="select_box">
			<c:forEach var="vo" items="${list}">
				<span>${ vo.auditorium }</span>
				<span>${ vo.s_date }</span>
				<span>${ vo.s_time }</span>
			</c:forEach>
			<select name="people" id="p">
				<option value="1">1명</option>
				<option value="2">2명</option>
				<option value="3">3명</option>
				<option value="4">4명</option>
			</select>
			<input onclick="send(this.form);" class="myButton" value="좌석 예약하기">
		</div>
				<table border="1" >
					<c:forEach var="n" begin="1" end="20" step="5">
						<tr>
							<td>${ n }<input type="checkbox" name="seat" value="${ n }" onchange="change();"></td>
							<td>${ n+1 }<input type="checkbox" name="seat" value="${ n+1 }" onchange="change();"></td>
							<td>${ n+2 }<input type="checkbox" name="seat" value="${ n+2 }" onchange="change();"></td>
							<td>${ n+3 }<input type="checkbox" name="seat" value="${ n+3 }" onchange="change();"></td>
							<td>${ n+4 }<input type="checkbox" name="seat" value="${ n+4 }" onchange="change();"></td>
						</tr>
					</c:forEach>
				</table>	
				
				
				<input type="hidden" name="s_idx">
			</form>
		</div>
		
		<div id="seat_disp">
		</div>
		
		
	</body>
</html>
