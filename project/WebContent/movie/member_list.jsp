<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
	
	<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<link rel="stylesheet" type="text/css" href="../css/member_list.css">
		<meta charset="UTF-8">
		<title>회원 목록 페이지</title>
		
		<script>
			function del(idx) {
				if(confirm("삭제하시겠습니까?")==false){
					return;
				}
				
				//ajax를 통해 삭제 처리
				var url = "member_del.korea";
				var param = "idx="+idx;
				
				//삭제를 GET으로 하면 
				sendRequest(url,param,resultFn,"POST");
				
				
			}
			
			function resultFn() {
				if( xhr.readyState == 4 && xhr.status == 200 ){
					var data = xhr.responseText;
					var json = eval( data );
					
					//[{'res':'1'},{'idx':'3'}]
					if( json[0].result == '0' ){
						alert( json[1].id + "삭제 실패" );
					}
					else{
						alert(json[1].idx+"번 회원 삭제 성공")
					}
					
					// 전체 목록을 select 하는 url로 다시 이동(서블릿)
					location.href="member_list.korea";
					//이동하면, select하고 list만들어서 이 페이지가 다시 나옴(forwar 하니까)
				}
			}
		</script>
		<script type="text/javascript" src="../js/httpRequest.js"></script>
	</head>
	<body>
		<div class="memls"> 
		<table class="member_ls" border="1">
			<caption>::회원목록::</caption>
			
			<tr>
				<td colspan="7">
					<input class="btncom" type="button" value="영화 목록 화면으로" onclick="location.href='movie_list.korea'">
				</td>
			</tr>
			<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>전화번호</th>
				<th>비고</th>
			</tr>
			</thead>
			<!-- 	이 페이지가 호출 되려면 서블릿을 거쳐야 한다(/member/member_list.korea)
					거기서 list를 requestScope에 넣어왔다. EL로 바로 사용 가능 -->
			<c:forEach var="vo" items="${ list }">
				<tr>
					<td>${ vo.idx }</td>
					<td>${ vo.name }</td>
					<td>${ vo.id }</td>
					<td>${ vo.pwd }</td>
					<td>${ vo.phone }</td>
					<td>
						<input class ="btn" type="button" value="삭제" onclick="del('${vo.idx}');">
					</td>
				</tr>
			</c:forEach>
			
		</table>
		</div>
	</body>
</html>