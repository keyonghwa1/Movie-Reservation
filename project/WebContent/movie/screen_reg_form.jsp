<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
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

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/screen_reg_form.css">
<script src="../js/httpRequest.js"></script>

<script>
function screen(f){
	var s_date = f.s_date.value;

	f.submit();
}	

</script>

</head>
<body>
	<jsp:include page="movie_main.jsp"/>
			
		<div class="position">	
			<form name="f" method="post" action="screen_insert_result.korea">
				<table class="reg_form" align="center" width="600" style="border-collapse : collapse">	
					<tr>
						<th>날짜</th>
						<td colspan="4" align="center">
						 	<select name="s_date">
								<option>날짜 선택</option>
								<option value='<%=strDate%>'><%=strDate %></option>
								<option value='<%=strDate1%>'><%=strDate1%></option>
								<option value='<%=strDate2%>'><%=strDate2%></option>
							</select>
							<input type="hidden" name="m_idx" style="height:30px" value="${vo.m_idx }"/>
						</td>
				</tr>
				
					
				<tr>
						<th>상영관</th>
						<td colspan="4" align="center"><input type="text" name="auditorium" ></td>
						
				</tr>
									
				<tr>
						<th>시간</th>
						<td colspan="4" align="center"><input type="text" name="s_time"/></td>
						
				</tr>
				
			 </table>
	
		<div class="button">
			<input class="btncom" type="button" value="예매하러 가기" onclick="screen(this.form);">
			<input class="btncom btnreset" type="reset" value="초기화">
		</div>
	</form>	
	
	</div>
</body>
</html>