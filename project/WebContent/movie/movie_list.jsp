<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>

<link rel="stylesheet" type="text/css" href="../css/movie_list.css">
<link rel="stylesheet" type="text/css" href="../css/reset.css">
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script src="../js/httpRequest.js"></script>
		
		<script>
			function del( m_idx ){
				if(confirm("삭제하시겠습니까?")==false){
					return;
					
				}
				
				//ajax를 통해 삭제 처리
				var url = "movie_del.korea";
				var param = "m_idx="+m_idx;
				
				//삭제를 GET으로 하면 
				sendRequest(url,param,resultFn,"POST");
			}
			
			function resultFn() {
				if( xhr.readyState == 4 && xhr.status == 200 ){
					var data = xhr.responseText;
					var json = eval( data );
					
					//[{'res':'1'},{'idx':'3'}]
					if( json[0].result == '0' ){
						alert( json[1].m_idx + "삭제 실패" );
					}
					else{
						alert(json[1].m_idx+"번 영화 삭제 성공")
					}
					
					// 전체 목록을 select 하는 url로 다시 이동(서블릿)
					location.href="movie_list.korea";
					//이동하면, select하고 list만들어서 이 페이지가 다시 나옴(forwar 하니까)
				}
			}
			
			function insert_screen( idx ){ // 관리자용 삽입
				var param = "?m_idx="+idx;
				location.href="screen_insert.korea"+param;
				
				idx.submit();
				
			}
			
			function screen_view( idx ){ // 회원 상영정보 보기
				var param = "?m_idx="+idx;
				location.href="screen_list.korea"+param;
				
				idx.submit();
			}
		
		</script>
		
		<link rel="stylesheet" href="../css/reset.css"/>
	</head>
	
	<body>
		<jsp:include page="movie_main.jsp"/>
		
		<div class="regi">
			<c:if test="${sessionScope.user.name=='관리자'}">
				<input class="btn" type="button" id="reg" value="영화등록" onclick="location.href='movie_insert.korea';">
			</c:if>
		</div>
		<div class="ml">
		<table class="movie_ls" align="center" width="600" border="1" style="border-collapse : collapse">
			<thead>
			<tr>
				<th width="25%">이미지</th>
				<th width="25%">영화제목</th>
				<th width="25%">가격</th>
				<th width="25%">감독</th>
			</tr>
			</thead>
			
			<tbody>
			<c:if test="${ empty listca }">
				<tr>
					<td colspan="4" align="center">
						영화를 추가해 주세요.
					</td>
				</tr>
			</c:if>
			
			<c:forEach var="p" items="${ listca }">
				<tr>
					<td>
						<img src="../images/${p.m_img}" width="100" height="90">
					</td>
					
					<td>
						<a href="movie_view?m_idx=${p.m_idx}">${ p.m_title }</a> 
					</td>
					
					<td>
						${ p.m_price }
					</td>
					
					<td>
						${ p.m_dir }
					</td>
					
					<td>
						<c:if test="${sessionScope.user.name=='관리자'}">
							<input class ="btn" type="button" value="삭제" onclick="del('${p.m_idx}');"/>
							<input class="btn" type="button" value="상영정보삽입" onclick="insert_screen('${p.m_idx}');"/> <!-- (관리자용 )삽입 -->
						</c:if>
						<input class="btn" type="button" value="상영정보보기" onclick="screen_view('${p.m_idx}');"/> <!-- (회원)상영정보 -->
					</td>
							
				</tr>
			
			</c:forEach>
			
			</tbody>
			
			<!-- 서블릿에서 requestScope에 "paging"이라는 객체를 넣어놨다.
				이 객체를 이용해서 페이지 버튼을 만들 수 있다.(버튼, 하이퍼링크 - 형식은 자유)-->
			<tr>
				<td colspan="4" align="center">
					<!-- 첫 페이지로 이동하는 버튼. 그냥 파라미터로 1 넣으면 됨 -->
					<input class="btncom" type="button" value="처음" onclick="location.href='movie_list.korea?page=1'">
					
					<!-- 이전페이지로 이동하는 버튼. 현재페이지 - 1 -->
					<c:if test="${ paging.currentPage > 1 }">
						<input class="btncom" type="button" value="이전" onclick="location.href='movie_list.korea?page=${paging.currentPage-1}'">
					</c:if>
					
					<!-- 현재 페이지가 1이면 '이전'은 비활성화 버튼으로 만든다. -->
					<c:if test="${ paging.currentPage <= 1 }">
						<input class="btncom" type="button" value="이전" disabled="disabled">
					</c:if>
					
					<!-- 1~10 각 페이지 버튼 만들기
							startPage, endPage 이런 값들은 이미 Paging 객체 생성 시 다 계산해놨다!-->
					<c:forEach var="i" begin="${ paging.startPage }" end="${ paging.endPage }" step="1">
						<!-- 현재 페이지의 버튼이라면 클릭할 필요 없다. => 비활성화 -->
						<c:if test="${ paing.currentPage == i }">
							<input class="btncom" type="button" value="${ i }" disabled="disabled">
						</c:if>
						
						<c:if test="${ paging.currentPage != i }">
							<input class="btncom" type="button" value="${ i }" onclick="location.href='movie_list.korea?page=${i}'">
						</c:if>
					</c:forEach>
					
					<!-- 다음  페이지 버튼 (현재페이지 + 1) -->
					<c:if test="${ paging.currentPage < paging.totalPage }">
						<input class="btncom" type="button" value="다음" onclick="location.href='movie_list.korea?page=${paging.currentPage+1}'">
					</c:if>
					
					<!-- 현재 페이지가 마지막페이지이면 '다음'버튼은 비활성화 -->
					<c:if test="${ paging.currentPage >= paging.totalPage }">
						<input class="btncom"  type="button" value="다음" disabled="disabled">
					</c:if>
					
					<!-- 마지막 페이지로 이동하는 버튼. -->
					<input class="btncom" type="button" value="끝" onclick="location.href='movie_list.korea?page=${paing.totalPage}'">
				</td>
				
			</tr>
		</table>
		</div>
	</body>
</html>