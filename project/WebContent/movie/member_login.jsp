<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<script src="../js/httpRequest.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/member_login.css">
		<script>
			function send(f) {
				var id = f.id.value.trim();
				var pwd = f.pwd.value.trim();
				
				if( id == '' || pwd == '' ) {
					alert("아이디 또는 비밀번호를 입력하세요!!");
					return;
				}
				
				var url = "login.korea";
				var param = "id=" + encodeURIComponent(id) +
							"&pwd=" + encodeURIComponent(pwd);
				// login.korea?id=111&pwd=222 형태를 만든다
				sendRequest( url, param, resultFn, "POST" );
			}
			
			function resultFn() {  // id/pw 체크 후 콜백될 함수
				if( xhr.readyState == 4 && xhr.status == 200 ) {
					var data = xhr.responseText;
					var json = eval(data);
					
					// login.korea에서 이렇게 json 값을 만들어 줄 예정!
					if( json[0].param == 'no_id' ) {
						alert("아이디가 존재하지 않습니다.");
					}
					else if( json[0].param == 'no_pwd' ) {
						alert("비밀번호가 일치하지 않습니다.");
					}
					else if( json[0].param == 'clear' ) {
						// 정상이라면 페이지 이동
						// main 페이지를 보이기 전에 거쳐갈 컨트롤러 서블릿
						location.href = "movie_list.korea";
					}
				}
			}
			
		</script>
		
		
	</head>
	<body>
		<form>
			<table>
				<caption> 로그인 페이지 </caption>
				
					<tr class="id">
						<th>아이디</th>
						<td><input name="id" style="height:28px;" ></td>
					</tr>
					<tr class="pwd">
						<th>비밀번호</th>
						<td><input type="password"  style=" height:28px;" name="pwd"></td>
					</tr>
					<tr class="logbtn">
						<td colspan="3">
							<input class="loginbtn" type="button" value="로그인" onclick="send(this.form);" style="width:85px; height:77px;">
							<input class="btncom" type="button" value="회원가입" onclick="location.href='member_insert_form.jsp'">
							<input class="btncom btnreset" type="reset" value="취소">
						</td>
					</tr>
			</table>
		</form>
		
		
		
	</body>
</html>